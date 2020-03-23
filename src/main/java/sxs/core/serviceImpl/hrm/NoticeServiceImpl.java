package sxs.core.serviceImpl.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxs.core.dao.hrm.NoticeDao;
import sxs.core.service.hrm.NoticeService;
import sxs.core.vo.hrm.NoticeVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/17/017
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<NoticeVo> getNoticeInfo(NoticeVo noticeVo) {
        return noticeDao.getNoticeInfo(noticeVo);
    }

    @Override
    public Integer getNoticeCount(NoticeVo noticeVo) {
        return noticeDao.getNoticeCount(noticeVo);
    }

    @Override
    public Integer updateNoticeInfo(NoticeVo noticeVo) {
        return noticeDao.updateNoticeInfo(noticeVo);
    }

    @Override
    public Integer deleteNoticeInfo(NoticeVo noticeVo) {
        return noticeDao.deleteNoticeInfo(noticeVo);
    }

    @Override
    public Integer addNoticeInfo(NoticeVo noticeVo) {
        return noticeDao.addNoticeInfo(noticeVo);
    }
}
