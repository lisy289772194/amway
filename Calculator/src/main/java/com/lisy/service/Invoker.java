package com.lisy.service;

import com.lisy.command.CalculatorCommand;
import com.lisy.command.Command;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


public class Invoker {

    private final Calculator calculator = new Calculator();
    private final ArrayList<Command> commands = new ArrayList<>();
    private final AtomicLong current = new AtomicLong(0L);


    public void redo(int levels) {
        System.out.println("redo levels:" + levels);
        for (int i = 0; i < levels; i++) {
            if (current.get() < commands.size() - 1) {
                commands.get(i).execute();
                current.incrementAndGet();
            }
        }
    }

    public void undo(int levels) {
        System.out.println("undo levels:" + levels);
        for (int i = 0; i < levels; i++) {
            if (current.get() > 0) {
                current.decrementAndGet();
                commands.get(i).unexecute();
            }
        }
    }

    public void compute(char operator, int operand) {
        Command command = new CalculatorCommand(calculator, operator, operand);
        command.execute();
        commands.add(command);
        current.incrementAndGet();
    }
}
