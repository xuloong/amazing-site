package com.xulong.amazingsite.model;

import com.xulong.amazingsite.enums.ArticleClassEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.time.ZonedDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Article
 *
 * @author xulong
 * @date 2018/8/5
 */
@Entity
@Table(name = "article")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @ApiModelProperty(value = "ID", dataType = "Long")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "类别(1:新闻;2.产品;3.关于我们;4.招聘;5.下载)", dataType = "Integer", example = "1")
    private ArticleClassEnum articleClass = ArticleClassEnum.NEWS;

    @Column(nullable = false)
    @ApiModelProperty(value = "分类", dataType = "Long", example = "1")
    private Long type;

    @Column(nullable = false)
    @ApiModelProperty(value = "标题", dataType = "String", example = "我是标题")
    private String title;

    @ApiModelProperty(value = "摘要", dataType = "String", example = "我是摘要")
    private String summary;

    @Column(nullable = false, columnDefinition = "TEXT")
    @ApiModelProperty(value = "内容", dataType = "String", example = "我是内容")
    private String content;

    @Column(nullable = false)
    @ApiModelProperty(value = "状态(1:有效;0:无效)", dataType = "Integer", example = "1")
    private Integer status = 1;

    @CreatedDate
    private Date createTime;

    @CreatedBy
    private Long creater;

    @LastModifiedDate
    private Date modifiedTime;

    @LastModifiedBy
    private Long modifier;

}
