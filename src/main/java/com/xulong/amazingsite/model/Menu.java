package com.xulong.amazingsite.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Menu
 *
 * @author xulong
 * @date 2018/8/5
 */
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String remark;

    @Column(nullable = false)
    private Long parentId;

    @Column(nullable = false)
    private Long articleId;

    @Column(nullable = false)
    private Integer orderByNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getOrderByNum() {
        return orderByNum;
    }

    public void setOrderByNum(Integer orderByNum) {
        this.orderByNum = orderByNum;
    }
}
