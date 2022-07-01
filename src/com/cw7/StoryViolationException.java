package com.cw7;

// Story violation!
// This exception is defined to keep story rules.
public class StoryViolationException extends RuntimeException {

    public StoryViolationException(String what) {
        super(what);
    }

    public void printMessage() {
        System.out.println(super.getMessage());
    }
}
