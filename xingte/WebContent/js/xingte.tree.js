Ext.namespace("Xingte");

Xingte.createTree=function(){
	var store = Ext.create('Ext.data.TreeStore', {
    root:{
    	expanded: true,
        text:"菜单",
        user:"",
        status:"",
        children: [
            {id:"x",text:"采购管理",
            	children:[
            		{text:"采购订单列表", leaf: true },
            		{text:"新建采购订单", leaf: true }
            	]
            },
            {text:"销售管理",
            	children:[
            		{text:"销售订单列表", leaf: true },
            		{text:"新建销售订单", leaf: true }
            	]
            },
            {text:"库存管理",
            	children:[
            		{text:"商品库存列表", leaf: true },
            		{text:"入库管理", leaf: true },
            		{text:"出库管理", leaf: true }
            	]
            },
            {text: "配送管理",
            	children:[
            		{text:"配送单列表", leaf: true },
            		{text:"新建配送单", leaf: true }
            	]
            },
            {text: "统计分析",
            	children:[
            		{text:"采购统计", leaf: true },
            		{text:"销售统计", leaf: true },
            		{text:"库存统计", leaf: true }
            	]
            },
            {text: "基础信息",
            	children:[
            		{text:"地区管理", leaf: true },
            		{text:"客户管理", leaf: true },
            		{text:"业务员管理", leaf: true },
            		{text:"岗位管理", leaf: true },
            		{text:"部门管理", leaf: true },
            		{text:"供货商管理", leaf: true },
            		{text:"商品分类管理", leaf: true },
            		{text:"商品管理", leaf: true }
            	]
            },
            {text: "用户权限管理",
            	children:[
            		{text:"销售订单列表", leaf: true },
            		{text:"新建销售订单", leaf: true }
            	]
            }
        ]
    }
	});
	
	var treePanel=new Ext.tree.TreePanel({
	title:'系统菜单',
	region:'west',
	id:'tree',
    store:store,
    slide:true,
    split:true,
    width:200,
    collapsible:true,
    scroll:true
	});
	
	
	
	/*Ext.getCmp("tree").on('click',function(node){
		if(node.id=="x"){			
			var tabitem=tabpanel.getItem('x');
			if(tabitem==null){
				tabitem=tabpanel.add(new Ext.TabPanel({
					id:"x",
					title:"x",
					closable:true,
					html:'hao'
				}));
			}
		}
	});*/
	
	/**Ext.EventManager.addListener(Ext.getCmp("tree"),"click",function(node){
		if(node.id=="x"){			
			var tabitem=tabpanel.getItem('x');
			if(tabitem==null){
				tabitem=tabpanel.add(new Ext.TabPanel({
					id:"x",
					title:"x",
					closable:true,
					html:'hao'
				}));
			}
		}
	});*/
	
	treePanel.on('click',function(){
		Ext.Msg.alert("","");
	});
	
	return treePanel;
};