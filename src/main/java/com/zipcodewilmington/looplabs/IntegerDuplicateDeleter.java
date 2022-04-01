package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public Integer[] newArr;

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
        newArr = Arrays.copyOf(intArray, intArray.length);
    }


    @Override
    public  Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer [] newArr = Arrays.copyOf(super.array, super.array.length);
        //removeDuplicatesExactly(maxNumberOfDuplications);
        for (int i = 0; i < newArr.length; i++) {
                int count = getNumberOfOccurrences(newArr, newArr[i]);
                if (count >= maxNumberOfDuplications) {
                    newArr = removeValue(newArr, newArr[i]);
                    i--;
                }
        }
        Integer[] newArr2 = Arrays.copyOf(newArr, newArr.length);
        return newArr2;
    }

    @Override
    public  Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer [] newArr = Arrays.copyOf(super.array, super.array.length);
        //removeDuplicatesExactly(maxNumberOfDuplications);
        for (int i = 0; i < newArr.length; i++) {
                int count = getNumberOfOccurrences(newArr, newArr[i]);
                if (count == exactNumberOfDuplications) {
                    newArr = removeValue(newArr, newArr[i]);
                    i--;
                }
        }
        Integer[] newArr2 = Arrays.copyOf(newArr, newArr.length);
        return newArr2;
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
