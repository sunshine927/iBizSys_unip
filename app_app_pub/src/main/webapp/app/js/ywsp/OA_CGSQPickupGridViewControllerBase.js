var OA_CGSQPickupGridViewControllerBase = PickupGridViewControllerBase.extend({
construct: function(config) {
    if(!config)config={};
    if(!config.appctx)config.appctx='';
    if(!config.containerid)config.containerid='';
    arguments.callee.$.construct.call(this,this.getDefaultCfg(config));
    this.regCodeLists(config);
    this.regUICounters(config);
    this.regUIActions(config);
    this.regUpdatePanels(config);
    this.regControllers(config);
}
,regCodeLists:function(config)
{
     /*采购类型*/
     this.regCodeList(new IBizCodeList({id: 'uniPSample_CGLX',datas:[{text:'打印机',value:'10',realtext:'打印机'},{text:'扫描仪',value:'20',realtext:'扫描仪'},{text:'电脑',value:'30',realtext:'电脑'},{text:'其他',value:'40',realtext:'其他'}]}));
     /*支付方式*/
     this.regCodeList(new IBizCodeList({id: 'uniPSample_ZFFS',datas:[{text:'网银',value:'10',realtext:'网银'},{text:'微信',value:'20',realtext:'微信'},{text:'支付宝',value:'30',realtext:'支付宝'},{text:'现金',value:'40',realtext:'现金'}]}));
}
,regUICounters:function(config)
{
}
,regUpdatePanels:function(config)
{
     var me=this;
}
,regControllers:function(config)
{
  var cid=config.containerid;
    if(cid!='')cid=cid+'_';
}
,regUIActions:function(config)
{
}
,onInit:function(){
   arguments.callee.$.onInit.call(this);
   var form=this.getSearchForm();
form.register(new IBizTextField({id:this.getCId2()+'M4',name:'n_orgusername_like',form:form,width:100})
);
form.register(new IBizTextField({id:this.getCId2()+'M5',name:'n_orgsectorname_like',form:form,width:100})
);

}
,onSearchFormFieldChanged: function (fieldname, field, value) {
   var me=this;
   var form=me.getSearchForm();
}
,getDefaultCfg:function(cfg){
     var me=this;   
    var config={backendurl:cfg.appctx+'/ywsp/OA_CGSQPickupGridView.do?'+'srfcid='+cfg.containerid+'&',loaddefault:true
                ,viewurl:'/ywsp/oa_cgsqpickupgridview.jsp?'+'srfcid='+cfg.containerid+'&'
               ,ctrls:{grid:{multiSelect:true
,enablePaging:true,pageSize:20,forceFit:false
,columns:[
{ "title" : '采购人',"width":150,"data" :'orgusername',"orderable":true}

,{ "title" : '部门名称',"width":150,"data" :'orgsectorname',"orderable":true}

,{ "title" : $IGM('DEF.LNAME.OA_CGSQNAME','采购申请名称'),"width":150,"data" :'oa_cgsqname',"orderable":true}

,{ "title" : '采购类型',"width":150,"data" :'cglx',"orderable":true,'render':function(data,type,row){return me.rendergrid_cglx(data,type,row,me);}}

,{ "title" : '价格',"width":150,"data" :'jg',"orderable":true}

,{ "title" : '数量',"width":150,"data" :'sl',"orderable":true}

,{ "title" : '申请事由',"width":150,"data" :'sqsy',"orderable":true}

,{ "title" : '支付方式',"width":150,"data" :'zffs',"orderable":true,'render':function(data,type,row){return me.rendergrid_zffs(data,type,row,me);}}

,{ "title" : '规格',"width":150,"data" :'gg',"orderable":true}

,{ "title" : '备注',"width":150,"data" :'bz',"orderable":true}

,{ "title" : $IGM('DEF.LNAME.UPDATEMAN','更新人'),"width":150,"data" :'updateman',"orderable":true}

,{ "title" : $IGM('DEF.LNAME.UPDATEDATE','更新时间'),"width":150,"data" :'updatedate',"orderable":true}

,{ "title" : $IGM('DEF.LNAME.CREATEDATE','建立时间'),"width":150,"data" :'createdate',"orderable":true}
]
},searchForm:{enableAdvanceSearch:false,dename:'OA_CGSQ'}}};
    return  $.extend({},config,cfg);
}
,doHideParentColumns: function (parentMode)
    {
        var me=this;
        arguments.callee.$.doHideParentColumns.call(this,parentMode);
 
         //关系类型 : DER1N ,主实体 :ORGUSER / 组织人员
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_OA_CGSQ_ORGUSER_ORGUSERID')
         {
              me.hideGridColumn('orgusername');
              return;
         }
         //关系类型 : DER1N ,主实体 :ORGSECTOR / 组织部门
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_OA_CGSQ_ORGSECTOR_ORGSECTORID')
         {
              me.hideGridColumn('orgsectorname');
              return;
         }
}
    ,rendergrid_cglx:function(data,type,row,me){
           return me.renderCodeList_Normal('uniPSample_CGLX',data,'未定义');
    }
    ,rendergrid_zffs:function(data,type,row,me){
           return me.renderCodeList_Normal('uniPSample_ZFFS',data,'未定义');
    }
});