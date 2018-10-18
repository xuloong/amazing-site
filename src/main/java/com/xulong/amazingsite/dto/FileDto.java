package com.xulong.amazingsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * FileDto
 *
 * @author xulong
 * @date 2018/9/30
 */
@Data
public class FileDto {

    @ApiModelProperty(value = "文件ID", dataType = "String", example = "123456")
    private String fileId;

    @ApiModelProperty(value = "文件名", dataType = "String", example = "文件")
    private String fileName;

    @ApiModelProperty(value = "后缀名", dataType = "String", example = ".jpg")
    private String suffixName;

    @ApiModelProperty(value = "文件大小", dataType = "long", example = "123456")
    private long fileSize;

    @ApiModelProperty(value = "URL", dataType = "Long", example = "http://www.abc.com/images/123.jpg")
    private String url;
}
