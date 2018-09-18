package com.xulong.amazingsite.repository;

import com.xulong.amazingsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author xulong
 * @date 2018-07-10
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByUsername(String username);

    User findByNameAndUsername(String name, String username);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
