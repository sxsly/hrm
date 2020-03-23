package sxs.core.vo.hrm;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Author: shang
 * Create Data: 2020/3/12/012
 */
public class DeptVo {
    private Integer id;
    private String deptName;
    private String remark;
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

    public Integer getPageIndex() {
        if (this.pageIndex == null){
            this.pageIndex = 1;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
