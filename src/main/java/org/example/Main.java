package org.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        String input = "swiss";

       Map<Character, Long> charCount =  input.chars().
               mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,
                Collectors.counting()));

       Optional<Character> firstNonRepeat = charCount.
               entrySet().stream().filter((e)-> e.getValue() ==1)
               .map(e -> e.getKey()).findFirst();


        Optional<Character> firstRepeat = charCount.
                entrySet().stream().filter((e)-> e.getValue() > 1)
                .map(e -> e.getKey()).findFirst();

        if(firstNonRepeat.isPresent()){
            System.out.println("FirstNonRepeat : "+ firstNonRepeat.get());
        }
        System.out.println("FirstRepeatChar :"+ firstRepeat.orElse(null));

    }
}