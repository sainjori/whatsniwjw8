package org.barry;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
//        System.out.println("Hello World!");
//
//
//        FileFilter fileFilter = new FileFilter()
//        {
//            @Override
//            public boolean accept(File pathname)
//            {
//                return pathname.getName().endsWith(".java");
//            }
//        };
//
//        FileFilter filter = (File file) -> file.getName().endsWith(".java");
//
//        File dir = new File("c:/tempo");
//
//        File[] files = dir.listFiles(fileFilter);
//
//        for (File file : files)
//        {
//            System.out.println(file);
//        }


        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 3; i++)
                {
                    System.out.println(
                            "Hello world from theread [" +
                                    Thread.currentThread().getName() +
                                    "]");
                }
            }
        };

        Runnable runnableLambda = () -> {

            for (int i = 0; i < 3; i++)
            {
                System.out.println(
                        "Hello world from theread [" +
                                Thread.currentThread().getName() +
                                "]");
            }
        };


        Comparator<String> stringComparator = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return Integer.compare(o1.length(), o2.length());
            }

        };

        Comparator<String> comparator = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());

        List<String> strings = Arrays.asList("****", "*********", "***");
        Collections.sort(strings, stringComparator);

        for (String s : strings)
        {
            System.out.println(s);
        }

        Thread thread = new Thread(runnable);

        thread.start();
        thread.join();


    }
}
