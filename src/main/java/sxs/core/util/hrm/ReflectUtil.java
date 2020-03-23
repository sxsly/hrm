package sxs.core.util.hrm;

import org.apache.log4j.Logger;
import sxs.core.vo.hrm.UserVo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Author: shang
 * Create Data: 2020/2/28/028
 */
public class ReflectUtil {
    private static Logger logger = Logger.getLogger(ReflectUtil.class);
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Object getVoObject(String voName, Map map){
        Object voObject = null;

        try {
            Class clazz = Class.forName("sxs.core.vo.hrm."+voName);
            voObject = clazz.newInstance();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("set")){
                    String key = method.getName().replace("set", "");
                    key = key.substring(0, 1).toLowerCase().concat(key.substring(1));
                    Object value = map.get(key);
                    if(value==null || value.equals("N/A")) continue;
                    Class<?>[]  paramType = method.getParameterTypes();
                    //根据参数类型执行对应的set方法给vo赋值
                    if(paramType[0] == String.class){
                        method.invoke(voObject, String.valueOf(value));
                        continue;
                    }else if(paramType[0] == BigDecimal.class){
                        method.invoke(voObject, new BigDecimal(value.toString()));
                        continue;
                    }else if(paramType[0] == Double.class){
                        method.invoke(voObject, Double.parseDouble(value.toString()));
                        continue;
                    }else if(paramType[0] == Date.class){
                        method.invoke(voObject, StringToDate(value.toString()));
                        continue;
                    }else if(paramType[0] == int.class || paramType[0] == Integer.class){
                        method.invoke(voObject, Integer.valueOf(value.toString()));
                        continue;
                    }else if(paramType[0] == Boolean.class){
                        method.invoke(voObject, Boolean.parseBoolean(value.toString()));
                        continue;
                    }else if(paramType[0] == char.class || paramType[0] == Character.class){
                        method.invoke(voObject, value.toString().charAt(0));
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return voObject;
    }

    //字符串转日期
    public static Date  StringToDate(String str){
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
