package com.xulong.amazingsite.service.impl;

import com.xulong.amazingsite.common.BizException;
import com.xulong.amazingsite.dto.UserDto;
import com.xulong.amazingsite.mapper.UserRepository;
import com.xulong.amazingsite.model.User;
import com.xulong.amazingsite.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

/**
 * UserServiceImpl
 *
 * @author xulong
 * @date 2018/7/10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findById(Long id) {

        UserDto userDto = new UserDto();
        User user = userRepository.findById(id);

        Assert.notNull(user, "用户不存在");

        BeanUtils.copyProperties(user,userDto);
        return userDto;

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void resetPassword(Long id, String oldPassword, String newPassword) throws BizException {

        User user = userRepository.findById(id);

        Assert.notNull(user, "用户不存在");

        String md5OldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        if (!md5OldPassword.equals(user.getPassword())) {
            throw new BizException("原密码输入不正确");
        }

        user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
        userRepository.save(user);

    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//
//        User user = userRepository.findByUsername(s);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名：" + s + "不存在");
//        }
//        else {
//            return UserDetailConverter.convert(user);
//        }
//
//    }
//
//    private static class UserDetailConverter {
//        static UserDetails convert(User user) {
//            Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
//            Iterator<Role> iterator = user.getRoleList().iterator();
//            while (iterator.hasNext()) {
//                collection.add(new SimpleGrantedAuthority(iterator.next().getRoleName()));
//            }
//            return new MyUserDetails(user,collection);
//        }
//    }
}
