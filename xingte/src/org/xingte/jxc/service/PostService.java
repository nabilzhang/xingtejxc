package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.daoimpl.DepartmentDaoImpl;
import org.xingte.jxc.daoimpl.PostDaoImpl;
import org.xingte.jxc.dto.PostDTO;
import org.xingte.jxc.model.Post;

public class PostService {
	private PostDaoImpl postDaoImpl=new PostDaoImpl();
	private DepartmentDaoImpl departmentDaoImpl=new DepartmentDaoImpl();
	
	public void addPost(Post post){
		postDaoImpl.addOne(post);
	}
	
	public void addPost(PostDTO postDTO){
		Post post=new Post();
		post.setName(postDTO.getName());
		post.setDescription(post.getDescription());
		post.setDepartmentid(postDTO.getDepartmentid());
		post.setState(postDTO.getState());
		this.addPost(post);
	}
	
	public List<Post> getAllPosts(){
		return postDaoImpl.getAll();
	}
	
	public List<PostDTO> getAllPostDTOs(){
		List posts=postDaoImpl.getAll();
		Iterator<Post> iter=posts.iterator();
		List<PostDTO> postDTOs=new ArrayList<PostDTO>();
		while(iter.hasNext()){
			Post post=iter.next();
			PostDTO postDTO=new PostDTO(post.getId(),post.getName(),post.getDepartmentid(),
					departmentDaoImpl.getOneById(post.getDepartmentid()).getName(),post.getDescription(),
					post.getState());
			postDTOs.add(postDTO);
		}
		return postDTOs;
	}
	
}
