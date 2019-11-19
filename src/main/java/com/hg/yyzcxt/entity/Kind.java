package com.hg.yyzcxt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_KIND")
public class Kind implements java.io.Serializable{

	 @Id
     @Column(name="ID")
	private String id;
	 
	 @Column(name="NAME")
	private String name;
	 
	 @Column(name="EXPLAIN")
	private String explain;
	 
	 @Column(name="SORT")
	private Integer sort;
	 
	 @Column(name="FIELD1")
	private String field1;
	 
	 @Column(name="FIELD2")
	private String field2;
	 
	 @Column(name="FIELD3")
	private String field3;

	public Kind() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}
	 
	
}
