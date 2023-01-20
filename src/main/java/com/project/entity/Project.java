package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "number")
	private String number;
	@Column(name = "name")
	private String name;
	@Column(name = "count")
	private Integer count;
	@Column(name = "price")
	private Integer price;
	@Column(name = "daytime")
	private String daytime;
	public Project() {}
	public Project(String number, String name, Integer count, Integer price, String daytime) {
		this.number = number;
		this.name = name;
		this.count = count;
		this.price = price;
		this.daytime = daytime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", number=" + number + ", name=" + name + ", count=" + count + ", price=" + price
				+ ", daytime=" + daytime + "]";
	}

}
