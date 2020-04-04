package com.framework.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductsEntity {
	@Id
	@Column(name="productid")
	String pid;
	@Column(name="product_name")
	String pname;
	@Column(name="price")
	String price;
	@Column(name="category")
	String category;
	@Column(name="picture")
	String picture;	
	@Column(name="detail")
	String detail;
	
	public ProductsEntity(){}

	public ProductsEntity(String pid) {
		this.pid = pid;
	}
	
	public ProductsEntity(String pid, String pname, String price, String category, String picture, String detail) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category = category;
		this.picture=picture;
		this.detail=detail;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String toString()
	{
		return "Product:"+pid+",Name:"+pname ;
	}

}
