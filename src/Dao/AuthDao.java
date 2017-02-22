package Dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import models.Beans;
import ravi.util.DBConnectionManager;

public class AuthDao {
	public static void createBean(Beans bean) throws SQLException{
         Connection con = (Connection) DBConnectionManager.getConnection();
         PreparedStatement ps=null;
         String query1 = "INSERT INTO marketplace(partner, baseUrl, uuid, openId, email) VALUES (?,?,?,?,?)";
         String query2= "INSERT INTO company(uuid,name,email,phone,website,country,m_uuid) VALUES (?,?,?,?,?,?,?) ";
         ps = (PreparedStatement) con.prepareStatement(query1);
         ps.setString(1, bean.getMarketplace().getPartner());
         ps.setString(2, bean.getMarketplace().getBaseUrl());
         ps.setString(3, bean.getCreator().getUuid());
         ps.setString(4, bean.getCreator().getOpenId());
         ps.setString(5, bean.getCreator().getEmail());
         ps.executeUpdate();
         
         ps = (PreparedStatement) con.prepareStatement(query2);
         ps.setString(1, bean.getPayload().getCompany().getUuid());
         ps.setString(2, bean.getPayload().getCompany().getName());
         ps.setString(3, bean.getPayload().getCompany().getEmail());
         ps.setString(4, bean.getPayload().getCompany().getPhoneNumber());
         ps.setString(5, bean.getPayload().getCompany().getWebsite());
         ps.setString(6, bean.getPayload().getCompany().getCountry());
         ps.setString(7, bean.getCreator().getUuid());
         ps.executeUpdate();
	}
}