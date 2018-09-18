package com.xulong.amazingsite.controller;

import com.xulong.amazingsite.common.BizException;
import com.xulong.amazingsite.model.Message;
import com.xulong.amazingsite.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * MessageController
 *
 * @author xulong
 * @date 2018/9/10
 */
@RestController
@RequestMapping(value = "/messages")
@Api(tags = "Message APIs", description = "留言接口")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "留言详情API", httpMethod = "GET", notes = "根据ID查询留言详情", response = Message.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "留言ID", required = true, paramType = "path", dataType = "Long")
    })
    @ResponseBody
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Message> getById(@NotNull @PathVariable("id") Long id) {

        Message message = messageService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }

    @ApiOperation(value = "留言列表API", httpMethod = "GET", notes = "查询留言列表", response = Page.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = false, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = false, paramType = "query", dataType = "Integer")
    })
    @ResponseBody
    @GetMapping(value = "")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Page<Message>> getList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {

        Message message = new Message();
        Page<Message> messages = messageService.getList(message, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(messages);

    }

    @ApiOperation(value = "留言新增API", httpMethod = "POST", notes = "新增留言", response = Message.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "留言对象", required = true, paramType = "body", dataType = "Message")
    })
    @ResponseBody
    @PostMapping(value = "")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Message> create(@RequestBody Message message) {

        message = messageService.save(message);
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }
}
