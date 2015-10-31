package com.goe.articles.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articles")
public class Article {

	private Integer id;
	private String title;
	private String slug;
	private String intro;
	private String body;
	private boolean approved;
	private ArticleCategory category;
//	private Set<ArticleTag> tags = new HashSet<ArticleTag>(0);

	public Article() {
	}

	public Article(String title, String slug, String intro, String body, boolean approved) {
		this.title = title;
		this.slug = slug;
		this.intro = intro;
		this.body = body;
		this.approved = approved;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 150)
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "slug", unique = true, nullable = false, length = 150)
	public String getSlug() {
		return this.slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "intro", nullable = false, length = 600)
	public String getIntro() {
		return this.intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "body", nullable = false, length = 600)
	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	@Column(name = "approved", nullable = false)
	public boolean isApproved() {
		return this.approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="article_category_id", nullable = false)
	public ArticleCategory getCategory() {
		return category;
	}
	public void setCategory(ArticleCategory category) {
		this.category = category;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	public Set<UserRole> getUserRole() {
//		return this.userRole;
//	}
//
//	public void setUserRole(Set<UserRole> userRole) {
//		this.userRole = userRole;
//	}

}