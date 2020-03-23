package sxs.core.service.hrm;

import sxs.core.vo.hrm.EmployeeVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/15/015
 */
public interface EmployeeService {
    /**
     * 查询员工信息
     * @param employeeVo
     * @return
     */
    public List<EmployeeVo> getEmployeeInfo(EmployeeVo employeeVo);

    /**
     * 查询员工数量
     * @param employeeVo
     * @return
     */
    public Integer getEmployeeCount(EmployeeVo employeeVo);

    /**
     * 修改员工信息
     * @param employeeVo
     * @return
     */
    public Integer updateEmployeeInfo(EmployeeVo employeeVo);

    /**
     * 删除员工信息
     * @param employeeVo
     * @return
     */
    public Integer deleteEmployeeInfo(EmployeeVo employeeVo);

    /**
     * 添加员工信息
     * @param employeeVo
     * @return
     */
    public Integer addEmployeeInfo(EmployeeVo employeeVo);
}
