package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;



public class Program {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        
    	SellerDao sellerDao = DaoFactory.creatSellerDao();
    	
    	System.out.println("=== TEST 1: Seller findById ====");
    	Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println("\n=== TEST 2: Seller findById ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        
        for (Seller obj : list) {
        	System.out.println(obj);
        }
        
        System.out.println("\n=== TEST 3: Seller findAll ====");
        list = sellerDao.findAll();
        
        for (Seller obj : list) {
        	System.out.println(obj);
        }
        
        System.out.println("\n=== TEST 4: Seller insert ====");
        Seller newSeller = new Seller(null, "Fred", "Fred@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        
        System.out.println("Inserted new id = " + newSeller.getId());
        
        
        
        System.out.println("\n=== TEST 5: Seller update ====");
        // pegando o usuario Id 1 
        seller = sellerDao.findById(1);
        //setando alterando o nome dele 
        seller.setName("jones horf");
        //carregando os dados mudados
        sellerDao.updated(seller);
        System.out.println("Updated completed");
        
        System.out.println("\n=== TEST 6: Seller delete ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
    
    }
}
