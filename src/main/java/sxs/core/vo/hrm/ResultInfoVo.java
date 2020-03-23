package sxs.core.vo.hrm;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用于封装后端返回前端数据对象
 */
public class ResultInfoVo {
    private boolean flag;//后端返回结果正常为true，发生异常返回false
    private Object data;//后端返回结果数据对象
    private Integer pageIndex;
    private Integer totalPages;
    private Integer totalRecords;
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private String errorMsg;//发生异常的错误消息

    //无参构造方法
    public ResultInfoVo() {
    }
    public ResultInfoVo(boolean flag) {
        this.flag = flag;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param errorMsg
     */
    public ResultInfoVo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param data
     * @param errorMsg
     */
    public ResultInfoVo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalPages() {
        if (totalRecords != null && pageSize != null){
            totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize:totalRecords / pageSize + 1;
        }
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    @JsonIgnore
    public Integer getPageColumn(){
        return (pageIndex - 1) * pageSize;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
