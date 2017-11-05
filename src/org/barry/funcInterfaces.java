package org.barry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class funcInterfaces
{

    public static void main(String[] args)
    {


        List<String> strings = Arrays.asList("one", "two", "three", "four");

        ArrayList<String> result = new ArrayList<>();

        Consumer c1 = System.out::println;

        Consumer<String> c2 = result::add;

        strings.forEach(c1.andThen(c2));

        System.out.println("Size of result = "+ result.size());
    }
}
