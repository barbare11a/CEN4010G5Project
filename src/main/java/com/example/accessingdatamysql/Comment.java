package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class  Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String value;

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

}
