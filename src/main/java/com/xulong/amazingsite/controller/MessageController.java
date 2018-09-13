package com.xulong.amazingsite.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageController
 *
 * @author xulong
 * @date 2018/9/10
 */
@RestController
@RequestMapping(value = "/messages")
@Api(tags = "Message API", description = "留言API")
public class MessageController {
}
