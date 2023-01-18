package com.sub.learner.javanewfeatures.trywithresources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TryWithResources {

    public static void main(String[] args) throws IOException {

        Reader sr = new StringReader("hi");
        BufferedReader br = new BufferedReader(sr);
        try (br) {
            System.out.println(br.readLine());
        }
    }

}
