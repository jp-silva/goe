package com.goe.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goe.articles.service.ArticleService;

@Controller
public class ArticlesController {

	@Autowired
	ArticleService articleService;

	@ResponseBody
	@RequestMapping(value="/articles", method=RequestMethod.GET)
	public Map<String, Object> articles() {
		return Collections.<String, Object> singletonMap("articles", articleService.getAllArticles());
	}
}
