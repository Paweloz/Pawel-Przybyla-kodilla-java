package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text1 ="ala ma kota";
        String text2 ="a kot ma kaca";
        String text3 = "to be or not to be";
        String text4 ="Kamil Slimak";

        PoemDecorator reverse = () -> {
            StringBuilder output = new StringBuilder(text4);
            return output.reverse().toString();
        };

        poemBeautifier.beautify(() -> "ABC "+text1+" ABC");
        poemBeautifier.beautify(() -> text2.toUpperCase());
        poemBeautifier.beautify(() -> text3.replace("t","T"));
        poemBeautifier.beautify(reverse);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
