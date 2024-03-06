package com.jspiders.springmvcfindcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvcfindcars.pojo.AdminPOJO;
import com.jspiders.springmvcfindcars.pojo.CarPOJO;

@Repository
public class CarRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("Vilen");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory!=null) {
			factory.close();
		}
		if (manager!=null) {
			manager.close();
		}
		if (transaction!=null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public List<CarPOJO> findAllCars() {
		openConnection();
		transaction.begin();
		
		String jpql="from CarPOJO";
		query=manager.createQuery(jpql);
		List<CarPOJO> cars = query.getResultList();
		
		transaction.commit();
		closeConnection();
		return cars;
	}

	public CarPOJO addCar(String name, String brand, String fuelType, double price) {
		openConnection();
		transaction.begin();
		
		CarPOJO car= new CarPOJO();
		car.setName(name);
		car.setBrand(brand);
		car.setFuelType(fuelType);
		car.setPrice(price);
		
		manager.persist(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO searchCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPOJO car=manager.find(CarPOJO.class, id);
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO removeCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPOJO pojo=manager.find(CarPOJO.class, id);
		manager.remove(pojo);
		
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, double price) {
		openConnection();
		transaction.begin();
		
		CarPOJO pojo= manager.find(CarPOJO.class, id);
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setFuelType(fuelType);
		pojo.setPrice(price);
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		return pojo;
	}
}
