package com.xulong.amazingsite.service;

import com.xulong.amazingsite.common.BizException;
import com.xulong.amazingsite.dto.UserDto;
import com.xulong.amazingsite.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * UserService
 *
 * @author xulong
 * @date 2018/7/10
 */
public interface UserService {

    UserDto findById(Long id);

    User findByUsername(String username);

    void resetPassword(Long id, String oldPassword, String newPassword) throws BizException;

}
