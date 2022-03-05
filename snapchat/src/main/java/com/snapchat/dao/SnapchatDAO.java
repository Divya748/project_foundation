package com.snapchat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.snapchat.entity.SnapchatUser;

public class SnapchatDAO implements SnapchatDAOInterface {

	public int createProfileDAO(SnapchatUser su) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl");
			
			//step 3 create query
			//for static query we will use Statement interface
			//for dynamic query we will use PreparedStatement interface
			//statement will run static query i.e. every time it will compile query
			//however PreparedStatement run dynamic query i.e. it will use pre compiled query 
			//will not compile query for every request
			PreparedStatement ps=con.prepareStatement("insert into snapchatuser values(?,?,?,?)");
			ps.setString(1, su.getName());
			ps.setString(2, su.getPassword());
			ps.setString(3, su.getEmail());
			ps.setString(4, su.getAddress());
			
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public SnapchatUser viewProfileDAO(SnapchatUser su) {
		SnapchatUser s2=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl");
			PreparedStatement ps=con.prepareStatement("select * from snapchatuser where email=?");
			ps.setString(1, su.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				s2=new SnapchatUser();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s2;
	}

	public int deleteProfileDAO(SnapchatUser su) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl");
			
			PreparedStatement ps=con.prepareStatement("delete from snapchatuser where email=?");
			ps.setString(1, su.getEmail());
						
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<SnapchatUser> viewAllProfileDAO() {
		SnapchatUser s2=null;
		ArrayList<SnapchatUser> ll=new ArrayList<SnapchatUser>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl");
			PreparedStatement ps=con.prepareStatement("select * from snapchatuser");
						
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				s2=new SnapchatUser();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
				
				ll.add(s2);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

}

















