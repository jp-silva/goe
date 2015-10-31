package com.goe.articles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goe.articles.models.Article;
import com.goe.articles.repositories.ArticleRepository;
import com.google.common.base.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleRepository articleRep;

	public Optional<Article> getArticle(String slug) {
		return Optional.fromNullable(articleRep.findBySlug(slug));
	}
	
	public Iterable<Article> getAllArticles() {
		return articleRep.findAll();
	}
}