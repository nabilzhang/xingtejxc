/**
 * @author Administrator
 */
 
/*
 * 左边导航部分
 */
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
var treeinit=function(){
	treePanel.on("click",function(node){
	Ext.Msg.show({
		title:'',
		msg:node
	});
});
};


var slideNavItem1=new Ext.Panel({
	title:'采购管理',
	html:'second 发发发发发发   ',
	width:200
});


//左边panel
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
 
/*
 * 正上方标题部分
 * 
 * 
 */ 

var northPanel=new Ext.Panel({
	region:'north',
	contentEl:'header',
	height:80,
	hideBorders:true,
	autoShow:true
});

/*
 * 中间主体部分
 */
var innerPanel=new Ext.TabPanel({
	region:'center',
	height:'100%',
	hideBorders:true,
	layout:'fit',
	items:[{
		id:'x',
		title:'defalt',
		html:'jsp'
		},{
		id:'y',
		title:'defalt',
		loader:'http://www.baidu.com'
		}],
	split:true
});

/*
 * 下方状态栏部分
 */
var southPanel=new Ext.Panel({
	region:'south',
	html:'southafafa',
	title:'south',
	height:25
});

Ext.onReady(function(){	
	treeinit();
	var viewport=new Ext.Viewport({
		layout:'border',
		hideBorders:true,
		items:[northPanel,southPanel,westPanel,innerPanel]
	});
});
