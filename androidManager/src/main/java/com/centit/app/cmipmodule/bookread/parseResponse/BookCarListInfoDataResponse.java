/*
 * File name:  BookCarListInfoDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016年10月8日
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.bookread.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016年10月8日]
 */
public class BookCarListInfoDataResponse implements Serializable
{
    
    /**
     * BookCarListInfoDataResponse.java
     */
    private static final long             serialVersionUID = 1L;
    
    private List<BookCarListInfoResponse> bookList         = new ArrayList<BookCarListInfoResponse>();
    
    /**
     * 获取 bookList
     * 
     * @return 返回 bookList
     * @author wl
     */
    public List<BookCarListInfoResponse> getBookList()
    {
        return bookList;
    }
    
    /**
     * 设置 bookList
     * 
     * @param bookList 对bookList进行赋值
     * @author wl
     */
    public void setBookList(List<BookCarListInfoResponse> bookList)
    {
        this.bookList = bookList;
    }
    
}
