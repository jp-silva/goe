package com.goe.articles.service;

import com.goe.articles.models.Article;
import com.google.common.base.Optional;

public interface ArticleService {

	Optional<Article> getArticle(String slug);

	Iterable<Article> getAllArticles();
}