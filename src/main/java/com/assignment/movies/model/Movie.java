package com.assignment.movies.model;

public class Movie {
	private String id;
	private String title;
	private Integer year;

	public Movie() {

	}

	public Movie(String id, String title, Integer year) {
		this.id = id;
		this.title = title;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
