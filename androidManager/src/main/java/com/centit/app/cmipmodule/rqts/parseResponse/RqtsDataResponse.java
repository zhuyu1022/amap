/*
 * File name:  YunTuDataResponse.java
 * Copyright:  Copyright (c) 2006-2016 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  zhc
 * Last modified date:  2016-9-22
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.centit.app.cmipmodule.rqts.parseResponse;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author zhc
 * @Version [版本号, 2016-9-22]
 */
public class RqtsDataResponse implements Serializable
{
    
    /**
     * YunTuDataResponse.java
     */
    private static final long serialVersionUID = 1L;
    
    // "usernumber": "1000004",
    // "period_code": "20160529",
    // "message_content":
    // "690:
    // 全球>实际72.9亿,完成率80.6%,同比-3%;国内>实际50.1亿,完成率75.6%,同比-3.3%;海外>实际22.8亿,完成率94.2%,同比-2.2%
    // #产线:彩电>实际52566.1万,完成率56.1%,同比-22.6%;制冷>实际199291.2万,完成率80.9%,同比-4.3%;商用>实际18426万,完成率76.7%,同比-2.8%
    // #用户小微:PAD>实际36.6万,完成率5.5%,同比-92.5%;工业装备小微>实际47.8万,完成率7.7%,同比-88.9%;商用小微>实际2659.2万,完成率34.1%,同比-65.3%
    // #海外:亚太直发小V>实际106.7万,完成率4.3%,同比-97%;沙阿小V>实际113.5万,完成率3.7%,同比-96.9%;空调大客户小V>实际1752.6万,完成率61.9%,同比-54.5%#"
    
    private String            usernumber;
    
    private String            period_code;
    
    private String            message_content;
    
    public String getUsernumber()
    {
        return usernumber;
    }
    
    public void setUsernumber(String usernumber)
    {
        this.usernumber = usernumber;
    }
    
    public String getPeriod_code()
    {
        return period_code;
    }
    
    public void setPeriod_code(String period_code)
    {
        this.period_code = period_code;
    }
    
    public String getMessage_content()
    {
        return message_content;
    }
    
    public void setMessage_content(String message_content)
    {
        this.message_content = message_content;
    }
    
}
