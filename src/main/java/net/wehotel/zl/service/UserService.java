package net.wehotel.zl.service;

import net.wehotel.zl.api.domain.UserDomain;
import net.wehotel.zl.api.response.Result;
import net.wehotel.zl.db.entity.UserInfo;
import net.wehotel.zl.db.dal.UserDAL;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAL userdbService;

    /**
     * 用户注册
     * 
     * @param rq
     * @return
     */
    public Result registerUser(UserDomain rq) {
        Result rs = new Result();

        // 校验username唯一性
        UserInfo userinfo = userdbService.findByUsername(rq.getUsername());
        if (userinfo != null) {
            rs.setValue("-1", "该账户已存在");
            return rs;
        }

        UserInfo registerUser = copyUserInfo(rq);
        try {
            // 注册用户数据
            boolean success = userdbService.insertRecord(registerUser);
            if (success) {
                // 返回用户id
                userinfo = userdbService.findByUsername(rq.getUsername());
                rs.setValue("0", userinfo.getId() + "");
                return rs;
            }
            rs.setValue("-1", "该账户已存在");
        } catch (Exception e) {
            String errMsg = String.format("插入用户数据异常,userinfo:%s", registerUser);
            logger.error(errMsg, e);
            rs.setValue("-1", "未知异常");
        }
        return rs;
    }

    /**
     * 用户登录
     * 
     * @param rq
     * @return
     */
    public Result login(UserDomain rq) {
        Result rs = new Result();
        if (!loginParmCheck(rq)) {
            rs.setValue("-1", "用户名密码不能为空");
            return rs;
        }
        UserInfo userinfo = userdbService.findByUsername(rq.getUsername());
        if (userinfo == null || !rq.getPassword().equals(userinfo.getPassword())) {
            rs.setValue("-1", "用户名/密码不正确");
            return rs;
        }
        rs.setValue("0", userinfo.getId() + "");
        return rs;
    }

    private UserInfo copyUserInfo(UserDomain domain) {
        UserInfo info = new UserInfo();
        info.setUsername(domain.getUsername());
        info.setPassword(domain.getPassword());
        info.setNickname(domain.getNickname());
        info.setEmail(domain.getEmail());
        return info;
    }

    private boolean loginParmCheck(UserDomain rq) {
        if (rq == null || StringUtils.isBlank(rq.getUsername()) || StringUtils.isBlank(rq.getPassword())) {
            return false;
        }
        return true;
    }
}
