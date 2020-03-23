package sxs.core.action.hrm;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sxs.core.service.hrm.NoticeService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.vo.hrm.NoticeVo;
import sxs.core.vo.hrm.ResultInfoVo;
import sxs.core.vo.hrm.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/17/017
 */
public class NoticeAction {
    private ApplicationContext context = ApplicationUtil.getApplicationContext();

    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes())
            .getRequest();


    /**
     * 查询公告信息
     * @param noticeVo
     * @return
     */
    public ResultInfoVo getNoticeInfo(NoticeVo noticeVo){
        ResultInfoVo resultInfo = new ResultInfoVo();
        NoticeService noticeService = context.getBean(NoticeService.class);
        resultInfo.setPageIndex(noticeVo.getPageIndex());
        resultInfo.setPageSize(4);

        noticeVo.setPageColumn(resultInfo.getPageColumn());
        noticeVo.setPageSize(resultInfo.getPageSize());

        try {
            Integer totalRecords = noticeService.getNoticeCount(noticeVo);
            resultInfo.setTotalRecords(totalRecords);
            List<NoticeVo> noticeVoList = noticeService.getNoticeInfo(noticeVo);
            resultInfo.setFlag(true);
            resultInfo.setData(noticeVoList);
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 修改公告信息
     * @param noticeVo
     * @return
     */
    public ResultInfoVo updateNoticeInfo(NoticeVo noticeVo){
        ResultInfoVo resultInfo = null;
        NoticeService noticeService = context.getBean(NoticeService.class);

        try {
            Integer row = noticeService.updateNoticeInfo(noticeVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"修改失败，该记录不存在或已删除！");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 删除公告信息
     * @param noticeVo
     * @return
     */
    public ResultInfoVo deleteNoticeInfo(NoticeVo noticeVo){
        ResultInfoVo resultInfo = null;
        NoticeService noticeService = context.getBean(NoticeService.class);

        try {
            Integer row = noticeService.deleteNoticeInfo(noticeVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"删除失败，该记录不存在或已被删除！");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 添加公告信息
     * @param noticeVo
     * @return
     */
    public ResultInfoVo addNoticeInfo(NoticeVo noticeVo){
        ResultInfoVo resultInfo = null;
        NoticeService noticeService = context.getBean(NoticeService.class);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        noticeVo.setCreateTime(sm.format(new Date()));
        UserVo login_user = (UserVo) request.getSession().getAttribute("login_user");
        noticeVo.setNoticeCreator(login_user.getRealName());

        try {
            Integer row = noticeService.addNoticeInfo(noticeVo);
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
}
