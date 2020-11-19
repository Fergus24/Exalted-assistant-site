package com.fshouse.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fshouse.models.CharacterSheet;

public class CharacterDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewExaltedWebSite");  				// project name
	private EntityManager entityManager = emf.createEntityManager();                                       			//used in all table interactions
	private EntityTransaction entityTransaction = entityManager.getTransaction();                          			//used in all interactions which change table contents
		
	public void insertIntoTable(CharacterSheet theCharacter)
	{
		CharacterSheet objectFromTable = getFromTable(theCharacter.getCharacterName());
		if(objectFromTable ==null)
		{
			entityTransaction.begin();																				//starts table entry
			entityManager.persist(theCharacter);
			entityTransaction.commit();																				//commits table, required after begin
		}
	}
		
	public CharacterSheet getFromTable(String CharacterName)
	{
		CharacterSheet objectFromTable = null;
		objectFromTable = entityManager.find(CharacterSheet.class, CharacterName);
		return objectFromTable;
	}
	
	public void deleteFromTable(String CharacterName)
	{
		CharacterSheet objectToDelete = getFromTable(CharacterName);
		if(objectToDelete !=null)
		{
			entityTransaction.begin();
			entityManager.remove(objectToDelete);
			entityTransaction.commit();
		}
	}
	public void updateRecordInTable(CharacterSheet newCharacterSheet)
	{
		CharacterSheet existingVersion = getFromTable(newCharacterSheet.getCharacterName());						//ensures only to update if the object exists in table
		if(existingVersion !=null)
		{
			entityTransaction.begin();
			entityManager.merge(newCharacterSheet);																	// insert if no table
			entityTransaction.commit();
		}
	}
	public List<CharacterSheet> getAllRecords()
	{
		String jpql = "select u from CharacterSheet u";																	// this is jpql not sql
		TypedQuery<CharacterSheet> selectAllQuery = entityManager.createQuery(jpql,CharacterSheet.class);
		List<CharacterSheet> CharacterSheets = selectAllQuery.getResultList();
		return CharacterSheets;
	}
}