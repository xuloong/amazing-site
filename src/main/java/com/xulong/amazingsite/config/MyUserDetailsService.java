package com.xulong.amazingsite.config;

import com.xulong.amazingsite.model.Role;
import com.xulong.amazingsite.model.User;
import com.xulong.amazingsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * MyUserDetailsService
 *
 * @author xulong
 * @date 2018/8/4
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("用户名：" + s + "不存在");
        }
        else {
            return MyUserDetailsService.UserDetailConverter.convert(user);
        }

    }

    private static class UserDetailConverter {
        static UserDetails convert(User user) {
            Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
            Iterator<Role> iterator = user.getRoleList().iterator();
            while (iterator.hasNext()) {
                collection.add(new SimpleGrantedAuthority(iterator.next().getRoleName()));
            }
            return new MyUserDetails(user,collection);
        }
    }
}
