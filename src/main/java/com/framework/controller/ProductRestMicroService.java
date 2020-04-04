package com.framework.controller;

import com.framework.business.*;
import com.framework.jpa.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestMicroService {
	@Autowired
	ProductBean productBean;
	String[][] products;
	
	@GetMapping(value="/checkProductName/{pid}")
	public String checkProductName(@PathVariable String pid) {
		String beanResult = productBean.checkProduct(pid).getPname();
		if(beanResult.equals("error")) {
			//System.out.println("success");
			return "error";
		}else if(beanResult.equals("badrequest400")) {
			//System.out.println("error");
			return "badrequest400";
		}else {
			return beanResult;
		}
	}
	
	@GetMapping(value="/checkProductPrice/{pid}")
	public String checkProductPrice(@PathVariable String pid) {
		String beanResult = productBean.checkProduct(pid).getPrice();
		if(beanResult.equals("error")) {
			return "error";
		}else if(beanResult.equals("badrequest400")) {
			return "badrequest400";
		}else {
			return beanResult;
		}
	}

	@GetMapping(value="/checkProductCategory/{pid}")
	public String checkProductCategory(@PathVariable String pid) {
		String beanResult = productBean.checkProduct(pid).getCategory();
		if(beanResult.equals("error")) {
			return "error";
		}else if(beanResult.equals("badrequest400")) {
			return "badrequest400";
		}else {
			return beanResult;
		}
	}

	@GetMapping(value="/checkProductPicture/{pid}")
	public String checkProductPicture(@PathVariable String pid) {
		String beanResult = productBean.checkProduct(pid).getPicture();
		if(beanResult.equals("error")) {
			return "error";
		}else if(beanResult.equals("badrequest400")) {
			return "badrequest400";
		}else {
			return beanResult;
		}
	}
	
	@GetMapping(value="/checkProductDetail/{pid}")
	public String checkProductDetail(@PathVariable String pid) {
		String beanResult = productBean.checkProduct(pid).getDetail();
		if(beanResult.equals("error")) {
			return "error";
		}else if(beanResult.equals("badrequest400")) {
			return "badrequest400";
		}else {
			return beanResult;
		}
	}
	
	
/*	
	@SuppressWarnings("null")
	@GetMapping(value="/checkProduct/{pid}")
	public String[] checkProduct(@PathVariable String pid) {
		ProductsEntity beanResult = productBean.checkProduct(pid);
		if(beanResult != null) {
			//System.out.println("success");
			//String result=beanResult.getPname()+" $"+beanResult.getPrice()+" "+beanResult.getCategory()+""+beanResult.getCategory();
			//String[] result= {beanResult.getPid(),beanResult.getPname(),beanResult.getPrice(),beanResult.getCategory(),beanResult.getPicture(),beanResult.getDetail()};
			String[] result = null;
			result[0]=beanResult.getPid();
			if(beanResult.getPname().isEmpty()||beanResult.getPname()==null) {
				result[1]="";
			}else {
				result[1]=beanResult.getPid();
			}
			
			if(beanResult.getPrice().isEmpty()||beanResult.getPrice()==null) {
				result[2]="";
			}else {
				result[2]=beanResult.getPrice();
			}
			
			if(beanResult.getCategory().isEmpty()||beanResult.getCategory()==null) {
				result[3]="";
			}else {
				result[3]=beanResult.getCategory();
			}
			
			if(beanResult.getPicture().isEmpty()||beanResult.getPicture()==null) {
				result[4]="";
			}else {
				result[4]=beanResult.getPicture();
			}
			
			if(beanResult.getDetail().isEmpty()||beanResult.getDetail()==null) {
				result[5]="";
			}else {
				result[5]=beanResult.getDetail();
			}
			
			return result;
		}else {
			//return "error";
			return null;
		}

	}
*/
	@GetMapping(value="/checkProduct/{pid}")
	public List<String> check(@PathVariable String pid) {
		ProductsEntity beanResult = productBean.checkProduct(pid);
		if(beanResult != null) {
			//System.out.println("success");
			//String result=beanResult.getPname()+" $"+beanResult.getPrice()+" "+beanResult.getCategory()+""+beanResult.getCategory();
			//String[] result= {beanResult.getPid(),beanResult.getPname(),beanResult.getPrice(),beanResult.getCategory(),beanResult.getPicture(),beanResult.getDetail()};
			List<String> result = null;
			result.add(beanResult.getPid());
			if(beanResult.getPname().isEmpty()||beanResult.getPname()==null) {
				result.add("");
			}else {
				result.add(beanResult.getPid());
			}
			
			if(beanResult.getPrice().isEmpty()||beanResult.getPrice()==null) {
				result.add("");
			}else {
				result.add(beanResult.getPrice());
			}
			
			if(beanResult.getCategory().isEmpty()||beanResult.getCategory()==null) {
				result.add("");
			}else {
				result.add(beanResult.getCategory());
			}
			
			if(beanResult.getPicture().isEmpty()||beanResult.getPicture()==null) {
				result.add("");
			}else {
				result.add(beanResult.getPicture());
			}
			
			if(beanResult.getDetail().isEmpty()||beanResult.getDetail()==null) {
				result.add("");
			}else {
				result.add(beanResult.getDetail());
			}
			
			return result;
		}else {
			//return "error";
			return null;
		}

	}
	
	
	@GetMapping(value="/checkCategory/{category}")
	public String checkCategory(@PathVariable String category){
		List<ProductsEntity> productsEntity = productBean.checkCategory(category);
		if(productsEntity!=null) {
			String ProductList = null;
			for(ProductsEntity product:productsEntity) {
				String productID= product.getPid();
				if(ProductList==null) {
					ProductList=productID;
				}else {
					ProductList+="|"+productID;
				}
			}
			
			return ProductList;
		}else {
			return null;
		}
			
		
	}
	

}
