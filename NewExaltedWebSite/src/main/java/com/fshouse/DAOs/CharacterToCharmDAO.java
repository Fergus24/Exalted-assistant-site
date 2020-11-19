package com.fshouse.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fshouse.models.CharacterToCharms;

public class CharacterToCharmDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewExaltedWebSite");  		// project name
	private EntityManager entityManager = emf.createEntityManager();                                       	//used in all table interactions
	private EntityTransaction entityTransaction = entityManager.getTransaction();                          	//used in all interactions which change table contents
		
	public void insertIntoTable(CharacterToCharms newID)
	{
		CharacterToCharms objectFromTable = getFromTable(newID.getNewID());
		if(objectFromTable ==null)
		{
			entityTransaction.begin();																			//starts table entry
			entityManager.persist(newID);
			entityTransaction.commit();																			//commits table, required after begin
		}
	}
		
	public CharacterToCharms getFromTable(int newID)
	{
		CharacterToCharms objectFromTable = null;
		objectFromTable = entityManager.find(CharacterToCharms.class, newID);
		return objectFromTable;
	}
	public void deleteFromTable(int newID)
	{
		CharacterToCharms objectToDelete = getFromTable(newID);
		if(objectToDelete !=null)
		{
			entityTransaction.begin();
			entityManager.remove(objectToDelete);
			entityTransaction.commit();
		}
	}
	public void updateRecordInTable(CharacterToCharms newID)
	{
		CharacterToCharms existingVersion = getFromTable(newID.getCharmID());											//ensures only to update if the object exists in table
		if(existingVersion !=null)
		{
			entityTransaction.begin();
			entityManager.merge(newID);																	// would run insert if does not exist in table
			entityTransaction.commit();
		}
	}
	public List<CharacterToCharms> getAllRecords()
	{
		String jpql = "select u from CharacterToCharms u";															// this is jpql not sql
		TypedQuery<CharacterToCharms> selectAllQuery = entityManager.createQuery(jpql,CharacterToCharms.class);
		List<CharacterToCharms> characterToCharms = selectAllQuery.getResultList();
		return characterToCharms;
	}
	
}
