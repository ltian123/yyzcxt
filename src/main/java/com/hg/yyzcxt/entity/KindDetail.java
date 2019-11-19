package com.hg.yyzcxt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_KIND_DETAIL")
public class KindDetail implements java.io.Serializable{

	 @Id
     @Column(name="ID")
	private String id;
	 
	 @Column(name="DETAIL_NAME")
	private String detailName;
	 
	 @Column(name="DETAIL_EXPLAIN")
	private String detailExplain;
	 
	 @Column(name="DEATIL_VALUE")
	private String detaileValue;
	 
	 @Column(name="KIND_ID")
	private String kindId;
	 
	 @Column(name="SORT")
	private Integer sort;
	 
	 @Column(name="FIELD1")
	private String field1;
	 
	 @Column(name="FIELD2")
	private String field2;
	 
	 @Column(name="FIELD3")
	private String field3;

	public KindDetail() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getDetailExplain() {
		return detailExplain;
	}

	public void setDetailExplain(String detailExplain) {
		this.detailExplain = detailExplain;
	}

	public String getDetaileValue() {
		return detaileValue;
	}

	public void setDetaileValue(String detaileValue) {
		this.detaileValue = detaileValue;
	}

	public String getKindId() {
		return kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
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

	@Override
	public String toString() {
		return "KindDetail [id=" + id + ", detailName=" + detailName + ", detailExplain=" + detailExplain
				+ ", detaileValue=" + detaileValue + ", kindId=" + kindId + ", sort=" + sort + ", field1=" + field1
				+ ", field2=" + field2 + ", field3=" + field3 + "]";
	}

	
	
}
