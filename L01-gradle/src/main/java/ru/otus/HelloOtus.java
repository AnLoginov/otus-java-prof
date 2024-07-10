package ru.otus;

import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("java:S106")
public class HelloOtus {
    public static void main(String[] args) {
        List<Integer> powerOfTwoRandoms = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Random randomizer = new Random();
            int randomNumber = randomizer.nextInt(64);
            if (IntMath.isPowerOfTwo(randomNumber)) {
                powerOfTwoRandoms.add(randomNumber);
            }
        }
        ImmutableList<Integer> finalRandomsList = ImmutableList.sortedCopyOf(powerOfTwoRandoms);
        System.out.println(finalRandomsList);
    }
}
