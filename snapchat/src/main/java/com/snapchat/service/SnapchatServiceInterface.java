package com.snapchat.service;

import java.util.ArrayList;

import com.snapchat.entity.SnapchatUser;

public interface SnapchatServiceInterface {

	int createProfileService(SnapchatUser su);

	SnapchatUser viewProfileService(SnapchatUser su);

	int deleteProfileService(SnapchatUser su);

	ArrayList<SnapchatUser> viewAllProfileService();

}
