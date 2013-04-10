package org.xingte.jxc.actions;

import org.xingte.jxc.model.ProCatalog;
import org.xingte.jxc.service.ProcatalogService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProCatalogAction extends ActionSupport implements ModelDriven {
	private ProcatalogService procatalogService=new ProcatalogService();
	private ProCatalog catalog=new ProCatalog();
	private String result;

	public ProCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(ProCatalog catalog) {
		this.catalog = catalog;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String addCatalog(){
		System.out.print(catalog+"shifou");
		procatalogService.addOne(catalog);
		result="1";
		return "add";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return catalog;
	}

}
