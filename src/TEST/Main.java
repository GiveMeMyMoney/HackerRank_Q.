package TEST;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    //1. zad [[5], [3,3], [4,4], [1,1,1]]
    static void customSort(int[] arr) {
        Map<Integer, Integer> numberRepeatCountMap = new TreeMap<>(); //ilosc powtorzen / liczba

        for (int element : arr) {
            Integer count = numberRepeatCountMap.getOrDefault(element, 0);
            numberRepeatCountMap.put(element, ++count);
        }

        Set<Map.Entry<Integer, Integer>> set = numberRepeatCountMap.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
        list.sort(Comparator.comparing(o -> (o.getValue())));

        for (Map.Entry<Integer, Integer> entry : list) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                System.out.println(entry.getKey());
            }
        }
    }

    //2. zad Complete the closestNumbers function below.
    static void closestNumbers(List<Integer> numbers) {
        int actualClosest = Integer.MAX_VALUE;
        List<Integer> sortedPairs = new ArrayList<>();

        Collections.sort(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            Integer left = numbers.get(i);
            Integer right = numbers.get(i + 1);
            int subtraction = Math.abs(left - right);
            if (subtraction < actualClosest) {
                actualClosest = subtraction;
                sortedPairs.clear();
                sortedPairs.add(left);
                sortedPairs.add(right);
            } else if (subtraction == actualClosest) {
                sortedPairs.add(left);
                sortedPairs.add(right);
            }
        }

        for (int i = 0; i < sortedPairs.size(); i += 2) {
            System.out.println(sortedPairs.get(i) + " " + sortedPairs.get(i + 1));
        }
    }

    /**
     * zad3. 1001 == 1100 & 1234 == 4321 & 12 != 321 & 010 != 110
     * if(rowne) - ile jest mozliwych kombinacji z A
     * else - ile jest mozliwych kombinacji z B
     */


    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 5, 3, 3, 4, 4, 2};

        customSort(arr);


        //System.out.println(findNumber(null, 1));


        //System.out.println(findNumber(null, 1));


    }
}
