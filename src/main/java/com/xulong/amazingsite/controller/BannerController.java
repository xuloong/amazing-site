package com.xulong.amazingsite.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BannerController
 *
 * @author xulong
 * @date 2018/9/30
 */
@RestController
@RequestMapping(value = "/banners")
@Api(tags = "Banner APIs", description = "Banner接口")
public class BannerController {
}
