package com.xulong.amazingsite.mapper;

import com.xulong.amazingsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UserRepository
 *
 * @author xulong
 * @date 2018-07-10
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User findByName(String name);

    User findByUsername(String username);

    User findByNameAndUsername(String name, String username);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
