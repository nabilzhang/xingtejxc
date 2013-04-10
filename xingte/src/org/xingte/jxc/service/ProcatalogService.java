package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.xingte.jxc.daoimpl.ProCatalogDaoImpl;

import org.xingte.jxc.model.ProCatalog;



import org.xingte.jxc.dto.ProcatalogDTO;
public class ProcatalogService {
    private ProCatalogDaoImpl procatalogDaoImpl=new ProCatalogDaoImpl();
    public void addOne(ProCatalog proCatalog){
    	procatalogDaoImpl.addOne(proCatalog);
	}
	
	public List<ProCatalog> getAll(){
		return procatalogDaoImpl.getAll();
	}
	public ProCatalog getOne(int id){
		return procatalogDaoImpl.getOne(id);
	}
	public void deleteById(int id){
		procatalogDaoImpl.deleteById(id);
    }
    public void deleteOne(ProCatalog proCatalog){
    	procatalogDaoImpl.deleteOne(proCatalog);
    }
    public ProcatalogDTO getProcatalogDTO(int id){
    	ProcatalogDTO procatalogDTO=new ProcatalogDTO();
    	ProCatalog p=procatalogDaoImpl.getOne(id);
    	int parentid=p.getParentid();
    	String parentname;
    	if(parentid==0){
    		parentname="无";
    	}
    	else{
    		parentname=procatalogDaoImpl.getOne(parentid).getName();
    	}
    	procatalogDTO.setId(p.getId());
    	procatalogDTO.setName(p.getName());
    	procatalogDTO.setParentid(p.getParentid());
    	procatalogDTO.setParentname(parentname);
    	procatalogDTO.setState(p.getState());
    	procatalogDTO.setCatalognumber(p.getCatalognumber());
    	return procatalogDTO;
    }
    public List<ProcatalogDTO> getAllProcatalogDTOs(){
    	List procatalogs=this.getAll();
    	Iterator<ProCatalog> iter=procatalogs.iterator();
    	List<ProcatalogDTO> procatalogDTOs=new ArrayList<ProcatalogDTO>();
    	while(iter.hasNext()){
    		ProCatalog p=iter.next();
    		int parentid=p.getParentid();
        	String parentname;
        	if(parentid==0){
        		parentname="无";
        	}
        	else{
        		parentname=procatalogDaoImpl.getOne(parentid).getName();
        	}
        	ProcatalogDTO procatalogDTO=new ProcatalogDTO();
        	procatalogDTO.setId(p.getId());
        	procatalogDTO.setName(p.getName());
        	procatalogDTO.setParentid(p.getParentid());
        	procatalogDTO.setParentname(parentname);
        	procatalogDTO.setState(p.getState());
        	procatalogDTO.setCatalognumber(p.getCatalognumber());
        	procatalogDTOs.add(procatalogDTO);
		}
		return procatalogDTOs;
    }
}
