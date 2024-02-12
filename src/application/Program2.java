package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner (System.in);
		
		// criando a minha conexao com banco de dados 
		DepartmentDao departmentDao = DaoFactory.creatDepatmentDao();
		//
		
		System.out.println("=== TEST 1 Department findById ====");	
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		
		System.out.println("\n=== TEST 2 department FindAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3 department insert  ====");
		Department newDepartment = new Department(null,"Hotel");
		departmentDao.insert(newDepartment);
		
		 System.out.println("Inserted new id = " + newDepartment.getId());
		
		
		
		System.out.println("\n=== TEST 4 department Update  ====");
		// id do usuario a ser atualizado
		department = departmentDao.findById(4);
		department.setName("Mecanica");
		departmentDao.updated(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5 department Delete  ====");
		System.out.print("Enter the id from delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Complete");
	}

}
