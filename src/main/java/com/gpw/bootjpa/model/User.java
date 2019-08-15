package com.gpw.bootjpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	private String userName;
	@ManyToMany(cascade = { CascadeType.MERGE  })
	@JoinTable(name = "user_modules", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
	private Set<Module> modules;

	public User() {
		super();
	}

	public User(String userName, Set<Module> modules) {
		super();
		this.userName = userName;
		this.modules = modules;
		this.modules.forEach(u -> u.getUsers().add(this));
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public void addModule(Module module) {
		modules.add(module);
		module.getUsers().add(this);
	}

}
