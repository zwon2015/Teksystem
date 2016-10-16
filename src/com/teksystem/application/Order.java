package com.teksystem.application;

import java.util.ArrayList;
import java.util.List;


public class Order {
	
	//List was not initialised, type of list not been defined
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		this.orderLines.add(o);
	}

	public int size() {
		return this.orderLines.size();
	}

	public OrderLine get(int i) {
		return this.orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
	}

