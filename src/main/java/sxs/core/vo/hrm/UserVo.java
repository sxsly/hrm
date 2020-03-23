package sxs.core.vo.hrm;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Author: shang
 * Create Data: 2020/2/21/021
 */
public class UserVo implements Serializable {
    private Integer id;
    private String realName;
    private String validateCode;
    private String userName;
    private String password;
    private Integer roleId;
    private Integer state;
    private String createTime;
    private String roleStr;
    private String stateStr;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", roleId=" + roleId +
                ", state=" + state +
                ", createTime='" + createTime + '\'' +
                ", stateStr='" + stateStr + '\'' +
                '}';
    }

    /**
     * 用来接收分页查询的索引
     */
    @JsonIgnore
    private Integer pageIndex;

    @JsonIgnore
    private Integer pageColumn;

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

    @JsonIgnore
    private Integer pageSize;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRoleStr() {
        if (1 == roleId){
            roleStr = "管理员";
        }else {
            roleStr = "普通用户";
        }
        return roleStr;
    }

    public String getStateStr() {
        if (1 == state){
            stateStr = "已审核";
        }else {
            stateStr = "未审核";
        }
        return stateStr;
    }
}
