package com.github.algo.java;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Steams {

    class Employee {
        int a;
        int b;

        public Employee(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);

        List<Integer> numList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        System.out.println(numList);

        Integer integer = numList.stream().filter(i -> i % 2 == 0).findFirst().orElse(null);
        System.out.println(integer);

        List<Employee> employees = Arrays.asList(new Employee(1, 2), new Employee(3, 4), new Employee(5, 6));
        List<Integer> intList = employees.stream().flatMap(e -> Stream.of(e.a, e.b)).collect(Collectors.toList());
        System.out.println(intList);

        employees.stream().peek(i -> System.out.println(i.a)).collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Integer> collect = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.a, e2.b))
                .mapToInt(e -> e.a)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(collect);

        System.out.println(collect.stream().count());

        System.out.println(collect.stream().mapToInt(i -> i).min());

        System.out.println(collect.stream().mapToInt(i -> i).max());

        System.out.println(collect.stream().reduce(0, Integer::sum).intValue());
    }

    @Test
    public void test2() {
        List<String> strings = Arrays.asList("Apple", "Ball", "Bull", "Bol", "Cat");
        Map<Boolean, List<String>> partitions = strings.stream().collect(Collectors.partitioningBy(s -> s.startsWith("A")));

        System.out.println(partitions.get(true));
        System.out.println(partitions.get(false));

        Map<Character, List<String>> collect = strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(collect);
    }
}
