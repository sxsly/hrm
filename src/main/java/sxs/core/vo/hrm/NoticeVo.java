package sxs.core.vo.hrm;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Author: shang
 * Create Data: 2020/3/17/017
 */
public class NoticeVo {
    private Integer id;
    private String noticeName;
    private String noticeContent;
    private String noticeCreator;
    private String createTime;

    /**
     * 用来接收分页查询的索引
     */
    @JsonIgnore
    private Integer pageIndex;

    @JsonIgnore
    private Integer pageColumn;

    @JsonIgnore
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeCreator() {
        return noticeCreator;
    }

    public void setNoticeCreator(String noticeCreator) {
        this.noticeCreator = noticeCreator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getPageIndex() {
        if (this.pageIndex == null){
            this.pageIndex = 1;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageColumn() {
        return pageColumn;
    }

    public void setPageColumn(Integer pageColumn) {
        this.pageColumn = pageColumn;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
