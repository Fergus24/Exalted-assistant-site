package com.fshouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "CharacterToCharms")
public class CharacterToCharms {


		@Id
		@Column(name="newID", length = 5)
		private int newID;
		
		@Column(name="charmID", length = 4)
		private int charmID;

		@Column(name="CharacterName")
		private String characterName;
		
		
		
		public CharacterToCharms() {	
		}
		
		public CharacterToCharms (int newID, int charmID, String characterName) {
			this.newID = newID;
			this.charmID = charmID;
			this.characterName = characterName;
		}
		
		
		
		
		

		public int getNewID() {
			return newID;
		}

		public void setNewID(int newID) {
			this.newID = newID;
		}

		public int getCharmID() {
			return charmID;
		}

		public void setCharmID(int charmID) {
			this.charmID = charmID;
		}

		public String getCharacterName() {
			return characterName;
		}

		public void setCharacterName(String characterName) {
			this.characterName = characterName;
		}


	
}
