package com.snapchat.view;

import java.util.Scanner;

import com.snapchat.controller.SnapChatController;
import com.snapchat.controller.SnapchatControllerInterface;

public class SnapchatView {

	public static void main(String[] args) {

		String s = "y";

		while (s.equals("y")) {

			System.out.println("********************MAIN MENU****************");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to delete profile");
			System.out.println("press 4 to view all profile");
			Scanner sc = new Scanner(System.in);

			System.out.println("enter your choice");
			int ch = sc.nextInt();

			SnapchatControllerInterface sf = new SnapChatController();

			switch (ch) {
			case 1:
				sf.createProfileController();
				break;
			case 2:
				sf.viewProfileController();
				break;
			case 3:
				sf.deleteProfileController();
				break;
			case 4:
				sf.viewAllProfileController();
				break;
			default:
				System.out.println("wrong choice");
			}
			System.out.println("press y/n to continue");
			s = sc.next();
		}

	}

}
