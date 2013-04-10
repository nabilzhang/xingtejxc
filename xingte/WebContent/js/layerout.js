/**
 * @author Administrator
 */
Ext.onReady(function(){
	
	
	var viewport=new Ext.Viewport({
		layout:'border',
		hideBorders:true,
		items:[{
				region:'north',
				contentEl:'header',
				height:80,
				xtype:'panel',
				hideBorders:true,
				autoShow:true
			},{
				region:'south',
				html:'southafafa',
				title:'south',
				height:25
			},{
				region:'west',
				title:'功能菜单',
				split:true,
				collapsible:true,
				width:200,
				layout:'accordion',
				layoutConfig:{
					titleCollapse:true,
					animate:true,
					activeOnTop:false					
				},
				items:[{
					title:'采购管理'
				},{
					title:'second',
					html:'second'
				},{
					title:'third',
					html:'third'
				}]
			},{
				region:'center',
				xtype:'tabpanel',
				items:[{
					title:'defalt',
					html:'jsp'
				},{
					title:'2',
					html:'2',
					closable:true
				}],
				split:true
				
			}]
	});
	
/*	var tree1=new Ext.tree.TreePanel()({
		root:new Ext.tree.TreeNode({
			text:我是根
		}),
		animate:true,
		containerScroll:true
	});*/
});