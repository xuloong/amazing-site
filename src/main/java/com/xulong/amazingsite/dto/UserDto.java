package com.xulong.amazingsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UserDto
 *
 * @author xulong
 * @date 2018/7/11
 */
@Data
public class UserDto {

    @ApiModelProperty(value = "ID", dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "姓名", dataType = "String")
    private String name;

    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;

}
