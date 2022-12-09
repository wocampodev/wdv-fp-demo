package dev.wocampo.learn.fpdemo.stream;

import java.util.List;
import java.util.stream.Collectors;

public class AppBeta {
    public static void main(String[] args) {
        // Streams API
        printElements();
    }

    private static void printElements() {
        var friends = List.of("Guillermo", "Anthony", "Liliana");
        // friends.removeIf("Liliana"::equals); // Mutability error, side effect
        var realFriends = friends.stream() // stream
                .peek(System.out::println)
                .filter(s -> !"Liliana".equals(s)) // map
                .peek(System.out::println)
                .map(String::toUpperCase) // map
                .peek(System.out::println)
                .collect(Collectors.toList()); // reduce
        System.out.println(realFriends);
    }
}
