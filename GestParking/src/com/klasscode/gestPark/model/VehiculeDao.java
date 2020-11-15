package com.klasscode.gestPark.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.klasscode.gestPark.bean.VehiculeBean;

public class VehiculeDao extends DAO<VehiculeBean> {

	@Override
	public void insert(VehiculeBean object) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO vehicule(id_category,id_slot,company_name,proprio_name,proprio_mail,in_parking) VALUES(?,?,?,?,?,?)	";
		
		try(PreparedStatement ps = this.dbConn.prepareStatement(sql)){
			
			ps.setInt(1, object.getCategory().getId());
			ps.setInt(2, object.getSlot().getId());
			ps.setString(3, object.getCompagnyName());
			ps.setString(4,object.getProprioName());
			ps.setString(5, object.getProprioMail());
			ps.setBoolean(6, object.isInParking());
			
			ps.executeUpdate();
			this.dbConn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public VehiculeBean select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehiculeBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(VehiculeBean object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int lastInsert() {
		// TODO Auto-generated method stub
		int id =0;
		String sql = "SELECT id FROM vehicule ORDER BY id DESC;";
		
		try(PreparedStatement ps = this.dbConn.prepareStatement(sql);ResultSet rs= ps.executeQuery()){
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

//	public List<VehiculeBean> selectIncomingVehicule() {
//		// TODO Auto-generated method stub
//		
//		List<VehiculeBean> vehc = new ArrayList<>();
//		String sql = "SELECT * FROM vehicule WHE"
//	}

}
