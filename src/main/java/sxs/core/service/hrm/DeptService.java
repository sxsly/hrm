package sxs.core.service.hrm;

import sxs.core.vo.hrm.DeptVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/12/012
 */
public interface DeptService {

    /**
     * 查询部门信息
     * @param deptVo
     * @return
     */
    public List<DeptVo> getDeptInfo(DeptVo deptVo);

    /**
     * 删除部门信息
     * @param deptVo
     * @return
     */
    public Integer deleteDeptInfo(DeptVo deptVo);

    /**
     * 修改部门信息
     * @param deptVo
     * @return
     */
    public Integer updateDeptInfo(DeptVo deptVo);

    /**
     * 添加部门信息
     * @param deptVo
     * @return
     */
    public Integer addDeptInfo(DeptVo deptVo);

    /**
     * 查询部门总数
     * @param deptVo
     * @return
     */
    public Integer deptCount(DeptVo deptVo);

    /**
     * 查询所有部门
     * @param deptVo
     * @return
     */
    public List<DeptVo> getAllDept(DeptVo deptVo);
}
