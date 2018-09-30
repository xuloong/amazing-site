package com.xulong.amazingsite.model;

import lombok.Data;

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
@Data
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

}
