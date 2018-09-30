package com.xulong.amazingsite.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Role
 *
 * @author xulong
 * @date 2018-07-10
 */
@Entity
@Table(name = "role")
@Data
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roleName;

}
