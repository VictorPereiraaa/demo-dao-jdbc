package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Main2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== department insert ===");
		Department dep = new Department(null, "Music");
		depDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());
		
		System.out.println("=== department update ===");
		dep = depDao.findById(2);
		dep.setName("Clothing");
		depDao.update(dep);
		System.out.println("Updated completed!");
		
		System.out.println("=== department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
		
		System.out.println("=== department findById ===");
		dep = depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("=== department findAll ===");
		List<Department> list = depDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		
	}
}
