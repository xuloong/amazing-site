package com.xulong.amazingsite.model;

import lombok.Data;

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
@Data
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

}
