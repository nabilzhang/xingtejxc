package org.xingte.jxc.service;

import java.util.Iterator;
import java.util.List;



import org.junit.Test;
import org.xingte.jxc.dto.InStoreOrderDTO;
import org.xingte.jxc.dto.PurchaseOrderDTO;
import org.xingte.jxc.model.InStoreOrder;

public class InStoreTest {
	private InStoreOrderService is=new InStoreOrderService();
	@Test
	public void testAllInStores(){
		InStoreOrder ii=is.getById(2);
		System.out.println(ii);
//		List<InStoreOrderDTO> ps=is.getInStoreOrderDTOs();
//		Iterator<InStoreOrderDTO> iter=ps.iterator();
//		while(iter.hasNext()){
//			System.out.println(iter.next());
//		}
	}

}
