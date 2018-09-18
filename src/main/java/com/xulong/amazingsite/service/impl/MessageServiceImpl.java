package com.xulong.amazingsite.service.impl;

import com.xulong.amazingsite.model.Message;
import com.xulong.amazingsite.repository.MessageRepository;
import com.xulong.amazingsite.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * MessageServiceImpl
 *
 * @author xulong
 * @date 2018/9/13
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message getById(Long id) {

        return messageRepository.findOne(id);

    }

    @Override
    public Page<Message> getList(Message message, Integer page, Integer size) {

        Pageable pageable = new PageRequest(page - 1, size, Sort.Direction.DESC, "id");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains());
        //.withIgnorePaths("password");

        Example<Message> example = Example.of(message, matcher);

        return messageRepository.findAll(example, pageable);

    }

    @Override
    public Message save(Message message) {

        return messageRepository.save(message);

    }

}
