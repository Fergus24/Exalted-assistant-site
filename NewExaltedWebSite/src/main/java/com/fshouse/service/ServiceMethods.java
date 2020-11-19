package com.fshouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.fshouse.DAOs.CharacterDAO;
import com.fshouse.DAOs.CharacterToCharmDAO;
import com.fshouse.DAOs.CharmDAO;
import com.fshouse.models.CharacterSheet;
import com.fshouse.models.CharacterToCharms;
import com.fshouse.models.Charms;

public class ServiceMethods {

	
	public int attributeCostCalculator(CharacterSheet CharacterSheet, String attribute) {
		
		int Tempvalue;
		
		if (attribute == "strength") {
			Tempvalue = CharacterSheet.getStrength();
		} else if (attribute == "dexterity") {
			Tempvalue = CharacterSheet.getDexterity();
		} else if (attribute == "stamina") {
			Tempvalue = CharacterSheet.getStamina();
		} else if (attribute == "charisma") {
			Tempvalue = CharacterSheet.getCharisma();
		} else if (attribute == "manipulation") {
			Tempvalue = CharacterSheet.getManipulation();
		} else if (attribute == "appearance") {
			Tempvalue = CharacterSheet.getAppearance();
		} else if (attribute == "perception") {
			Tempvalue = CharacterSheet.getPerception();
		} else if (attribute == "intelligence") {
			Tempvalue = CharacterSheet.getIntelligence();
		} else if (attribute == "wits") {
			Tempvalue = CharacterSheet.getWits();
		} else {
			Tempvalue = 1;
		}
		
		int XPcost = Tempvalue * 4;
			
		return XPcost;
		
	}
	
	public ArrayList<String> listOfAllCharmNames(){
	
		ArrayList<String> listOfAllCharmNames = new ArrayList<>();		
		CharmDAO charmdao = new CharmDAO();
		List<Charms> Thesecharms = charmdao.getAllRecords();

		for(Charms element: Thesecharms) {
			listOfAllCharmNames.add(element.getCharmName());
		}
		
		return listOfAllCharmNames;
	}
	
	
	
	
	public ArrayList<Charms> listOfAllCharacterCharms(String character){
	
//		ArrayList<String> listOfAllCharacterCharms = new ArrayList<>();	
		
		CharacterToCharmDAO characterToCharmDAO = new CharacterToCharmDAO();
		CharmDAO charmsdao = new CharmDAO();
		
		List<Charms> allCharms = charmsdao.getAllRecords();
		List<CharacterToCharms> theseCharms = characterToCharmDAO.getAllRecords();

		ArrayList<Integer> characterCharmIDs = new ArrayList<>();
		
		ArrayList<Charms> charactersCharms = new ArrayList<>();
		
		for(CharacterToCharms element: theseCharms) {
			if(element.getCharacterName().equals(character)) {
				characterCharmIDs.add(element.getCharmID());
			}
		}
			
		for(Charms element: allCharms) {
			if (characterCharmIDs.contains(element.getCharmID())) {
				charactersCharms.add(element);
			}
			
		}
		

		return charactersCharms;
	}
	

	public ArrayList<Charms> listOfAllCharmsNotOwned(String character){
		
		CharacterToCharmDAO characterToCharmDAO = new CharacterToCharmDAO();
		CharmDAO charmsdao = new CharmDAO();
		List<Charms> allCharms = charmsdao.getAllRecords();
		List<CharacterToCharms> theseCharms = characterToCharmDAO.getAllRecords();
		ArrayList<Integer> characterCharmIDs = new ArrayList<>();
		ArrayList<Charms> otherCharms = new ArrayList<>();
		
		for(CharacterToCharms element: theseCharms) {
			if(element.getCharacterName().equals(character)) {
				characterCharmIDs.add(element.getCharmID());
			}
		}
			
		for(Charms element: allCharms) {
			if (!characterCharmIDs.contains(element.getCharmID())) {
				otherCharms.add(element);
			}
			
		}
		
		
		return otherCharms;
	}
	
}
