package com.citiustech.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.citiustech.entity.Employee;

public class EmployeeDao {

	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-demo");
		Runtime.getRuntime().addShutdownHook(new Thread(() -> entityManagerFactory.close()));
	}
	
	public void add(Employee emp) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			entityManager.persist(emp); //persist generates insert query
			
			tx.commit();
		}
		finally {
			entityManager.close();
		}
	}
}
