package org.xingte.jxc.actions;

import org.xingte.jxc.model.Post;
import org.xingte.jxc.service.PostService;

import com.opensymphony.xwork2.ActionSupport;

public class AddPostAction extends ActionSupport{
	private PostService postService=new PostService();
	
	public String result;
	
	public String addPost(){
		Post post=new Post();
		post.setName(name);
		post.setDepartmentid(departmentid);
		post.setDescription(description);
		postService.addPost(post);
		result="1";
		return "addpost";
	}
	
	private String name;
	private int departmentid;
	private String description;
	
	public String getResult() {
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
