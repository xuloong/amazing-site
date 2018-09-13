package com.xulong.amazingsite.repository;

import com.xulong.amazingsite.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRoleRepository
 *
 * @author xulong
 * @date 2018-07-10
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Long userId);

    @Query(value = "SELECT r.role_name FROM user_role ur LEFT JOIN role r ON ur.role_id = r.id WHERE ur.user_id = ?1", nativeQuery = true)
    List<String> findRoleName(Long userId);

}
