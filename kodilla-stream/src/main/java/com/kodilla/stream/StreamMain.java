package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text1 ="ala ma kota";
        String text2 ="a kot ma kaca";
        String text3 = "to be or not to be";
        String text4 ="Kamil Slimak";

        PoemDecorator reverse = (text) -> {
            StringBuilder output = new StringBuilder(text4);
            return output.reverse().toString();
        };

        poemBeautifier.beautify(text1,(text) -> "ABC "+text+" ABC");
        poemBeautifier.beautify(text2,(text) -> text2.toUpperCase());
        poemBeautifier.beautify(text3,(text) -> text3.replace("t","T"));
        poemBeautifier.beautify(text4,reverse);
    }
}
