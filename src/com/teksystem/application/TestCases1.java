package com.teksystem.application;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestCases1 {

	@Test
	public void checkAddFunctionOrderIfNull() throws Exception {
		String description = "book";
		float price = (float) 12.49;
		Item item = new Item(description, price);
		OrderLine ol = new OrderLine(item, 1);
		Order order = new Order();
		order.add(ol);
		assertNotNull(order);

	}

	@Test
	public void checkCalculatorMethodIfRecognisesKeyWordImported()
			throws Exception {

		Map<String, Order> o = new HashMap<String, Order>();

		Order c1 = new Order();
		c1.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c1.add(new OrderLine(new Item("imported bottle of perfume",
				(float) 47.50), 1));

		o.put("Order 2", c1);

		new Calculator().calculate(o);
	}

	@Test
	public void checkIFCalculatorMethodRecognisesWithoutImportedKeyWord()
			throws Exception {

		Map<String, Order> o = new HashMap<String, Order>();
		Order c = new Order();
		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);
		new Calculator().calculate(o);

	}

}
