package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
import org.xingte.jxc.daoimpl.UserDaoImpl;
import org.xingte.jxc.daoimpl.UserGroupDaoImpl;
import org.xingte.jxc.dto.UserDTO;
import org.xingte.jxc.model.User;

public class UserService {
	private static final int HASTHEUSER=0;
	private static final int NOTHASTHEUSER=1;
	private UserDaoImpl userDaoImpl=new UserDaoImpl();
	private PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	private UserGroupDaoImpl userGroupDaoImpl=new UserGroupDaoImpl();
	public int addUser(User u){
		int flag=HASTHEUSER;
		if(!userDaoImpl.existByUsername(u.getName())){
			flag=NOTHASTHEUSER;
			userDaoImpl.add(u);
		}
		return flag;
	}
	
	//用户登录
	public boolean Logon(User u){
		boolean flag=false;
		if(userDaoImpl.existByUsernameAndPassWord(u.getName(),u.getPassword()))
		{
			flag=true;
		}
		return flag;
	}
	
	//返回所有用户
	public List<User> getAllUsers(){
		List<User> list=null;
		try{
			list=userDaoImpl.getUsers();
		}catch(Exception e){
			
		}
		return list;
	}
	
	//返回用户DTO
	public List<UserDTO> getAllUserDTOs(){
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		List<User> users=userDaoImpl.getUsers();
		Iterator<User> useriter=users.iterator();
		while(useriter.hasNext()){
			User u=useriter.next();
			UserDTO userDTO=new UserDTO();
			userDTO.setId(u.getId());
			userDTO.setName(u.getName());
			userDTO.setPassword(u.getPassword());
			userDTO.setPersonnelname(personnelDaoImpl.getById(u.getPersonnelid()).getName());
			userDTO.setGroupname(userGroupDaoImpl.getOneById(u.getGroupid()).getName());
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}
	
	public User GetOneUserById(int id){
		return userDaoImpl.getOneById(id);
	}
	public User GetOneUserByName(String name){
		return userDaoImpl.getOneByName(name);
	}
}
