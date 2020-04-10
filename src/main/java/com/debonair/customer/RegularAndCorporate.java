// user defined package
package com.debonair.customer;

// importing built in packages
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.debonair.resources.Constants;

public class RegularAndCorporate {
	Customer customers[] = new Customer[10];

	RegularAndCorporate() {
		/* com.debonair.customer id 0-4 is for regular customers */
		for (int i = 0; i < 5; i++) {
			customers[i] = new RegularCustomer(i, "Chetna", "31-01-1994", "9876543" + i, "Regular", "Rajat Vihar", 10);
		}
		/* com.debonair.customer id 5-9 is for corporate customers */
		for (int i = 5; i < 10; i++) {
			customers[i] = new CorporateCustomer(i, "Prafull", "01-07-1994", "8734231" + i, "Corporate",
					"Mansarovar Apartments", i, 5.0f);
		}
		System.out.println("Dummy customers created");
	}

	public void updateCustomers() {
		try (ObjectOutputStream regularCustomerObjectStream = new ObjectOutputStream(
				new FileOutputStream("./RegularCustomer.txt"));
				ObjectOutputStream corporateCustomerObjectStream = new ObjectOutputStream(
						new FileOutputStream("./CorporateCustomer.txt"));) {
			for (int i = 0; i < customers.length; i++) {
				if (Constants.REGULAR.equalsIgnoreCase(customers[i].getCustomerType())) {
					// inserting Regular com.debonair.customer entries to RegularCustomer.txt
					regularCustomerObjectStream.writeObject(customers[i]);
					regularCustomerObjectStream.flush();
				} else if (Constants.CORPORATE.equalsIgnoreCase(customers[i].getCustomerType())) {
					// inserting Regular com.debonair.customer entries to CorporateCustomer.txt
					corporateCustomerObjectStream.writeObject(customers[i]);
					corporateCustomerObjectStream.flush();
				}
			}
			System.out.println("Customer details successfully added to their respective files.");
			System.out.println();
		} catch (IOException ie) {
			System.err.println(ie);
		}
	}

	public void displayCustomerData() {
		try (ObjectInputStream regularCustomerObjectStream = new ObjectInputStream(
				new FileInputStream("./RegularCustomer.txt"));
				ObjectInputStream corporateCustomerObjectStream = new ObjectInputStream(
						new FileInputStream("./CorporateCustomer.txt"));) {
			System.out.println("*************************Regular Customer Details*************************\n");
			// displaying Regular Customer Details
			for (int i = 0; i < 5; i++) {
				Object tempCustomer = regularCustomerObjectStream.readObject();
				if (tempCustomer instanceof RegularCustomer) {
					System.out.println(tempCustomer);
					System.out.println();
				}
			}
			System.out.println("*************************Corporate Customer Details*************************\n");
			// displaying Corporate Customer Details
			for (int i = 5; i < 10; i++) {
				Object tempCustomer = corporateCustomerObjectStream.readObject();
				if (tempCustomer instanceof CorporateCustomer) {
					System.out.println(tempCustomer);
					System.out.println();
				}
			}
		} catch (IOException ie) {
			System.err.println(ie);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RegularAndCorporate obj = new RegularAndCorporate();
		obj.updateCustomers();
		obj.displayCustomerData();
	}
}
