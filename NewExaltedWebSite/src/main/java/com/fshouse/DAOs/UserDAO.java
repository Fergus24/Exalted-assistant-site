package com.fshouse.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fshouse.models.User;

 

public class UserDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewExaltedWebSite");  		// project name
	private EntityManager entityManager = emf.createEntityManager();                                       	// used in all table interactions
	private EntityTransaction entityTransaction = entityManager.getTransaction();                          	// used in all interactions which change table contents
		
	public void insertIntoTable(User theUser)
	{
		User objectFromTable = getFromTable(theUser.getUsername());
		if(objectFromTable ==null)
		{
			entityTransaction.begin();																			//starts table entry
			entityManager.persist(theUser);
			entityTransaction.commit();																			//commits table, required after begin
		}
	}
		
	public User getFromTable(String username)
	{
		User objectFromTable = null;
		objectFromTable = entityManager.find(User.class, username);
		return objectFromTable;
	}
	public void deleteFromTable(String username)
	{
		User objectToDelete = getFromTable(username);
		if(objectToDelete !=null)
		{
			entityTransaction.begin();
			entityManager.remove(objectToDelete);
			entityTransaction.commit();
		}
	}
	public void updateRecordInTable(User newUser)
	{
		User existingVersion = getFromTable(newUser.getUsername());											//ensures only to update if the object exists in table
		if(existingVersion !=null)
		{
			entityTransaction.begin();
			entityManager.merge(newUser);																	// would run insert if does not exist in table
			entityTransaction.commit();
		}
	}
	public List<User> getAllRecords()
	{
		String jpql = "select u from accounts u";															// this is jpql not sql
		TypedQuery<User> selectAllQuery = entityManager.createQuery(jpql,User.class);
		List<User> users = selectAllQuery.getResultList();
		return users;
	}
}

	
	

