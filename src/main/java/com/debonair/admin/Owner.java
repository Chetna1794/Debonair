package com.debonair.admin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.debonair.resources.Constants;


/**
 * This class stores Restaurant owner information
 * 
 * @author Chetna
 * @since 08-Apr-2020
 */
public class Owner {

	/**
	 * This method is provided to the owner to add items to the Menu
	 * 
	 * @since 08-Apr-2020
	 */
	public void modifyMenu() {
		try (BufferedWriter bufferedWriterObj = new BufferedWriter(new FileWriter("./src/Items.txt", true))) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String addItems;
			String item;
			int itemId;
			String itemName;
			Double itemRate;
			do {
				System.out.println("Do you want to add items in the menu?");
				addItems = sc.next();
				if (Constants.YES.equalsIgnoreCase(addItems)) {
					System.out.println("Enter item id");
					itemId = sc.nextInt();
					System.out.println("Enter item name");
					itemName = sc.next();
					System.out.println("Enter item rate");
					itemRate = sc.nextDouble();
					item = itemId + "," + itemName + "," + itemRate;
					bufferedWriterObj.append(item);
					bufferedWriterObj.newLine();
				}
			} while (Constants.YES.equalsIgnoreCase(addItems));
			bufferedWriterObj.flush();
			if (!Constants.YES.equalsIgnoreCase(addItems)) {
				System.out.println("Program exitted!");
			}
		} catch (FileNotFoundException fe) {
			System.err.println(fe);
		} catch (IOException ie) {
			System.err.println(ie);
		}
	}
	
	/**
	 * This is main method for the owner 
	 * 
	 * @param args
	 * @since 08-Apr-2020
	 */
	public static void main(String[] args) {
		Owner ownerObj = new Owner();
		ownerObj.modifyMenu();

	}
}
