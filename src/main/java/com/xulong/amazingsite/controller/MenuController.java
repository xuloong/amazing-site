package com.xulong.amazingsite.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MenuController
 *
 * @author xulong
 * @date 2018/9/30
 */
@RestController
@RequestMapping(value = "/menus")
@Api(tags = "Menu APIs", description = "菜单接口")
public class MenuController {
}
