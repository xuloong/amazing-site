package com.xulong.amazingsite.repository;

import com.xulong.amazingsite.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ArticleRepository
 *
 * @author xulong
 * @date 2018/9/18
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
