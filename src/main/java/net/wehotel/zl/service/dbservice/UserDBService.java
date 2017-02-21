package net.wehotel.zl.service.dbservice;

import java.util.Date;
import java.util.List;

import net.wehotel.zl.db.dao.UserInfoMapper;
import net.wehotel.zl.db.entity.UserInfo;
import net.wehotel.zl.db.entity.UserInfoExample;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userdbService")
public class UserDBService {
    private Logger logger = LoggerFactory.getLogger(UserDBService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo findById(int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户名查询用户信息
     * 
     * @param username
     * @return
     */
    public UserInfo findByUsername(String username) {
        try {
            UserInfoExample example = new UserInfoExample();
            example.createCriteria().andUsernameEqualTo(username);
            List<UserInfo> userinfo = userInfoMapper.selectByExample(example);
            if (CollectionUtils.isNotEmpty(userinfo)) {
                return userinfo.get(0);
            }
        } catch (Exception e) {
            logger.error("查询用户数据异常,username:" + username, e);
        }
        return null;
    }

    /**
     * 插入用户数据
     * 
     * @param userinfo
     * @return
     */
    public boolean insertRecord(UserInfo userinfo) throws Exception {
            userinfo.setCreatetime(new Date());
            int i = userInfoMapper.insertSelective(userinfo);
            if (i == 1) {
                return true;
            }
//            String errMsg = String.format("插入用户数据异常,userinfo:%s", userinfo);
//            logger.error(errMsg, e);
        return false;
    }

}
