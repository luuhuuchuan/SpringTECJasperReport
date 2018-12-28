package com.ck.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "app_roles")
public class App_roles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "app_roles")
	private Set<App_users> app_users;
	
	public App_roles() {
	}
	
	public App_roles(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<App_users> getUsers() {
		return app_users;
	}

	public void setUsers(Set<App_users> users) {
		this.app_users = users;
	}
	
}
