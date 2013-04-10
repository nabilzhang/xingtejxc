/**
 * @author 张弼
 * @version 1.0
 */
/**
 * 以下为基础信息及权限管理
 */
//添加地区表单
var showAddAreaForm=function(){
		var win;  		
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
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '地区名称',
                    allowBlank: false,
                    maxLength:20,
                    name:'name',
                    id:'areaname'
                },Ext.create('Ext.form.ComboBox',{
                	fieldLabel: '上级地区',
    				store:Ext.create('Ext.data.Store', {
    					
        					fields: [
        					{name:'id',mapping:'id'},
        					{name:'name',mapping:'name'},
        					'parentid',
        					{name:'parentname',mapping:'parentname'}
        					]
    					,
    					proxy:{
            				type: 'ajax',
           					url: 'baseinfo/reAreaList.action',
            				reader: {
                				type: 'json',
                				root: 'model'
            				}
        				}
					}),
					id:'upareaid',
					emptyText:'请选择',
    				queryMode: 'remote',
    				displayField: 'name',
    				editable:false,
    				valueField: 'id',
    				listeners:{
    					
    				}

                })
                ],

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
                        	var areaname=this.up('form').getForm().findField('areaname').getValue();
                            var upareaid=this.up('form').getForm().findField('upareaid').getValue();

                            Ext.Ajax.request({
    							url: 'baseinfo/addArea.action',
    							method:'POST',
    							params: {
        							areaname:areaname,
        							upareaid:upareaid
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加地区',
                closeAction: 'hide',
                width: 300,
                height:150,
                minHeight: 150,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//添加用户表单
var showAddUserForm=function(){
		var win;  		
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
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '用户名称',
                    allowBlank: false,
                    maxLength:20,
                    id:'auname'
                },{
                	xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '密码',
                    allowBlank: false,
                    maxLength:20,
                    id:'aupassword'
                },{
                	xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '确认密码',
                    allowBlank: false,
                    maxLength:20,
                    id:'auconfirmpassword'
                },Ext.create('Ext.form.ComboBox',{
                	fieldLabel: '对应员工',
    				store:Ext.create('Ext.data.Store', {    					
        					fields: [
        					{name:'id',mapping:'id'},
        					{name:'name',mapping:'name'},
        					'parentid',
        					{name:'parentname',mapping:'parentname'}
        					]
    					,
    					proxy:{
            				type: 'ajax',
           					url: 'baseinfo/PersonnelList.action',
            				reader: {
                				type: 'json',
                				root: 'model'
            				}
        				}
					}),
					id:'aupid',
					emptyText:'请选择',
    				queryMode: 'remote',
    				displayField: 'name',
    				editable:false,
    				valueField: 'id',
    				listeners:{
    					
    				}

                }),
                Ext.create('Ext.form.ComboBox',{
                	fieldLabel: '用户组',
    				store:Ext.create('Ext.data.Store', {    					
        					fields: [
        					{name:'id',mapping:'id'},
        					{name:'name',mapping:'name'},
        					'parentid',
        					{name:'parentname',mapping:'parentname'}
        					]
    					,
    					proxy:{
            				type: 'ajax',
           					url: 'baseinfo/UserGroupList.action',
            				reader: {
                				type: 'json',
                				root: 'model'
            				}
        				}
					}),
					id:'auugid',
					emptyText:'请选择',
    				queryMode: 'remote',
    				displayField: 'name',
    				editable:false,
    				valueField: 'id'
                })
                ],
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
                        	var auname=this.up('form').getForm().findField('auname').getValue();
                            var aupassword=this.up('form').getForm().findField('aupassword').getValue();
                            var auconfirmpassword=this.up('form').getForm().findField('auconfirmpassword').getValue();
                            var aupid=this.up('form').getForm().findField('aupid').getValue();
                            var auugid=this.up('form').getForm().findField('auugid').getValue();
                            
                            if(aupassword!==auconfirmpassword){
                            	Ext.MessageBox.alert('错误','两次密码不一致');
                            	return;
                            }
                            
                            Ext.Ajax.request({
    							url: 'baseinfo/AddUser.action',
    							method:'POST',
    							params: {
        							name:auname,
        							password:aupassword,
        							personnelid:aupid,
        							groupid:auugid
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加用户',
                closeAction: 'hide',
                width: 300,
                height:300,
                minHeight: 150,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};


//添加部门表单
var showAddDepartmentForm=function(){
		var win;  		
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
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '部门名称',
                    allowBlank: false,
                    maxLength:20,
                    name:'name',
                    id:'departmentname'
                },{
                	xtype: 'textareafield',
                    emptyText:'请填写',
                    fieldLabel: '部门描述',
                    allowBlank: false,
                    labelAlign:'top',
                    maxLength:20,
                    name:'dspn',
                    id:'departmentdspn'
                }
                ],

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
                        	var departmentname=this.up('form').getForm().findField('departmentname').getValue();
                            var departmentdspn=this.up('form').getForm().findField('departmentdspn').getValue();

                            Ext.Ajax.request({
    							url: 'baseinfo/AddDepartment',
    							method:'POST',
    							params: {
        							name:departmentname,
        							description:departmentdspn
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加地区',
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
};

//添加岗位表单
var showAddPersonnelForm=function(){
		var win;  		
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
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '姓名',
                    allowBlank: false,
                    maxLength:20,
                    name:'name',
                    id:'personnelname'
                },Ext.create('Ext.form.ComboBox',{
                	fieldLabel: '岗位',
    				store:Ext.create('Ext.data.Store', {
    					
        					fields: [
        					{name:'id',mapping:'id'},
        					{name:'name',mapping:'name'}
        					]
    					,
    					proxy:{
            				type: 'ajax',
           					url: 'baseinfo/AllPost.action',
            				reader: {
                				type: 'json',
                				root: 'model'
            				}
        				}
					}),
					id:'ppost',
					emptyText:'请选择',
    				queryMode: 'remote',
    				displayField: 'name',
    				editable:false,
    				valueField: 'id',
    				listeners:{
    					
    				}

                }),{
                	xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '学历',
                    allowBlank: false,
                    maxLength:20,
                    id:'pdegree'
                },{
                	xtype: 'textareafield',
                    emptyText:'请填写',
                    fieldLabel: '工作经历',
                    allowBlank: false,
                    labelAlign:'top',
                    maxLength:20,
                    id:'pworkexprc'
                }
                ],

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
                        	var personnelname=this.up('form').getForm().findField('personnelname').getValue();
                            var ppost=this.up('form').getForm().findField('ppost').getValue();
                            var pdegree=this.up('form').getForm().findField('pdegree').getValue();
                            var pworkexprc=this.up('form').getForm().findField('pworkexprc').getValue();
                            Ext.Ajax.request({
    							url: 'baseinfo/AddPersonnel.action',
    							method:'POST',
    							params: {
    								name:personnelname,
    								postid:ppost,
    								degree:pdegree,
    								workexperience:pworkexprc
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加岗位',
                closeAction: 'hide',
                width: 300,
                height:300,
                minHeight:300,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};
//添加职员表单
var showAddPostForm=function(){
		var win;  		
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
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '岗位名称',
                    allowBlank: false,
                    maxLength:20,
                    name:'name',
                    id:'postname'
                },Ext.create('Ext.form.ComboBox',{
                	fieldLabel: '所在部门',
    				store:Ext.create('Ext.data.Store', {
    					
        					fields: [
        					{name:'id',mapping:'id'},
        					{name:'name',mapping:'name'}
        					]
    					,
    					proxy:{
            				type: 'ajax',
           					url: 'baseinfo/Department!reDepartmentList',
            				reader: {
                				type: 'json',
                				root: 'model'
            				}
        				}
					}),
					id:'padddepartmt',
					emptyText:'请选择',
    				queryMode: 'remote',
    				displayField: 'name',
    				editable:false,
    				valueField: 'id',
    				listeners:{
    					
    				}

                }),{
                	xtype: 'textareafield',
                    emptyText:'请填写',
                    fieldLabel: '岗位描述',
                    allowBlank: false,
                    labelAlign:'top',
                    maxLength:20,
                    id:'postdspn'
                }
                ],

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
                        	var postname=this.up('form').getForm().findField('postname').getValue();
                            var padddepartmt=this.up('form').getForm().findField('padddepartmt').getValue();
                            var postdspn=this.up('form').getForm().findField('postdspn').getValue();
                            Ext.Ajax.request({
    							url: 'baseinfo/AddPost.action',
    							method:'POST',
    							params: {
    								name:postname,
    								departmentid:padddepartmt,
    								description:postdspn
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加地区',
                closeAction: 'hide',
                width: 300,
                height:300,
                minHeight:300,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//添加客户表单
var showAddCustomerForm=function(){
		var win;  		
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                    	xtype:'fieldset',
                    	border: false,
                    	title:'基本信息',
                    	autoHeight:true,                   	
                    	items:[{
                    		fieldLabel:'编码',
                    		xtype: 'textfield',
                    		labelWidth:50,
                    		width:300,
                    		id:'acnumber'
                    	},{
                    		fieldLabel:'名称',
                    		xtype: 'textfield',
                    		width:300,
                    		id:'acname'
                    	},
                    	Ext.create('Ext.form.ComboBox',{
                			fieldLabel: '业务员',
    						store:Ext.create('Ext.data.Store', {
    							fields: [
        							{name:'id',mapping:'id'},
        							{name:'name',mapping:'name'}
        							],
    							proxy:{
            						type: 'ajax',
           							url: 'baseinfo/PersonnelList',
            						reader: {
                						type: 'json',
                						root: 'model'
            						}
        						}
							}),
							id:'acpersonnelid',
							emptyText:'请选择',
    						queryMode: 'remote',
    						displayField: 'name',
    						editable:false,
    						valueField: 'id',
    						listeners:{
    					
    						}
						})]
                	}]
                },{
                	xtype: 'fieldset',
                	border: false,
                    title:'联系信息',
                    autoHeight:true, 
                	items:[{
                		layout:'column',
                		border: false,
                		items:[{
                			columnWidth:.33,
                			defaultType:'textfield',
                			border: false,
                			items:[
                				{
                					minLength:6,
                					maxLength:6,
                					fieldLabel:'邮编',
                					width:150,
                					id:'acpostcode'
                				},
                				{
                					fieldLabel:'电话',
                					width:150,
                					id:'actelephone',
                					maxLength:12
                				}
                			]
                		},{
                			columnWidth:.33,
                			defaultType:'textfield',
                			border: false,
                			items:[
                				{
                					fieldLabel:'区号',
                					width:150,
                					id:'acareacode',
                					maxLength:6
                				},
                				{
                					fieldLabel:'传真',
                					width:150,
                					id:'acfax',
                					maxLength:12
                				}
                			]
                		},{
                			columnWidth:.33,
                			defaultType:'textfield',
                			border: false,
                			items:[
                				Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '地区',
    								store:Ext.create('Ext.data.Store', {
    									fields: [
        									{name:'id',mapping:'id'},
        									{name:'name',mapping:'name'}
        								],
    									proxy:{
            								type: 'ajax',
           									url: 'baseinfo/reAreaList',
            								reader: {
                								type: 'json',
                								root: 'model'
            								}
        								}
									}),
									id:'acareaid',
									emptyText:'请选择',
    								queryMode: 'remote',
    								width:180,
    								displayField: 'name',
    								editable:false,
    								valueField: 'id'
								})
                			]
                		}]
                	},{
                		xtype:'textfield',
                		fieldLabel:'地址',
                		width:250,
                		id:'acaddress'
                	}]                   
                }
                ],

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
                        	var acnumber=this.up('form').getForm().findField('acnumber').getValue();
                        	var acname=this.up('form').getForm().findField('acname').getValue();
                        	var acpersonnelid=this.up('form').getForm().findField('acpersonnelid').getValue();
                        	var acpostcode=this.up('form').getForm().findField('acpostcode').getValue();
                        	var actelephone=this.up('form').getForm().findField('actelephone').getValue();
                        	var acareacode=this.up('form').getForm().findField('acareacode').getValue();
                        	var acfax=this.up('form').getForm().findField('acfax').getValue();
                        	var acareaid=this.up('form').getForm().findField('acareaid').getValue();
                        	var acaddress=this.up('form').getForm().findField('acaddress').getValue();

                            Ext.Ajax.request({
    							url: 'baseinfo/AddCustomer.action',
    							method:'POST',
    							params: {
    									customernumber:acaddress,
    									name:acname,
    									salesmanid:acpersonnelid,
    									postcode:acpostcode,
    									telephone:actelephone,
    									areacode:acareacode,
    									fax:acfax,
    									areaid:acareaid,
    									address:acaddress
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加新客户',
                closeAction: 'hide',
                width: 600,
                height:400,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//添加供货商表单
var showAddSupplierForm=function(){
		var win;  		
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                    	xtype:'fieldset',
                    	border: false,
                    	title:'基本信息',
                    	autoHeight:true,      	
                    	items:[{
                    		fieldLabel:'编码',
                    		xtype: 'textfield',
                    		labelWidth:50,
                    		width:300,
                    		id:'apnumber'
                    	},{
                    		fieldLabel:'名称',
                    		xtype: 'textfield',
                    		width:300,
                    		id:'apname'
                    	},{
                    		fieldLabel:'类型',
                    		xtype: 'textfield',
                    		width:300,
                    		id:'aptype'
                    	}
                    	]
                	}]
                },{
                	xtype: 'fieldset',
                	border: false,
                    title:'联系信息',
                    autoHeight:true, 
                	items:[{
                		layout:'column',
                		border: false,
                		items:[{
                			columnWidth:.5,
                			defaultType:'textfield',
                			border: false,
                			items:[
                				{
                					minLength:6,
                					maxLength:6,
                					fieldLabel:'邮编',
                					width:150,
                					id:'appostcode'
                				},
                				{
                					fieldLabel:'电话',
                					width:150,
                					id:'aptelephone',
                					maxLength:12
                				}
                			]
                		},{
                			columnWidth:.5,
                			defaultType:'textfield',
                			border: false,
                			items:[
                				{
                					fieldLabel:'区号',
                					width:150,
                					id:'apareacode',
                					maxLength:6
                				},
                				{
                					fieldLabel:'传真',
                					width:150,
                					id:'apfax',
                					maxLength:12
                				}
                			]
                		}]
                	},{
                		xtype:'textfield',
                		fieldLabel:'地址',
                		width:250,
                		id:'apaddress'
                	}]
                }
                ],

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
                        	var apnumber=this.up('form').getForm().findField('apnumber').getValue();
                        	var apname=this.up('form').getForm().findField('apname').getValue();
                        	var aptype=this.up('form').getForm().findField('aptype').getValue();
                        	var appostcode=this.up('form').getForm().findField('appostcode').getValue();
                        	var aptelephone=this.up('form').getForm().findField('aptelephone').getValue();
                        	var apareacode=this.up('form').getForm().findField('apareacode').getValue();
                        	var apfax=this.up('form').getForm().findField('apfax').getValue();     
                        	var apaddress=this.up('form').getForm().findField('apaddress').getValue();

                            Ext.Ajax.request({
    							url: 'baseinfo/AddSupplier.action',
    							method:'POST',
    							params: {
    									suppliernumber:apaddress,
    									name:apname,
    									type:aptype,
    									postcode:appostcode,
    									telephone:aptelephone,
    									areacode:apareacode,
    									fax:apfax,
    									address:apaddress
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加新供货商',
                closeAction: 'hide',
                width: 600,
                height:400,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//添加商品分类表单
var showAddCatalogForm=function(){
		var win;  		
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
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '分类编号',
                    allowBlank: false,
                    maxLength:20,
                    name:'number',
                    id:'catanumber'
                },{
                    xtype: 'textfield',
                    emptyText:'请填写',
                    fieldLabel: '分类名称',
                    allowBlank: false,
                    maxLength:20,
                    name:'name',
                    id:'cataname'
                },Ext.create('Ext.form.ComboBox',{
                	fieldLabel: '上级分类',
    				store:Ext.create('Ext.data.Store', {    					
        					fields: [
        					{name:'id',mapping:'id'},
        					{name:'name',mapping:'name'},
        					'parentid',
        					{name:'parentname',mapping:'parentname'}
        					]
    					,
    					proxy:{
            				type: 'ajax',
           					url: 'baseinfo/ProCatalogList.action',
            				reader: {
                				type: 'json',
                				root: 'model'
            				}
        				}
					}),
					id:'cataparentid',
					emptyText:'请选择',
    				queryMode: 'remote',
    				displayField: 'name',
    				editable:false,
    				valueField:'id'
                })
                ],

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
                        	var catanumber=this.up('form').getForm().findField('catanumber').getValue();
                            var cataname=this.up('form').getForm().findField('cataname').getValue();
                            var cataparentid=this.up('form').getForm().findField('cataparentid').getValue();
                            Ext.Ajax.request({
    							url: 'baseinfo/AddProCatalog.action',
    							method:'POST',
    							params: {
        							catalognumber:catanumber,
        							name:cataname,
        							parentid:cataparentid       							
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加商品分类',
                closeAction: 'hide',
                width: 300,
                height:200,
                minHeight: 150,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//添加商品信息表单
var showAddProductForm=function(){
		var win;
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                    	xtype:'fieldset',
                    	border: false,
                    	title:'基本信息',
                    	autoHeight:true,                   	
                    	items:[{
                			layout:'column',
                			border: false,
                			allowBlank:false,
                			fieldDefaults: {
                    			labelStyle: 'font-weight:bold',
                    			labelWidth:90
                			},
                			items:[{
                				columnWidth:.5,
                				border: false,
                				defaultType:'textfield',
                				items:[{
                					fieldLabel:'商品编码',
                					width:230,
                					id:'aprnumber',
                					labelWidth:80
                				},{
                					fieldLabel:'计量单位',
                					width:230,
                					id:'aprunits',
                					labelWidth:80
                				}]
                			},{
                				columnWidth:.5,
                				defaultType:'textfield',
                				border: false,
                				items:[{
                					fieldLabel:'商品名称',
                					width:230,
                					id:'aprname',
                					labelWidth:80
                				},Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '商品分类',
    								store:Ext.create('Ext.data.Store', {    					
        							fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'},
        								'parentid',
        								{name:'parentname',mapping:'parentname'}
        								],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/ProCatalogList.action',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
									id:'aprcatalogid',
									emptyText:'请选择',
    								queryMode: 'remote',
    								displayField: 'name',
    								labelWidth:80,
    								editable:false,
    								valueField:'id'
                				})]
                			}]
                		},Ext.create('Ext.form.ComboBox',{
                				fieldLabel: '供货商',
    							store:Ext.create('Ext.data.Store', {			
        						fields: [
        							{name:'id',mapping:'id'},
        							{name:'name',mapping:'name'}
        							],
    							proxy:{
            						type: 'ajax',
           							url: 'baseinfo/SupplierList.action',
            						reader: {
                						type: 'json',
                						root: 'model'
            						}
        						}
							}),
								id:'aprsupplierid',
								emptyText:'请选择',
    							queryMode: 'remote',
    							displayField: 'name',
    							labelWidth:80,
    							editable:false,
    							valueField:'id'
                			})]
                	}]
                },{
                	xtype: 'fieldset',
                	border: false,
                    title:'价格信息',
                    autoHeight:true, 
                	items:[{
                		layout:'column',
                		border: false,
                		fieldDefaults: {
                    		labelStyle: 'font-weight:bold',
                    		labelWidth:90
                		},
                		items:[{
                			columnWidth:.33,
                			defaultType:'numberfield',
                			border: false,
                			items:[
                				{
                					fieldLabel:'采购价格(元)',
                					width:170,
                					id:'aprinprice',
                					minValue:0,
                					labelWidth:80
                				}
                			]
                		},{
                			columnWidth:.33,
                			defaultType:'numberfield',
                			border: false,
                			items:[
                				{
                					fieldLabel:'销售价格(元)',
                					width:170,
                					id:'aprsaleprice',
                					minValue:0,
                					labelWidth:80
                				}
                			]
                		},{
                			columnWidth:.33,
                			defaultType:'numberfield',
                			border: false,
                			items:[
                				{
                					fieldLabel:'最低销售价格(元)',
                					width:170,
                					id:'aprlowprice',
                					minValue:0,
                					labelWidth:80
                				}
                			]
                		}]
                	}]                   
                }
                ],

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
                        	var aprnumber=this.up('form').getForm().findField('aprnumber').getValue();
                        	var aprname=this.up('form').getForm().findField('aprname').getValue();
                        	var aprunits=this.up('form').getForm().findField('aprunits').getValue();
                        	var aprcatalogid=this.up('form').getForm().findField('aprcatalogid').getValue();
                        	var aprsupplierid=this.up('form').getForm().findField('aprsupplierid').getValue();
                        	var aprinprice=this.up('form').getForm().findField('aprinprice').getValue();
                        	var aprsaleprice=this.up('form').getForm().findField('aprsaleprice').getValue();
                        	var aprlowprice=this.up('form').getForm().findField('aprlowprice').getValue();
              

                            Ext.Ajax.request({
    							url: 'baseinfo/AddProduct.action',
    							method:'POST',
    							params: {
    									productnumber:aprnumber,
    									name:aprname,
    									units:aprunits,
    									catalogid:aprcatalogid,
    									supplierid:aprsupplierid,
    									inprice:aprinprice,
    									saleprice:aprsaleprice,
    									lowprice:aprlowprice
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加商品',
                closeAction: 'hide',
                width: 600,
                height:300,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//添加用户组信息表单
var showAddUserGroupForm=function(){
		var win;
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                		fieldLabel:'用户组名',
                		width:230,
                		id:'augname',
                		labelWidth:80,
                		xtype:'textfield'
                	}]
                },
                {
                	xtype: 'checkboxgroup',
            		fieldLabel: '所有权限',
            		labelWidth:70,
           			cls: 'x-check-group-alt',
            		items: [
                		{boxLabel: '采购管理', name: 'cb-auto-1'},
                		{boxLabel: '销售管理', name: 'cb-auto-2'},
               			{boxLabel: '库存管理', name: 'cb-auto-3'},
                		{boxLabel: '配送管理', name: 'cb-auto-4'},
               			{boxLabel: '基础信息', name: 'cb-auto-5'},
               			{boxLabel: '用户管理', name: 'cb-auto-6'}
            		]
        		},{
                	fieldLabel:'描述',
                	width:230,
                	id:'augdescriptn',
                	labelWidth:80,
                	xtype:'textareafield'
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
                        	var augname=this.up('form').getForm().findField('augname').getValue();
                        	

//                            Ext.Ajax.request({
//    							url: '',
//    							method:'POST',
//    							params: {
//    									
//    								},
//    							success: function(arg){
//    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
//    							}
//							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '添加用户组',
                closeAction: 'hide',
                width: 600,
                height:300,
                layout: 'fit',
                resizable: false,
                modal: true,
                items: form
            });
       	}
        win.show();
};

//地区列表grid
var CreateAreaGrid=function(){
	Ext.define('Area',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'parentid',
        	{name:'parentname',mapping:'parentname'}
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Area',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/reAreaList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	
    var areagrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "地区号", width: 120, dataIndex:'id',sortable: true},
            {text: "地区名", flex: 1, dataIndex:'name',sortable: true},
            {text: "上级地区号", width: 115, dataIndex:'parentid',sortable: true},
            {text: "上级地区", width: 115, dataIndex: 'parentname', sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '地区列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加地区',
        			handler:function(){
        				showAddAreaForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索地区'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
        
    });
    store.load();
    var contextmenu=Ext.create('Ext.menu.Menu',{
    	id:'theContextMenu',
    	items:{
    		text:'查看详情',
    		handler:function(){
    			
    		}
    	}
    });
    areagrid.getSelectionModel().on('itemdblclick', function(sm, selectedRecord) {
        if (selectedRecord.length) {
            alert('hao');
        }
    });
    
    areagrid.on("rowcontextmenu",function(grid,rowIndex,e)
         {
            e.preventDefault();
            grid.getSelectionMode().selectRow(rowIndex);
            contextmenu.showAt(e.getXY);
        });
    
    return areagrid;
};
//用户列表grid
var userList=function(){
	Ext.define('User',{
        extend: 'Ext.data.Model',
        fields: [
        	'id',
            'name',
            'password',
            'personnelname',
            'groupname'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'User',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/UserList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });

    var usergrid = Ext.create('Ext.grid.Panel', {
        store: store,
        columns: [
            //{text: "编号", width: 120, dataIndex: 'id', sortable: true},
            {text: "用户名",width: 120, dataIndex: 'name', sortable: true},
            {text: "对应员工名",flex:1, dataIndex: 'personnelname', sortable: true},
            {text: "用户组名", flex:1, dataIndex: 'groupname', sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '所有用户',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加用户',
        			handler:function(){
        				showAddUserForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索用户'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:1,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
    });
    store.load();
    return usergrid;
};
//客户管理grid
var CreateCustomerList=function(){
	Ext.define('Customer',{
        extend: 'Ext.data.Model',
        fields: [
            'id',
            'customernumber',
            'name',
            'address',
            'postcode',
            'areacode',
            'areaid',
            'areaname',
            'telephone',
            'fax',
            'salesmanid',
            'salesmanname',
            'state'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Customer',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/CustomerList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });

    var customergrid = Ext.create('Ext.grid.Panel', {
        store: store,
        columns: [
            {text: "客户编码", width: 120, dataIndex: 'customernumber', sortable: true},
            {text: "名称", dataIndex: 'name', sortable: true},
            {text: "邮编", dataIndex: 'postcode', sortable: true},
            {text: "区号", dataIndex: 'areacode', sortable: true},
            {text: "地区", dataIndex: 'areaname', sortable: true},
            {text: "电话", dataIndex: 'telephone', sortable: true},
            {text: "传真", dataIndex: 'fax', sortable: true},
            {text: "业务员", dataIndex: 'salesmanname', sortable: true},
            {text: "地址",flex:1,dataIndex: 'address', sortable: true}
            
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '客户列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加客户',
        			handler:function(){
        				showAddCustomerForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索职员'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:1,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
    });
    store.load();
    return customergrid;
};


//业务员管理grid
var CreateSalesManGrid=function(){
	Ext.define('Personnel',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'degree',
        	'postid',
        	'postname',
        	'workexperience',
        	'state'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Personnel',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/PersonnelList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	
    var salesManGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "姓名", width: 120, dataIndex:'name',sortable: true},
            {text: "岗位", width: 115, dataIndex:'postname',sortable: true},
            {text: "学历", width: 115, dataIndex: 'degree', sortable: true},
            {text: "工作经历", flex: 1, dataIndex:'workexperience',sortable: true}
            
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '职员列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加业务员',
        			handler:function(){
        				showAddPersonnelForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索职员'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return salesManGrid;
};

//岗位管理grid
var CreatePostGrid=function(){
	Ext.define('Post',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'departmentid',
        	{name:'departmentname',mapping:'departmentname'},
        	'description',
        	'state'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Post',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/AllPost.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	
    var postGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "岗位名", width: 120, dataIndex:'name',sortable: true},
            {text: "岗位描述", flex: 1, dataIndex:'description',sortable: true},
            {text: "岗位所在部门", width: 115, dataIndex:'departmentname',sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '岗位列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加岗位',
        			handler:function(){
        				showAddPostForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索岗位'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return postGrid;
};

//部门管理grid
var CreateDepartmentGrid=function(){
	Ext.define('Department',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'description',
        	{name:'state',mapping:'state'}
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Department',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/Department!reDepartmentList',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	
    var departmentGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "部门名", width: 115,dataIndex:'name',sortable: true},
            {text: "部门描述", flex: 1,  dataIndex:'description',sortable: true}
          
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '部门列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加部门',
        			handler:function(){
        				showAddDepartmentForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索部门'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return departmentGrid;
};
//供货商管理grid
var CreateSupplierList=function(){
	Ext.define('Supplier',{
        extend: 'Ext.data.Model',
        fields: [
            'id',
            'suppliernumber',
            'name',
            'address',
            'postcode',
            'areacode',
            'telephone',
            'fax',
            'remark',
            'type',
            'state'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Supplier',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/SupplierList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });

    var customergrid = Ext.create('Ext.grid.Panel', {
        store: store,
        columns: [
            {text: "供货商编码", width: 120, dataIndex: 'suppliernumber', sortable: true},
            {text: "名称", dataIndex: 'name', sortable: true},
            {text: "邮编", dataIndex: 'postcode', sortable: true},
            {text: "区号", dataIndex: 'areacode', sortable: true},
            {text: "类型", dataIndex: 'type', sortable: true},
            {text: "电话", dataIndex: 'telephone', sortable: true},
            {text: "传真", dataIndex: 'fax', sortable: true},
            {text: "地址",flex:1,dataIndex: 'address', sortable: true}        
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '客户列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加供货商',
        			handler:function(){
        				showAddSupplierForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索供货商'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:1,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
    });
    store.load();
    return customergrid;
};

//商品分类管理grid
var CreateProCatalogGrid=function(){
	Ext.define('ProCatalog',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'catalognumber',mapping:'catalognumber'},
        	{name:'name',mapping:'name'},
        	'parentid',
        	'parentname',
        	'state'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'ProCatalog',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/ProCatalogList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	
    var postGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "分类编码", width: 120, dataIndex:'catalognumber',sortable: true},
            {text: "分类名", flex: 1, dataIndex:'name',sortable: true},
            {text: "上级分类", width: 115, dataIndex:'parentname',sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '商品分类列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加分类',
        			handler:function(){
        				showAddCatalogForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索分类'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return postGrid;
};
//商品管理grid
var CreateProductGrid=function(){
	Ext.define('Product',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'productnumber',
        	'units',
        	'catalogid',
        	'catalogname',
        	'supplierid',
        	'suppliername',
        	'inprice',
        	'saleprice',
        	'lowprice'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Product',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/ProductList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	function chtored(val){ 
            return '<span style="color:red;">' + val + '</span>';
    }
    function chtogreen(val){ 
            return '<span style="color:green;">' + val + '</span>';
    }
    function chtoblue(val){ 
            return '<span style="color:blue;">' + val + '</span>';
    }
    var ProductGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "商品编码", width: 120, dataIndex:'productnumber',sortable: true},
            {text: "商品名称", width: 115, dataIndex:'name',sortable: true},
            {text: "计量单位", width: 115, dataIndex: 'units', sortable: true},
            {text: "分类", width: 115, dataIndex: 'catalogname', sortable: true},
            {text: "采购价格(元)", width: 115, dataIndex: 'inprice', sortable: true, renderer: chtoblue},
            {text: "销售价格(元)", width: 115, dataIndex: 'saleprice', sortable: true,renderer: chtogreen},
            {text: "最低销售价格(元)", width: 115, dataIndex: 'lowprice', sortable: true,renderer: chtored},
            {text: "供货商", flex: 1, dataIndex:'suppliername',sortable: true}
            
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '商品列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加商品',
        			handler:function(){
        				showAddProductForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索商品'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return ProductGrid;
};

//用户组管理grid
var CreateUserGroupGrid=function(){
	Ext.define('UserGroup',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'decription',
        	'limits',
        	{name:'state',mapping:'state'}
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'UserGroup',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/UserGroupList',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	
    var userGroup = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "用户组名", width: 115,dataIndex:'name',sortable: true},
            {text: "权限",  flex: 1, dataIndex:'limits',sortable: true},
            {text: "描述", flex: 1,  dataIndex:'decription',sortable: true}
          
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '权限列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加用户组',
        			handler:function(){
        				showAddUserGroupForm();
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索用户组'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return userGroup;
};

/**
 * 以下为采购管理
 */
//新建采购订单表单
var showAddPurchaseForm=function(){
		Ext.QuickTips.init();
			var pitemsstore;
			
			pitemsstore=Ext.create('Ext.data.ArrayStore',{
				autoLoad:true,
       			fields: [
       			'id',
       			'productid',
       			'productname',
       			'purchaseprice',
       			'amount',
       			'units'
           		],

           		data:[
        			
        		]
       			});
			
		
		var win;
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                    	xtype:'fieldset',
                    	border: false,
                    	collapsible:'true',
                    	title:'采购订单信息',
                    	autoHeight:true,                   	
                    	items:[{
                			layout:'column',
                			border: false,
                			fieldDefaults: {
                    			labelStyle: 'font-weight:bold',
                    			labelWidth:90
                			},
                			items:[{
                				columnWidth:.5,
                				border: false,
                				defaultType:'textfield',
                				items:[{
                					fieldLabel:'订单编码',
                					allowBlank:false,
                					width:230,
                					id:'apcsnumber',
                					labelWidth:80
                				},Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '业务员',
                					
    								store:Ext.create('Ext.data.Store', {
    								fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'}
        							],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/PersonnelList',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
								id:'apcspersonnelid',
								emptyText:'请选择',
								labelWidth:80,
								allowBlank:false,
    							queryMode: 'remote',
    							displayField: 'name',
    							editable:false,
    							valueField: 'id'
								})]
                			},{
                				columnWidth:.5,
                				defaultType:'textfield',
                				border: false,
                				items:[Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '供货商',
    								store:Ext.create('Ext.data.Store', {    					
        							fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'},
        								'parentid',
        								{name:'parentname',mapping:'parentname'}
        								],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/SupplierList.action',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
									id:'apcssupplierid',
									emptyText:'请选择',
    								queryMode: 'remote',
    								allowBlank:false,
    								displayField: 'name',
    								labelWidth:80,
    								editable:false,
    								valueField:'id'
                				})]
                			}]
                		}]
                	}]
                },{
                	xtype: 'fieldset',
                	border: false,
                	collapsible:'true',
                    title:'订单商品',
                    autoScroll:true,
                    autoHeight:true,
                    height:250,
                    items: {
       					 xtype: 'grid',
       					 //id:'ppitermgrid',
       					 border: true,
       					 border:true,
       					 viewConfig: {
            				stripeRows: true
        				},
       					 height:200,
       					 tbar:new Ext.Toolbar({
       					 	items:[{
       					 		text:'添加商品项',
       					 		handler:function(){
       					 			var num=this.up('form').getForm().findField('apcsnumber').getValue();
                        			var pid=this.up('form').getForm().findField('apcspersonnelid').getValue();
       					 			var sid=this.up('form').getForm().findField('apcssupplierid').getValue();
       					 			if(null!==sid&&null!==pid&&num!==null){
       					 				var additem=Ext.widget('window', {
                							title: '添加商品',
                							closeAction: 'hide',
                							width: 300,
                							height:240,
               	 							layout: 'fit',
                							resizable: true,
                							modal: true,	
                							items:Ext.widget('form',{
                								layout: {
                    								type: 'vbox',
                   									align: 'stretch'
                								},
               									border: false,
               			 						bodyPadding: 10,
                								fieldDefaults: {
                    								labelStyle: 'font-weight:bold',
                    								labelWidth:90
                								},
                								defaults: {
                   								margins: '0 0 10 0'
                								},
                								items:[
                									Ext.create('Ext.form.ComboBox',{
                									fieldLabel: '商品',
    												store:Ext.create('Ext.data.Store', {    					
        											fields: [
        												{name:'id',mapping:'id'},
        												{name:'name',mapping:'name'}
        												],
    												proxy:{
            										type: 'ajax',
           											url: 'baseinfo/ProductList.action?sid='+sid,
            											reader: {
                											type: 'json',
                											root: 'model'
            												}
        												}
													}),
												id:'apcsproitemid',
												emptyText:'请选择',
    											queryMode: 'remote',
    											displayField: 'name',
    											allowBlank:false,
    											editable:false,
    											valueField:'id'
                								}),{
                									xtype:'numberfield',
                									fieldLabel:'采购价格(元)',
                									minValue:0,
                									allowBlank:false,
                									id:'apcsproitemprice'
                								},{
                									xtype:'numberfield',
                									fieldLabel:'数量',
                									minValue:0,
                									allowBlank:false,
                									id:'apcsproitemamount'
                								},{
                									xtype:'textfield',
                									fieldLabel:'单位',
                									allowBlank:false,
                									id:'apcsproitemunits'
                								}],
                								buttons:[
                									{
                    									text: '取消',
                    									handler: function() {
                   											this.up('form').getForm().reset();
                        									this.up('window').hide();
                    										}
                									},{
                    									text: '确定',
                    									handler: function() {
                    										if (this.up('form').getForm().isValid()) {
                    											var apcsproitemid=this.up('form').getForm().findField('apcsproitemid').getValue();
                    											var apcsproitemname=this.up('form').getForm().findField('apcsproitemid').getRawValue();
                    											var apcsproitemprice=this.up('form').getForm().findField('apcsproitemprice').getValue();
                    											var apcsproitemamount=this.up('form').getForm().findField('apcsproitemamount').getValue();
                    											var apcsproitemunits=this.up('form').getForm().findField('apcsproitemunits').getValue();
                    											
                    											pitemsstore.add({
                    												productid:apcsproitemid,
                    												productname:apcsproitemname,
                    												purchaseprice:apcsproitemprice,
                    												amount:apcsproitemamount,
                    												units:apcsproitemunits
                    											});
                    											this.up('form').getForm().reset();
                        										this.up('window').hide();
                    										}
                   											
                    										}
                									}
                								]
                							})
                						});
                						additem.show();
       					 			}else{
       					 				Ext.MessageBox.alert('错误','请先填写订单基本信息！');
       					 			}	
       					 		}
       					 	}]
       					 })
       					 ,
       					viewConfig: {
            				stripeRows: true
        				},
        				stateful: true,
        				stateId: 'stateGrid',
       					 columns: [
       					 	{text: "商品编号", flex:1, dataIndex: 'productid', sortable: true},
       					 	{text: "商品名称", flex:1,  dataIndex: 'productname',sortable: true},
       					 	{text: "采购价格", flex:1, dataIndex: 'purchaseprice', sortable: true},
       					 	{text: "数量", flex:1, dataIndex: 'amount', sortable: true},
       					 	{text: "单位", flex:1, dataIndex: 'units', sortable: true},
       					 	{header:'操作', xtype: 'actioncolumn',
       					 		 items: [{
       					 		 	icon:'./icon/Seuuo.com_008066.png',
       					 		 	tooltip: '删除',
       					 		 	handler: function(grid, rowIndex, colIndex) {
                        				var rec = pitemsstore.removeAt(rowIndex);
                    				}
       					 		 }]
       					 	}
       					 ],               
       					 store:pitemsstore
    				}
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
                        	var apcsnumber=this.up('form').getForm().findField('apcsnumber').getValue();
                        	var apcspersonnelid=this.up('form').getForm().findField('apcspersonnelid').getValue();
                        	var apcssupplierid=this.up('form').getForm().findField('apcssupplierid').getValue();
                        	
                        	var rowsData = []; 
							var count = pitemsstore.getCount(); 
							var record; 
							for (var i = 0; i < count; i++) { 
								record = pitemsstore.getAt(i); 
									rowsData.push(record.data);

							} 
                        	var iteminfo=Ext.encode(rowsData);
//                        	alert(rowsData[0].productname);
//                        	alert(test);
//                        	return;
                            Ext.Ajax.request({
    							url: 'purchase/AddPurchaseOrder',
    							method:'POST',
    							params: {
    									podnum:apcsnumber,
    									pid:apcspersonnelid,
    									sid:apcssupplierid,
    									iteminfo:iteminfo
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '新建采购订单',
                closeAction: 'hide',
                width: 600,
                height:450,
                layout: 'fit',
                resizable: true,
                maximizable:true,
                floatable:true,
                modal: true,
                autoShow:true,
                items:form
            });
       	}
        win.show();
};
//编辑采购单表单,暂未经使用
var showEditPurchaseForm=function(){
		Ext.QuickTips.init();
		
		var getpitemsstore=function(pcseid){
			var pitemsstore;
			pitemsstore=Ext.create('Ext.data.JsonStore',{
				autoLoad:true,
       			fields: [
       			'id',
       			'productid',
       			'productname',
       			'purchaseprice',
       			'amount',
       			'units'
           		],
           		autoDestroy: true,
           		proxy: {
        			type: 'ajax',
        			url: 'purchase/PurchaseOrderItemList?pcseid='+pcseid,	
        			reader: {
            			type: 'json',
            			root: 'model'
        			}
   				}
       			});
			
			return pitemsstore;
		};
		
		
		
		
		var win;
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                    	xtype:'fieldset',
                    	border: false,
                    	collapsible:'true',
                    	title:'采购订单信息',
                    	autoHeight:true,                   	
                    	items:[{
                			layout:'column',
                			border: false,
                			fieldDefaults: {
                    			labelStyle: 'font-weight:bold',
                    			labelWidth:90
                			},
                			items:[{
                				columnWidth:.5,
                				border: false,
                				defaultType:'textfield',
                				items:[{
                					fieldLabel:'订单编码',
                					width:230,
                					id:'apcsnumber',
                					labelWidth:80
                				},Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '业务员',
    								store:Ext.create('Ext.data.Store', {
    								fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'}
        							],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/PersonnelList',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
								id:'apcspersonnelid',
								emptyText:'请选择',
								labelWidth:80,
    							queryMode: 'remote',
    							displayField: 'name',
    							editable:false,
    							valueField: 'id'
								})]
                			},{
                				columnWidth:.5,
                				defaultType:'textfield',
                				border: false,
                				items:[Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '供货商',
    								store:Ext.create('Ext.data.Store', {    					
        							fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'},
        								'parentid',
        								{name:'parentname',mapping:'parentname'}
        								],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/SupplierList.action',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
									id:'apcssupplierid',
									emptyText:'请选择',
    								queryMode: 'remote',
    								displayField: 'name',
    								labelWidth:80,
    								editable:false,
    								valueField:'id'
                				})]
                			}]
                		}]
                	}]
                },{
                	xtype: 'fieldset',
                	border: false,
                	collapsible:'true',
                    title:'订单商品',
                    autoScroll:true,
                    autoHeight:true,
                    height:250,
                    items: {
       					 xtype: 'grid',
       					 //id:'ppitermgrid',
       					 border: true,
       					 border:true,
       					 viewConfig: {
            				stripeRows: true
        				},
       					 height:200,
       					 tbar:new Ext.Toolbar({
       					 	items:[{
       					 		text:'添加商品项'
       					 	}]
       					 })
       					 ,
       					 viewConfig: {
            				stripeRows: true
        				},
        				stateful: true,
        				stateId: 'stateGrid',
       					 columns: [
       					 	{text: "商品编号", flex:1, dataIndex: 'id', sortable: true},
       					 	{text: "商品名称", flex:1,  dataIndex: 'productname',sortable: true},
       					 	{text: "采购价格", flex:1, dataIndex: 'purchaseprice', sortable: true},
       					 	{text: "数量", flex:1, dataIndex: 'amount', sortable: true},
       					 	{text: "单位", flex:1, dataIndex: 'units', sortable: true},
       					 	{header:'操作', xtype: 'actioncolumn',
       					 		 items: [{
       					 		 	icon:'./icon/Seuuo.com_008066.png',
       					 		 	tooltip: '删除',
       					 		 	handler: function(grid, rowIndex, colIndex) {
                        				var rec = pitemsstore.getAt(rowIndex);
                       					alert("删除 " + rec.get('pprice'));
                    				}
       					 		 },
       					 		 {
       					 		 	icon:'./icon/Seuuo.com_0033451.png',
       					 		 	tooltip: '编辑',
       					 		 	handler: function(grid, rowIndex, colIndex){
                        				var rec = getpitemsstore(1).getAt(rowIndex);
                       					alert("编辑 " + rec.get('pprice'));
       					 		 	}
       					 		 }]
       					 	}
       					 ],               
       					 store:getpitemsstore(1)
    				}
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
                        	//var apcsnumber=this.up('form').getForm().findField('apcsnumber').getValue();
                        	//var apcsname=this.up('form').getForm().findField('apcsname').getValue();
                        	//var apcspersonnelid=this.up('form').getForm().findField('apcspersonnelid').getValue();
                        	//var apcssupplierid=this.up('form').getForm().findField('apcsnumber').getValue();
                        	
                        	var test=this.up('form').getForm().getComponent('ppitermgrid').getColumnModel().getDataIndex(cell[1]);
                        	alert(test);
                        	return;
                            Ext.Ajax.request({
    							url: 'purchase/',
    							method:'POST',
    							params: {
    									
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '新建采购订单',
                closeAction: 'hide',
                width: 600,
                height:450,
                layout: 'fit',
                resizable: true,
                maximizable:true,
                floatable:true,
                modal: true,
                autoShow:true,
                items:form
            });
       	}
        win.show();
};
//采购订单管理grid

var CreatePurchaseGrid=function(){
	
	Ext.define('PurchaseOrder',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'purchasenumber',
        	'purchasedate',
        	'salesmanid',
        	'salesmanname',
        	'supplierid',
        	'suppliername',
        	'state',
        	'statename'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'PurchaseOrder',
        proxy: {
            type: 'ajax',
            url: 'purchase/PurchaseOrderList',
            param:{
            	//pstate:jj
            	
            	
            },
            reader: {
                type: 'json',
                root: 'purchaseOrderList'
            }
        }
    });
	function chtored(val){ 
            return '<span style="color:red;">' + val + '</span>';
    }
    function chtogreen(val){ 
            return '<span style="color:green;">' + val + '</span>';
    }
    function chtoblue(val){ 
            return '<span style="color:blue;">' + val + '</span>';
    }
    var puchaseGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "订单编码", flex:1, dataIndex:'purchasenumber',sortable: true},
            //{text: "订单名",flex:1, dataIndex:'name',sortable: true},
            {text: "供货商", flex:1,dataIndex: 'suppliername', sortable: true},
            {text: "负责业务员", flex:1, dataIndex: 'salesmanname', sortable: true},
            {text: "时间", flex:1, dataIndex: 'purchasedate', sortable: true},
            {text: "状态", flex:1, dataIndex: 'statename', sortable: true, renderer: chtoblue}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '采购列表',
        waitMsg:'数据载入中',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加采购订单',
        			handler:function(){
        				showAddPurchaseForm();
        				
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		Ext.create('Ext.form.ComboBox', {
    				fieldLabel: '搜索条件',
    				store: Ext.create('Ext.data.Store', {
    				fields: ['abbr', 'name'],
    					data : [
    						{"abbr":1, "name":"订单编号"},
    						{"abbr":2, "name":"供应商"},
    						{"abbr":3, "name":"负责业务员"},
    						{"abbr":4, "name":"状态"}
    						]
    					}),
    				queryMode: 'local',
    				displayField: 'name',
    				valueField: 'abbr',
    				editable:false,
    				id:'searchtype'
    			}),
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索订单',
            		id:'search'
        		},
        		{
        			xtype:'button',
        			text:'搜索',
        			handler:function(){
        				//alert(this.up("puchaseGrid").getComponent('search').getValue());
//        				snm=Ext.getCmp('search').getValue();
//        				alert(snm);
//        				store.load(); 
        				var filtertext=Ext.getCmp('search').getValue();
        				var comname=Ext.getCmp('searchtype').getValue();
        				store.filterBy(function(record) {        					
        					if(comname==1){
        						return record.get('purchasenumber') ==filtertext;
        					}
        					else if(comname==2){
        						return record.get('suppliername') ==filtertext;
        					}
        					else if(comname==3){
        						return record.get('salesmanname') ==filtertext;
        					}
        					else if(comname==4){
        						return record.get('statename') ==filtertext;
        					}
						});
        			}
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return puchaseGrid;
};

/**
 * 以下为销售管理
 */
//添加销售表单
var showAddSellOrderForm=function(){
		Ext.QuickTips.init();
			var pitemsstore;
			
			pitemsstore=Ext.create('Ext.data.ArrayStore',{
				autoLoad:true,
       			fields: [
       			'id',
       			'productid',
       			'productname',
       			'sellprice',
       			'amount',
       			'units'
           		],

           		data:[
        			
        		]
       			});
			
		
		var win;
       	if (!win) {
        	var form = Ext.widget('form', {
                layout: {
                    type: 'vbox',
                   	align: 'stretch'
                },
                border: false,
                bodyPadding: 10,
                fieldDefaults: {
                    labelStyle: 'font-weight:bold',
                    labelWidth:50
                },
                defaults: {
                    margins: '0 0 10 0'
                },
                items: [{
                	layout:'auto',
                	border: false,
                    items:[{
                    	xtype:'fieldset',
                    	border: false,
                    	collapsible:'true',
                    	title:'销售订单信息',
                    	autoHeight:true,                   	
                    	items:[{
                			layout:'column',
                			border: false,
                			fieldDefaults: {
                    			labelStyle: 'font-weight:bold',
                    			labelWidth:90
                			},
                			items:[{
                				columnWidth:.5,
                				border: false,
                				defaultType:'textfield',
                				items:[{
                					fieldLabel:'订单编码',
                					allowBlank:false,
                					width:230,
                					id:'asenumber',
                					labelWidth:80
                				},Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '业务员',
                					
    								store:Ext.create('Ext.data.Store', {
    								fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'}
        							],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/PersonnelList',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
								id:'asepersonnelid',
								emptyText:'请选择',
								labelWidth:80,
								allowBlank:false,
    							queryMode: 'remote',
    							displayField: 'name',
    							editable:false,
    							valueField: 'id'
								})]
                			},{
                				columnWidth:.5,
                				defaultType:'textfield',
                				border: false,
                				items:[Ext.create('Ext.form.ComboBox',{
                					fieldLabel: '客户',
    								store:Ext.create('Ext.data.Store', {    					
        							fields: [
        								{name:'id',mapping:'id'},
        								{name:'name',mapping:'name'},
        								'parentid',
        								{name:'parentname',mapping:'parentname'}
        								],
    								proxy:{
            							type: 'ajax',
           								url: 'baseinfo/CustomerList.action',
            							reader: {
                							type: 'json',
                							root: 'model'
            							}
        							}
								}),
									id:'asecustomerid',
									emptyText:'请选择',
    								queryMode: 'remote',
    								allowBlank:false,
    								displayField: 'name',
    								labelWidth:80,
    								editable:false,
    								valueField:'id'
                				})]
                			}]
                		}]
                	}]
                },{
                	xtype: 'fieldset',
                	border: false,
                	collapsible:'true',
                    title:'订单商品',
                    autoScroll:true,
                    autoHeight:true,
                    height:250,
                    items: {
       					 xtype: 'grid',
       					 //id:'ppitermgrid',
       					 border: true,
       					 border:true,
       					 viewConfig: {
            				stripeRows: true
        				},
       					 height:200,
       					 tbar:new Ext.Toolbar({
       					 	items:[{
       					 		text:'添加商品项',
       					 		handler:function(){
       					 			var num=this.up('form').getForm().findField('asenumber').getValue();
                        			var pid=this.up('form').getForm().findField('asepersonnelid').getValue();
       					 			var cid=this.up('form').getForm().findField('asecustomerid').getValue();
       					 			if(null!==cid&&null!==pid&&num!==null){
       					 				var additem=Ext.widget('window', {
                							title: '添加商品',
                							closeAction: 'hide',
                							width: 300,
                							height:240,
               	 							layout: 'fit',
                							resizable: true,
                							modal: true,	
                							items:Ext.widget('form',{
                								layout: {
                    								type: 'vbox',
                   									align: 'stretch'
                								},
               									border: false,
               			 						bodyPadding: 10,
                								fieldDefaults: {
                    								labelStyle: 'font-weight:bold',
                    								labelWidth:90
                								},
                								defaults: {
                   								margins: '0 0 10 0'
                								},
                								items:[
                									Ext.create('Ext.form.ComboBox',{
                									fieldLabel: '商品',
    												store:Ext.create('Ext.data.Store', {    					
        											fields: [
        												{name:'id',mapping:'id'},
        												{name:'name',mapping:'name'}
        												],
    												proxy:{
            										type: 'ajax',
           											url: 'baseinfo/ProductList.action',
            											reader: {
                											type: 'json',
                											root: 'model'
            												}
        												}
													}),
												id:'aseproitemid',
												emptyText:'请选择',
    											queryMode: 'remote',
    											displayField: 'name',
    											allowBlank:false,
    											editable:false,
    											valueField:'id'
                								}),{
                									xtype:'numberfield',
                									fieldLabel:'销售价格(元)',
                									minValue:0,
                									allowBlank:false,
                									id:'aseproitemprice'
                								},{
                									xtype:'numberfield',
                									fieldLabel:'数量',
                									minValue:0,
                									allowBlank:false,
                									id:'aseproitemamount'
                								},{
                									xtype:'textfield',
                									fieldLabel:'单位',
                									allowBlank:false,
                									id:'aseproitemunits'
                								}],
                								buttons:[
                									{
                    									text: '取消',
                    									handler: function() {
                   											this.up('form').getForm().reset();
                        									this.up('window').hide();
                    										}
                									},{
                    									text: '确定',
                    									handler: function() {
                    										if (this.up('form').getForm().isValid()) {
                    											var aseproitemid=this.up('form').getForm().findField('aseproitemid').getValue();
                    											var aseproitemname=this.up('form').getForm().findField('aseproitemid').getRawValue();
                    											var aseproitemprice=this.up('form').getForm().findField('aseproitemprice').getValue();
                    											var aseproitemamount=this.up('form').getForm().findField('aseproitemamount').getValue();
                    											var aseproitemunits=this.up('form').getForm().findField('aseproitemunits').getValue();
                    											
                    											pitemsstore.add({
                    												productid:aseproitemid,
                    												productname:aseproitemname,
                    												sellprice:aseproitemprice,
                    												amount:aseproitemamount,
                    												units:aseproitemunits
                    											});
                    											this.up('form').getForm().reset();
                        										this.up('window').hide();
                    										}
                   											
                    										}
                									}
                								]
                							})
                						});
                						additem.show();
       					 			}else{
       					 				Ext.MessageBox.alert('错误','请先填写订单基本信息！');
       					 			}	
       					 		}
       					 	}]
       					 })
       					 ,
       					viewConfig: {
            				stripeRows: true
        				},
        				stateful: true,
        				stateId: 'stateGrid',
       					 columns: [
       					 	{text: "商品编号", flex:1, dataIndex: 'productid', sortable: true},
       					 	{text: "商品名称", flex:1,  dataIndex: 'productname',sortable: true},
       					 	{text: "采购价格", flex:1, dataIndex: 'purchaseprice', sortable: true},
       					 	{text: "数量", flex:1, dataIndex: 'amount', sortable: true},
       					 	{text: "单位", flex:1, dataIndex: 'units', sortable: true},
       					 	{header:'操作', xtype: 'actioncolumn',
       					 		 items: [{
       					 		 	icon:'./icon/Seuuo.com_008066.png',
       					 		 	tooltip: '删除',
       					 		 	handler: function(grid, rowIndex, colIndex) {
                        				var rec = pitemsstore.removeAt(rowIndex);
                    				}
       					 		 }]
       					 	}
       					 ],               
       					 store:pitemsstore
    				}
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
                        	var asenumber=this.up('form').getForm().findField('asenumber').getValue();
                        	var asepersonnelid=this.up('form').getForm().findField('asepersonnelid').getValue();
                        	var asecustomerid=this.up('form').getForm().findField('asecustomerid').getValue();
                        	
                        	var rowsData = []; 
							var count = pitemsstore.getCount(); 
							var record; 
							for (var i = 0; i < count; i++) { 
								record = pitemsstore.getAt(i); 
									rowsData.push(record.data);

							} 
                        	var iteminfo=Ext.encode(rowsData);
//                        	alert(rowsData[0].productname);
//                        	alert(test);
//                        	return;
                            Ext.Ajax.request({
    							url: 'sell/AddSellOrder',
    							method:'POST',
    							params: {
    									podnum:apcsnumber,
    									pid:apcspersonnelid,
    									sid:apcssupplierid,
    									iteminfo:iteminfo
    								},
    							success: function(arg){
    								var jsonResult = Ext.JSON.decode(arg.responseText,true);              
    							}
							});	
                            
                            this.up('form').getForm().reset();
                            this.up('window').hide();
                            Ext.MessageBox.alert('成功!', '添加成功.');
                        }
                    }
                }]
            });

            win = Ext.widget('window', {
                title: '新建销售订单',
                closeAction: 'hide',
                width: 600,
                height:450,
                layout: 'fit',
                resizable: true,
                maximizable:true,
                floatable:true,
                modal: true,
                autoShow:true,
                items:form
            });
       	}
        win.show();
};
//销售订单列表
var CreateSellGrid=function(){
	Ext.define('SellOrder',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'sellnumber',
        	'selldate',
        	'salesmanid',
        	'salesmanname',
        	'customerid',
        	'customername',
        	'state',
        	'statename'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'SellOrder',
        proxy: {
            type: 'ajax',
            url: 'sell/SellOrderList',
            param:{
            	pstate:1
            },
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
	function chtored(val){ 
            return '<span style="color:red;">' + val + '</span>';
    }
    function chtogreen(val){ 
            return '<span style="color:green;">' + val + '</span>';
    }
    function chtoblue(val){ 
            return '<span style="color:blue;">' + val + '</span>';
    }
    var sellGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "订单编码", flex:1, dataIndex:'sellnumber',sortable: true},
            //{text: "订单名",flex:1, dataIndex:'name',sortable: true},
            {text: "客户", flex:1,dataIndex: 'customername', sortable: true},
            {text: "负责业务员", flex:1, dataIndex: 'salesmanname', sortable: true},
            {text: "时间", flex:1, dataIndex: 'selldate', sortable: true},
            {text: "状态", flex:1, dataIndex: 'statename', sortable: true, renderer: chtoblue}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '销售订单列表',
        waitMsg:'数据载入中',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加销售订单',
        			handler:function(){
        				showAddSellOrderForm();
        				
        			}
        		},'->', // same as {xtype: 'tbfill'}, // Ext.toolbar.Fill
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索订单'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return sellGrid;
};

/**
 * 以下为库存管理
 */
//商品库存列表
var CreateGoodsStockGrid=function(){
	Ext.define('Product',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'productnumber',
        	'units',
        	'catalogid',
        	'catalogname',
        	'supplierid',
        	'suppliername',
        	'store',
        	'inprice',
        	'saleprice',
        	'lowprice'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Product',
        proxy: {
            type: 'ajax',
            url: 'baseinfo/ProductList.action',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
    function warn(val){ 
    	if(val<100){
    		 return '<span style="color:red;">' + val + '</span>';
    	}else{
    		return '<span style="color:green;">' + val + '</span>';
    	}
           
    }
	function chtored(val){ 
            return '<span style="color:red;">' + val + '</span>';
    }
    function chtogreen(val){ 
            return '<span style="color:green;">' + val + '</span>';
    }
    function chtoblue(val){ 
            return '<span style="color:blue;">' + val + '</span>';
    }
    var GoodsStockGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "商品编码", width: 120, dataIndex:'productnumber',sortable: true},
            {text: "商品名称", width: 115, dataIndex:'name',sortable: true},
            {text: "当前库存", width: 115, dataIndex:'store',sortable: true,renderer:warn},
            {text: "计量单位", width: 115, dataIndex: 'units', sortable: true},
            {text: "分类", width: 115, dataIndex: 'catalogname', sortable: true},
            {text: "采购价格(元)", width: 115, dataIndex: 'inprice', sortable: true, renderer: chtoblue},
            {text: "销售价格(元)", width: 115, dataIndex: 'saleprice', sortable: true,renderer: chtogreen},
            {text: "最低销售价格(元)", width: 115, dataIndex: 'lowprice', sortable: true,renderer: chtored},
            {text: "供货商", flex: 1, dataIndex:'suppliername',sortable: true}
            
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '商品库存列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'统计分析',
        			handler:function(){
        				//此处执行
        			}
        		},'->', 
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索商品'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return GoodsStockGrid;
};
//入库单列表
var CreateInStoreGrid=function(){
	Ext.define('Instore',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'instorenumber',
        	'instoretype',
        	'instoretypes',
        	'indate',
        	'salesmanid',
        	'salesmanname',
        	'state',
        	'statename'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Instore',
        proxy: {
            type: 'ajax',
            url: 'stock/InStoreList',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
    var instoreGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "入库单编码", width: 120, dataIndex:'instorenumber',sortable: true},
            {text: "入库类型", width: 115, dataIndex:'instoretypes',sortable: true},
            {text: "入库时间", width: 115, dataIndex:'indate',sortable: true},
            {text: "业务员", width: 115, dataIndex: 'salesmanname', sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '入库单列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加入库单',
        			handler:function(){
        				//此处执行
        			}
        		},'->', 
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索商品'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return instoreGrid;
};
//以下为出库管理
var CreateOutStoreGrid=function(){
	Ext.define('Outstore',{
        extend: 'Ext.data.Model',
        fields: [
        	{name:'id',mapping:'id'},
        	{name:'name',mapping:'name'},
        	'outstorenumber',
        	'outstoretype',
        	'outstoretypes',
        	'outdate',
        	'storeroomkeeperid',
        	'storeroomkeepername',
        	'state',
        	'statename'
        ]
    });
    var store = Ext.create('Ext.data.Store', {
        model: 'Outstore',
        proxy: {
            type: 'ajax',
            url: 'stock/OutStoreList',
            reader: {
                type: 'json',
                root: 'model'
            }
        }
    });
    var outstoreGrid = Ext.create('Ext.grid.Panel', {
        store:store,
        columns: [
            {text: "出库单编码", width: 120, dataIndex:'outstorenumber',sortable: true},
            {text: "出库类型", width: 115, dataIndex:'outstoretypes',sortable: true},
            {text: "出库时间", width: 115, dataIndex:'outdate',sortable: true},
            {text: "业务员", width: 115, dataIndex: 'storeroomkeepername', sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: '出库单列表',
        closable:true,
        tbar:new Ext.Toolbar({
        	items:[
        		{
        			xtype:'button',
        			border:1,
        			text:'添加出库单',
        			handler:function(){
        				//此处执行
        			}
        		},'->', 
        		{
            		xtype    : 'textfield',
            		name     : 'field1',
            		emptyText: '搜索商品'
        		},
        		{
        			xtype:'button',
        			text:'搜索'
        		}
        		]
        }),
        bbar:Ext.create('Ext.PagingToolbar',{
        	pageSize:10,
        	store:store,
        	displayInfo:true,
        	displayMsg:'显示第{0}条到{1}条记录，一共显示{2}条',
        	emptyMsg:'没有记录'
        })
        
    });
    store.load();    
    return outstoreGrid;
};
//以下为配送管理

//以下为统计管理
//销售分析tab
//var CreateSellTab=function(){
//		generateData = function(n, floor){
//        var data = [],
//            p = (Math.random() *  11) + 1,
//            i;
//            
//        floor = (!floor && floor !== 0)? 20 : floor;
//        
//        for (i = 0; i < (n || 12); i++) {
//            data.push({
//                name: Ext.Date.monthNames[i % 12],
//                data1: Math.floor(Math.max((Math.random() * 100), floor)),
//                data2: Math.floor(Math.max((Math.random() * 100), floor)),
//                data3: Math.floor(Math.max((Math.random() * 100), floor)),
//                data4: Math.floor(Math.max((Math.random() * 100), floor)),
//                data5: Math.floor(Math.max((Math.random() * 100), floor)),
//                data6: Math.floor(Math.max((Math.random() * 100), floor)),
//                data7: Math.floor(Math.max((Math.random() * 100), floor)),
//                data8: Math.floor(Math.max((Math.random() * 100), floor)),
//                data9: Math.floor(Math.max((Math.random() * 100), floor))
//            });
//        }
//       	 return data;
//    	};
//    
//    	store1 = Ext.create('Ext.data.JsonStore', {
//        	fields: ['name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data9', 'data9'],
//        	data: generateData()
//    	});
//	
//	
//	    var tab = Ext.create('Ext.panel.Panel', {
//        title: 'Column Chart',
//        layout: 'fit',
//        tbar: [{
//            text: 'Reload Data',
//            handler: function() {
//                store1.loadData(generateData());
//            }
//        }],
//        items: {
//            id: 'chartCmp',
//            xtype: 'chart',
//            style: 'background:#fff',
//            animate: true,
//            shadow: true,
//            store: store1,
//            axes: [{
//                type: 'Numeric',
//                position: 'left',
//                fields: ['data1'],
//                label: {
//                    renderer: Ext.util.Format.numberRenderer('0,0')
//                },
//                title: 'Number of Hits',
//                grid: true,
//                minimum: 0
//            }, {
//                type: 'Category',
//                position: 'bottom',
//                fields: ['name'],
//                title: 'Month of the Year'
//            }],
//            series: [{
//                type: 'column',
//                axis: 'left',
//                highlight: true,
//                tips: {
//                  trackMouse: true,
//                  width: 140,
//                  height: 28,
//                  renderer: function(storeItem, item) {
//                    this.setTitle(storeItem.get('name') + ': ' + storeItem.get('data1') + ' $');
//                  }
//                },
//                label: {
//                  display: 'insideEnd',
//                  'text-anchor': 'middle',
//                    field: 'data1',
//                    renderer: Ext.util.Format.numberRenderer('0'),
//                    orientation: 'vertical',
//                    color: '#333'
//                },
//                xField: 'name',
//                yField: 'data1'
//            }]
//        }
//    });
//    return tab;
//};

/**
 * 页面加载后执行操作
 */

Ext.onReady(function(){
	Ext.require([
   		'Ext.grid.*',
    	'Ext.data.*',
    	'Ext.panel.*',
    	'Ext.layout.container.Border'
	]);
	
	
	//采购管理菜单
	var purchasemenu=Xingte.createPurchaseMenu();
	p1=purchasemenu.getComponent('p1');
	p1.on("click",function(){
		puchaseGrid=CreatePurchaseGrid();
		innerPanel.add(puchaseGrid);
		innerPanel.setActiveTab(puchaseGrid);
	});
	//销售管理菜单
	var sellmenu=Xingte.createSellMenu();
	s1=sellmenu.getComponent('s1');
	s1.on("click",function(){
		sellgrid=CreateSellGrid();
		innerPanel.add(sellgrid);
		innerPanel.setActiveTab(sellgrid);
	});
	
	//库存管理菜单
	var stockmenu=Xingte.createStockMenu();
	t1=stockmenu.getComponent('t1');
	t1.on("click",function(){
		goodsStockGrid=CreateGoodsStockGrid();
		innerPanel.add(goodsStockGrid);
		innerPanel.setActiveTab(goodsStockGrid);
	});
	
	t2=stockmenu.getComponent('t2');
	t2.on("click",function(){
		
		instoregrid=CreateInStoreGrid();
		innerPanel.add(instoregrid);
		innerPanel.setActiveTab(instoregrid);
	});
	t3=stockmenu.getComponent('t3');
	t3.on("click",function(){
		
		outstoregrid=CreateOutStoreGrid();
		innerPanel.add(outstoregrid);
		innerPanel.setActiveTab(outstoregrid);
	});
	//配送管理
	var sendmenu=Xingte.createSendMenu();
	//统计分析
	//销售分析

	
	analysemenu=Xingte.createAnalyseMenu();
	
//	al2=stockmenu.getComponent('al2');
//	al2.on("click",function(){
//		
//		sellalay=CreateSellTab();
//		innerPanel.add(sellalay);
//		innerPanel.setActiveTab(sellalay);
//	});
	
	//用户管理菜单
	
	var usermenu=Xingte.createUserMenu();
	//用户列表
	u1=usermenu.getComponent('u1');
	u1.on('click',function(){
		if(!userlist){
			var userlist=userList();
			innerPanel.add(userlist);
		}	
		innerPanel.setActiveTab(userlist);
	});
	//用户组列表
	u3=usermenu.getComponent('u3');
	u3.on('click',function(){
		if(!usergrouplist){
			var usergrouplist=CreateUserGroupGrid();
			innerPanel.add(usergrouplist);
		}		
		innerPanel.setActiveTab(usergrouplist);
	});
	//基础信息菜单
	var basemenu=Xingte.createBasicInfoMenu();
	b1=basemenu.getComponent('b1');
	b1.on('click',function(){		
		var areagrid=CreateAreaGrid();
		innerPanel.add(areagrid);
		innerPanel.setActiveTab(areagrid);
	});
	
	b2=basemenu.getComponent('b2');
	b2.on('click',function(){		
		var customergrid=CreateCustomerList();
		innerPanel.add(customergrid);
		innerPanel.setActiveTab(customergrid);
	});
	
	b3=basemenu.getComponent('b3');
	b3.on('click',function(){		
		var salesManGrid=CreateSalesManGrid();
		innerPanel.add(salesManGrid);
		innerPanel.setActiveTab(salesManGrid);
	});
	
	b4=basemenu.getComponent('b4');
	b4.on('click',function(){		
		var postGrid=CreatePostGrid();
		innerPanel.add(postGrid);
		innerPanel.setActiveTab(postGrid);
	});
	
	b5=basemenu.getComponent('b5');
	b5.on('click',function(){		
		var departmentGrid=CreateDepartmentGrid();
		innerPanel.add(departmentGrid);
		innerPanel.setActiveTab(departmentGrid);
	});
	b6=basemenu.getComponent('b6');
	b6.on('click',function(){		
		var supplierGrid=CreateSupplierList();
		innerPanel.add(supplierGrid);
		innerPanel.setActiveTab(supplierGrid);
	});
	
	b7=basemenu.getComponent('b7');
	b7.on('click',function(){		
		var cataGrid=CreateProCatalogGrid();
		innerPanel.add(cataGrid);
		innerPanel.setActiveTab(cataGrid);
	});
	
	b8=basemenu.getComponent('b8');
	b8.on('click',function(){		
		var productGrid=CreateProductGrid();
		innerPanel.add(productGrid);
		innerPanel.setActiveTab(productGrid);
	});
	
	
	//顶部菜单条
	var toptoolbar=Xingte.createTopbar();
	toptoolbar.add({
		text:"采购管理",
		menu:purchasemenu
	});
	toptoolbar.add({
		text:'销售管理',
		menu:sellmenu
	});
	toptoolbar.add({
		text:'库存管理',
		menu:stockmenu
	});
	toptoolbar.add({
		text:'配送管理',
		menu:sendmenu
	});
	toptoolbar.add({
		text:'统计分析',
		menu:analysemenu
	});
	toptoolbar.add({
		text:'基础信息',
		menu:basemenu
	});
	toptoolbar.add({
		text:'用户权限管理',
		menu:usermenu
	});
	//顶部panel
	var northPanel=Xingte.createTopBanner(toptoolbar);
	//左边tree
	var tree=Xingte.createTree();
	//下方状态栏
	var southPanel=Xingte.creatSouthPanel();
	//主要区域
	var innerPanel=Xingte.createInnerPanel();

	var viewport=new Ext.Viewport({
		layout:'border',
		hideBorders:true,
		items:[northPanel,southPanel,tree,innerPanel]
	});
	
});