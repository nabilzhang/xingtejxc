Ext.namespace("Xingte");
Xingte.createPurchaseListGrid=function(){	
	Ext.define('User',{
        extend: 'Ext.data.Model',
        fields: [
            // set up the fields mapping into the xml doc
            // The first needs mapping, the others are very basic
            'id',
            'name',
            'password'
        ]
    });

    // create the Data Store
    var store = Ext.create('Ext.data.Store', {
        model: 'User',
        proxy: {
            // load using HTTP
            type: 'ajax',
            url: 'http://localhost/ext4/returnlist.json',
            // the return will be XML, so lets set up a reader
            reader: {
                type: 'json',
                root: 'model'
               // totalProperty : 2
            }
        }
    });

    // create the grid
    var grid = Ext.create('Ext.grid.Panel', {
        store: store,
        columns: [
            {text: "id", width: 120, dataIndex: 'id', sortable: true},
            {text: "name", flex: 1, dataIndex: 'name', sortable: true},
            {text: "password", width: 115, dataIndex: 'password', sortable: true}
        ],
        viewConfig: {
            forceFit: true
        },
        split: true,
        frame: true,
        title: 'Book List'        
    });
    store.load();
    
    var purchaseListGrid=Ext.create('Ext.Panel',{
    	title:'x',
    	html:'x'
    });
    
	return purchaseListGrid;
};

Xingte.createInnerPanel=function(){
	var innerPanel=new Ext.TabPanel({ 
	region:'center',
	height:'100%',
	hideBorders:true,
	layout:'fit',
	items:[{
		id:'welcome',
		title:'欢迎页',
		html:'欢迎页'
		}],
	split:true
	});	
	return innerPanel;
};