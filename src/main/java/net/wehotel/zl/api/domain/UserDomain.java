package net.wehotel.zl.api.domain;

import java.io.Serializable;
import java.util.Date;

public class UserDomain implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;// 流水号，主键
    private String username;// 帐号 唯一
    private String password;// 密码
    private String nickname;// 昵称
    private String email;// 邮箱
    private Date createtime;// 帐号创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "{ \"" + (id != null ? "id\" : \"" + id + "\", \"" : "") + (username != null ? "username\" : \"" + username + "\", \"" : "")
                + (password != null ? "password\" : \"" + password + "\", \"" : "")
                + (nickname != null ? "nickname\" : \"" + nickname + "\", \"" : "") + (email != null ? "email\" : \"" + email + "\", \"" : "")
                + (createtime != null ? "createtime\" : \"" + createtime : "") + "\"}";
    }
}
