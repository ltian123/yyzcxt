package com.hg.yyzcxt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_USER_ROLE")
public class UserRoleMap  implements java.io.Serializable{

	
	 @Id
     @Column(name="ID")
     private String id;
	 @Column(name="USER_ID")
     private String userId;
	 @Column(name="ROLE_ID")
     private String roleId;
	 @Column(name="SORT")
     private Integer sort;
	 @Column(name="FIELD1")
     private String field1;
	 @Column(name="FIELD2")
     private String field2;
	 @Column(name="FIELD3")
     private String field3;
	 
	public UserRoleMap() {
		super();
	}
	


	public UserRoleMap(String userId, String roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
