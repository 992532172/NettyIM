package net.wehotel.zl.web.controller;

import net.wehotel.zl.api.domain.UserDomain;
import net.wehotel.zl.api.response.Result;
import net.wehotel.zl.db.entity.UserInfo;
import net.wehotel.zl.service.UserService;
import net.wehotel.zl.service.dbservice.UserDBService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserDBService userdbService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String loginpage(ModelMap model, @RequestParam(value = "id", required = false) int id) {
        if (id > 0) {
            UserInfo userinfo = userdbService.findById(id);
            model.addAttribute("userid", userinfo.getUserid());
        }
        return "user/login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerpage() {
        return "user/register";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap model, @RequestParam int id) {
        if (id > 0) {
            UserInfo userinfo = userdbService.findById(id);
            model.addAttribute("userid", userinfo.getUserid());
            model.addAttribute("nickname", userinfo.getNickname() + "");
        }
        return "user/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody UserDomain rq) {
        Result rs = new Result();
        if (!checkLoginParms(rq)) {
            rs.setValue("-1", "帐号密码不能为空");
            return rs;
        }
        UserInfo userinfo = userdbService.findByUsername(rq.getUserid());
        if (userinfo == null) {
            rs.setValue("-1", "账户不存在");
            return rs;
        }
        if (rq.getPassword().equals(userinfo.getPassword())) {
            rs.setValue("0", userinfo.getId() + "");
            return rs;
        } else {
            rs.setValue("-1", "密码错误");
            return rs;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(ModelMap model, @RequestBody UserDomain rq) {
        Result rs = new Result();
        if (!checkRegisterParms(rq)) {
            rs.setValue("-1", "参数校验失败");
            return rs;
        }
        fillModelmap(model, rq);
        rs = userService.registerUser(rq);
        return rs;
    }

    // ----------------------------------private mothed------------------------------------
    private void fillModelmap(ModelMap model, UserDomain user) {
        model.addAttribute("userid", user.getUserid());
        // model.addAttribute("password", user.getPassword());
        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("email", user.getEmail());
    }

    private boolean checkLoginParms(UserDomain rq) {
        if (rq == null) return false;
        if (StringUtils.isBlank(rq.getUserid())) return false;
        if (StringUtils.isBlank(rq.getPassword())) return false;
        return true;
    }

    private boolean checkRegisterParms(UserDomain rq) {
        if (rq == null) return false;
        if (StringUtils.isBlank(rq.getUserid())) return false;
        if (StringUtils.isBlank(rq.getPassword())) return false;
        if (StringUtils.isBlank(rq.getEmail())) return false;
        return true;
    }
}
