package dev.wocampo.learn.fpdemo.functional;

public class App {
    private static void executeWithPoo() {
        var firstSubject = new Subject();
        System.out.println(firstSubject.doSomething("his life"));
    }

    private static void executeWithAnonymousClass() {
        var secondSubject = new MyFunctionalInterface() {
            @Override
            public String doSomething(String param) {
                return "ANONYMOUS CLASS | This subject is already doing something with " + param;
            }
        };
        System.out.println(secondSubject.doSomething("his life"));
    }

    private static void executeWithSimpleLambda() {
        MyFunctionalInterface thirdSubject = param -> "LAMBDA | This subject is already doing something with " + param;
        System.out.println(thirdSubject.doSomething("his life"));
    }

    private static void executeWithHighOrderFunction(MyFunctionalInterface behavior) {
        System.out.println(behavior.doSomething("FROM HIGH ORDER FUNCTION"));
    }

    public static void main(String... args) {
        // Functional Programming
        executeWithPoo();
        executeWithAnonymousClass();
        executeWithSimpleLambda();

        // Composite Functions
        executeWithHighOrderFunction(x -> "Hello " + x);
        executeWithHighOrderFunction(x -> "Bye " + x);

        // Method reference
        executeWithHighOrderFunction(new Subject());
        var pikachu = new Pikachu();
        executeWithHighOrderFunction(pikachu::call);
        executeWithHighOrderFunction(pikachu::eat);
    }
}
