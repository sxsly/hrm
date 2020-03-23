package sxs.core.dao.hrm;

import org.apache.ibatis.annotations.Mapper;
import sxs.core.vo.hrm.NoticeVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/17/017
 */
@Mapper
public interface NoticeDao {
    // 查询公告信息
    public List<NoticeVo> getNoticeInfo(NoticeVo noticeVo);

    // 查询记录总数
    public Integer getNoticeCount(NoticeVo noticeVo);

    // 修改公告信息
    public Integer updateNoticeInfo(NoticeVo noticeVo);

    // 删除公告信息
    public Integer deleteNoticeInfo(NoticeVo noticeVo);

    // 添加公告信息
    public Integer addNoticeInfo(NoticeVo noticeVo);
}
