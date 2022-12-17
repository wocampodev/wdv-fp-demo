package dev.wocampo.learn.stream;

import java.util.*;
import java.util.stream.Collectors;

public class AppV1 {
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void main(String... args) {
        System.out.println(":: Start ::");
        AppV1 appV1 = new AppV1();
        appV1.setQuantity(Integer.parseInt(args.length > 0 ? args[0] : "1"));
        appV1.oldSort();
        appV1.lambdaSort();

        appV1.oldFilter();
        appV1.lambdaFilter();
        System.out.println(":: End ::");
    }

    public List<Integer> createRandomList() {
        List<Integer> numberList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quantity; i++) {
            numberList.add(rand.nextInt(255));
        }
        return numberList;
    }

    public void oldSort() {
        List<Integer> unsortedList = createRandomList();
        Collections.sort(unsortedList, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        });
        //The list has been sorted in the traditional way
        System.out.println("Last -> " + unsortedList.get(unsortedList.size() - 1));
    }

    public void lambdaSort() {
        List<Integer> unsortedList = createRandomList();
        unsortedList.sort((Integer n1, Integer n2) -> n1.compareTo(n2));
        //The list has been sorted in lambda way
        System.out.println("Last -> " + unsortedList.get(unsortedList.size() - 1));
    }

    public void oldFilter() {
        List<Integer> unfilteredList = createRandomList();
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : unfilteredList) {
            if (number > 50) {
                filteredList.add(number);
            }
        }
        //The list has been filtered in the traditional way
        System.out.println("Last -> " + filteredList.get(filteredList.size() - 1));
    }

    public void lambdaFilter() {
        List<Integer> unfilteredList = createRandomList();
        List<Integer> filteredList = unfilteredList.parallelStream() // ParallelStream
                .filter(x -> x > 50) //Intermediate operator
                .collect(Collectors.toList()); //Terminal operator
        //The list has been filtered in the lambda way
        System.out.println("Last -> " + filteredList.get(filteredList.size() - 1));
    }
}
