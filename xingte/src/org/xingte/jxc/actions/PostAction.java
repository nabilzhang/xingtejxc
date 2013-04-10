package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.dto.PostDTO;
import org.xingte.jxc.service.PostService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven{
	private PostService postService=new PostService ();
	private List<PostDTO> postDTOs;

	public void setPostDTOs(List<PostDTO> postDTOs) {
		this.postDTOs = postDTOs;
	}
	//显示所有职位
	public String getAllPost(){
		postDTOs=postService.getAllPostDTOs();
		return "allpost";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return postDTOs;
	}
	
	
}
