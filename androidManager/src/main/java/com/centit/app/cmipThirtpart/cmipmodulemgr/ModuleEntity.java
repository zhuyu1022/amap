/*
 * File name:  ModuleEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  Administrator
 * Last modified date:  2015-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipThirtpart.cmipmodulemgr;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author Administrator
 * @Version [版本号, 2015-9-22]
 */
public class ModuleEntity implements Serializable
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    // 功能code，应用的appid
    private String            funcode          = "";
    
    // 应用、功能的名称
    private String            funname          = "";
    
    // 对于功能的跳转的Activity的路径，对于APK应用为包名，对于web应用为指向的URL
    private String            funclasspath     = "";
    
    /**
     * 功能的icon
     */
    private String            funicon          = "";
    
    /**
     * 功能的icon
     */
    private String            funicon_l        = "";
    
    // -1 无应用 ， 0:添加，1:功能， 2:应用 3:web应用
    private String            type             = "";
    
    //
    private String            value            = "";
    
    // 是否有权限被添加
    private String            isAble           = "";
    
    // 是否被添加
    private String            isAdd            = "";
    
    // 被添加后的排序
    private int               sort_in_addlist;
    
    // 在分组中的排序
    private int               sort_in_team;
    
    // 该功能是否有未读数的功能
    private String            count_able       = "";
    
    // 存在待办数/未读数时第一套模板下的图标
    private String            count_icon_1     = "";
    
    // 存在待办数/未读数时第二套模板下的图标
    private String            count_icon_2     = "";
    
    // 未读数的数量
    private int               count            = -1;
    
    // 用于公文 紧急文件数
    private int               urgCount         = -1;
    
    // 获取未读数时的类型
    private String            count_type       = "";
    
    // 是否可以被移除
    private boolean           isEdit           = false;
    
    // 该模块所属的分组code
    private String            pCode            = "";
    
    // 该模块所属的分组name
    private String            pName            = "";
    
    // apk下载地址
    private String            attachURL        = "";
    
    // 外部应用时图标地址
    private String            iconURL          = "";
    
    // apk应用的版本号
    private String            version          = "";
    
    /**
     * <默认构造函数>
     */
    public ModuleEntity()
    {
        super();
    }
    
    /**
     * @param funcode
     * @param funname
     * @param funclasspath
     * @param funicon
     * @param type
     * @param value
     * @param isAble
     * @param isAdd
     * @param sort
     * @param count_able
     * @param count_icon_1
     * @param count_icon_2
     * @param isEdit
     * @param pCode
     * @param pName
     * @param iconURL
     * @param version
     */
    public ModuleEntity(String funcode, String funname, String funclasspath, String funicon, String type, String value,
        String isAble, String isAdd, int sort, String count_able, String count_icon_1, String count_icon_2,
        boolean isEdit, String pCode, String pName, String iconURL, String version)
    {
        super();
        this.funcode = funcode;
        this.funname = funname;
        this.funclasspath = funclasspath;
        this.funicon = funicon;
        this.type = type;
        this.value = value;
        this.isAble = isAble;
        this.isAdd = isAdd;
        this.sort_in_addlist = sort;
        this.count_able = count_able;
        this.count_icon_1 = count_icon_1;
        this.count_icon_2 = count_icon_2;
        this.isEdit = isEdit;
        this.pCode = pCode;
        this.pName = pName;
        this.iconURL = iconURL;
        this.version = version;
    }
    
    public ModuleEntity(String funcode, String funname)
    {
        super();
        this.funcode = funcode;
        this.funname = funname;
    }
    
    public int getUrgCount()
    {
        return urgCount;
    }
    
    public void setUrgCount(int urgCount)
    {
        this.urgCount = urgCount;
    }
    
    /**
     * 获取 funcode
     * 
     * @return 返回 funcode
     * @author Administrator
     */
    public String getFuncode()
    {
        return funcode;
    }
    
    /**
     * 设置 funcode
     * 
     * @param funcode 对funcode进行赋值
     * @author Administrator
     */
    public void setFuncode(String funcode)
    {
        this.funcode = funcode;
    }
    
    /**
     * 获取 funname
     * 
     * @return 返回 funname
     * @author Administrator
     */
    public String getFunname()
    {
        return funname;
    }
    
    /**
     * 设置 funname
     * 
     * @param funname 对funname进行赋值
     * @author Administrator
     */
    public void setFunname(String funname)
    {
        this.funname = funname;
    }
    
    /**
     * 获取 funclasspath
     * 
     * @return 返回 funclasspath
     * @author Administrator
     */
    public String getFunclasspath()
    {
        return funclasspath;
    }
    
    /**
     * 设置 funclasspath
     * 
     * @param funclasspath 对funclasspath进行赋值
     * @author Administrator
     */
    public void setFunclasspath(String funclasspath)
    {
        this.funclasspath = funclasspath;
    }
    
    /**
     * 获取 funicon
     * 
     * @return 返回 funicon
     * @author Administrator
     */
    public String getFunicon()
    {
        return funicon;
    }
    
    /**
     * 设置 funicon
     * 
     * @param funicon 对funicon进行赋值
     * @author Administrator
     */
    public void setFunicon(String funicon)
    {
        this.funicon = funicon;
    }
    
    /**
     * 获取 type
     * 
     * @return 返回 type
     * @author Administrator
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * 设置 type
     * 
     * @param type 对type进行赋值
     * @author Administrator
     */
    public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * 获取 value
     * 
     * @return 返回 value
     * @author Administrator
     */
    public String getValue()
    {
        return value;
    }
    
    /**
     * 设置 value
     * 
     * @param value 对value进行赋值
     * @author Administrator
     */
    public void setValue(String value)
    {
        this.value = value;
    }
    
    /**
     * 获取 isAble
     * 
     * @return 返回 isAble
     * @author rqj
     */
    public String getIsAble()
    {
        return isAble;
    }
    
    /**
     * 设置 isAble
     * 
     * @param isAble 对isAble进行赋值
     * @author rqj
     */
    public void setIsAble(String isAble)
    {
        this.isAble = isAble;
    }
    
    /**
     * 获取 isAdd
     * 
     * @return 返回 isAdd
     * @author rqj
     */
    public String getIsAdd()
    {
        return isAdd;
    }
    
    /**
     * 设置 isAdd
     * 
     * @param isAdd 对isAdd进行赋值
     * @author rqj
     */
    public void setIsAdd(String isAdd)
    {
        this.isAdd = isAdd;
    }
    
    /**
     * @return the count_able
     */
    public String getCount_able()
    {
        return count_able;
    }
    
    /**
     * @param count_able the count_able to set
     */
    public void setCount_able(String count_able)
    {
        this.count_able = count_able;
    }
    
    /**
     * @return the count_icon_1
     */
    public String getCount_icon_1()
    {
        return count_icon_1;
    }
    
    /**
     * @param count_icon_1 the count_icon_1 to set
     */
    public void setCount_icon_1(String count_icon_1)
    {
        this.count_icon_1 = count_icon_1;
    }
    
    /**
     * @return the count_icon_2
     */
    public String getCount_icon_2()
    {
        return count_icon_2;
    }
    
    /**
     * @param count_icon_2 the count_icon_2 to set
     */
    public void setCount_icon_2(String count_icon_2)
    {
        this.count_icon_2 = count_icon_2;
    }
    
    /**
     * @return the isEdit
     */
    public boolean isEdit()
    {
        return isEdit;
    }
    
    /**
     * @param isEdit the isEdit to set
     */
    public void setEdit(boolean isEdit)
    {
        this.isEdit = isEdit;
    }
    
    /**
     * @return the pCode
     */
    public String getpCode()
    {
        return pCode;
    }
    
    /**
     * @param pCode the pCode to set
     */
    public void setpCode(String pCode)
    {
        this.pCode = pCode;
    }
    
    /**
     * @return the pName
     */
    public String getpName()
    {
        return pName;
    }
    
    /**
     * @param pName the pName to set
     */
    public void setpName(String pName)
    {
        this.pName = pName;
    }
    
    /**
     * @return the iconURL
     */
    public String getIconURL()
    {
        return iconURL;
    }
    
    /**
     * @param iconURL the iconURL to set
     */
    public void setIconURL(String iconURL)
    {
        this.iconURL = iconURL;
    }
    
    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }
    
    /**
     * @param version the version to set
     */
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    /**
     * @return the attachURL
     */
    public String getAttachURL()
    {
        return attachURL;
    }
    
    /**
     * @param attachURL the attachURL to set
     */
    public void setAttachURL(String attachURL)
    {
        this.attachURL = attachURL;
    }
    
    /**
     * @return the sort_in_addlist
     */
    public int getSort_in_addlist()
    {
        return sort_in_addlist;
    }
    
    /**
     * @param sort_in_addlist the sort_in_addlist to set
     */
    public void setSort_in_addlist(int sort_in_addlist)
    {
        this.sort_in_addlist = sort_in_addlist;
    }
    
    /**
     * @return the sort_in_team
     */
    public int getSort_in_team()
    {
        return sort_in_team;
    }
    
    /**
     * @param sort_in_team the sort_in_team to set
     */
    public void setSort_in_team(int sort_in_team)
    {
        this.sort_in_team = sort_in_team;
    }
    
    /**
     * 获取 count_type
     * 
     * @return 返回 count_type
     * @author rqj
     */
    public String getCount_type()
    {
        return count_type;
    }
    
    /**
     * 设置 count_type
     * 
     * @param count_type 对count_type进行赋值
     * @author rqj
     */
    public void setCount_type(String count_type)
    {
        this.count_type = count_type;
    }
    
    /**
     * 获取 count
     * 
     * @return 返回 count
     * @author rqj
     */
    public int getCount()
    {
        return count;
    }
    
    /**
     * 设置 count
     * 
     * @param count 对count进行赋值
     * @author rqj
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    
    /**
     * 获取 funicon_l
     * 
     * @return 返回 funicon_l
     * @author wl
     */
    public String getFunicon_l()
    {
        return funicon_l;
    }
    
    /**
     * 设置 funicon_l
     * 
     * @param funicon_l 对funicon_l进行赋值
     * @author wl
     */
    public void setFunicon_l(String funicon_l)
    {
        this.funicon_l = funicon_l;
    }
    
    public boolean isChange(ModuleEntity entity)
    {
        if (!funcode.equals(entity.getFuncode()))
        {
            return false;
        }
        
        if (!funname.equals(entity.getFunname()))
        {
            return false;
        }
        if (!funclasspath.equals(entity.getFunclasspath()))
        {
            return false;
        }
        
        if (!funicon.equals(entity.getFunicon()))
        {
            return false;
        }
        if (!funicon_l.equals(entity.getFunicon_l()))
        {
            return false;
        }
        
        if (!type.equals(entity.getType()))
        {
            return false;
        }
        
        if (!value.equals(entity.getValue()))
        {
            return false;
        }
        
        if (!isAble.equals(entity.getIsAble()))
        {
            return false;
        }
        if (!isAdd.equals(entity.getIsAdd()))
        {
            return false;
        }
        
        if (sort_in_addlist != entity.getSort_in_addlist())
        {
            return false;
        }
        
        if (sort_in_team != entity.getSort_in_team())
        {
            return false;
        }
        
        if (!count_able.equals(entity.getCount_able()))
        {
            return false;
        }
        if (!count_icon_1.equals(entity.getCount_icon_1()))
        {
            return false;
        }
        
        if (!count_icon_2.equals(entity.getCount_icon_2()))
        {
            return false;
        }
        if (count != entity.getCount())
        {
            return false;
        }
        
        if (urgCount != entity.getUrgCount())
        {
            return false;
        }
        if (!count_type.equals(entity.getCount_type()))
        {
            return false;
        }
        if (isEdit != entity.isEdit)
        {
            return false;
        }
        if (!pCode.equals(entity.getpCode()))
        {
            return false;
        }
        if (!pName.equals(entity.getpName()))
        {
            return false;
        }
        if (!attachURL.equals(entity.getAttachURL()))
        {
            return false;
        }
        if (!iconURL.equals(entity.getIconURL()))
        {
            return false;
        }
        if (!version.equals(entity.getVersion()))
        {
            return false;
        }
        return true;
    }
}
