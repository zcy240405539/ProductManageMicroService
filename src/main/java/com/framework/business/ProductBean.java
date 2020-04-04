package com.framework.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.framework.jpa.*;

//@Service
@Component
public class ProductBean {
	@Autowired
	public ProductRepository productRepository;
	public ProductsEntity product;
	
	public ProductsEntity checkProduct(String pid) {
		
		try {
			List<ProductsEntity> products = productRepository.findByPid(pid);
			if (products.size() > 0) {
				//System.out.println(userid + " " + pwd);
				return products.get(0);
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public List<ProductsEntity> checkCategory(String category) {
		
		try {
			List<ProductsEntity> products = productRepository.findByCategory(category);
			if (products.size() > 0) {
				//System.out.println(userid + " " + pwd);
				return products;
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}	
	
}
