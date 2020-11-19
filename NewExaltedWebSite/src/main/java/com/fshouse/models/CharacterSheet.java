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
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "CharacterSheet")
public class CharacterSheet {

	@Id
	@Column(name="CharacterName", length = 50)
	private String CharacterName;

	@Column(name="username", length = 30)
	private String username;

//    @ManyToOne
//    private User user;
	
	
	
	@Column(name="strength", length = 3)
	private int strength;
	@Column(name="dexterity", length = 3)
	private int dexterity;
	@Column(name="stamina", length = 3)
	private int stamina;
	@Column(name="charisma", length = 3)
	private int charisma;
	@Column(name="manipulation", length = 3)
	private int manipulation;
	@Column(name="appearance", length = 3)
	private int appearance;
	@Column(name="perception", length = 3)
	private int perception;
	@Column(name="intelligence", length = 3)
	private int intelligence;
	@Column(name="wits", length = 3)
	private int wits;
	
	@Column(name="XP", length = 4)
	private int XP;
	
	@Column(name="XP_spent", length = 4)
	private int XP_Spent;
	
	
	
//	@CollectionTable(name="Character_Charms",joinColumns=@JoinColumn(name="CharacterName")) // name of joining table
//	@MapKeyJoinColumn(name="charmID") // pk of class used as Map key
//	@Column(name="charmName") // name of value column from Map
//	private ArrayList<Charms> charms = new ArrayList<Charms>();
	
	
	
//	@ManyToMany
//	@JoinTable(name="Character_Charms", joinColumns= {@JoinColumn(name="CharacterName")}, inverseJoinColumns= {@JoinColumn(name="charmID")})
//	private ArrayList<Charms> charms = new ArrayList<Charms>();
	

	public CharacterSheet() {	
	}
	
//	public CharacterSheet(String CharacterName, String username) {
//		super();
//		this.username = username;
//		this.CharacterName = CharacterName;
//	}
//	
//	public CharacterSheet(String CharacterName, String username, int XP) {
//		super();
//		this.username = username;
//		this.CharacterName = CharacterName;
//		this.XP = XP; 
//	}
	
	public CharacterSheet(String CharacterName, String username, int strength,  int dexterity, int stamina, int charisma, int manipulation, int appearance, int perception, int intelligence, int wits, int XP, int XP_Spent) {
		this.username = username;
		this.CharacterName = CharacterName;
		this.strength = strength;
		this.dexterity = dexterity;
		this.stamina = stamina;
		this.charisma = charisma;
		this.manipulation = manipulation;
		this.appearance = appearance;
		this.perception = perception;
		this.intelligence = intelligence;
		this.wits = wits;
		this.XP = XP;
		this.XP_Spent = XP_Spent;
	}
	
	
	
	
	
	
	
	
//	public ArrayList<Charms> getCharms() {
//		return charms;
//	}
//
//	public void setCharms(ArrayList<Charms> charms) {
//		this.charms = charms;
//	}

	public int getXP_Spent() {
		return XP_Spent;
	}

	public void setXP_Spent(int xP_Spent) {
		XP_Spent = xP_Spent;
	}

	public int getXP() {
		return XP;
	}
	public void setXP(int XP) {
		this.XP = XP;
	}
	
	public String getCharacterName() {
		return CharacterName;
	}
	public void setCharacterName(String characterName) {
		CharacterName = characterName;
	}

	public int getStrength() {
		return strength;
	}
	public void setStrength(int stength) {
		this.strength = stength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	public int getManipulation() {
		return manipulation;
	}
	public void setManipulation(int manipulation) {
		this.manipulation = manipulation;
	}
	public int getAppearance() {
		return appearance;
	}
	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}
	public int getPerception() {
		return perception;
	}
	public void setPerception(int perception) {
		this.perception = perception;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getWits() {
		return wits;
	}
	public void setWits(int wits) {
		this.wits = wits;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
