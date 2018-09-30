package com.xulong.amazingsite.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * ArticleClassEnum
 *
 * @author xulong
 * @date 2018/9/18
 */
public enum ArticleClassEnum {

    NEWS(1, "新闻"),

    PRODUCT(2, "产品"),

    ABOUTUS(3, "关于我们"),

    JOB(4, "招聘"),

    DOWNLOAD(5, "下载");

    private int index;

    private String description;

    private static final List<ArticleClassEnum> enumList = new ArrayList<ArticleClassEnum>();

    static {
        for (ArticleClassEnum articleClassEnum : EnumSet.allOf(ArticleClassEnum.class)) {
            enumList.add(articleClassEnum);
        }
    }

    public static ArticleClassEnum valueOf(int value) {
        switch (value) {
            case 1:
                return NEWS;
            case 2:
                return PRODUCT;
            case 3:
                return ABOUTUS;
            case 4:
                return JOB;
            case 5:
                return DOWNLOAD;
            default:
                return null;
        }
    }

    ArticleClassEnum(int index, String description) {
        this.index = index;
        this.description = description;
    }

}
