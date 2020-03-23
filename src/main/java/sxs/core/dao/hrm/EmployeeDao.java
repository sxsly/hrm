package sxs.core.dao.hrm;

import org.apache.ibatis.annotations.Mapper;
import sxs.core.vo.hrm.EmployeeVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/15/015
 */
@Mapper
public interface EmployeeDao {
    // 查询员工信息
    public List<EmployeeVo> getEmployeeInfo(EmployeeVo employeeVo);

    // 查询员工总数
    public Integer getEmployeeCount(EmployeeVo employeeVo);

    // 修改员工信息
    public Integer updateEmployeeInfo(EmployeeVo employeeVo);

    // 删除员工信息
    public Integer deleteEmployeeInfo(EmployeeVo employeeVo);

    // 添加员工信息
    public Integer addEmployeeInfo(EmployeeVo employeeVo);
}
