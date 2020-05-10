package sxs.core.vo.hrm;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Author: shang
 * Create Data: 2020/3/15/015
 */
public class EmployeeVo {
    private Integer id;
    private String employeeName;
    private Integer sex;
    private String phone;
    private String email;
    private String positionName;
    private String record;
    private String cardId;
    private String deptName;
    private String address;
    private String createTime;
    private String sexStr;
    private Integer positionId;
    private Integer deptId;

    public String getSexStr() {
        if (this.sex == 1){
            sexStr = "男";
        } else {
          sexStr = "女";
        }
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
