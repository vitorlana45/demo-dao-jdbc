package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	// injetando a dependencia atraves de um construtor
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {

	}

	@Override
	public void updated(Department obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT department.*,department.Name AS DepName FROM department " + "WHERE department.Id = ?");
			st.setInt(1, 4);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				return dep;

			}
			System.out.println("Deu Erro a busca");
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Department> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT department.* FROM department");
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("Id"));
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("Id"), dep);
				}
				Department obj = instantiateDepartment(rs);
				list.add(obj);
			}
			return list;
			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		// passando a exception pra minha funcao que ira chamar esse metodo auxiliar

		Department obj = new Department();
		obj.setId(rs.getInt("id"));
		obj.setName(rs.getString("Name"));

		return obj;

	}

}
