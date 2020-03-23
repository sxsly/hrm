package sxs.core.dao.hrm;

import org.apache.ibatis.annotations.Mapper;
import sxs.core.vo.hrm.UserVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/1/001
 */
@Mapper
public interface UserDao {
    // 查询用户信息
    List<UserVo> getUserInfo(UserVo userVo);

    // 删除用户信息
    Integer deleteUserInfo(UserVo userVo);

    // 修改用户信息
    Integer updateUserInfo(UserVo userVo);

    // 增加用户信息
    Integer addUserInfo(UserVo userVo);

    // 获取用户总数
    Integer getUserCount(UserVo userVo);
}
