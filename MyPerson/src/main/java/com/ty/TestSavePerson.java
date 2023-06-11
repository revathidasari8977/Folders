package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePerson {
	public static void main(String[] args) {
		
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=new Person();
		person.setId(103);
		person.setName("Madhu");
		person.setAge(22);
		person.setGender("female");
		person.setPhno(783475698l);
		person.setEmail("madhu@gmail.com");
		
		
		
		entityTransaction.begin();
		entityManager.persist(person);
		
		
		entityTransaction.commit();

		
	}

}
