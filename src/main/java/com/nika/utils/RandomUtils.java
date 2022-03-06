package com.nika.utils;

import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class RandomUtils {
    private static Random random = new Random();

    public static int getRandomItem(List<Integer> list) {

        return list.get(random.nextInt(list.size()));
    }
}
