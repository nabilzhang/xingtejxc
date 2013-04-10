package org.xingte.jxc.util;

public enum OrderState {
	Unsend{
    	public String toString(){
    	     return "未发出";
    	}
    },
    Send{
    	public String toString(){
    		return "已发出";
    	}   	
    },
    Received{
    	public String toString(){
    		return "已收到";
    	}   
    };
}
