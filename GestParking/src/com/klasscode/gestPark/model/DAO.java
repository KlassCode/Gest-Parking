package com.klasscode.gestPark.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.klasscode.gestPark.utils.JDBCUtils;

public abstract class DAO<T> {

	protected Connection dbConn;

	public DAO() {

		this.dbConn = JDBCUtils.getConnection();

	}

	public Connection getConn() {
		return dbConn;
	}

	public abstract void insert(T object);

	public abstract T select(int id);

	public abstract List<T> selectAll();

	public abstract boolean update(T object);

	public abstract boolean delete(int id);
}