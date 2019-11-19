package com.hg.yyzcxt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_MENU")
public class Menu implements java.io.Serializable{
	 @Id
     @Column(name="ID")
	private String id;
	 @Column(name="PID")
	private String pid;
	 @Column(name="NAME")
	private String name;
	 @Column(name="URL")
	private String url;
	 @Column(name="REMARK")
	private String remark;
	 @Column(name="MENUICON")
	private String menuicon;
	 @Column(name="IS_PARENT_MENU")
	private Integer isParentMenu;
	 @Column(name="SORT")
	private Integer sort;
	 @Column(name="FIELD1")
	private String field1;
	 @Column(name="FIELD2")
	private String field2;
	 @Column(name="FIELD3")
	private String field3;
	 
	 
	 
	public Menu() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}
	public Integer getIsParentMenu() {
		return isParentMenu;
	}
	public void setIsParentMenu(Integer isParentMenu) {
		this.isParentMenu = isParentMenu;
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
