package com.xulong.amazingsite.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * User
 *
 * @author xulong
 * @date 2018-07-10
 */
@Entity
@Table(name = "user_role")
@Data
public class UserRole implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Long userId;

    private Long roleId;

}
