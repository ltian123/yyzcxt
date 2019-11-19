package com.hg.yyzcxt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_ROLE_MENU")
public class RoleMenuMap implements java.io.Serializable {

	
	 @Id
    @Column(name="ID")
    private String id;
	 @Column(name="ROLE_ID")
    private String roleId;
	 @Column(name="MENU_ID")
    private String menuId;
	 @Column(name="ADD_AUTH")
    private Integer addAuth;
	 @Column(name="DEL_AUTH")
    private Integer delAuth;
	 @Column(name="UPD_AUTH")
    private Integer updAuth;
	 @Column(name="SORT")
    private Integer sort;
	 @Column(name="FIELD1")
    private String field1;
	 @Column(name="FIELD2")
    private String field2;
	 @Column(name="FIELD3")
    private String field3;
	public RoleMenuMap() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public Integer getAddAuth() {
		return addAuth;
	}
	public void setAddAuth(Integer addAuth) {
		this.addAuth = addAuth;
	}
	public Integer getDelAuth() {
		return delAuth;
	}
	public void setDelAuth(Integer delAuth) {
		this.delAuth = delAuth;
	}
	public Integer getUpdAuth() {
		return updAuth;
	}
	public void setUpdAuth(Integer updAuth) {
		this.updAuth = updAuth;
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
