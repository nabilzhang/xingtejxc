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