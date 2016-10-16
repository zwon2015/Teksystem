package com.teksystem.application;

import java.util.HashMap;
import java.util.Map;



public class Foo {
	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new HashMap<String, Order>();

		Order c = new Order();

		double grandTotal = 0;                    //grandTotal variable not being used in the file
		
		

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		//c.clear();
		Order c1 = new Order();
		c1.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c1.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c1);

		// Reuse cart for an other order
		//c1.clear();

		Order c2 = new Order();
		c2.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c2.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c2.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		
		
		//spelling of imported is wrong. Original 'importd'
		c2.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c2);
		//c2.clear();
		new Calculator().calculate(o);

	}
}
