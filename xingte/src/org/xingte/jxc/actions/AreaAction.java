package org.xingte.jxc.actions;

import java.util.ArrayList;
import java.util.List;

import org.xingte.jxc.model.Area;
import org.xingte.jxc.service.AreaService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AreaAction extends ActionSupport implements ModelDriven  {
	private String areaname;
	private String upareaid;
	private String result;
	
		
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getUpareaid() {
		return upareaid;
	}

	public void setUpareaid(String upareaid) {
		this.upareaid = upareaid;
	}
	/**
	 * 业务层areaservice
	 */
	private AreaService areaService=new AreaService();
	
	private List areaDTOList;

	public void setAreaDTOList(List areaDTOList) {
		this.areaDTOList = areaDTOList;
	}
	
	public String reAreaList(){
		areaDTOList=areaService.getAllArea();
		return SUCCESS;
	}
	
	public String addArea(){
		Area area=new Area();
		area.setName(areaname);
		area.setParentid(Integer.parseInt(upareaid));
		area.setState(0);
		areaService.addArea(area);
		this.result="1";
		return "add";
	}

	@Override
	public Object getModel() {
		return areaDTOList;
	}
	
	
}
