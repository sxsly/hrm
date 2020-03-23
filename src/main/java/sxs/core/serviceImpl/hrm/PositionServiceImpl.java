package sxs.core.serviceImpl.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxs.core.dao.hrm.PositionDao;
import sxs.core.service.hrm.PositionService;
import sxs.core.vo.hrm.PositionVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/14/014
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    public List<PositionVo> getPositionInfo(PositionVo positionVo) {
        return positionDao.getPositionInfo(positionVo);
    }

    @Override
    public Integer getPositionCount(PositionVo positionVo) {
        return positionDao.getPositionCount(positionVo);
    }

    @Override
    public Integer updatePositionInfo(PositionVo positionVo) {
        return positionDao.updatePositionInfo(positionVo);
    }

    @Override
    public Integer deletePositionInfo(PositionVo positionVo) {
        return positionDao.deletePositionInfo(positionVo);
    }

    @Override
    public Integer addPositionInfo(PositionVo positionVo) {
        return positionDao.addPositionInfo(positionVo);
    }

    @Override
    public List<PositionVo> getAllPosition(PositionVo positionVo) {
        return positionDao.getAllPosition(positionVo);
    }
}
