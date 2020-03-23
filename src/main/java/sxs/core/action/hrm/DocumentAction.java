package sxs.core.action.hrm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sxs.core.service.hrm.DocumentService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.vo.hrm.DocumentVo;
import sxs.core.vo.hrm.ResultInfoVo;
import sxs.core.vo.hrm.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/19/019
 */
public class DocumentAction {
    private ApplicationContext context = ApplicationUtil.getApplicationContext();

    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes())
            .getRequest();

    /**
     * 上传文档
     */
    public ResultInfoVo addDocumentInfo(DocumentVo documentVo){
        ResultInfoVo resultInfo = null;
        DocumentService documentService = context.getBean(DocumentService.class);
        if (StringUtils.isNotBlank(documentVo.getFilePath())){
            String fileName = documentVo.getFilePath().substring(10);
            documentVo.setFileName(fileName);
        }
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        documentVo.setCreateTime(sm.format(new Date()));
        UserVo login_user = (UserVo) request.getSession().getAttribute("login_user");
        documentVo.setCreator(login_user.getRealName());

        try {
            Integer row = documentService.addDocumentInfo(documentVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"添加失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 查询文档信息
     */
    public ResultInfoVo getDocumentInfo(DocumentVo documentVo){
        ResultInfoVo resultInfo = new ResultInfoVo();
        DocumentService documentService = context.getBean(DocumentService.class);
        resultInfo.setPageIndex(documentVo.getPageIndex());
        resultInfo.setPageSize(4);

        documentVo.setPageColumn(resultInfo.getPageColumn());
        documentVo.setPageSize(resultInfo.getPageSize());

        try {
            Integer totalRecords = documentService.getDocumentCount(documentVo);
            resultInfo.setTotalRecords(totalRecords);
            List<DocumentVo> voList = documentService.getDocumentInfo(documentVo);
            resultInfo.setFlag(true);
            resultInfo.setData(voList);
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 修改文档信息
     */
    public ResultInfoVo updateDocumentInfo(DocumentVo documentVo){
        ResultInfoVo resultInfo = null;
        DocumentService documentService = context.getBean(DocumentService.class);

        try {
            Integer row = documentService.updateDocumentInfo(documentVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"修改失败，该记录不存在或已被删除！");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }
}
