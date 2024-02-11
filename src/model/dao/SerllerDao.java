package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SerllerDao {

	
	void insert (Seller obj);
	void updated (Seller obj);
	void deleteById (Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();	
	
}