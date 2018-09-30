package com.xulong.amazingsite.service.impl;

import com.xulong.amazingsite.base.impl.BaseServiceImpl;
import com.xulong.amazingsite.model.Article;
import com.xulong.amazingsite.repository.ArticleRepository;
import com.xulong.amazingsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ArticleServiceImpl
 *
 * @author xulong
 * @date 2018/9/19
 */
@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

//    @Resource
//    public void setArticleRepository(ArticleRepository articleRepository) {
//        this.articleRepository = articleRepository;
//        super.setJpaRepository(articleRepository);
//    }

}
