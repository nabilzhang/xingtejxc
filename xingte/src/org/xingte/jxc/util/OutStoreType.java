package org.xingte.jxc.util;

public enum OutStoreType {
	ForSellOutStore{
    	public String toString(){
    	     return "销售出库";
    	}
    },
    PurchaseBackStore{
    	public String toString(){
    		return "采购退还出库";
    	}   	
    } ;
}
