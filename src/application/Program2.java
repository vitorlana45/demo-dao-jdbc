package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		// criando a minha conexao com banco de dados 
		DepartmentDao departmentDao = DaoFactory.creatDepatmentDao();
		
		System.out.println("=== TEST Department findById ====");	
		Department department = departmentDao.findById(4);
		System.out.println(department);
	}

}
