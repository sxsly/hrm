package sxs.core.dao.hrm;

import org.apache.ibatis.annotations.Mapper;
import sxs.core.vo.hrm.DeptVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/12/012
 */
@Mapper
public interface DeptDao {
    // 查询部门信息
    public List<DeptVo> getDeptInfo(DeptVo deptVo);

    // 删除部门信息
    public Integer deleteDeptInfo(DeptVo deptVo);

    // 修改部门信息
    public Integer updateDeptInfo(DeptVo deptVo);

    // 添加部门信息
    public Integer addDeptInfo(DeptVo vo);

    // 查询部门总数
    public Integer deptCount(DeptVo vo);

    // 查询所有部门
    public List<DeptVo> getAllDept(DeptVo deptVo);
}
