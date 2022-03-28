package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public static Integer[] newArr;

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
        newArr = Arrays.copyOf(intArray, intArray.length);
    }


    @Override
    public  Integer[] removeDuplicates(int maxNumberOfDuplications) {
        //removeDuplicatesExactly(maxNumberOfDuplications);
        return new Integer[0];
    }

    @Override
    public  Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int count = 0;
       for (int i = 0; i < newArr.length; i++){
           count = getNumberOfOccurrences(newArr, i);
           if (count == exactNumberOfDuplications){
               removeValue(newArr, newArr[i]);
               i--;
           }
       }

        return newArr;
    }


    //reuse methods
    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        int count = 0;
        for (Object s : objectArray) {
            if (s.equals(objectToCount)) {
                count++;
            }
        }
        return count;
    }

    public static Integer[] removeValue(Integer[] objectArray, Integer objectToRemove) {
        List<Integer> list = new ArrayList<>(Arrays.asList(objectArray));
        list.removeAll(Arrays.asList(objectToRemove));
        objectArray = list.toArray(new Integer[0]);


        return objectArray;
    }
}
