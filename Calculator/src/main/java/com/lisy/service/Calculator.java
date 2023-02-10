package com.lisy.service;

import java.util.concurrent.atomic.AtomicLong;

public class Calculator {

	private final AtomicLong total = new AtomicLong(0L);
	public void operation(char operator,int operand) {
		switch (operator) {

			case '+':
				total.addAndGet(operand);
				break;
			case '-':
				total.addAndGet(-operand);
				break;
			case '*':
				total.accumulateAndGet(operand, (left, right) -> left * right);
				break;
			case '/':
				total.accumulateAndGet(operand, (left, right) -> left / right);
				break;
			default:
				throw new RuntimeException("unexpected branch!");
		}
		System.out.println(operator+" "+operand+" ="+total.get());
	}
}
