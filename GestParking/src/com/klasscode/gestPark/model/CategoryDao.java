package com.klasscode.gestPark.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.klasscode.gestPark.bean.CategoryBean;

public class CategoryDao extends DAO<CategoryBean> {

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(CategoryBean object) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO category(category_name) VALUES(?)";

		try (PreparedStatement ps = this.dbConn.prepareStatement(sql)) {

			ps.setString(1, object.getCategoryName());

			ps.executeUpdate();
			this.dbConn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean update(CategoryBean object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CategoryBean select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryBean> selectAll() {
		// TODO Auto-generated method stub
		List<CategoryBean> categorys = new ArrayList<>();

		String sql = "SELECT * FROM category";
		try (PreparedStatement ps = this.dbConn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				categorys.add(new CategoryBean(rs.getInt("id"), rs.getString("category_name")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorys;
	}

}