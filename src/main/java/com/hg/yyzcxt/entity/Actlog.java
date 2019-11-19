package com.hg.yyzcxt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_ACTLOG")
public class Actlog implements java.io.Serializable{

	 @Id
     @Column(name="ID")
	private String id;
	 
	 @Column(name="ACT_MODULE")
	private String actModule;
	 
	 @Column(name="ACT_TYPE")
	private String actType;
	 
	 @Column(name="ACT_CONTENT")
	private Integer actContent;
	 
	 @Column(name="CREATETIME")
	private Date createtime;
	 
	 @Column(name="ACT_USERID")
	private String actUserId;
	 
	 @Column(name="ACT_USERNAME")
	private String actUsername;
	 
	 @Column(name="ACT_IP")
	private String actIp;
	 
	 @Column(name="FIELD1")
	private String field1;
	 
	 @Column(name="FIELD2")
	private String field2;
	 
	 @Column(name="FIELD3")
	private String field3;

	public Actlog() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActModule() {
		return actModule;
	}

	public void setActModule(String actModule) {
		this.actModule = actModule;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public Integer getActContent() {
		return actContent;
	}

	public void setActContent(Integer actContent) {
		this.actContent = actContent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getActUserId() {
		return actUserId;
	}

	public void setActUserId(String actUserId) {
		this.actUserId = actUserId;
	}

	public String getActUsername() {
		return actUsername;
	}

	public void setActUsername(String actUsername) {
		this.actUsername = actUsername;
	}

	public String getActIp() {
		return actIp;
	}

	public void setActIp(String actIp) {
		this.actIp = actIp;
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
		return "Actlog [id=" + id + ", actModule=" + actModule + ", actType=" + actType + ", actContent=" + actContent
				+ ", createtime=" + createtime + ", actUserId=" + actUserId + ", actUsername=" + actUsername
				+ ", actIp=" + actIp + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

	
}
