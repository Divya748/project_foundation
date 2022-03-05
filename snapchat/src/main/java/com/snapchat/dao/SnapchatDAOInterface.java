package com.snapchat.dao;

import java.util.ArrayList;

import com.snapchat.entity.SnapchatUser;

public interface SnapchatDAOInterface {

	int createProfileDAO(SnapchatUser su);

	SnapchatUser viewProfileDAO(SnapchatUser su);

	int deleteProfileDAO(SnapchatUser su);

	ArrayList<SnapchatUser> viewAllProfileDAO();

}
