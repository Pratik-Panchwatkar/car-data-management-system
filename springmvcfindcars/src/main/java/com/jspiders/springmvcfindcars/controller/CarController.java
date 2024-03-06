package com.jspiders.springmvcfindcars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvcfindcars.pojo.AdminPOJO;
import com.jspiders.springmvcfindcars.pojo.CarPOJO;
import com.jspiders.springmvcfindcars.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService service;

	// Home Page Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

	// Add Page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			if (cars.isEmpty() == false) {
				map.addAttribute("cars", cars);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

	// Add Car Controller
	@PostMapping("/add")
	public String addCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map,
			@RequestParam String name, @RequestParam String brand, @RequestParam String fuelType,
			@RequestParam double price) {
		if (admin != null) {
			CarPOJO pojo = service.addCar(name, brand, fuelType, price);

			// Success
			if (pojo != null) {
				map.addAttribute("msg", "Data Inserted Successfully..!");
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars", cars);
				return "Add";
			}
			// Failure
			map.addAttribute("msg", "Data does not inserted..!");
			List<CarPOJO> cars = service.findAllCars();
			if (cars != null) {
				map.addAttribute("cars", cars);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

	// Search Page Controller
	@GetMapping("/search")
	public String search(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			
			return "Search";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

	// Search Car Controller
	@PostMapping("/search")
	public String searchCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(id);

			if (pojo != null) {
				map.addAttribute("car", pojo);
				map.addAttribute("msg", "Car Data Found successfully..!");
				return "Search";
			}
			map.addAttribute("msg", "Car Data does not found..!");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}
	
	//Remove page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			// Success
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Remove";
			}
			map.addAttribute("msg", "No Data Present..!");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive Timeout");
		return "Login";
	}

	// Remove Car Controller
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			ModelMap map) {
		
		if (admin != null) {
			CarPOJO pojo = service.removeCar(id);
			List<CarPOJO> cars = service.findAllCars();
			// Success
			if (pojo != null) {
				map.addAttribute("cars", cars);
				map.addAttribute("msg", "Data Removed Successfully..!");
				return "Remove";
			}
			// Failure
			map.addAttribute("msg", "Data does not exists..!");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "session inactive Timeout");
		return "Login";
	}

	// Update Page Controller
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

	// Update Form Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map,
			@RequestParam int id) {
		
		if (admin != null) {
			CarPOJO pojo = service.searchCar(id);
			// Success
			if (pojo != null) {
				map.addAttribute("car", pojo);
				return "Update";
			}
			// Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car data Does not Found..!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

	// Update Car Controller
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
																	@RequestParam String name,
																	@RequestParam String brand,
																	@RequestParam String fuelType,
																	@RequestParam double price, ModelMap map) {
		

		if (admin != null) {
			CarPOJO pojo = service.updateCar(id, name, brand, fuelType, price);
			// Success
			if (pojo != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("msg", "Data Updated Successfully..!");
				map.addAttribute("cars", cars);
				return "Update";
			}
			// Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "Data Does not updated..!");
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive Timeout..!");
		return "Login";
	}

}
