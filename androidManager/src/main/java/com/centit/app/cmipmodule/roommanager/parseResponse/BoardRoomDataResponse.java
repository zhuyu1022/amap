/*
 * File name:  BoardRoomDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2016-3-4
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.roommanager.parseResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2016-3-4]
 */
public class BoardRoomDataResponse implements Serializable
{
    
    /**
     * BoardRoomDataResponse.java
     */
    private static final long       serialVersionUID = 1L;
    
    private List<BoardRoomListInfo> boardroomlist    = new ArrayList<BoardRoomListInfo>();
    
    public List<BoardRoomListInfo> getBoardroomlist()
    {
        return boardroomlist;
    }
    
    public void setBoardroomlist(List<BoardRoomListInfo> boardroomlist)
    {
        this.boardroomlist = boardroomlist;
    }
}
