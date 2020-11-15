package com.klasscode.gestPark.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.klasscode.gestPark.bean.ParkingBean;

public class ParkingDao extends DAO<ParkingBean>{

	@Override
	public void insert(ParkingBean object) {
		// TODO Auto-generated method stub
		
String sql = "INSERT INTO parking(id_vehicule,parking_code,parking_date,parking_charge,action,remarque) VALUES(?,?,?,?,?,?)";
		
		try(PreparedStatement ps = this.dbConn.prepareStatement(sql)){
			
			ps.setInt(1, object.getVehicule().getId());
			ps.setString(2, object.getParkingCode());
			ps.setObject(3,object.getParkingDate());
			ps.setDouble(4, object.getParkingCharge());
			ps.setString(5,object.getAction());
			ps.setString(6, object.getRemarque());
			
			ps.executeUpdate();
			this.dbConn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ParkingBean select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ParkingBean object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
