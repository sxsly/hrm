package sxs.core.controller.hrm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sxs.core.service.hrm.*;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.util.hrm.ReflectUtil;
import sxs.core.vo.hrm.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: shang
 * Create Data: 2020/2/20/020
 */
@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/page/{namespace}/{pageName}/{style}")
    public String parseThree(@PathVariable String namespace,@PathVariable String pageName,@PathVariable String style){

        if (StringUtils.isNotBlank(namespace) && StringUtils.isNotBlank(pageName) && StringUtils.isNotBlank(style)){
            return namespace + "/" + pageName + "/" + style;
        }

        return "error";
    }

    @RequestMapping("/page/{namespace}/{pageName}")
    public String parseTwo(@PathVariable String namespace, @PathVariable String pageName, HttpServletRequest request){

        String id = request.getParameter("id");
        if (StringUtils.isNotBlank(id)){
            String voName = namespace.substring(0,1).toUpperCase()+namespace.substring(1)+"Vo";
            Map<String,Object> map = new HashMap();
            map.put("id",id);
            Object voObject = ReflectUtil.getVoObject(voName,map);
            List result = null;
            switch (namespace){
                case "user":
                    result = userService.getUserInfo((UserVo) voObject);
                    break;
                case "dept":
                    result = deptService.getDeptInfo((DeptVo) voObject);
                    break;
                case "position":
                    result = positionService.getPositionInfo((PositionVo) voObject);
                    break;
                case "employee":
                    result = employeeService.getEmployeeInfo((EmployeeVo) voObject);
                    break;
                case "notice":
                    result = noticeService.getNoticeInfo((NoticeVo) voObject);
                    break;
                case "document":
                    result = documentService.getDocumentInfo((DocumentVo) voObject);
                    break;
            }
            if (result != null && !result.isEmpty()){
                request.setAttribute("voInfo",result.get(0));
            }
        }

        if (StringUtils.isNotBlank(namespace) && StringUtils.isNotBlank(pageName)){
             return namespace + "/" + pageName;
        }

        return "error";
    }

    @RequestMapping("/page/{pageName}")
    public String parse(@PathVariable String pageName){

        if (StringUtils.isNotBlank(pageName)){
            return pageName;
        }

        return "error";
    }
}
