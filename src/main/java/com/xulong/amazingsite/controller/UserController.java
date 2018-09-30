package com.xulong.amazingsite.controller;

import com.xulong.amazingsite.common.BizException;
import com.xulong.amazingsite.common.SysContext;
import com.xulong.amazingsite.dto.PasswordDto;
import com.xulong.amazingsite.dto.UserDto;
import com.xulong.amazingsite.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author xulong
 * @date 2018-07-10
 */
@RestController
@RequestMapping(value = "/users")
@Api(tags = "User APIs", description = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询当前用户详情API", httpMethod = "GET", notes = "查询当前用户详情", response = UserDto.class)
    @ResponseBody
    @GetMapping(value = "/my/info")
    //@PreAuthorize("#oauth2.hasScope('write') and hasRole('ROLE_USER')")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<UserDto> getCurrentUser() {

        UserDto userDto = userService.getById(SysContext.getCurrentUser().getId());
        return ResponseEntity.status(HttpStatus.OK).body(userDto);

    }

    public UserController() {
    }

    @ApiOperation(value = "修改密码API", httpMethod = "PATCH", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "passwordDto", value = "密码Dto", required = true, paramType = "body", dataType = "PasswordDto")

    })
    @PatchMapping(value = "/my/password")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void resetPassword(@RequestBody PasswordDto passwordDto) throws BizException {

        userService.resetPassword(SysContext.getCurrentUser().getId(), passwordDto.getOldPassword(), passwordDto.getNewPassword());

    }

}
