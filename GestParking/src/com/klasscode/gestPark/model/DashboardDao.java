package com.klasscode.gestPark.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.klasscode.gestPark.bean.CategoryBean;
import com.klasscode.gestPark.bean.SlotBean;
import com.klasscode.gestPark.utils.JDBCUtils;

public class DashboardDao {

	private Connection conn = JDBCUtils.getConnection();

	public DashboardDao() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addSlot(SlotBean slot) {

		String sql = "INSERT INTO slot(no_slot,dispo) VALUES(?,?)";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, slot.getNoSlot());
			ps.setBoolean(2, slot.isDispo());

			ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkExistSlot(int slotNo) {

		boolean resp = false;

		String sql = "Select * from slot where no_slot = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, slotNo);

			try (ResultSet rs = ps.executeQuery()) {
				resp = rs.next();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resp;
	}

	public int getAvailableSlot() {

		int nb = 0;

		String sql = "Select count(*) as nb from slot where dispo = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setBoolean(1, true);

			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					nb = rs.getInt("nb");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nb;
	}

	public List<SlotBean> getAllSlots() {
		// TODO Auto-generated method stub
		List<SlotBean> slots = new ArrayList<>();

		String sql = "SELECT * FROM slot WHERE dispo = 1";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				slots.add(new SlotBean(rs.getInt("id"), rs.getInt("no_slot"),rs.getBoolean("dispo")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slots;
	}
}
