package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven{
	private ProductService productService=new ProductService();
	private List productList;
	
	//供货商id
	private int sid;
	//商品分类id
	private int cid;
	
	
	
	public int getSid() {
		return sid;
	}



	public void setSid(int sid) {
		this.sid = sid;
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public List getProductList() {
		return productList;
	}



	public void setProductList(List productList) {
		this.productList = productList;
	}
	
	public String getAllProducts(){
		System.out.print(cid+","+sid);
		if(0!=sid&&0!=cid){
			productList=productService.getAllProducts(sid, cid);
		}else if(0==sid&&0!=cid){
			productList=productService.getAllProducts(cid);
		}else if(0!=sid&&0==cid){
			productList=productService.getAllProductsBySupplierid(sid);
		}
		else{
			productList=productService.getAllProducts();
		}

		return "all";
		
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return productList;
	}

}
