package dev.wocampo.learn.functional;

public class Subject implements MyFunctionalInterface {
    @Override
    public String doSomething(String param) {
        return "POO | This subject is already doing something with " + param;
    }
}
