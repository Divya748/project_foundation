package com.snapchat.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.snapchat.entity.SnapchatUser;
import com.snapchat.service.SnapchatService;
import com.snapchat.service.SnapchatServiceInterface;

public class SnapChatController implements SnapchatControllerInterface {

	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		
		SnapchatUser su=new SnapchatUser();
		su.setName(name);
		su.setPassword(password);
		su.setEmail(email);
		su.setAddress(address);
		
		SnapchatServiceInterface ss=new SnapchatService();
		
		int i=ss.createProfileService(su);
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}

	}

	public void viewProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email to view profile");
		String email=sc.next();
		
		SnapchatUser su=new SnapchatUser();
		su.setEmail(email);
		
		SnapchatServiceInterface ss=new SnapchatService();
		SnapchatUser s1=ss.viewProfileService(su);
		
		if(s1!=null) {
			System.out.println("Name is "+s1.getName());
			System.out.println("Password is "+s1.getPassword());
			System.out.println("Email is "+s1.getEmail());
			System.out.println("Address is "+s1.getAddress());
		}
		else {
			System.out.println("profile not found");
		}
	}

	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email to delete profile");
		String email=sc.next();
		
		SnapchatUser su=new SnapchatUser();
		su.setEmail(email);
		
		SnapchatServiceInterface ss=new SnapchatService();
		int s1=ss.deleteProfileService(su);
		
		if(s1>0) {
			System.out.println("profile deleted");
		}
		else {
			System.out.println("could not delete profile");
		}
		
	}

	public void viewAllProfileController() {
		SnapchatServiceInterface ss=new SnapchatService();
		ArrayList<SnapchatUser> ll=ss.viewAllProfileService();
		
		System.out.println(ll.size()+ "  record found in database");
		for(SnapchatUser r:ll) {
			System.out.println("************************");
			System.out.println("Name is "+r.getName());
			System.out.println("Password is "+r.getPassword());
			System.out.println("Email is "+r.getEmail());
			System.out.println("Address is "+r.getAddress());
		}
	}

}












