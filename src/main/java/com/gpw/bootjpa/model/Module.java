package com.gpw.bootjpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "module_name")
	private String moduleName;
	@Column(name = "module_order")
	private Integer moduleOrder;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, mappedBy = "modules")
	private Set<User> users = new HashSet<User>();

	public Module() {
		super();
	}

	public Module(String moduleName, Integer moduleOrder, Set<User> users) {
		super();
		this.moduleName = moduleName;
		this.moduleOrder = moduleOrder;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(Integer moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}

	@JsonProperty
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tid: " + id + "\n\tmoduleName: " + moduleName + "\n\tmoduleOrder: "
				+ moduleOrder + "\n\tusers: " + users + "\n}";
	}

}
