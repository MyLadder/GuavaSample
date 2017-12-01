package com.myladder.tripexpense;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.myladder.tripexpense.person.Gender;
import com.myladder.tripexpense.person.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Manu on 12/1/2017.
 */

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

//Collections.unmodifiableCollection
        List list = Arrays.asList("one", "two",
                "three", "four", "five", "six", "seven", "eight");
        System.out.println("List to be modified: " + list);
        Collection unmodifiableList = Collections.unmodifiableCollection(list);
        System.out.println("Modify the wrapped list");
        list.set(7, "AN EMPEROR");
        System.out.println("After the change:" + unmodifiableList);

        setup();
    }

//http://www.javarticles.com/2015/04/guava-immutablelist.html

    private void setup(){
        System.out
                .println("-----------open(1,4) ==> 1<value<4--------------------");

        // 1<value<4
        Range<Integer> range = Range.open(1, 4);
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out
                .println("-----------closed(1,4) ==> 1<=value<=4----------------");

        // 1<=value<=4
        range = Range.closed(1, 4);
        System.out.println("Conatins 0? " + range.contains(0));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out.println("Conatins 5? " + range.contains(5));
        System.out
                .println("-----------openClosed(1,4) ==> 1<value<=4-------------");

        // 1<value<=4
        range = Range.openClosed(1, 4);
        System.out.println("Conatins 0? " + range.contains(0));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out.println("Conatins 5? " + range.contains(5));
        System.out
                .println("-----------closedOpen(1,4) ==> 1<=value<4-------------");

        // 1<=value<4
        range = Range.closedOpen(1, 4);
        System.out.println("Conatins 0? " + range.contains(0));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 3? " + range.contains(3));
        System.out.println("Conatins 4? " + range.contains(4));
        System.out.println("Conatins 5? " + range.contains(5));

        System.out
                .println("----------------------2<value-------------------------");
        // 2<value
        range = Range.greaterThan(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 2000? " + range.contains(2000));

        System.out
                .println("----------------------2<=value-------------------------");
        // 2<=value
        range = Range.atLeast(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 2000? " + range.contains(2000));

        System.out
                .println("----------------------2>value-------------------------");
        // 2>value
        range = Range.lessThan(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins -1? " + range.contains(-1));

        System.out
                .println("----------------------2<=value-------------------------");
        // 2<=value
        range = Range.atMost(2);
        System.out.println("Conatins 2? " + range.contains(2));
        System.out.println("Conatins 1? " + range.contains(1));
        System.out.println("Conatins -1? " + range.contains(-1));

        System.out
                .println("-----------------------(-infinity<value<+infinity)-------------------------");
        // -infinity<value<+infinity
        range = Range.all();
        System.out.println("Conatins -200? " + range.contains(-200));
        System.out.println("Conatins 200? " + range.contains(200));

        //http://www.javarticles.com/2015/11/guava-range-example.html
    }


    private void personMethod(){
        List<Person> persons = Lists.newArrayList(
                new Person(34, "Michael", Gender.MALE),
                new Person(17, "Jane", Gender.FEMALE),
                new Person(28, "John", Gender.MALE),
                new Person(47, "Peter", Gender.MALE),
                new Person(27, "Lucy", Gender.FEMALE)
        );

        Predicate<Person> byGender = person -> person.getSex() == Gender.MALE;

        List<Person> results = FluentIterable.from(persons)
                .filter(byGender)
                .toList();

        System.out.println(results);
    }



}
