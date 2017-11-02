/*
 * File name:  IAddressItemToAddressView.java
 * Copyright:  Copyright (c) 2006-2015 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  wl
 * Last modified date:  2015-9-29
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.addressbook.utils;

import com.centit.app.cmipmodule.addressbook.entity.AddressItemEntity;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author wl
 * @Version [版本号, 2015-9-29]
 */
public interface IAddressItemToAddressView
{
    public void onArrowListener(int postion);
    
    public void onCheckListener(AddressItemEntity entity);
}
