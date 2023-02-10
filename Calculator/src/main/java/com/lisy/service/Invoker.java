package com.lisy.service;

import com.lisy.command.CalculatorCommand;
import com.lisy.command.Command;

import java.util.ArrayList;


public class Invoker {

    private Calculator calculator = new Calculator();
    private ArrayList<Command> commands = new ArrayList<Command>();
    private int current = 0;

    public void redo(int levels) {
        System.out.println("redo levels:" + levels);
        for (int i = 0; i < levels; i++) {
            if (current < commands.size() - 1) {
                commands.get(i).execute();
                current++;
            }
        }
    }

    public void undo(int levels) {
        System.out.println("undo levels:" + levels);
        for (int i = 0; i < levels; i++) {
            if (current > 0) {
                --current;
                commands.get(i).execute();
            }
        }
    }

    public void compute(char operator, int operand) {
        Command command = new CalculatorCommand(calculator, operator, operand);
        command.execute();
        commands.add(command);
        current++;
    }
}
