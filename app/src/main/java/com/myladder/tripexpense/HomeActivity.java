package com.myladder.tripexpense;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.CharMatcher;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //List of host data
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

//        // key = id, value - websites
//        Map<Integer, String> result1 = list.stream().collect(
//                Collectors.toMap(Hosting::getId, Hosting::getName));
//
//        System.out.println("Result 1 : " + result1);
//
//        // key = name, value - websites
//        Map<String, Long> result2 = list.stream().collect(
//                Collectors.toMap(Hosting::getName, Hosting::getWebsites));
//
//        System.out.println("Result 2 : " + result2);
//
//        // Same with result1, just different syntax
//        // key = id, value = name
//        Map<Integer, String> result3 = list.stream().collect(
//                Collectors.toMap(x -> x.getId(), x -> x.getName()));
//
//        System.out.println("Result 3 : " + result3);


        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi",
                "mandarin", "date", "quince");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }


        Multimap<String, Integer> scores = HashMultimap.create();
        scores.put("Bob", 20);
        scores.put("Bob", 10);
        scores.put("Bob", 15);
        System.out.println(Collections.max(scores.get("Bob"))); // prints 20

        toStringHelper();
    }

    private void toStringHelper() {
        Car car1 = new Car(1, "Audi", 52642);
        Car car2 = new Car(2, "Mercedes", 57127);
        Car car3 = new Car(3, "Skoda", 9000);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }

    //http://zetcode.com/articles/guava/
    private void fluentiterableMethod() {
        List<Car> cars = Lists.newArrayList(new Car(1, "Audi", 52642),
                new Car(2, "Mercedes", 57127), new Car(3, "Skoda", 9000),
                new Car(4, "Volvo", 29000));

        Predicate<Car> byPrice = car -> car.getPrice() <= 30000;

        List<String> results = FluentIterable.from(cars)
                .filter(byPrice)
                .transform(Functions.toStringFunction())
                .toList();

        System.out.println(results);
    }

    private void predicateMethod() {
        List<Integer> values = Lists.newArrayList(3, null, 4, 7,
                8, null, 7);

        Iterable<Integer> filtered = Iterables.filter(values,
                Predicates.notNull());

        for (Integer i : filtered) {
            System.out.println(i);
        }


        //Example

        List<String> items = Lists.newArrayList("coin", "book",
                "cup", "purse", "bottle");
        Collection<String> result = Collections2.filter(items,
                Predicates.containsPattern("o"));

        for (String item : result) {
            System.out.println(item);
        }
    }

    private void stringjoinerMethod() {
        List<String> myList = Lists.newArrayList("8", "2", "7", "10");

        String result = Joiner.on(",").join(myList);

        System.out.println(result);
    }

    private void stringSplitterMethod() {
        String input = "There is a dog in the garden.";

        List<String> words = Splitter.on(" ").splitToList(input);

        for (String word : words) {
            System.out.println(word);
        }


// splits the input into three substrings.
        String input1 = "coin, pencil, chair, bottle, soap";

        List<String> words1 = Splitter.on(",")
                .trimResults()
                .limit(3)
                .splitToList(input1);

        for (String word : words1) {
            System.out.println(word);
        }
    }

    private void CharMatcherMethod(){
        String input = "manuaravind1989";

        CharMatcher matcher = CharMatcher.JAVA_LETTER;
        String result = matcher.retainFrom(input);

        System.out.println(result);
        //The example removes any non-letter characters from the input string.



        String input1 = "Beautiful sunny day";

        int n1  = CharMatcher.is('n').countIn(input1);
        System.out.format("Number of n characters: %d%n", n1);

        int n2  = CharMatcher.is('i').countIn(input1);
        System.out.format("Number of i characters: %d", n2);
        //The countIn() method returns the number of matching characters found in the character sequence.



        String input2 = "   yogurt \t";
        String result1 = CharMatcher.whitespace().trimFrom(input2);
        System.out.println(input2 + " and bread" );
        System.out.println(result1 + " and bread");
        //In this example, we remove white space from the string.

    }

}
