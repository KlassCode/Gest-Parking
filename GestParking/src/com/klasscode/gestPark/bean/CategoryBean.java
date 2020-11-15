package com.klasscode.gestPark.bean;

public class CategoryBean {

	private int id;
	private String categoryName;

	public CategoryBean(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public CategoryBean(String categoryName) {

		this.categoryName = categoryName;
	}

	public CategoryBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}