package org.barry;

import org.barry.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample
{
    public static void main(String[] args)
    {

        ArrayList<Person> persons = new ArrayList<>();

        try (
                BufferedReader bufferedReader =
                        new BufferedReader(
                                new InputStreamReader(
                                        CollectorsExample.class.getResourceAsStream("people.txt")));
                Stream<String> stream = bufferedReader.lines();
        )
        {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person person = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(person);
                return person;
            }).forEach(System.out::println);

        } catch (IOException e)
        {
            System.out.println(e);
        }

        Stream<Person> stream = persons.stream();
        Optional<Person> opt = stream.filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));

        System.out.println(opt);


        //Exception: You need to open a new stream
        Optional<Person> max = persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(max);

//        Map<Integer, List<Person>> map = persons.stream().
//                collect(
//                        Collectors.groupingBy(
//                                Person::getAge
//                        )
//                );

//        Map<Integer, Long> map = persons.stream().
//                collect(
//                        Collectors.groupingBy(
//                                Person::getAge,
//                                //Downstream collector
//                                Collectors.counting()
//                        )
//                );

//        Map<Integer, List<String>> map = persons.stream().
//                collect(
//                        Collectors.groupingBy(
//                                Person::getAge,
//                                Collectors.mapping(
//                                        Person::getName,
//                                        Collectors.toList()
//                                )
//                        )
//                );

//        Map<Integer, Set<String>> map = persons.stream().
//                collect(
//                        Collectors.groupingBy(
//                                Person::getAge,
//                                Collectors.mapping(
//                                        Person::getName,
//                                        Collectors.toCollection(TreeSet::new)
//                                )
//                        )
//                );
        Map<Integer, String> map = persons.stream().
                collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println(map);
    }

}
