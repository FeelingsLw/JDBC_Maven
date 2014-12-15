package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.model.InfoSingle;

//��ʼ����ҳ�����˵����̨�����˵��б��ѡ��
public class OpDB {
	private DB mydb = new DB();

	public TreeMap OpGetListBox(String sql, Object[] params) {
		TreeMap typeMap = new TreeMap();
		
		mydb.doPstm(sql, params);
		try {
			ResultSet rs = mydb.getRs();
			if (rs != null) {
				while (rs.next()) {
					int sign = rs.getInt("type_sign");				// ��ȡ��ǰ ��¼�е�type_sign����
					String intro = rs.getString("type_intro"); 		// ��ȡ��ǰ��¼�е�type_intro����
					typeMap.put(sign, intro);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeMap;
	}
	// ��ȡ��Ϣ�б�
	public List OpListShow(String sql, Object[] params) {
		List onelist = new ArrayList();
		mydb.doPstm(sql, params);
		try {
			ResultSet rs = mydb.getRs();
			if (rs != null) {
				while (rs.next()) {
					InfoSingle infoSingle=new InfoSingle();
					infoSingle.setId(rs.getInt("id"));	 						
					infoSingle.setInfo_type(rs.getInt("info_type"));			
					infoSingle.setInfo_title(rs.getString("info_title"));
					infoSingle.setInfo_content(rs.getString("info_content"));
					infoSingle.setInfo_linkman(rs.getString("info_linkman"));
					infoSingle.setInfo_phone(rs.getString("info_phone"));
					infoSingle.setInfo_email(rs.getString("info_email"));
					infoSingle.setInfo_date(rs.getDate("info_date"));
					infoSingle.setInfo_state(rs.getString("info_state"));
					infoSingle.setInfo_payfor(rs.getString("info_payfor"));
					onelist.add(infoSingle);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return onelist;
	}
	
	// ��ȡ��Ϣ��ϸ����
	
	public InfoSingle OpSingleShow(String sql,Object[]params){
		InfoSingle infoSingle=null;
		mydb.doPstm(sql, params);
		try {
			ResultSet rs = mydb.getRs();
			if (rs != null&&rs.next()) {
				
					infoSingle=new InfoSingle();
					infoSingle.setId(rs.getInt("id"));	 						
					infoSingle.setInfo_type(rs.getInt("info_type"));			
					infoSingle.setInfo_title(rs.getString("info_title"));
					infoSingle.setInfo_content(rs.getString("info_content"));
					infoSingle.setInfo_linkman(rs.getString("info_linkman"));
					infoSingle.setInfo_phone(rs.getString("info_phone"));
					infoSingle.setInfo_email(rs.getString("info_email"));
					infoSingle.setInfo_date(rs.getDate("info_date"));
					infoSingle.setInfo_state(rs.getString("info_state"));
					infoSingle.setInfo_payfor(rs.getString("info_payfor"));
					rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoSingle;
	}
	//����ɾ������Ϣ
	public int OpUpdate(String sql,Object[]params){
		int i=-1;
		try{
			mydb.doPstm(sql, params);
			i=mydb.getCount();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	
	//��֤��¼
	public boolean LogOn(String sql,Object[]params){
		mydb.doPstm(sql, params);
		boolean mark=false;
		ResultSet rs;
		try {
			rs = mydb.getRs();
			mark=(rs==null||!rs.next()?false:true);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mark;
	}
}
