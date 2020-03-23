package sxs.core.controller.hrm;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sxs.core.vo.hrm.ResultInfoVo;

import java.lang.reflect.Method;

/**
 * Author: shang
 * Create Data: 2020/2/21/021
 * 此Controller用来统一json控制器,所有json请求都会经过此控制器
 */
@Controller
public class JsonController {

    @RequestMapping("/{packageName}/json/{nameSpace}/{methodName}")
    @ResponseBody
    public ResultInfoVo parseJson(@PathVariable String packageName, @PathVariable String nameSpace, @PathVariable String methodName, @RequestBody String JsonData) throws ClassNotFoundException {

        if (StringUtils.isNotBlank(nameSpace)){
            String voClass = nameSpace.substring(0,1).toUpperCase()+nameSpace.substring(1)+"Vo";
            Class vClazz = Class.forName("sxs.core.vo."+packageName+"."+voClass);
            JSONObject jsonObject= JSONObject.fromObject(JsonData);
            Object object = JSONObject.toBean(jsonObject,vClazz);
            String actionClass = nameSpace.substring(0,1).toUpperCase()+nameSpace.substring(1)+"Action";
            Class aClazz = Class.forName("sxs.core.action."+packageName+"."+actionClass);
            try {
                Method method = aClazz.getMethod(methodName,vClazz);
                ResultInfoVo resultInfoVo = (ResultInfoVo) method.invoke(aClazz.newInstance(),object);
                return resultInfoVo;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ResultInfoVo(false,null,"访问的资源不存在或地址有误");
    }
}
