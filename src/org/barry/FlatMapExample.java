package org.barry;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample
{
    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(3, 5, 7);

        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);

        System.out.println(lists);


        Function<List<?>, Integer> size = List::size;
        Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();

//        lists.stream()
//                .map(flatmapper)
//                .forEach(System.out::println);
        lists.stream()
                .flatMap(flatmapper)
                .forEach(System.out::println);

    }
}
