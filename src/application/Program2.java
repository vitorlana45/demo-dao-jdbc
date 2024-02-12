package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
	
		
		// criando a minha conexao com banco de dados 
		DepartmentDao departmentDao = DaoFactory.creatDepatmentDao();
		//
		
		System.out.println("=== TEST 1 Department findById ====");	
		Department department = departmentDao.findById(4);
		System.out.println(department);
		
		
		System.out.println("\n=== TEST 2 department FindAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		
	}

}
