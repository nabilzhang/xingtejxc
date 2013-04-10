package org.xingte.jxc.service;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;
import org.xingte.jxc.dto.PurchaseOrderDTO;

public class PurchaseTest {
	private PurchaseOrderService purchaseOrderService=
		new PurchaseOrderService();
	@Test
	public void testAllPurchaseOrderList(){
		List<PurchaseOrderDTO> ps=purchaseOrderService.getAllPurchaseOrders();
		Iterator<PurchaseOrderDTO> iter=ps.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
	@Test
	public void testJSONObject() throws UnsupportedEncodingException{
		String info="[{\"productid\":1,\"productname\":\"\u5c0f\u679d\u6c5f\u767d\u9152\",\"purchaseprice\":9,\"amount\":9,\"units\":\"hh\",\"id\":\"\"}]";
		//String info="[{\"productid\":1,\"productname\":\"hao\",\"purchaseprice\":9,\"amount\":9,\"units\":\"hh\",\"id\":\"\"}";
		//System.out.println(new String(info.getBytes("utf-8"),"utf-8"));
		System.out.println(info);
//		List x=JSONUtil.asList(info);
//		System.out.print("\n");
//		Iterator i=x.iterator();
//		while(i.hasNext()){
//			System.out.println(i.next().toString());
//		}
		JSONArray jarr=(JSONArray)JSONValue.parse(info);
		for(int i=0;i<jarr.size();i++){
			JSONObject jo=(JSONObject)jarr.get(i);
			System.out.println(jo.get("productname"));
		}
		System.out.println(jarr.toJSONString());		
		System.out.print(jarr.size());
	}
}
