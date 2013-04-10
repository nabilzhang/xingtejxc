package org.xingte.jxc.actions;

import org.xingte.jxc.model.Product;
import org.xingte.jxc.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProductAction extends ActionSupport implements ModelDriven  {
	private ProductService productService=new ProductService();
	private Product product=new Product();
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String addProduct(){
		productService.addOne(product);
		return "add";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	

}
