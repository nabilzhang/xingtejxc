package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.service.ProcatalogService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProCatalogAction extends ActionSupport implements ModelDriven{
	private ProcatalogService procatalogService=new ProcatalogService();
	private List ProcatalogDTOList;
	
	
	public List getProcatalogDTOList() {
		return ProcatalogDTOList;
	}


	public void setProcatalogDTOList(List procatalogDTOList) {
		ProcatalogDTOList = procatalogDTOList;
	}
	
	public String getAllProCatalog(){
		ProcatalogDTOList=procatalogService.getAllProcatalogDTOs();
		return "all";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return ProcatalogDTOList;
	}

}
