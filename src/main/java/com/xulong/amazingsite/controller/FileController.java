package com.xulong.amazingsite.controller;

import com.xulong.amazingsite.common.BizException;
import com.xulong.amazingsite.dto.FileDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * FileController
 *
 * @author xulong
 * @date 2018/9/30
 */
@RestController
@RequestMapping(value = "/files")
@Api(tags = "File APIs", description = "文件接口")
public class FileController {

    @Value("${amazing.config.upload-file-path}")
    private String UPLOAD_FILE_PATH;
    @Value("${amazing.config.view-file-path}")
    private String VIEW_FILE_PATH;

    @ApiOperation(value = "上传文件API", httpMethod = "POST", notes = "上传文件", response = FileDto.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件对象", required = true, paramType = "body", dataType = "MultipartFile")
    })
    @ResponseBody
    @PostMapping(value = "")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<FileDto> upload(@RequestParam("file") MultipartFile file) throws BizException {

        if (file.isEmpty()) {
            throw new BizException("文件为空");
        }

        FileDto fileDto = new FileDto();
        fileDto.setFileId(UUID.randomUUID().toString());
        fileDto.setFileName(file.getOriginalFilename());
        fileDto.setSuffixName(fileDto.getFileName().substring(fileDto.getFileName().lastIndexOf(".")));
        fileDto.setFileSize(file.getSize());
        fileDto.setUrl(VIEW_FILE_PATH + fileDto.getFileId() + fileDto.getSuffixName());

        File dest = new File(UPLOAD_FILE_PATH + fileDto.getFileId() + fileDto.getSuffixName());

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return ResponseEntity.status(HttpStatus.CREATED).body(fileDto);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new BizException("上传文件出错：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException("上传文件出错：" + e.getMessage());
        }
    }

}
