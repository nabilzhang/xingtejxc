package org.xingte.jxc.service;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;
import org.xingte.jxc.model.User;
/**
 * @author Administrator
 *
 */
public class UserServiceTest {
	UserService userservice =new UserService();
	@Test
	public void testAddUserTest() throws Exception{
		User user=new User();
		user.setId(1);
		user.setName("admin001");
		user.setPassword("admin888");
		user.setState(1);
		Assert.assertEquals(userservice.addUser(user), 1);
		System.out.print(user.toString());
	}
	
	@Test
	public void testGetAllUsers()throws Exception{
		
		Iterator<User> iter =userservice.getAllUsers().iterator();
		while(iter.hasNext()){			
			System.out.println(iter.next().toString());			
		}
	}
	@Test
	public void testgetOneById(){
		User u=userservice.GetOneUserById(11);
		System.out.println(u.toString());
	}
	@Test
	public void testLogon(){
		User user=new User();
		user.setName("admin");
		user.setPassword("admin888");
		boolean a= userservice.Logon(user);
		Assert.assertTrue(a);
	}
	
}
