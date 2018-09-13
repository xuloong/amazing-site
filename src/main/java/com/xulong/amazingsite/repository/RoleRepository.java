package com.xulong.amazingsite.repository;

import com.xulong.amazingsite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author xulong
 * @date 2018-07-10
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
