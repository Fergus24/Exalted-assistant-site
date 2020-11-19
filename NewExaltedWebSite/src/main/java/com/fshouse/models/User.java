package com.fshouse.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class User {

	@Id
	@Column(name = "username", length = 30, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@Column(name = "emailAddress", length = 30, nullable = true)
	private String email;
	
	@OneToMany( targetEntity=CharacterSheet.class )
	private List<CharacterSheet> characterSheets;


	public User() {	
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String userName, String password, String email) {
		this.username = userName;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public CharacterSheet getCharacterSheet() {
//		return CharacterSheet;
//	}
//
//	public void setCharacterSheet(CharacterSheet characterSheet) {
//		CharacterSheet = characterSheet;
//	}




}
