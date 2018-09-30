package com.xulong.amazingsite.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * BaseService
 *
 * @author xulong
 * @date 2018/9/19
 */
public interface BaseService<T> {

    public T getById(Long id);

    public Page<T> getList(Example<T> example, Pageable pageable);

    public T save(T entity);

    public void delete(Long id);

    public List<T> getAll();

}
