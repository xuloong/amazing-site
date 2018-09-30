package com.xulong.amazingsite.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Message
 *
 * @author xulong
 * @date 2018/8/5
 */
@Entity
@Table(name = "message")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @ApiModelProperty(value = "ID", dataType = "Long")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "姓名", dataType = "String", example = "张三")
    private String name;

    @Column(nullable = false)
    @ApiModelProperty(value = "电话", dataType = "String", example = "13888888888")
    private String tel;

    @Column(nullable = false)
    @ApiModelProperty(value = "邮箱", dataType = "String", example = "zhangsan@qq.com")
    private String email;

    @Column(length = 5000)
    @ApiModelProperty(value = "内容", dataType = "String", example = "Hello World")
    private String content;

    @CreatedDate
    @ApiModelProperty(value = "创建时间（不用赋值）", dataType = "Date", example = "2018-01-01 00:00:00")
    private Date createTime;

}
