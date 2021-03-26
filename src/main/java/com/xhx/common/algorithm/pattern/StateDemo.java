package com.xhx.common.algorithm.pattern;

import com.xhx.common.algorithm.pattern.ext.StateBase;

/**
 * 状态模式
 */
public class StateDemo {

    public static void main(String[] args) {
        new Washer();
    }
}
interface State {
    void run();
}

abstract class StateMachine {
    protected State currentState;

    protected abstract boolean changeState();

    // Template method:
    protected final void runAll() {
        while (changeState()) // Customizable
            currentState.run();
    }
}

// A different subclass for each state:

class Wash implements State {
    @Override
    public void run() {
        System.out.println("Washing");
    }
}

class Spin implements State {
    @Override
    public void run() {
        System.out.println("Spinning");
    }
}

class Rinse implements State {
    @Override
    public void run() {
        System.out.println("Rinsing");
    }
}

class Washer extends StateMachine {
    private int i = 0;
    // The state table:
    private State[] states = {
            new Wash(), new Spin(),
            new Rinse(), new Spin(),
    };

    Washer() {
        runAll();
    }

    @Override
    public boolean changeState() {
        if (i < states.length) {
            // Change the state by setting the
            // surrogate reference to a new object:
            currentState = states[i++];
            return true;
        } else
            return false;
    }
}
