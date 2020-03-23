package sxs.core.dao.hrm;

import org.apache.ibatis.annotations.Mapper;
import sxs.core.vo.hrm.PositionVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/14/014
 */
@Mapper
public interface PositionDao {
    // 查询职位信息
    public List<PositionVo> getPositionInfo(PositionVo positionVo);

    // 查询部门总数
    public Integer getPositionCount(PositionVo positionVo);

    // 修改职位信息
    public Integer updatePositionInfo(PositionVo positionVo);

    // 删除职位信息
    public Integer deletePositionInfo(PositionVo positionVo);

    // 添加职位信息
    public Integer addPositionInfo(PositionVo positionVo);

    // 查询所有的职位
    public List<PositionVo> getAllPosition(PositionVo positionVo);
}
