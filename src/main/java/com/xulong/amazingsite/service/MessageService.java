package com.xulong.amazingsite.service;

import com.xulong.amazingsite.model.Message;
import org.springframework.data.domain.Page;

/**
 * MessageService
 *
 * @author xulong
 * @date 2018/9/13
 */
public interface MessageService {

    Message getById(Long id);

    Page<Message> getList(Message message, Integer page, Integer size);

    Message save(Message message);

}
