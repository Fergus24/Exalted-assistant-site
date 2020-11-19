package com.fshouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Charms")
public class Charms {

	@Id
	@Column(name="charmID", length = 4)
	private int charmID;
	
	@Column(name="charmName", length = 30)
	private String charmName;

	@Column(name="charmCost")
	private int charmCost;
	
	
	
	
	public Charms() {	
	}
	
	public Charms (int charmID, String charmName, int charmCost) {
		this.charmID = charmID;
		this.charmName = charmName;
		this.charmCost = charmCost;
	}
	
	
	
	
	
	
	
	public String getCharmName() {
		return charmName;
	}
	public void setCharmName(String charmName) {
		this.charmName = charmName;
	}
	public int getCharmCost() {
		return charmCost;
	}
	public void setCharmCost(int charmCost) {
		this.charmCost = charmCost;
	}
	public int getCharmID() {
		return charmID;
	}
	public void setCharmID(int charmID) {
		this.charmID = charmID;
	}
	
	
}
