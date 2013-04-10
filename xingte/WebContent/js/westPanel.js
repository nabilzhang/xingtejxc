var store = Ext.create('Ext.data.TreeStore', {
    root: {
    	expanded: true, 
        text:"",
        user:"",
        status:"",
        children: [
            {text:"detention",leaf: true},
            {text:"book", leaf: true },
            {text:"alegrbra", leaf: true},
            {text: "buy", leaf:true }
        ]
    }
});

var treePanel=new Ext.tree.TreePanel({
	title:'树形菜单',
    store:store,
    layout:'fit',
    autoWidth:true,
    autoHeigth:true,
    rootVisible:false,
    autoScroll:true
});


var slideNavItem1=new Ext.Panel({
	title:'采购管理',
	html:'second 发发发发发发   ',
	width:200
});



var westPanel=new Ext.Panel({
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
	items:[slideNavItem1,treePanel]
});