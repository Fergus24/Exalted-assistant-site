package com.fshouse.runner;

import java.util.ArrayList;
import java.util.List;

import com.fshouse.DAOs.CharacterDAO;
import com.fshouse.DAOs.CharacterToCharmDAO;
import com.fshouse.DAOs.CharmDAO;
import com.fshouse.models.CharacterSheet;
import com.fshouse.models.CharacterToCharms;
import com.fshouse.models.Charms;

public class Runner {

	public static void main(String[] args) {

		CharmDAO charmdao = new CharmDAO();
//		List<CharacterSheet> listCharacterSheets = characterdao.getAllRecords();
//		List<CharacterSheet> usersCharacterSheets = new ArrayList<CharacterSheet>();
//		
//		for (CharacterSheet element: listCharacterSheets) {
//			if (element.getUsername().equals("NewRandom") )
//				usersCharacterSheets.add(element);
//		}
//		
//		ArrayList<String> userCharacterNames = new ArrayList<>();
//		
//		for (CharacterSheet element: usersCharacterSheets) {
//			userCharacterNames.add(element.getCharacterName());
//		}
//		
//		for (String element: userCharacterNames) {
//			System.out.println(element);
//		}
		
		CharacterToCharmDAO charactertocharmdao = new CharacterToCharmDAO();
		
		Charms Shoes = new Charms(0002, "Shoes", 4);
		Charms GoodShoes = new Charms(0004, "GoodShoes", 6);
		Charms GreatShoes = new Charms(0005, "GreatShoes", 8);
		Charms GreatHat = new Charms(0006, "GreatHat", 10);
		
		CharacterToCharms two = new CharacterToCharms(4,0002,"NewCharacter");
		CharacterToCharms three = new CharacterToCharms(5,0004,"RandomCharacter");
		CharacterToCharms four = new CharacterToCharms(6,0005,"Panda");
		CharacterToCharms five = new CharacterToCharms(7,0006,"Again");
		
		charmdao.insertIntoTable(Shoes);
		charmdao.insertIntoTable(GoodShoes);
		charmdao.insertIntoTable(GreatShoes);
		charmdao.insertIntoTable(GreatHat);
		
		charactertocharmdao.insertIntoTable(two);
		charactertocharmdao.insertIntoTable(three);
		charactertocharmdao.insertIntoTable(four);
		charactertocharmdao.insertIntoTable(five);
		
		
		System.out.println(GreatHat.getCharmName());
	}

}
