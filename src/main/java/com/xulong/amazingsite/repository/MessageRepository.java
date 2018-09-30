package com.xulong.amazingsite.repository;

import com.xulong.amazingsite.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MessageRepository
 *
 * @author xulong
 * @date 2018/9/13
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
