package sxs.core.action.hrm;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sxs.core.service.hrm.UserService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.util.hrm.MD5Util;
import sxs.core.vo.hrm.ResultInfoVo;
import sxs.core.vo.hrm.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/2/22/022
 */
public class UserAction {

    private ApplicationContext context = ApplicationUtil.getApplicationContext();

    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes())
            .getRequest();

    /**
     * 用户登录
     * @param vo
     * @return
     * @throws Exception
     */
    public ResultInfoVo login(UserVo vo) throws Exception {

        ResultInfoVo resultInfo = null;

        UserService userService = context.getBean(UserService.class);
        vo.setPassword(MD5Util.encode(vo.getPassword()));
        try {
            List<UserVo> userVoList = userService.getUserInfo(vo);
            if (!userVoList.isEmpty()){
                resultInfo = new ResultInfoVo(true,userVoList,null);
                request.getSession().setAttribute("login_user",userVoList.get(0));
            }else {
                resultInfo = new ResultInfoVo(false,null,"用户名或密码不正确");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 查询用户信息
     * @param vo
     * @return
     */
    public ResultInfoVo getUserInfo(UserVo vo){
        ResultInfoVo resultInfo = new ResultInfoVo();
        UserService userService = context.getBean(UserService.class);
        resultInfo.setPageIndex(vo.getPageIndex());
        resultInfo.setPageSize(4);

        vo.setPageColumn(resultInfo.getPageColumn());
        vo.setPageSize(resultInfo.getPageSize());

        try {
            Integer totalRecords = userService.getUserCount(vo);
            resultInfo.setTotalRecords(totalRecords);
            List<UserVo> userVoList = userService.getUserInfo(vo);
            resultInfo.setFlag(true);
            resultInfo.setData(userVoList);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 删除用户信息
     * @param vo
     * @return
     */
    public ResultInfoVo deleteUserInfo(UserVo vo){
        ResultInfoVo resultInfo = null;
        UserService userService = context.getBean(UserService.class);
        try {
            Integer row = userService.deleteUserInfo(vo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            }else {
                resultInfo = new ResultInfoVo(false,null,"删除失败,没有相应记录");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 修改用户信息
     * @param vo
     * @return
     */
    public ResultInfoVo updateUserInfo(UserVo vo){
        ResultInfoVo resultInfo = null;
        UserService userService = context.getBean(UserService.class);
        vo.setPassword(MD5Util.encode(vo.getPassword()));
        try {
            Integer row = userService.updateUserInfo(vo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            }else {
                resultInfo = new ResultInfoVo(false,row,"修改失败，该记录不存在或已被删除");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 增加用户
     * @param vo
     * @return
     */
    public ResultInfoVo addUserInfo(UserVo vo){
        ResultInfoVo resultInfo = null;
        UserService userService = context.getBean(UserService.class);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setCreateTime(sm.format(new Date()));
        vo.setPassword(MD5Util.encode(vo.getPassword()));
        try {
            Integer row = userService.addUserInfo(vo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            }else {
                resultInfo = new ResultInfoVo(false,null,"添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 用户退出
     * @param vo
     * @return
     */
    public ResultInfoVo logout(UserVo vo){
        HttpSession session = request.getSession();
        session.removeAttribute("login_user");
        ResultInfoVo resultInfo = new ResultInfoVo();
        resultInfo.setFlag(true);
        return resultInfo;
    }
}
