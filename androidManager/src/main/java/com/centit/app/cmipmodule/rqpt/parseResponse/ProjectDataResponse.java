/*
 * File name:  YunTuDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqpt.parseResponse;

import java.io.Serializable;
import java.util.List;

import com.centit.app.cmipmodule.rqpt.entity.Projects;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-22]
 */
public class ProjectDataResponse implements Serializable
{
    
    /**
     * YunTuDataResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "pcid":"分类ID",
    // "pcname":"分类名称",
    // "projects":[{
    // "pid": "项目ID",
    // "pname": "项目名称",
    // "purl": "项目图标",
    // "newreportsnum":"最新报告数量"
    // },{…},{…}]
    
    private String            pcid;
    
    private String            pcname;
    
    private List<Projects>    projects;
    
    public String getPcid()
    {
        return pcid;
    }
    
    public void setPcid(String pcid)
    {
        this.pcid = pcid;
    }
    
    public String getPcname()
    {
        return pcname;
    }
    
    public void setPcname(String pcname)
    {
        this.pcname = pcname;
    }
    
    public List<Projects> getProjects()
    {
        return projects;
    }
    
    public void setProjects(List<Projects> projects)
    {
        this.projects = projects;
    }
    
}
