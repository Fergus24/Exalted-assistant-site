package com.fshouse.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fshouse.DAOs.CharacterDAO;
import com.fshouse.DAOs.CharacterToCharmDAO;
import com.fshouse.DAOs.CharmDAO;
import com.fshouse.DAOs.UserDAO;
import com.fshouse.models.CharacterSheet;
import com.fshouse.models.CharacterToCharms;
import com.fshouse.models.Charms;
import com.fshouse.models.User;
import com.fshouse.service.ServiceMethods;



@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String homePageHandler(Model model) {
		return "index";
	}

	@RequestMapping(value = "signupform")
	public String registerPageHandler(Model model) {
		model.addAttribute("user", new User());
		return "signupform";
	}
	
	@RequestMapping(value = "login")
	public String loginHandler(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	
	@RequestMapping("/userProfile")
	public String userprofile() {
		return "userProfile";
	}

	
	@RequestMapping("/charactercreation")
	public String charactercreation(Model model, HttpServletRequest request) {
		
		model.addAttribute("CharacterSheet", new CharacterSheet());
		
		HttpSession session = request.getSession();
		String userCurrentName = (String) session.getAttribute("username");
		model.addAttribute("userCurrentName", userCurrentName);
		
		return "charactercreation";
	}

	@RequestMapping(value = "createCharacter", method = POST)
	public String registerSubmitHandler(Model model, CharacterSheet CharacterSheet,HttpServletRequest request) {
		model.addAttribute("CharacterSheet", CharacterSheet);
		
		String CharacterName = CharacterSheet.getCharacterName();
		String username = CharacterSheet.getUsername();
		
		int strength = CharacterSheet.getStrength();
		int dexterity = CharacterSheet.getDexterity();
		int stamina = CharacterSheet.getStamina();
		int charisma = CharacterSheet.getCharisma();
		int manipulation = CharacterSheet.getManipulation();
		int appearance = CharacterSheet.getAppearance();
		int perception = CharacterSheet.getPerception();
		int intelligence = CharacterSheet.getIntelligence();
		int wits = CharacterSheet.getWits();
		
		int XP = CharacterSheet.getXP();
		int XP_Spent = CharacterSheet.getXP_Spent();
		
		if(CharacterName.equals(""))
		{
			request.setAttribute("message", "Character Name Cannot Be Empty");
			return "charactercreation";
		}

		if(CharacterName.contains(" "))
		{
			request.setAttribute("message", "Character Name Cannot Contain Space");
			return "charactercreation";
		}
		CharacterDAO characterdao = new CharacterDAO();
		CharacterSheet newCharacter = characterdao.getFromTable(CharacterName);
		
		if (newCharacter==null)
		{
			characterdao.insertIntoTable(new CharacterSheet(CharacterName,username,strength,dexterity,stamina,charisma,manipulation,appearance,perception,intelligence,wits, XP,XP_Spent));
			return "userProfile";
		}
		else
		{
			request.setAttribute("message", "Character already exists");
			return "charactercreation";
		}
	}
	
//	
//	@RequestMapping("/Step_One_of_Character_Creation")
//	public ModelAndView Step_One_of_Character_Creation() {
//		
//		ModelAndView model3 = new ModelAndView("Step_One_of_Character_Creation");
//		
//		return model3;
//	
//	}
//	
//	@RequestMapping("/Step_Two_of_Character_Creation")
//	public ModelAndView Step_Two_of_Character_Creation() {
//		
//		ModelAndView model3 = new ModelAndView("Step_Two_of_Character_Creation");
//		
//		return model3;
//	
//	}	
//
//	@RequestMapping("/Step_Three_of_Character_Creation")
//	public ModelAndView Step_Three_of_Character_Creation() {
//		
//		ModelAndView model3 = new ModelAndView("Step_Three_of_Character_Creation");
//		
//		return model3;
//	
//	}	
//
//	@RequestMapping("/Step_Four_of_Character_Creation")
//	public ModelAndView Step_Four_of_Character_Creation() {
//		
//		ModelAndView model3 = new ModelAndView("Step_Four_of_Character_Creation");
//		
//		return model3;
//	
//	}	
//
//	@RequestMapping("/Step_Five_of_Character_Creation")
//	public ModelAndView Step_Five_of_Character_Creation() {
//		
//		ModelAndView model1 = new ModelAndView("Step_Five_of_Character_Creation");
//		
//		return model1;
//	}
//	
//	@RequestMapping("/Final_Check")
//	public ModelAndView Final_Check() {
//		
//		ModelAndView model1 = new ModelAndView("Final_Check");
//		
//		return model1;
//	}
//
//	@RequestMapping("/Bonus_Points_1")
//	public ModelAndView Bonus_Points() {
//		
//		ModelAndView model1 = new ModelAndView("Bonus_Points_1");
//		
//		return model1;
//	}
//	
//	@RequestMapping("/Bonus_Points_2")
//	public ModelAndView Bonus_Points2() {
//		
//		ModelAndView model1 = new ModelAndView("Bonus_Points_2");
//		
//		return model1;
//	}
//	
//	@RequestMapping("/Bonus_Points_3")
//	public ModelAndView Bonus_Points3() {
//		
//		ModelAndView model1 = new ModelAndView("Bonus_Points_3");
//		
//		return model1;
//	}
//	
//	@RequestMapping("/Bonus_Points_4")
//	public ModelAndView Bonus_Points4() {
//		
//		ModelAndView model1 = new ModelAndView("Bonus_Points_4");
//		
//		return model1;
//	}
//	
//	@RequestMapping("/Bonus_Points_5")
//	public ModelAndView Bonus_Points5() {
//		
//		ModelAndView model1 = new ModelAndView("Bonus_Points_5");
//		
//		return model1;
//	}
//	
//	@RequestMapping("/Bonus_Points_6")
//	public ModelAndView Bonus_Points6() {
//		
//		ModelAndView model1 = new ModelAndView("Bonus_Points_6");
//		
//		return model1;
//	}
	
	@RequestMapping("/Back_To_User_Profile")
	public String Back_To_User_Profile() {
		return "userProfile";
	}

	
	@RequestMapping(value="listCharacters")
	public String listAllUserCharacters(Model model, HttpSession session) {

		CharacterDAO characterdao = new CharacterDAO();
		String username = (String) session.getAttribute("username");
		
		List<CharacterSheet> listCharacterSheets = characterdao.getAllRecords();
		List<CharacterSheet> usersCharacterSheets = new ArrayList<CharacterSheet>();
		
		
		for (CharacterSheet element: listCharacterSheets) {
			if (element.getUsername().equals(username)){
				usersCharacterSheets.add(element);
			}
		}
		
		List<String> userCharacterNames = new ArrayList<String>();
		
		for (CharacterSheet element: usersCharacterSheets) {
			userCharacterNames.add(element.getCharacterName());
		}
			
		
		model.addAttribute("usersCharacterSheets", usersCharacterSheets);
		model.addAttribute("userCharacterNames", userCharacterNames);
		return "listCharacters";
	}
	

	
	@RequestMapping(value = "Character_Sheet", method = POST)
	public String Character_Sheet(Model model, String Character, HttpServletRequest request) {

		model.addAttribute("CharacterName", Character);

		CharacterDAO characterDAO = new CharacterDAO();
		String currentCharacterName = Character;

		HttpSession session = request.getSession();
		session.setAttribute("currentCharacterName", currentCharacterName);
		
		CharacterSheet currentCharacter = characterDAO.getFromTable(currentCharacterName);
		session.setAttribute("currentCharacter", currentCharacter);

		CharmDAO charmdao = new CharmDAO();

		ServiceMethods servicemethods = new ServiceMethods();
		
		ArrayList<Charms> notOwned = servicemethods.listOfAllCharmsNotOwned(Character);
		ArrayList<Charms> owned = servicemethods.listOfAllCharacterCharms(Character);
		
		ArrayList<String> ownedCharmNames = new ArrayList<>();
		ArrayList<String> notOwnedCharmNames = new ArrayList<>();
		ArrayList<Integer> notOwnedCharmPrice = new ArrayList<>();
		
		for (Charms element : notOwned) {
			notOwnedCharmNames.add(element.getCharmName());
		}
		for (Charms element : notOwned) {
			notOwnedCharmPrice.add(element.getCharmCost());
		}
		for (Charms element : owned) {
			ownedCharmNames.add(element.getCharmName());
		}	
		
		HashMap<String, Integer> buyingoptions = new HashMap<>();
		
		for (Charms element : notOwned) {
			buyingoptions.put(element.getCharmName(), element.getCharmCost());
		}
		
		model.addAttribute("buyingoptions", buyingoptions);
		model.addAttribute("ownedCharms", ownedCharmNames);
		model.addAttribute("notOwnedCharms", notOwnedCharmNames);
		model.addAttribute("notOwnedCharmsPrice", notOwnedCharmPrice);
		model.addAttribute("currentCharacter", currentCharacter);
		model.addAttribute("CharacterStrength", currentCharacter.getStrength());
		model.addAttribute("CharacterDexterity", currentCharacter.getDexterity());
		model.addAttribute("CharacterStamina", currentCharacter.getStamina());
		model.addAttribute("CharacterCharisma", currentCharacter.getCharisma());
		model.addAttribute("CharacterManipulation", currentCharacter.getManipulation());
		model.addAttribute("CharacterAppearance", currentCharacter.getAppearance());
		model.addAttribute("CharacterPerception", currentCharacter.getPerception());
		model.addAttribute("CharacterIntelligence", currentCharacter.getIntelligence());
		model.addAttribute("CharacterWits", currentCharacter.getWits());
		model.addAttribute("XP", currentCharacter.getXP());
		model.addAttribute("XP_Spent", currentCharacter.getXP_Spent());
		
		int blankDotsStrength = 5-currentCharacter.getStrength();
		int blankDotsDexterity = 5-currentCharacter.getDexterity();
		int blankDotsStamina = 5-currentCharacter.getStamina();
		int blankDotsCharisma = 5-currentCharacter.getCharisma();
		int blankDotsManipulation = 5-currentCharacter.getManipulation();
		int blankDotsAppearance = 5-currentCharacter.getAppearance();
		int blankDotsPerception = 5-currentCharacter.getPerception();
		int blankDotsIntelligence = 5-currentCharacter.getIntelligence();
		int blankDotsWits = 5-currentCharacter.getWits();

		model.addAttribute("blankDotsStrength", blankDotsStrength);
		model.addAttribute("blankDotsDexterity", blankDotsDexterity);
		model.addAttribute("blankDotsStamina", blankDotsStamina);
		model.addAttribute("blankDotsCharisma", blankDotsCharisma);
		model.addAttribute("blankDotsManipulation", blankDotsManipulation);
		model.addAttribute("blankDotsAppearance", blankDotsAppearance);
		model.addAttribute("blankDotsPerception", blankDotsPerception);
		model.addAttribute("blankDotsIntelligence", blankDotsIntelligence);
		model.addAttribute("blankDotsWits", blankDotsWits);
		
		int strengthCost = servicemethods.attributeCostCalculator(currentCharacter, "strength");
		int dexterityCost = servicemethods.attributeCostCalculator(currentCharacter, "dexterity");
		int staminaCost = servicemethods.attributeCostCalculator(currentCharacter, "stamina");
		int charismaCost = servicemethods.attributeCostCalculator(currentCharacter, "charisma");
		int manipulationCost = servicemethods.attributeCostCalculator(currentCharacter, "manipulation");
		int appearanceCost = servicemethods.attributeCostCalculator(currentCharacter, "appearance");
		int perceptionCost = servicemethods.attributeCostCalculator(currentCharacter, "perception");
		int intelligenceCost = servicemethods.attributeCostCalculator(currentCharacter, "intelligence");
		int witsCost = servicemethods.attributeCostCalculator(currentCharacter, "wits");
		
		model.addAttribute("dexterityCost", dexterityCost);
		model.addAttribute("strengthCost", strengthCost);
		model.addAttribute("staminaCost", staminaCost);
		model.addAttribute("charismaCost", charismaCost);
		model.addAttribute("manipulationCost", manipulationCost);
		model.addAttribute("appearanceCost", appearanceCost);
		model.addAttribute("perceptionCost", perceptionCost);
		model.addAttribute("intelligenceCost", intelligenceCost);
		model.addAttribute("witsCost", witsCost);
		
		
		
		
		return "Character_Sheet";
	}


	
	
	
//	@RequestMapping(value = "Character_Sheet_XP_Mode")
//	public String Character_Sheet_XP_Mode(Model model) {
//
//
//
//		
//		return "Character_Sheet_XP_Mode";
//	}
	
	@RequestMapping("IncreaseStrength")
	public String IncreaseStregnth(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		String shortage = "you don't have enough XP";
		int tempStrengthCost = servicemethods.attributeCostCalculator(currentCharacter, "strength");
		int currentXP = currentCharacter.getXP();
		
		if (tempStrengthCost <= currentXP) {
			int newXP = currentXP - tempStrengthCost;
			int strength = currentCharacter.getStrength();
			int newStrength = strength + 1;
			int newXP_Spent = tempStrengthCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setStrength(newStrength);
			characterdao.updateRecordInTable(currentCharacter);
			
			updateSheet(model, session, servicemethods);

			return "Character_Sheet";
		} else
			model.addAttribute("shortage", shortage);

		updateSheet(model, session, servicemethods);
		return "Character_Sheet";
	}
	
	@RequestMapping("IncreaseDexterity")
	public String IncreaseDexterity(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempDexterityCost = servicemethods.attributeCostCalculator(currentCharacter, "dexterity");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempDexterityCost <= currentXP) {
		
			int newXP = currentXP - tempDexterityCost;
			int dexterity = currentCharacter.getDexterity();
			int newDexterity = dexterity + 1;
			int newXP_Spent = tempDexterityCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setDexterity(newDexterity);
			characterdao.updateRecordInTable(currentCharacter);
			
			updateSheet(model, session, servicemethods);
			
			return "Character_Sheet";
			
		} else

			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
			
			return "Character_Sheet";
	}
	
	@RequestMapping("IncreaseStamina")
	public String IncreaseStamina(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempStaminaCost = servicemethods.attributeCostCalculator(currentCharacter, "stamina");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempStaminaCost <= currentXP) {
		
			int newXP = currentXP - tempStaminaCost;
			int stamina = currentCharacter.getStamina();
			int newStamina = stamina + 1;
			int newXP_Spent = tempStaminaCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setStamina(newStamina);
			characterdao.updateRecordInTable(currentCharacter);
			
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
		} else
			
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
		
			return "Character_Sheet";
	}
	
	
	@RequestMapping("IncreaseCharisma")
	public String IncreaseCharisma(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempCharismaCost = servicemethods.attributeCostCalculator(currentCharacter, "charisma");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempCharismaCost <= currentXP) {
		
			int newXP = currentXP - tempCharismaCost;
			int charisma = currentCharacter.getCharisma();
			int newCharima = charisma + 1;
			int newXP_Spent = tempCharismaCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setCharisma(newCharima);
			characterdao.updateRecordInTable(currentCharacter);
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
		
		} else 
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
		
			return "Character_Sheet";		
		
	}
	@RequestMapping("IncreaseManipulation")
	public String IncreaseManipulation(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempManipulationCost = servicemethods.attributeCostCalculator(currentCharacter, "manipulation");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempManipulationCost <= currentXP) {
		
			int newXP = currentXP - tempManipulationCost;
			int manipulation = currentCharacter.getManipulation();
			int newManipulation = manipulation + 1;
			int newXP_Spent = tempManipulationCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setManipulation(newManipulation);
			characterdao.updateRecordInTable(currentCharacter);
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
		} else 
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
		
			return "Character_Sheet";
		}
	
	@RequestMapping("IncreaseAppearance")
	public String IncreaseAppearance(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempAppearanceCost = servicemethods.attributeCostCalculator(currentCharacter, "appearance");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempAppearanceCost <= currentXP) {
		
			int newXP = currentXP - tempAppearanceCost;
			int appearance = currentCharacter.getAppearance();
			int newAppearance = appearance + 1;
			int newXP_Spent = tempAppearanceCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setAppearance(newAppearance);
			characterdao.updateRecordInTable(currentCharacter);
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
		} else 
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
		
			return "Character_Sheet";
		}

	
	@RequestMapping("IncreasePerception")
	public String IncreasePerception(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempPerceptionCost = servicemethods.attributeCostCalculator(currentCharacter, "perception");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempPerceptionCost <= currentXP) {
		
			int newXP = currentXP - tempPerceptionCost;
			int perception = currentCharacter.getPerception();
			int newPerception = perception + 1;
			int newXP_Spent = tempPerceptionCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setPerception(newPerception);
			characterdao.updateRecordInTable(currentCharacter);
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
		
		} else 
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
			return "Character_Sheet";
	}
	
	@RequestMapping("IncreaseIntelligence")
	public String IncreaseIntelligence(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempIntelligenceCost = servicemethods.attributeCostCalculator(currentCharacter, "intelligence");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempIntelligenceCost <= currentXP) {
			int newXP = currentXP - tempIntelligenceCost;
			int intelligence = currentCharacter.getIntelligence();
			int newIntelligence = intelligence + 1;
			int newXP_Spent = tempIntelligenceCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setIntelligence(newIntelligence);
			characterdao.updateRecordInTable(currentCharacter);
			updateSheet(model, session, servicemethods);
		return "Character_Sheet";

		} else 
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);	
			return "Character_Sheet";
	}
	
	@RequestMapping("IncreaseWits")
	public String IncreaseWits(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int tempWitsCost = servicemethods.attributeCostCalculator(currentCharacter, "wits");
		int currentXP = currentCharacter.getXP();
		String shortage = "you don't have enough XP";
		
		if (tempWitsCost <= currentXP) {
			int newXP = currentXP - tempWitsCost;
			int wits = currentCharacter.getWits();
			int newWits = wits + 1;
			int newXP_Spent = tempWitsCost + currentCharacter.getXP_Spent();
			
			currentCharacter.setXP_Spent(newXP_Spent);
			currentCharacter.setXP(newXP);
			currentCharacter.setWits(newWits);
			characterdao.updateRecordInTable(currentCharacter);
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
		
		} else 
			model.addAttribute("shortage", shortage);
			updateSheet(model, session, servicemethods);
			return "Character_Sheet";
	}
	
	@RequestMapping("IncreaseXP1")
	public String IncreaseXP(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int currentXP = currentCharacter.getXP();
		int newXP = currentXP + 1;


		currentCharacter.setXP(newXP);
		characterdao.updateRecordInTable(currentCharacter);
		updateSheet(model, session, servicemethods);
		return "Character_Sheet";

	}
	
	@RequestMapping("IncreaseXP5")
	public String IncreaseXP5(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int currentXP = currentCharacter.getXP();
		int newXP = currentXP + 5;


		currentCharacter.setXP(newXP);
		characterdao.updateRecordInTable(currentCharacter);
		updateSheet(model, session, servicemethods);
		return "Character_Sheet";

	}
	
	@RequestMapping("IncreaseXP10")
	public String IncreaseXP10(Model model, HttpSession session) {

		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		ServiceMethods servicemethods = new ServiceMethods();
		
		int currentXP = currentCharacter.getXP();
		int newXP = currentXP + 10;


		currentCharacter.setXP(newXP);
		characterdao.updateRecordInTable(currentCharacter);
		updateSheet(model, session, servicemethods);
		return "Character_Sheet";

	}
	

	@RequestMapping(value = "BuyCharm", method = POST)
	public String BuyCharm(Model model, String charmname, HttpServletRequest request, HttpSession session) {
		
		
		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");
		CharacterDAO characterdao = new CharacterDAO();
		
//		String thisCharacterName = currentCharacter.getCharacterName();
		ServiceMethods servicemethods = new ServiceMethods();
//		ArrayList<Charms> notOwned = servicemethods.listOfAllCharmsNotOwned(thisCharacterName);
//		Integer charmID = notOwned.indexOf(charmname);
		CharacterToCharmDAO charactertocharmdao = new CharacterToCharmDAO();
		int randomNum = ThreadLocalRandom.current().nextInt(10, 9000 + 1);
		CharacterToCharms charactertocharm = new CharacterToCharms(randomNum, 4,currentCharacter.getCharacterName());
		charactertocharmdao.insertIntoTable(charactertocharm);

		int currentXP = currentCharacter.getXP();
		int newXP = currentXP - 6;


		currentCharacter.setXP(newXP);
		characterdao.updateRecordInTable(currentCharacter);
		
		
		updateSheet(model, session, servicemethods);
		
		return "Character_Sheet";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		public static Model updateSheet(Model model, HttpSession session, ServiceMethods servicemethods) {
				
		CharacterSheet currentCharacter = (CharacterSheet) session.getAttribute("currentCharacter");	
		String characterName = currentCharacter.getCharacterName();
		
		
		ArrayList<Charms> notOwned = servicemethods.listOfAllCharmsNotOwned(characterName);
		ArrayList<Charms> owned = servicemethods.listOfAllCharacterCharms(characterName);
		
		ArrayList<String> ownedCharmNames = new ArrayList<>();
		ArrayList<String> notOwnedCharmNames = new ArrayList<>();
		ArrayList<Integer> notOwnedCharmPrice = new ArrayList<>();
		
		for (Charms element : notOwned) {
			notOwnedCharmNames.add(element.getCharmName());
		}
		for (Charms element : notOwned) {
			notOwnedCharmPrice.add(element.getCharmCost());
		}
		for (Charms element : owned) {
			ownedCharmNames.add(element.getCharmName());
		}		
	
		HashMap<String, Integer> buyingoptions = new HashMap<>();
		
		for (Charms element : notOwned) {
			buyingoptions.put(element.getCharmName(), element.getCharmCost());
		}
		
		model.addAttribute("buyingoptions", buyingoptions);
		
		
		
		model.addAttribute("ownedCharms", ownedCharmNames);
		model.addAttribute("notOwnedCharms", notOwnedCharmNames);
		model.addAttribute("notOwnedCharmsPrice", notOwnedCharmPrice);
		model.addAttribute("CharacterName", currentCharacter.getCharacterName());
		model.addAttribute("currentCharacter", currentCharacter);
		model.addAttribute("CharacterStrength", currentCharacter.getStrength());
		model.addAttribute("CharacterDexterity", currentCharacter.getDexterity());
		model.addAttribute("CharacterStamina", currentCharacter.getStamina());
		model.addAttribute("CharacterCharisma", currentCharacter.getCharisma());
		model.addAttribute("CharacterManipulation", currentCharacter.getManipulation());
		model.addAttribute("CharacterAppearance", currentCharacter.getAppearance());
		model.addAttribute("CharacterPerception", currentCharacter.getPerception());
		model.addAttribute("CharacterIntelligence", currentCharacter.getIntelligence());
		model.addAttribute("CharacterWits", currentCharacter.getWits());
		model.addAttribute("XP", currentCharacter.getXP());
		model.addAttribute("XP_Spent", currentCharacter.getXP_Spent());
		
		int blankDotsStrength = 5-currentCharacter.getStrength();
		int blankDotsDexterity = 5-currentCharacter.getDexterity();
		int blankDotsStamina = 5-currentCharacter.getStamina();
		int blankDotsCharisma = 5-currentCharacter.getCharisma();
		int blankDotsManipulation = 5-currentCharacter.getManipulation();
		int blankDotsAppearance = 5-currentCharacter.getAppearance();
		int blankDotsPerception = 5-currentCharacter.getPerception();
		int blankDotsIntelligence = 5-currentCharacter.getIntelligence();
		int blankDotsWits = 5-currentCharacter.getWits();

		model.addAttribute("blankDotsStrength", blankDotsStrength);
		model.addAttribute("blankDotsDexterity", blankDotsDexterity);
		model.addAttribute("blankDotsStamina", blankDotsStamina);
		model.addAttribute("blankDotsCharisma", blankDotsCharisma);
		model.addAttribute("blankDotsManipulation", blankDotsManipulation);
		model.addAttribute("blankDotsAppearance", blankDotsAppearance);
		model.addAttribute("blankDotsPerception", blankDotsPerception);
		model.addAttribute("blankDotsIntelligence", blankDotsIntelligence);
		model.addAttribute("blankDotsWits", blankDotsWits);
		
		
		
		int strengthCost = servicemethods.attributeCostCalculator(currentCharacter, "strength");
		int dexterityCost = servicemethods.attributeCostCalculator(currentCharacter, "dexterity");
		int staminaCost = servicemethods.attributeCostCalculator(currentCharacter, "stamina");
		int charismaCost = servicemethods.attributeCostCalculator(currentCharacter, "charisma");
		int manipulationCost = servicemethods.attributeCostCalculator(currentCharacter, "manipulation");
		int appearanceCost = servicemethods.attributeCostCalculator(currentCharacter, "appearance");
		int perceptionCost = servicemethods.attributeCostCalculator(currentCharacter, "perception");
		int intelligenceCost = servicemethods.attributeCostCalculator(currentCharacter, "intelligence");
		int witsCost = servicemethods.attributeCostCalculator(currentCharacter, "wits");
		
		model.addAttribute("dexterityCost", dexterityCost);
		model.addAttribute("strengthCost", strengthCost);
		model.addAttribute("staminaCost", staminaCost);
		model.addAttribute("charismaCost", charismaCost);
		model.addAttribute("manipulationCost", manipulationCost);
		model.addAttribute("appearanceCost", appearanceCost);
		model.addAttribute("perceptionCost", perceptionCost);
		model.addAttribute("intelligenceCost", intelligenceCost);
		model.addAttribute("witsCost", witsCost);
		
		return model;
		
	}
	
	
	
	
	
}
