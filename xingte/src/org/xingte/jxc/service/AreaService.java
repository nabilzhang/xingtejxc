package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.daoimpl.AreaDaoImpl;
import org.xingte.jxc.dto.AreaDTO;
import org.xingte.jxc.model.Area;

public class AreaService {
	private AreaDaoImpl areaDaoImpl=new AreaDaoImpl();
	
	public void addArea(AreaDTO areaDTO){
		Area area=new Area();
		area.setName(areaDTO.getName());
		area.setParentid(areaDTO.getParentid());
		area.setState(areaDTO.getState());
		areaDaoImpl.addOne(area);
	}
	public void addArea(Area area){
		areaDaoImpl.addOne(area);
	}
	
	public List<AreaDTO> getAllArea(){
		List areas=areaDaoImpl.getAll();
		Iterator<Area> iter =areas.iterator();
		List<AreaDTO> areaDTOs=new ArrayList<AreaDTO>();
		while(iter.hasNext()){
			Area area=iter.next();
			int pid=area.getParentid();
			String pname;
			if(pid==0){
				pname="无";
			}else{
				pname=areaDaoImpl.getOneAreaById(pid).getName();
			}
			AreaDTO areaDTO=new AreaDTO(area.getId(),
					area.getName(), area.getParentid(),
					pname, area.getState());
			areaDTOs.add(areaDTO);			
		}
		return areaDTOs;
	}
}
