package com.jspiders.springmvcfindcars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvcfindcars.pojo.CarPOJO;
import com.jspiders.springmvcfindcars.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository  repository;

	public List<CarPOJO> findAllCars() {
		List<CarPOJO>cars=repository.findAllCars();
		return cars;
	}

	public CarPOJO addCar(String name, String brand, String fuelType, double price) {
		CarPOJO admin=repository.addCar(name,brand,fuelType,price);
		return admin;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo=repository.searchCar(id);
		return pojo;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO pojo=repository.removeCar(id);
		return pojo;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, double price) {
		CarPOJO pojo= repository.updateCar(id,name,brand,fuelType,price);
		return pojo;
	}
}
