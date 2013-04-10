package org.xingte.jxc.service;
import java.util.Iterator;

import org.junit.Test;
import org.junit.Assert;
import org.xingte.jxc.daoimpl.AreaDaoImpl;
import org.xingte.jxc.dto.AreaDTO;
import org.xingte.jxc.dto.CustomerDTO;
import org.xingte.jxc.dto.PersonnelDTO;
import org.xingte.jxc.model.Area;
import org.xingte.jxc.model.Department;
import org.xingte.jxc.model.User;
public class BasicInfoTest {
	AreaService areaService=new AreaService();
	DepartmentService departmentService=new DepartmentService();
	@Test
	public void testAddArea(){
		Area area=new Area();
		area.setName("汉川");
		area.setParentid(0);
		area.setState(0);
		
		AreaDaoImpl areaDaoImpl=new AreaDaoImpl();
		areaDaoImpl.addOne(area);
		
		
	}
	
	@Test
	public void testGetAllUsers()throws Exception{
		
		Iterator<Area> iter =new AreaDaoImpl().getAll().iterator();
		while(iter.hasNext()){			
			System.out.println(iter.next().toString());			
		}
	}
	
	@Test
	public void testGetAllAreaDTOs(){
		Iterator<AreaDTO> iter =areaService.getAllArea().iterator();
		while(iter.hasNext()){			
			System.out.println(iter.next().toString());			
		}
	}
	/**
	 * 测试添加部门
	 */
	@Test
	public void testAddDepartment(){
		Department department=new Department();
		department.setName("销售部");
		department.setDescription("主要负责销售");
		department.setState(0);
		departmentService.addDepartment(department);
	}
	/**
	 * 测试获取所有部门
	 */
	@Test
	public void testGetAllDepartment(){
		Iterator<Department> iter =departmentService.getAllDepartments().iterator();
		while(iter.hasNext()){			
			System.out.println(iter.next().toString());			
		}
	}
	/**
	 * 测试获得所有职员
	 */
	@Test
	public void testGetAllPersonnelDTOs(){
		Iterator<PersonnelDTO> iter=new PersonnelService().getAllPersonnelDTOs().iterator();
		while(iter.hasNext()){			
			System.out.println(iter.next().toString());			
		}
	}
	@Test
	public void testGetAllCustomerDTOs(){
		Iterator<CustomerDTO> iter=new CustomerService().getAllCustomerDTOs().iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().toString());	
		}
	}
}
