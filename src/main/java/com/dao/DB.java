package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DB {
	private Connection con;
	private PreparedStatement pstm;
	private String user = "root";
	private String password = "";
	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_cityinfo";
	private static final Logger logger = Logger.getLogger(DB.class);

	// ��newʵ��ʱ����Driver
	public DB() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.info("����Driverʧ��");
			e.printStackTrace();
		}
	}

	// ��ȡ����
	public Connection getCon() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			con = null;
			logger.info("getCon()��ȡ����ʧ��");
			e.printStackTrace();
		}
		return con;
	}

	// �����ݿ�����ɾ���ġ���ķ���
	public void doPstm(String sql, Object[] params) {
		if (sql != null && sql.equals("")) {
			if (params != null) {
				params = new Object[0];
			}
			getCon();
			if (con != null) {
				try {
					pstm = con.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					for (int i = 0; i < params.length; i++) {
						pstm.execute();
					}
				} catch (SQLException e) {
					logger.info("doPstm()����ʧ��");
					e.printStackTrace();
				}
			}
		}
	}

	// ��ȡ��ѯ�����
	public ResultSet getRs() throws SQLException {
		return pstm.getResultSet();
	}

	// ��ȡӰ��ļ�¼��
	public int getCount() throws SQLException {
		return pstm.getUpdateCount();
	}
}