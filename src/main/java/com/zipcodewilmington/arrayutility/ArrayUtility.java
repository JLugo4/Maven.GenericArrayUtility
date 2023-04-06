package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public ArrayList<T> inputArray = new ArrayList<>();

    public T[] input;
    public ArrayUtility(T[] inputArray) {
        this.inputArray.addAll(Arrays.asList(inputArray));
        this.input = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = (T[]) Stream.concat(Arrays.stream(inputArray.toArray()), Arrays.stream(arrayToMerge))
                        .toArray(size -> Arrays.copyOf(inputArray.toArray(), size));

        return (int)Arrays.stream(mergedArray)
                .filter(element ->  Objects.equals(element,valueToEvaluate))
                .count();
    }
//    private Integer countDuplicates(T item){
//        int count = 0;
//        for(T element : this.input){
//            if(item.equals(element)){
//                count++;
//            }
//        }
//        return count;
//    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        //this.inputArray.addAll(Arrays.asList(arrayToMerge));
        //T[] newArray = inputArray.toArray(new T[0]);

//       Stream.concat(inputArray.stream(), Arrays.stream(arrayToMerge))
//                .toArray(size -> (T[]) Array.newInstance(inputArray.getClass().getComponentType(), size));
        Map<T, Long> occurences =

                Arrays.stream(arrayToMerge)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
                Arrays.stream(inputArray.toArray())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        return occurences
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);



    }


    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return (int)inputArray.stream()
                .filter(element -> valueToEvaluate == element)
                .count();
    }

    public T[] removeValue(T valueToRemove) {
        /*List<T> processedList = */
        //ArrayList<T> list = (ArrayList<T>) new ArrayList<>(Arrays.asList(inputArray));

//                inputArray.stream()
//                .filter(element -> valueToRemove != element)
//                .collect(Collectors.toList());
//        ArrayList<T>array = new ArrayList<>(Arrays.asList(inputArray));

//                T[]newArray=Arrays.copyOf(inputArray,array.size());
                //T[] processedArray = Arrays.copyOf(inputArray, processedList.size());

        //return (T[]) processedList.toArray(new Object[processedList.size()]);
        //new try
//        ArrayList<T> list = new ArrayList<T>((Collection<? extends T>) Arrays.asList(inputArray));
//        list.removeIf(val -> val == valueToRemove);
//        inputArray.toArray();
//        return list.toArray(Arrays.copyOf(inputArray,list.size()));
        List<T> processedList = inputArray.stream()
                .filter(element -> !element.equals(valueToRemove))
                .collect(Collectors.toList());
            T[] newArray = (T[]) Array.newInstance(valueToRemove.getClass(), processedList.size());
        return processedList.toArray(newArray);
    }
}
