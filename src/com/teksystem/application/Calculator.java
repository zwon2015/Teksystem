package com.teksystem.application;

import java.util.Map;

public class Calculator {

	public static double rounding(double value) {
		value = Math.round(value * 100);
		value = value/100;
		return value;
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			
			//Grandtotal equals to 0 will always initialize it's value to zero when it loops every single time
			//grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			//Removed equal sign. Original i <= r.size()
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;
				
				//'imported' and 'Imported' both are validated in the below if condition
				if (r.get(i).getItem().getDescription().contains("imported") || r.get(i).getItem().getDescription().contains("Imported")) {
					tax = (r.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = (r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = (r.get(i).getItem().getPrice() + (tax));

				// Print out the item's total price
				System.out.println(r.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			//Since question says to get total price without tax, we don't need to add it.
			//total = (total) + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total));
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal));
	}
}
