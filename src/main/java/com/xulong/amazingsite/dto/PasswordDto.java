package com.xulong.amazingsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PasswordDto
 *
 * @author xulong
 * @date 2018/7/14
 */
@Data
public class PasswordDto {

    @ApiModelProperty(value = "原密码", dataType = "String", example = "123456")
    private String oldPassword;

    @ApiModelProperty(value = "新密码", dataType = "String", example = "123456")
    private String newPassword;

}
