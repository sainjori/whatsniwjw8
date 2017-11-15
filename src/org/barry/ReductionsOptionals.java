package org.barry;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionsOptionals
{
    public static void main(String[] args)
    {
//        List<Integer> list = Arrays.asList(10,10,10);
//        List<Integer> list = Arrays.asList(10,10);
//        List<Integer> list = Arrays.asList();
//        List<Integer> list = Arrays.asList(10);

        //Problem: I want to know from this whatis max: But 0 is also involved!
        List<Integer> list = Arrays.asList(-10, -10);

//        list.stream()
//                .reduce(0, (i1, i2) -> i1 + i2);
        Optional<Integer> red =
                list.stream()
                        //Solution: remove identity value
//                        .reduce(Integer::max); // this version doesnt compile(change return to optional)
                        .reduce(Integer::max);

        System.out.println(red);
        //!! Optionals needed because default values cant always be defined
    }

}
