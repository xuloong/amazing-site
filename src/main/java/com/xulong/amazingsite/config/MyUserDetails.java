package com.xulong.amazingsite.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * MyUserDetails
 *
 * @author xulong
 * @date 2018/7/14
 */
public class MyUserDetails extends User {

    private com.xulong.amazingsite.model.User user;

    public MyUserDetails(com.xulong.amazingsite.model.User user, Collection<SimpleGrantedAuthority> collection) {

        super(user.getUsername(), user.getPassword(), true, true, true, true, collection);
        this.user = user;
    }

    public com.xulong.amazingsite.model.User getUser() {
        return user;
    }

    public void setUser(com.xulong.amazingsite.model.User user) {
        this.user = user;
    }
}
