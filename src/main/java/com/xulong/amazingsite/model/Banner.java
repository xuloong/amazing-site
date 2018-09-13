package com.xulong.amazingsite.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Banner
 *
 * @author xulong
 * @date 2018/8/5
 */
@Entity
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private String imageSrc;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false)
    private Integer orderByNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderByNum() {
        return orderByNum;
    }

    public void setOrderByNum(Integer orderByNum) {
        this.orderByNum = orderByNum;
    }
}
