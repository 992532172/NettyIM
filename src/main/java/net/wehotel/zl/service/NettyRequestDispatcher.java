package net.wehotel.zl.service;

import net.wehotel.zl.api.domain.UserDomain;
import net.wehotel.zl.api.request.BaseNettyRequest;
import net.wehotel.zl.api.response.Result;
import net.wehotel.zl.commen.RequestTypeEnmu;
import net.wehotel.zl.util.GsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NettyRequestDispatcher {
    @Autowired
    private UserService userService;

    public String dispatch(String requestData) {
        BaseNettyRequest request = GsonUtil.json2Obj(requestData, BaseNettyRequest.class);
        if (RequestTypeEnmu.LOGIN.equals(request.getRqType())) {
            String loginRequest = request.getMsgContent();
            UserDomain domain = GsonUtil.json2Obj(loginRequest, UserDomain.class);
            Result rs = userService.login(domain);
            return GsonUtil.toJsonStr(rs);
        }
        
        return null;
    }
}
