package com.centit.core.tools.netUtils.baseReqeust.baseParseResponse;

import com.centit.core.tools.exceptionManager.ExceptionConst;
import com.centit.core.tools.exceptionManager.MIPException;
import com.google.gson.Gson;

public class ParseResponseUtils
{
    
    public static <T> T parse(String json, Class<T> cla)
        throws Exception
    {
        try
        {
            
            if (json != null)
            {
                Gson gson = new Gson();
                T response = (T)gson.fromJson(json, cla);
                return response;
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
            throw new MIPException(ExceptionConst.EXCEPTION, e.toString());
        }
        return null;
    }
}
