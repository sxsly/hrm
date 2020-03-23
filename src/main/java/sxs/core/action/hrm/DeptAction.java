package sxs.core.action.hrm;

import org.springframework.context.ApplicationContext;
import sxs.core.service.hrm.DeptService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.vo.hrm.DeptVo;
import sxs.core.vo.hrm.ResultInfoVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/12/012
 */
public class DeptAction {
    private ApplicationContext context = ApplicationUtil.getApplicationContext();

    /**
     * 查询部门信息
     * @param deptVo
     * @return
     */
    public ResultInfoVo getDeptInfo(DeptVo deptVo){
        ResultInfoVo resultInfo = new ResultInfoVo();
        DeptService deptService = context.getBean(DeptService.class);
        resultInfo.setPageIndex(deptVo.getPageIndex());
        resultInfo.setPageSize(4);

        deptVo.setPageColumn(resultInfo.getPageColumn());
        deptVo.setPageSize(resultInfo.getPageSize());

        try {
            Integer totalRecords = deptService.deptCount(deptVo);
            resultInfo.setTotalRecords(totalRecords);
            List<DeptVo> deptVoList = deptService.getDeptInfo(deptVo);
            resultInfo.setFlag(true);
            resultInfo.setData(deptVoList);
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 删除部门信息
     * @param deptVo
     * @return
     */
    public ResultInfoVo deleteDeptInfo(DeptVo deptVo){
        ResultInfoVo resultInfo = null;
        DeptService deptService = context.getBean(DeptService.class);
        try {
            Integer row = deptService.deleteDeptInfo(deptVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
              resultInfo = new ResultInfoVo(false,null,"该记录不存在或已被删除");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 修改部门信息
     * @param deptVo
     * @return
     */
    public ResultInfoVo updateDeptInfo(DeptVo deptVo){
        ResultInfoVo resultInfo = null;
        DeptService deptService = context.getBean(DeptService.class);
        try {
            Integer row = deptService.updateDeptInfo(deptVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"修改失败，记录不存在或已删除！");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 添加部门信息
     * @param deptVo
     * @return
     */
    public ResultInfoVo addDeptInfo(DeptVo deptVo){
        ResultInfoVo resultInfo = null;
        DeptService deptService = context.getBean(DeptService.class);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        deptVo.setCreateTime(sm.format(new Date()));
        try {
            Integer row = deptService.addDeptInfo(deptVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"添加失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 查询所有部门
     * @param deptVo
     * @return
     */
    public ResultInfoVo getAllDept(DeptVo deptVo){
        ResultInfoVo resultInfo = null;
        DeptService deptService = context.getBean(DeptService.class);

        try {
            List<DeptVo> deptVoList = deptService.getAllDept(deptVo);
            resultInfo = new ResultInfoVo(true,deptVoList,null);
        } catch (Exception e){
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }
}
