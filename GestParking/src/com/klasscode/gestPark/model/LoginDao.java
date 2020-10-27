package com.klasscode.gestPark.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.klasscode.gestPark.bean.LoginBean;
import com.klasscode.gestPark.utils.JDBCUtils;

public class LoginDao {

	public boolean validate(LoginBean log) {

		boolean status = false;

		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

		try (PreparedStatement pr = JDBCUtils.getConnection().prepareStatement(sql)) {

			pr.setString(1, log.getUsername());
			pr.setString(2, log.getPassword());

			try (ResultSet rs = pr.executeQuery()) {
				status = rs.next();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}
}
