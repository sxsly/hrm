package sxs.core.service.hrm;

import sxs.core.vo.hrm.NoticeVo;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2020/3/17/017
 */
public interface NoticeService {
    /**
     * 查询公告信息
     * @param noticeVo
     * @return
     */
    public List<NoticeVo> getNoticeInfo(NoticeVo noticeVo);

    /**
     * 查询记录总数
     * @param noticeVo
     * @return
     */
    public Integer getNoticeCount(NoticeVo noticeVo);

    /**
     * 修改公告信息
     * @param noticeVo
     * @return
     */
    public Integer updateNoticeInfo(NoticeVo noticeVo);

    /**
     * 删除公告信息
     * @param noticeVo
     * @return
     */
    public Integer deleteNoticeInfo(NoticeVo noticeVo);

    /**
     * 添加公告信息
     * @param noticeVo
     * @return
     */
    public Integer addNoticeInfo(NoticeVo noticeVo);
}
