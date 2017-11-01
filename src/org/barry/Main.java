package org.barry;

import java.io.File;
import java.io.FileFilter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        FileFilter fileFilter = new FileFilter()
        {
            @Override
            public boolean accept(File pathname)
            {
                return pathname.getName().endsWith(".java");
            }
        };

        FileFilter filter = (File file) -> file.getName().endsWith(".java");

        File dir = new File("c:/tempo");

        File[] files = dir.listFiles(fileFilter);

        for (File file : files)
        {
            System.out.println(file);
        }


    }
}
