package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "types")
	private String types;
	@Column(name = "number")
	private String number;
	@Column(name = "name")
	private String name;
	@Column(name = "count")
	private Integer count;
	@Column(name = "price")
	private Integer price;
	@Column(name = "day")
	private String day;
	@Column(name = "text")
	private String text;
	@Column(name = "daytime")
	private String daytime;
	public Project() {}
	public Project(String types, String number, String name, Integer count, Integer price, String day, String text, String daytime) {
		this.types = types;
		this.number = number;
		this.name = name;
		this.count = count;
		this.price = price;
		this.day = day;
		this.text = text;
		this.daytime = daytime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotalprice() {
		return count * price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", types=" + types + ", number=" + number + ", name=" + name + ", count=" + count
				+ ", price=" + price + ", day=" + day + ", text=" + text + ", daytime=" + daytime + "]";
	}
	
	

	

}
