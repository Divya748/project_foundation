package com.snapchat.service;

import java.util.ArrayList;

import com.snapchat.dao.SnapchatDAO;
import com.snapchat.dao.SnapchatDAOInterface;
import com.snapchat.entity.SnapchatUser;

public class SnapchatService implements SnapchatServiceInterface {

	public int createProfileService(SnapchatUser su) {
		SnapchatDAOInterface sd=new SnapchatDAO();
		int i=sd.createProfileDAO(su);
		return i;
	}

	public SnapchatUser viewProfileService(SnapchatUser su) {
		SnapchatDAOInterface sd=new SnapchatDAO();
		SnapchatUser s=sd.viewProfileDAO(su);
		return s;
	}

	public int deleteProfileService(SnapchatUser su) {
		SnapchatDAOInterface sd=new SnapchatDAO();
		int i=sd.deleteProfileDAO(su);
		return i;
	}

	public ArrayList<SnapchatUser> viewAllProfileService() {
		SnapchatDAOInterface sd=new SnapchatDAO();
		ArrayList<SnapchatUser> s=sd.viewAllProfileDAO();
		return s;
	}

}













