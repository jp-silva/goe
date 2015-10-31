package com.goe.articles.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "articles_category")
public class ArticleCategory{

	private Integer id;
	private String name;
	private String description;
	private Set<Article> articles = new HashSet<Article>(0);

	public ArticleCategory() {
	}
	public ArticleCategory(String name) {
		this.name = name;
	}
	public ArticleCategory(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer Id) {
		this.id = Id;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Article> getArticles() {
		return this.articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}