package com.xulong.amazingsite.base.impl;

import com.xulong.amazingsite.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * BaseServiceImpl
 *
 * @author xulong
 * @date 2018/9/19
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private JpaRepository<T, Long> jpaRepository;

//    public void setJpaRepository(JpaRepository<T, Long> jpaRepository) {
//        this.jpaRepository = jpaRepository;
//    }

    @Override
    public T getById(Long id) {
        return jpaRepository.findOne(id);
    }

    @Override
    public Page<T> getList(Example<T> example, Pageable pageable) {
        return jpaRepository.findAll(example, pageable);
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.delete(id);
    }

    @Override
    public List<T> getAll() {
        return jpaRepository.findAll();
    }

}

