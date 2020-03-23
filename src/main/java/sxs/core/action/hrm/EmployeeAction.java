package sxs.core.action.hrm;

import org.springframework.context.ApplicationContext;
import sxs.core.service.hrm.EmployeeService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.vo.hrm.EmployeeVo;
import sxs.core.vo.hrm.ResultInfoVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/15/015
 */
public class EmployeeAction {
    private ApplicationContext context = ApplicationUtil.getApplicationContext();

    /**
     * 查询员工信息
     * @param employeeVo
     * @return
     */
    public ResultInfoVo getEmployeeInfo(EmployeeVo employeeVo){
        ResultInfoVo resultInfo = new ResultInfoVo();
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        resultInfo.setPageIndex(employeeVo.getPageIndex());
        resultInfo.setPageSize(4);

        employeeVo.setPageColumn(resultInfo.getPageColumn());
        employeeVo.setPageSize(resultInfo.getPageSize());

        try {
            Integer totalRecords = employeeService.getEmployeeCount(employeeVo);
            resultInfo.setTotalRecords(totalRecords);
            List<EmployeeVo> employeeVoList = employeeService.getEmployeeInfo(employeeVo);
            resultInfo.setFlag(true);
            resultInfo.setData(employeeVoList);
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 修改员工信息
     * @param employeeVo
     * @return
     */
    public ResultInfoVo updateEmployeeInfo(EmployeeVo employeeVo){
        ResultInfoVo resultInfo = null;
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        try {
            Integer row = employeeService.updateEmployeeInfo(employeeVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"修改失败，该记录不存在或已被删除");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 删除员工信息
     * @param employeeVo
     * @return
     */
    public ResultInfoVo deleteEmployeeInfo(EmployeeVo employeeVo){
        ResultInfoVo resultInfo = null;
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        try {
            Integer row = employeeService.deleteEmployeeInfo(employeeVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"删除失败，该记录不存在或已被删除");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 添加员工信息
     * @param employeeVo
     * @return
     */
    public ResultInfoVo addEmployeeInfo(EmployeeVo employeeVo){
        ResultInfoVo resultInfo = null;
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        employeeVo.setCreateTime(sm.format(new Date()));
        try {
            Integer row = employeeService.addEmployeeInfo(employeeVo);
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
