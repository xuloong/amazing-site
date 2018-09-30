package com.xulong.amazingsite.controller;

import com.xulong.amazingsite.model.Article;
import com.xulong.amazingsite.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * ArticleController
 *
 * @author xulong
 * @date 2018/9/18
 */
@RestController
@RequestMapping(value = "/articles")
@Api(tags = "Article APIs", description = "文章接口")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "查询文章详情API", httpMethod = "GET", notes = "根据ID查询文章详情", response = Article.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章ID", required = true, paramType = "path", dataType = "Long")
    })
    @ResponseBody
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Article> getById(@NotNull @PathVariable("id") Long id) {

        Article article = articleService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);

    }

    @ApiOperation(value = "查询文章列表API", httpMethod = "POST", notes = "查询文章列表", response = Page.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = false, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = false, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "article", value = "文章对象", required = false, paramType = "body", dataType = "Article")
    })
    @ResponseBody
    @PostMapping(value = "/list")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Page<Article>> getList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                                 @RequestBody(required = false) Article article) {

        Pageable pageable = new PageRequest(page - 1, size, Sort.Direction.DESC, "id");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<Article> example = Example.of(article, matcher);
        Page<Article> articles = articleService.getList(example, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(articles);

    }

    @ApiOperation(value = "新增文章API", httpMethod = "POST", notes = "新增文章", response = Article.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "article", value = "文章对象", required = true, paramType = "body", dataType = "Article")
    })
    @ResponseBody
    @PostMapping(value = "")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Article> create(@RequestBody Article article) {

        article = articleService.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);

    }

    @ApiOperation(value = "修改文章API", httpMethod = "PATCH", notes = "修改文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章ID", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "article", value = "文章对象", required = true, paramType = "body", dataType = "Article")
    })
    @ResponseBody
    @PatchMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void update(@NotNull @PathVariable("id") Long id, @RequestBody Article article) {

        article.setId(id);
        articleService.save(article);

    }

    @ApiOperation(value = "删除文章API", httpMethod = "DELETE", notes = "删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章ID", required = true, paramType = "path", dataType = "Long")
    })
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_USER')")
    public void delete(@NotNull @PathVariable("id") Long id) {

        articleService.delete(id);

    }

}
