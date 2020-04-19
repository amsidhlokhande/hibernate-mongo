package com.amsidh.mvc.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {

	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
	}

	public static void main(String[] args) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		// Create first client.
		Client client = new Client("Juan", "Re-pollo", "jrepo@uni.es", "Av Luz 12", "BANKINTER");

		// Store initial.
		Store foodStore = new Store("FoodStore", "Storage for food", new Date(), new BigDecimal("12500.58"),
				new Purchase("Rice", new Date(), new BigDecimal("13.63"), new BigDecimal("2.25")),
				new Purchase("Vegetables", new Date(), new BigDecimal("19.21"), new BigDecimal("1.89")),
				new Purchase("spaghetti", new Date(), new BigDecimal("95.66"), new BigDecimal("2.74")));

		Store electronicStore = new Store("ElectronicStore", "Storage for articles Electronic", new Date(),
				new BigDecimal("145007.84"),
				new Purchase("PC", new Date(), new BigDecimal("685.19"), new BigDecimal("95.97")),
				new Purchase("Tablet", new Date(), new BigDecimal("502.63"), new BigDecimal("62.98")),
				new Purchase("Mouse", new Date(), new BigDecimal("54.21"), new BigDecimal("12.87")),
				new Purchase("Raspberry", new Date(), new BigDecimal("49.99"), new BigDecimal("22.41")),
				new Purchase("Multimeter", new Date(), new BigDecimal("39.33"), new BigDecimal("8.23")));
		
		foodStore.setBuyer( client );
		client.getPurchases().add( foodStore );
		
		electronicStore.setBuyer( client );
		client.getPurchases().add( electronicStore );
		
		// Use persistence to store stores, will be cascaded to purchaes, and commit operations
		entityManager.persist( client );
		entityManager.getTransaction().commit();
		
		// close entity
		entityManager.close();
		
		entityManagerFactory.close();
		
	}

}
