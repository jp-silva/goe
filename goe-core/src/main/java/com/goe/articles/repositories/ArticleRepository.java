package com.goe.articles.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.goe.articles.models.Article;

@Component
public interface ArticleRepository extends CrudRepository<Article, Long> {

	Article findBySlug(String slug);
}
