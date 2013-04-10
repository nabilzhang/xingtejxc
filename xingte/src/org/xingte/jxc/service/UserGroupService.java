package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.daoimpl.LimitDaoImpl;
import org.xingte.jxc.daoimpl.UserGroupDaoImpl;
import org.xingte.jxc.dto.UserGroupDTO;
import org.xingte.jxc.model.Limit;
import org.xingte.jxc.model.UserGroup;

public class UserGroupService {
	private LimitDaoImpl limitDaoImpl=new LimitDaoImpl();
	private UserGroupDaoImpl userGroupDaoImpl=new UserGroupDaoImpl();
	
	public void addUserGroup(UserGroup userGroup,List<Limit> limits){
		userGroupDaoImpl.add(userGroup);
		Iterator<Limit> iter=limits.iterator();
		while(iter.hasNext()){
			Limit limit=iter.next();
			limitDaoImpl.addOne(limit);
		}
	}
	
	public void updateUserGroup(UserGroup userGroup,List<Limit> limits){
		if(userGroupDaoImpl.existById(userGroup.getId())){
			//删除旧的用户组
			userGroupDaoImpl.deleteById(userGroup.getId());
			//以下取出旧的权限并删掉
			List<Limit> oldlimits=limitDaoImpl.getLimitsByGroupId(userGroup.getId());
			Iterator<Limit> olditer=oldlimits.iterator();
			while(olditer.hasNext()){
				Limit oldlimit=olditer.next();
				limitDaoImpl.deleteLimit(oldlimit);
			}		
		}
		addUserGroup(userGroup, limits);
	}
	
	public List<UserGroupDTO> getAllUserGroupDTOs(){
		List<UserGroupDTO> userGroupDTOs=new ArrayList<UserGroupDTO>();
		List<UserGroup> userGroups=userGroupDaoImpl.getUserGroups();
		Iterator<UserGroup> usergroupiter=userGroups.iterator();
		while(usergroupiter.hasNext()){
			UserGroup ug=usergroupiter.next();
			UserGroupDTO userGroupDTO=new UserGroupDTO();
			userGroupDTO.setId(ug.getId());
			userGroupDTO.setDecription(ug.getDecription());
			userGroupDTO.setName(ug.getName());
			userGroupDTO.setState(ug.getState());
			List<Limit> limits=limitDaoImpl.getLimitsByGroupId(ug.getId());
			Iterator<Limit> lmtsiter=limits.iterator();
			String limitsplus=new String();
			while(lmtsiter.hasNext()){
				limitsplus+=lmtsiter.next().getName()+",";
			}
			limitsplus=limitsplus.substring(0, limitsplus.length()-1);
			userGroupDTO.setLimits(limitsplus);
			userGroupDTOs.add(userGroupDTO);
		}
		return userGroupDTOs;
	}
}
