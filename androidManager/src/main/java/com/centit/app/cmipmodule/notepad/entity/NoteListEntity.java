/*
 * File name:  NoteListEntity.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  rqj
 * Last modified date:  2015-9-25
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.notepad.entity;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author rqj
 * @Version [版本号, 2015-9-25]
 */
public class NoteListEntity
{
    private String  noteId;
    
    private String  noteDate;
    
    private String  noteTitle;
    
    private String  noteContent;
    
    private Boolean isDeleting = false;
    
    /**
     * <默认构造函数>
     */
    public NoteListEntity(String noteId, String noteDate, String noteTitle, String noteContent, Boolean isDeleting)
    {
        super();
        this.noteId = noteId;
        this.noteDate = noteDate;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.isDeleting = isDeleting;
    }
    
    /**
     * 获取 noteId
     * 
     * @return 返回 noteId
     * @author rqj
     */
    public String getNoteId()
    {
        return noteId;
    }
    
    /**
     * 设置 noteId
     * 
     * @param noteId 对noteId进行赋值
     * @author rqj
     */
    public void setNoteId(String noteId)
    {
        this.noteId = noteId;
    }
    
    /**
     * 获取 noteDate
     * 
     * @return 返回 noteDate
     * @author rqj
     */
    public String getNoteDate()
    {
        return noteDate;
    }
    
    /**
     * 设置 noteDate
     * 
     * @param noteDate 对noteDate进行赋值
     * @author rqj
     */
    public void setNoteDate(String noteDate)
    {
        this.noteDate = noteDate;
    }
    
    /**
     * 获取 noteTitle
     * 
     * @return 返回 noteTitle
     * @author rqj
     */
    public String getNoteTitle()
    {
        return noteTitle;
    }
    
    /**
     * 设置 noteTitle
     * 
     * @param noteTitle 对noteTitle进行赋值
     * @author rqj
     */
    public void setNoteTitle(String noteTitle)
    {
        this.noteTitle = noteTitle;
    }
    
    /**
     * 获取 noteContent
     * 
     * @return 返回 noteContent
     * @author rqj
     */
    public String getNoteContent()
    {
        return noteContent;
    }
    
    /**
     * 设置 noteContent
     * 
     * @param noteContent 对noteContent进行赋值
     * @author rqj
     */
    public void setNoteContent(String noteContent)
    {
        this.noteContent = noteContent;
    }
    
    /**
     * 获取 isDeleting
     * 
     * @return 返回 isDeleting
     * @author rqj
     */
    public Boolean getIsDeleting()
    {
        return isDeleting;
    }
    
    /**
     * 设置 isDeleting
     * 
     * @param isDeleting 对isDeleting进行赋值
     * @author rqj
     */
    public void setIsDeleting(Boolean isDeleting)
    {
        this.isDeleting = isDeleting;
    }
    
}
