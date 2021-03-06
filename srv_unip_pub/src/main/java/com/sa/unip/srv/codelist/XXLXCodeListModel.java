/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="B99D2D57-FA19-4179-B012-F2DC659860AD",name="消息类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="10",text="类型1",realtext="类型1")
    ,@CodeItem(value="20",text="类型2",realtext="类型2")
    ,@CodeItem(value="30",text="类型3",realtext="类型3")
})



/**
 * 静态代码表[消息类型]模型类
 */
public class XXLXCodeListModel extends com.sa.unip.srv.codelist.UniPSampleStaticCodeListModelBase  {

    /**
     *  类型1，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_10 = "10";
    /**
     *  类型2，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_20 = "20";
    /**
     *  类型3，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_30 = "30";

    public XXLXCodeListModel() {
        super();
        this.initAnnotation(XXLXCodeListModel.class);
        CodeListGlobal.registerCodeList("com.sa.unip.srv.codelist.XXLXCodeListModel", this);
    }

}