/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.srv.xxtz.service;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.EntityError;
import java.sql.Timestamp;
import net.ibizsys.paas.util.DefaultValueHelper;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.service.IDataContextParam;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import com.sa.unip.srv.xxtz.entity.LVXIN_ORGANIZATION;
import com.sa.unip.srv.xxtz.dao.LVXIN_ORGANIZATIONDAO;
import com.sa.unip.srv.xxtz.demodel.LVXIN_ORGANIZATIONDEModel;


/**
 * 实体[LVXIN_ORGANIZATION] 服务对象基类
 */
@Component
public class LVXIN_ORGANIZATIONService extends com.sa.unip.srv.UniPSampleSysServiceBase<LVXIN_ORGANIZATION> {
    private static final Log log = LogFactory.getLog(LVXIN_ORGANIZATIONService.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public LVXIN_ORGANIZATIONService () {
        super();

    }

    /**
     * 获取实体[LVXIN_ORGANIZATION]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static LVXIN_ORGANIZATIONService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[LVXIN_ORGANIZATION]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static LVXIN_ORGANIZATIONService getInstance(SessionFactory sessionFactory) throws Exception {
        return (LVXIN_ORGANIZATIONService)ServiceGlobal.getService(LVXIN_ORGANIZATIONService.class, sessionFactory);
    }

    /**
     * Spring注册后执行构造处理
     * @throws Exception
     */
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(getServiceId(), this);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getServiceId()
     */
    @Override
    protected String getServiceId() {
        return "com.sa.unip.srv.xxtz.service.LVXIN_ORGANIZATIONService";
    }

    private LVXIN_ORGANIZATIONDEModel lVXIN_ORGANIZATIONDEModel;
    /**
     * 获取实体[LVXIN_ORGANIZATION]模型对象
     */
    public  LVXIN_ORGANIZATIONDEModel getLVXIN_ORGANIZATIONDEModel() {
        if(this.lVXIN_ORGANIZATIONDEModel==null) {
            try {
                this.lVXIN_ORGANIZATIONDEModel = (LVXIN_ORGANIZATIONDEModel)DEModelGlobal.getDEModel("com.sa.unip.srv.xxtz.demodel.LVXIN_ORGANIZATIONDEModel");
            } catch(Exception ex) {
            }
        }
        return this.lVXIN_ORGANIZATIONDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getLVXIN_ORGANIZATIONDEModel();
    }


    private LVXIN_ORGANIZATIONDAO lVXIN_ORGANIZATIONDAO;

    /**
     * 获取实体[LVXIN_ORGANIZATION]数据操作对象
     */
    public  LVXIN_ORGANIZATIONDAO getLVXIN_ORGANIZATIONDAO() {
        if(this.lVXIN_ORGANIZATIONDAO==null) {
            try {
                this.lVXIN_ORGANIZATIONDAO= (LVXIN_ORGANIZATIONDAO)DAOGlobal.getDAO("com.sa.unip.srv.xxtz.dao.LVXIN_ORGANIZATIONDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.lVXIN_ORGANIZATIONDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getLVXIN_ORGANIZATIONDAO();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onfetchDataSet(java.lang.String, net.ibizsys.paas.core.IDEDataSetFetchContext)
     */
    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName,IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if(StringHelper.compare(strDataSetName,DATASET_DEFAULT,true)==0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName,iDEDataSetFetchContext);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onExecuteAction(java.lang.String, net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected  void onExecuteAction(String strAction,IEntity entity) throws Exception {
        super.onExecuteAction(strAction,entity);
    }

    /**
     * 获取数据集合[DEFAULT]
     * @param iDEDataSetFetchContext
     * @return
     * @throws Exception
     */
    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {

        DBFetchResult dbFetchResult =  doServiceFetchWork(iDEDataSetFetchContext,DATASET_DEFAULT,false);
        // dbFetchResult.getDataSet().cacheDataRow();
        // session.close();
        return dbFetchResult;
    }







    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillParentInfo(net.ibizsys.paas.entity.IEntity, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected void onFillParentInfo(LVXIN_ORGANIZATION et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        super.onFillParentInfo(et,strParentType,strTypeParam,strParentKey);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncDER1NData(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData( strDER1NId,  strParentKey,  strDatas);
    }





    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(LVXIN_ORGANIZATION et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(LVXIN_ORGANIZATION et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }







    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(LVXIN_ORGANIZATION et) throws Exception {
        super.onBeforeRemove(et);
    }






    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(LVXIN_ORGANIZATION et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,LVXIN_ORGANIZATION  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 组织标识
        entityFieldError = onCheckField_CODE( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 组织名称
        entityFieldError = onCheckField_NAME( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 上级编号
        entityFieldError = onCheckField_Parentcode( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 排序
        entityFieldError = onCheckField_Sort( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[CODE]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_CODE(boolean bBaseMode,LVXIN_ORGANIZATION et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isCODEDirty())
            return null;

        String value = et.getCODE();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(LVXIN_ORGANIZATION.FIELD_CODE);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_CODE_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(LVXIN_ORGANIZATION.FIELD_CODE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[NAME]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_NAME(boolean bBaseMode,LVXIN_ORGANIZATION et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isNAMEDirty())
            return null;

        String value = et.getNAME();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_NAME_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(LVXIN_ORGANIZATION.FIELD_NAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Parentcode]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Parentcode(boolean bBaseMode,LVXIN_ORGANIZATION et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isParentcodeDirty())
            return null;

        String value = et.getParentcode();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Parentcode_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(LVXIN_ORGANIZATION.FIELD_PARENTCODE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Sort]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Sort(boolean bBaseMode,LVXIN_ORGANIZATION et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isSortDirty())
            return null;

        String value = et.getSort();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Sort_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(LVXIN_ORGANIZATION.FIELD_SORT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncEntity(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncEntity(LVXIN_ORGANIZATION et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(LVXIN_ORGANIZATION et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(LVXIN_ORGANIZATION et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,LVXIN_ORGANIZATION.FIELD_CODE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CODE_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,LVXIN_ORGANIZATION.FIELD_SORT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Sort_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,LVXIN_ORGANIZATION.FIELD_PARENTCODE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Parentcode_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,LVXIN_ORGANIZATION.FIELD_NAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_NAME_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[组织标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_CODE_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("CODE", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]")))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[排序][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Sort_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("SORT", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]")))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[上级编号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Parentcode_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PARENTCODE", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]")))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组织名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_NAME_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("NAME", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]")))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onMergeChild(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, LVXIN_ORGANIZATION et) throws Exception {
        boolean bRet = false;
        if(super.onMergeChild( strChildType, strTypeParam,  et))
            bRet = true;
        return bRet;
    }



    /**
     * 更新父数据
     * @param et
     * @throws Exception
     */
    @Override
    protected void onUpdateParent(LVXIN_ORGANIZATION et)throws Exception {
        super.onUpdateParent(et);
    }


}