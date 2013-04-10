package org.xingte.jxc.actions;

import org.xingte.jxc.model.Area;
import org.xingte.jxc.service.AreaService;

import com.opensymphony.xwork2.ActionSupport;

public class AddAreaAction extends ActionSupport{
	private AreaService areaService=new AreaService();
	private String areaname;
	private String upareaid;
	private String result;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String excute(){
		Area area=new Area();
		area.setName(areaname);
		area.setParentid(Integer.parseInt(upareaid));
		area.setState(0);
		areaService.addArea(area);
		this.result="1";		
		return SUCCESS;
	}

}
