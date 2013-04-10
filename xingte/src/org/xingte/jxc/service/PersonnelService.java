package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
import org.xingte.jxc.daoimpl.PostDaoImpl;
import org.xingte.jxc.dto.PersonnelDTO;
import org.xingte.jxc.model.Personnel;


public class PersonnelService {
	private PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	private PostDaoImpl postDaoImpl=new PostDaoImpl();
	/**
	 * 添加一个职员
	 * @param personnel
	 */
	public void addPersonnel(Personnel personnel){
		personnelDaoImpl.addPersonnel(personnel);
	}
	public void addPersonnel(PersonnelDTO personnelDTO){
		Personnel p=new Personnel();
		p.setName(personnelDTO.getName());
		p.setPostid(personnelDTO.getPostid());
		p.setDegree(personnelDTO.getDegree());
		p.setWorkexperience(personnelDTO.getWorkexperience());
		p.setState(personnelDTO.getState());
		
		this.addPersonnel(p);
	}
	
	/**
	 * 返回所有职员
	 * @return
	 */
	private List<Personnel> getAllPersonnels(){
		return personnelDaoImpl.getPersonnels();
	}
	/**
	 * 返回所有职员(拥有所有的)
	 * @return
	 */
	public List<PersonnelDTO> getAllPersonnelDTOs(){
		List personnels=this.getAllPersonnels();
		Iterator<Personnel> iter=personnels.iterator();
		List<PersonnelDTO> personnelDTOs=new ArrayList<PersonnelDTO>();
		
		while(iter.hasNext()){
			Personnel p=iter.next();
			int postid=p.getPostid();
			String postname;
			if(postid==0){
				postname="无职位";
			}else{
				postname=postDaoImpl.getOneById(postid).getName();
			}
			
			PersonnelDTO personnelDTO=new PersonnelDTO(p.getId(), p.getName(), p.getPostid()
					, postname, p.getDegree(), p.getWorkexperience(), p.getState());
			
			personnelDTOs.add(personnelDTO);
			
		}
		return personnelDTOs;
	}

}
