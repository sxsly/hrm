package sxs.core.controller.hrm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sxs.core.service.hrm.UserService;
import sxs.core.util.hrm.ReflectUtil;
import sxs.core.vo.hrm.ResultInfoVo;
import sxs.core.vo.hrm.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: shang
 * Create Data: 2020/2/27/027
 */
@Controller
public class JqGridController {

    @RequestMapping("/{packageName}/jqGrid/{nameSpace}/{methodName}")
    @ResponseBody
    public ResultInfoVo parseJqGrid(@PathVariable String packageName, @PathVariable String nameSpace, @PathVariable String methodName, HttpServletRequest request) throws Exception {
        Enumeration parameterNames = request.getParameterNames();
        // String voName = request.getParameter("voName");
        if (StringUtils.isNotBlank(nameSpace)){
            String voName = nameSpace.substring(0,1).toUpperCase()+nameSpace.substring(1)+"Vo";
            Map<String,Object> map = new HashMap();
            while (parameterNames.hasMoreElements()){
                String paramName = (String) parameterNames.nextElement();
                Object paramValue = request.getParameter(paramName);
                map.put(paramName,paramValue);
            }

            Object voObject = ReflectUtil.getVoObject(voName,map);
            String actionClass = nameSpace.substring(0,1).toUpperCase()+nameSpace.substring(1)+"Action";
            Class aClazz = Class.forName("sxs.core.action."+packageName+"."+actionClass);
            Method method = aClazz.getMethod(methodName,voObject.getClass());
            ResultInfoVo resultInfoVo = (ResultInfoVo) method.invoke(aClazz.newInstance(),voObject);
            return resultInfoVo;
        }

        return new ResultInfoVo(false,null,"访问的资源不存在或地址有误");
    }
}
