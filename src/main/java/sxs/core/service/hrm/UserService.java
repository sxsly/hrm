package sxs.core.service.hrm;

import sxs.core.vo.hrm.UserVo;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2020/2/28/028
 */
public interface UserService {

    /**
     * 查询用户信息
     * @param userVo
     * @return
     */
    public List<UserVo> getUserInfo(UserVo userVo);

    /**
     * 删除用户信息
     * @param userVo
     * @return
     */
    public Integer deleteUserInfo(UserVo userVo);

    /**
     * 修改用户信息
     * @param userVo
     * @return
     */
    public Integer updateUserInfo(UserVo userVo);

    /**
     * 增加用户信息
     * @param userVo
     * @return
     */
    public Integer addUserInfo(UserVo userVo);

    /**
     * 获取用户总数
     * @param userVo
     * @return
     */
    public Integer getUserCount(UserVo userVo);
}
