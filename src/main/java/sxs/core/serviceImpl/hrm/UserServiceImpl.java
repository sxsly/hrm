package sxs.core.serviceImpl.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxs.core.dao.hrm.UserDao;
import sxs.core.service.hrm.UserService;
import sxs.core.vo.hrm.UserVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/2/28/028
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserVo> getUserInfo(UserVo userVo){
        return userDao.getUserInfo(userVo);
    }

    @Override
    public Integer deleteUserInfo(UserVo userVo) {
        return userDao.deleteUserInfo(userVo);
    }

    @Override
    public Integer updateUserInfo(UserVo userVo) {
        return userDao.updateUserInfo(userVo);
    }

    @Override
    public Integer addUserInfo(UserVo userVo) {
        return userDao.addUserInfo(userVo);
    }

    @Override
    public Integer getUserCount(UserVo userVo) {
        return userDao.getUserCount(userVo);
    }
}
