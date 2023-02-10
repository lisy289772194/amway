package com.lisy.service;

public class Calculator {

	private int total=0;
	public void operation(char operator,int operand) {
		switch(operator) {
		case '+':total+=operand;break;
		case '-':total-=operand;break;
		case '*':total*=operand;break;
		case '/':total/=operand;break;
		}
		System.out.println(operator+" "+operand+" ="+total);
	}
}
