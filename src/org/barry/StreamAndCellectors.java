package org.barry;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAndCellectors
{

    public static void main(String[] args){


        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        ArrayList<String> list = new ArrayList<>();

        stream
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);

        System.out.println("Done!");
        System.out.println("Size = " + list.size());
        //Temination operations
    }
}
