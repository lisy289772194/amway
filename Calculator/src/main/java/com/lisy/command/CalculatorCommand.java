package com.lisy.command;

import com.lisy.service.Calculator;

public class CalculatorCommand extends Command {

	private Calculator calculator;
	private char operator;
	private int operand;
	
	public CalculatorCommand(Calculator calculator, char operator, int operand) {
		super();
		this.calculator = calculator;
		this.operator = operator;
		this.operand = operand;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public int getOperand() {
		return operand;
	}

	public void setOperand(int operand) {
		this.operand = operand;
	}

	@Override
	public void execute() {
		calculator.operation(operator, operand);

	}

	@Override
	public void unexecute() {
		calculator.operation(undo(operator), operand);

	}

	/**
	 * @param operator2
	 * @return
	 */
	private char undo(char operator2) {
		char ch = 0;
		switch(operator2) {
		case '+':ch='-';break;
		case '-':ch='+';break;
		case '*':ch='/';break;
		case '/':ch='*';break;
		}
		return ch;
	}
}
