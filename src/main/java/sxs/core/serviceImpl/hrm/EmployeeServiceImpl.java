package sxs.core.serviceImpl.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxs.core.dao.hrm.EmployeeDao;
import sxs.core.service.hrm.EmployeeService;
import sxs.core.vo.hrm.EmployeeVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/15/015
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeVo> getEmployeeInfo(EmployeeVo employeeVo) {
        return employeeDao.getEmployeeInfo(employeeVo);
    }

    @Override
    public Integer getEmployeeCount(EmployeeVo employeeVo) {
        return employeeDao.getEmployeeCount(employeeVo);
    }

    @Override
    public Integer updateEmployeeInfo(EmployeeVo employeeVo) {
        return employeeDao.updateEmployeeInfo(employeeVo);
    }

    @Override
    public Integer deleteEmployeeInfo(EmployeeVo employeeVo) {
        return employeeDao.deleteEmployeeInfo(employeeVo);
    }

    @Override
    public Integer addEmployeeInfo(EmployeeVo employeeVo) {
        return employeeDao.addEmployeeInfo(employeeVo);
    }

}
