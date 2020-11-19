package com.fshouse.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fshouse.models.Charms;

public class CharmDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewExaltedWebSite");  		// project name
	private EntityManager entityManager = emf.createEntityManager();                                       	//used in all table interactions
	private EntityTransaction entityTransaction = entityManager.getTransaction();                          	//used in all interactions which change table contents
		
	public void insertIntoTable(Charms theCharm)
	{
		Charms objectFromTable = getFromTable(theCharm.getCharmID());
		if(objectFromTable ==null)
		{
			entityTransaction.begin();																			//starts table entry
			entityManager.persist(theCharm);
			entityTransaction.commit();																			//commits table, required after begin
		}
	}
		
	public Charms getFromTable(int CharmID)
	{
		Charms objectFromTable = null;
		objectFromTable = entityManager.find(Charms.class, CharmID);
		return objectFromTable;
	}
	public void deleteFromTable(int CharmID)
	{
		Charms objectToDelete = getFromTable(CharmID);
		if(objectToDelete !=null)
		{
			entityTransaction.begin();
			entityManager.remove(objectToDelete);
			entityTransaction.commit();
		}
	}
	public void updateRecordInTable(Charms newCharm)
	{
		Charms existingVersion = getFromTable(newCharm.getCharmID());											//ensures only to update if the object exists in table
		if(existingVersion !=null)
		{
			entityTransaction.begin();
			entityManager.merge(newCharm);																	// would run insert if does not exist in table
			entityTransaction.commit();
		}
	}
	public List<Charms> getAllRecords()
	{
		String jpql = "select u from Charms u";															// this is jpql not sql
		TypedQuery<Charms> selectAllQuery = entityManager.createQuery(jpql,Charms.class);
		List<Charms> charms = selectAllQuery.getResultList();
		return charms;
	}
}
	

