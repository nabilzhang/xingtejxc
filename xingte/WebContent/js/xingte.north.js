Ext.namespace("Xingte");
//采购管理菜单
Xingte.createPurchaseMenu=function(){
	var purchasemenu =new Ext.menu.Menu({
		items:[
			{id:"p1",text:'采购订单列表'},
			{id:"p2",text:'新建采购订单'	}
		]
	});	
	return purchasemenu;
};
//销售管理
Xingte.createSellMenu=function(){
	var sellmenu =new Ext.menu.Menu({
		items:[
			{id:"s1",text:'销售订单列表'},
			{id:"s2",text:'新建销售订单'}
		]
	});	
	return sellmenu;
};
//库存管理
Xingte.createStockMenu=function(){
	var stockmenu =new Ext.menu.Menu({
		items:[
			{id:"t1",text:'商品库存列表'},
			{id:"t2",text:'入库管理'},
			{id:"t3",text:'出库管理'},
			{id:"t4",text:'库存盘点'}
		]
	});	
	return stockmenu;
};
//配送管理
Xingte.createSendMenu=function(){
	var sendmenu =new Ext.menu.Menu({
		items:[
			{id:"sd1",text:'配送单列表'},
			{id:"sd2",text:'创建配送单'}
		]
	});	
	return sendmenu;
};
//统计分析
Xingte.createAnalyseMenu=function(){
	var analysemenu =new Ext.menu.Menu({
		items:[
			{id:"al1",text:'采购统计'},
			{id:"al2",text:'销售统计'},
			{id:"al3",text:'库存统计'}
		]
	});	
	return analysemenu;
};
//用户管理菜单
Xingte.createUserMenu=function(){
	var usermenu=new Ext.menu.Menu({
		items:[
			{id:"u1",text:'所有用户'},
			{id:"u2",text:'系统日志'},
			{id:'u3',text:'用户组管理'}
		]
	});
	return usermenu;
};
//基础信息菜单
Xingte.createBasicInfoMenu=function(){
	var basicInfoMenu=new Ext.menu.Menu({
		items:[
			{id:'b1',text:'地区管理'},
			{id:'b2',text:'客户管理'},
			{id:'b3',text:'业务员管理'},
			{id:'b4',text:'岗位管理'},
			{id:'b5',text:'部门管理'},
			{id:'b6',text:'供货商管理'},
			{id:'b7',text:'商品分类管理'},
			{id:'b8',text:'商品管理'}
		]
	});
	return basicInfoMenu;
};


Xingte.createTopbar=function(){
	var toolbar=new Ext.Toolbar();
	return toolbar;
};

Xingte.getUsername=function(){
	var name=new String();
	
	Ext.Ajax.request({
    		url: 'useroper/user',
    		method:'POST',
    		success: function(arg){
    				var jsonResult = Ext.JSON.decode(arg.responseText,true);
                	this.name=jsonResult.model.name;
    			}
			});
	return this.name;
};

Xingte.checklogin=function(name,pass){
	var ifscc;
	Ext.Ajax.request({
    		url: 'json/ajaxlogon.action',
    		method:'POST',
    		params: {
        		name:name,
        		password:pass
    		},
    		success: function(arg){
    				var jsonResult = Ext.JSON.decode(arg.responseText,true);
                	if(jsonResult.result==='0'){
                		ifscc=false;
                	}else{
                		ifscc=true;
                	}
    			}
			});	
	return ifscc;
};

Xingte.createTopBanner=function(toolbar){	
	var northPanel=new Ext.Panel({
	region:'north',
	hideBorders:true,
	autoShow:true,
	layout:'vbox',
	contentEl:'header',
	height:100,
	bbar:toolbar	
	});

	Ext.get("topchangepass").on("click",function(){
		var win;		
    	function showChangePassForm() {    		
        	if (!win) {
            	var form = Ext.widget('form', {
                	layout: {
                    	type: 'vbox',
                   	 	align: 'stretch'
                	},
                	border: false,
                	bodyPadding: 10,
                	fieldDefaults: {
                    	labelStyle: 'font-weight:bold'
                	},
                	defaults: {
                    	margins: '0 0 10 0'
                	},
                	items: [{
                   	 	xtype: 'displayfield',
                    	fieldLabel: '您的帐号',
                   		allowBlank: false,                   		
                   		value:Xingte.getUsername()
                   		
                	}, {
                    	xtype: 'textfield',
                    	fieldLabel: '原密码',
                    	allowBlank: false,
                    	inputType:'password',
                    	maxLength:20,
                    	id:'oldpass',
                    	name:'oldpass'
                	}, {
                    	xtype: 'textfield',
                    	fieldLabel: '新密码',
                    	allowBlank: false,
                    	inputType:'password',
                    	maxLength:20,
                    	id:'password',
                    	name:'password'
                	},{
                		xtype: 'textfield',
                    	fieldLabel: '重复密码',
                    	allowBlank: false,
                    	inputType:'password',
                    	maxLength:20,
                    	id:'confirmpass',
                    	name:'confirmpass'
                	}],

                	buttons: [{
                    	text: '取消',
                    	handler: function() {
                        	this.up('form').getForm().reset();
                        	this.up('window').hide();
                    	}
                	}, {
                    	text: '确认',
                    	handler: function() {
                        	if (this.up('form').getForm().isValid()) {
                            // In a real application, this would submit the form to the configured url
                            // this.up('form').getForm().submit();
                        		var oldpass=this.up('form').getForm().findField('oldpass').getValue();
                        		var newpass=this.up('form').getForm().findField('password').getValue();
                        		var confirmpass=this.up('form').getForm().findField('confirmpass').getValue();
                        		
                        		if(newpass !== confirmpass){
                        			Ext.MessageBox.alert('错误','两次密码输入不一致,请重新输入！');
                        			return;
                        		}
                        		name=Xingte.getUsername();
                        		if(!Xingte.checklogin(name,oldpass)){
                        			Ext.MessageBox.alert('错误','原密码错误！');
                        			return
                        		}
                        		
                        		this.up('form').getForm().reset();
                            	this.up('window').hide();
                            	Ext.MessageBox.alert('成功!', '密码修改成功.');
                        	}
                    	}
                	}]
            	});

            	win = Ext.widget('window', {
                	title: '修改密码',
                	closeAction: 'hide',
                	width: 300,
                	height:250,
                	minHeight: 250,
                	layout: 'fit',
                	resizable: false,
                	modal: true,
                	items: form
            	});
        	}
        	win.show();
    		}
    	showChangePassForm();
	});
	
	Ext.get("topexit").on('click',function(){
		Ext.MessageBox.show({
			title:'退出',
			msg:'你确定要退出吗？',
			buttons:Ext.MessageBox.OKCANCEL,
			fn:function(btn){
				if(btn=="ok"){
					window.location.href = "User!logonout";
				}
			}
		});
	});	
	return northPanel;
};