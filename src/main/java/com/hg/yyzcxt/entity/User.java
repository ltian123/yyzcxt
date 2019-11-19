package com.hg.yyzcxt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_USER")
public class User  implements java.io.Serializable {

	 @Id
     @Column(name="ID")
     private String id;
	 @Column(name="USERNAME")
     private String username;
	 @Column(name="PASSWORD")
     private String password;
	 @Column(name="PHONE")
     private String phone;
	 @Column(name="CREATEDATE")
     private Date createDate;
	 @Column(name="EMAIL")
     private String email;
	 @Column(name="SORT")
     private Integer sort;
	 @Column(name="USER_STATE")
     private String status;
	 @Column(name="FIELD1")
     private String field1;
	 @Column(name="FIELD2")
     private String field2;
	 @Column(name="FIELD3")
     private String field3;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getGroupId() {
//		return groupId;
//	}
//	public void setGroupId(String groupId) {
//		this.groupId = groupId;
//	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", createDate=" + createDate + ", email=" + email + ", sort=" + sort
				+ ", status=" + status + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	public User() {
		super();
	}

    








}