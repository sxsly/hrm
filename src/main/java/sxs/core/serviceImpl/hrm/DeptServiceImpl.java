package sxs.core.serviceImpl.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxs.core.dao.hrm.DeptDao;
import sxs.core.service.hrm.DeptService;
import sxs.core.vo.hrm.DeptVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/12/012
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<DeptVo> getDeptInfo(DeptVo deptVo) {
        return deptDao.getDeptInfo(deptVo);
    }

    @Override
    public Integer deleteDeptInfo(DeptVo deptVo) {
        return deptDao.deleteDeptInfo(deptVo);
    }

    public Integer updateDeptInfo(DeptVo deptVo){
        return deptDao.updateDeptInfo(deptVo);
    }

    @Override
    public Integer addDeptInfo(DeptVo deptVo) {
        return deptDao.addDeptInfo(deptVo);
    }

    @Override
    public Integer deptCount(DeptVo deptVo) {
        return deptDao.deptCount(deptVo);
    }

    @Override
    public List<DeptVo> getAllDept(DeptVo deptVo) {
        return deptDao.getAllDept(deptVo);
    }
}
