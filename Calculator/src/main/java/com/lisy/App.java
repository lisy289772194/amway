package com.lisy;

import com.lisy.service.Invoker;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.compute('+', 100);
        invoker.compute('-', 50);
        invoker.compute('*', 20);
        invoker.compute('/', 2);

        invoker.undo(2);
        invoker.redo(1);
    }
}
