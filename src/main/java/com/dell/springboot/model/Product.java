package com.dell.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="product_user")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="TYPE", nullable=false)
	private String type;
	
	
	@NotEmpty
	@Column(name="BRAND", nullable=false)
	private String brand;
	
	@NotEmpty
	@Column(name="COLOR", nullable=false)
	private String color;
	
	
	@Column(name="PRICE")
	private Integer price;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if (Double.compare(product.price, price) != 0) return false;
		if (id != null ? !id.equals(product.id) : product.id != null) return false;
		if (type != null ? !type.equals(product.type) : product.type != null) return false;
		if (color != null ? !color.equals(product.color) : product.color != null) return false;
		return brand != null ? brand.equals(product.brand) : product.brand == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (color != null ? color.hashCode() : 0);
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + type + ", color=" + color
				+ ", price=" + price + " , brand=" + brand + "]";
	}

	
	
	
	
}
