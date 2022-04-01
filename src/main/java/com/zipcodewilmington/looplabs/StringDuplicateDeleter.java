package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public static String[] newArr;

    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
        newArr = Arrays.copyOf(intArray, intArray.length);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String [] newArr = Arrays.copyOf(super.array, super.array.length);
        //removeDuplicatesExactly(maxNumberOfDuplications);
        for (int i = 0; i < newArr.length; i++) {
                int count = getNumberOfOccurrences(newArr, newArr[i]);
                if (count >= maxNumberOfDuplications) {
                    newArr = removeValue(newArr, newArr[i]);
                    i--;
                }
        }
        String[] newArr2 = Arrays.copyOf(newArr, newArr.length);
        return newArr2;

    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String [] newArr = Arrays.copyOf(super.array, super.array.length);
        //removeDuplicatesExactly(maxNumberOfDuplications);
        for (int i = 0; i < newArr.length; i++) {
                int count = getNumberOfOccurrences(newArr, newArr[i]);
                if (count == exactNumberOfDuplications) {
                    newArr = removeValue(newArr, newArr[i]);
                    i--;
                }
        }
        String[] newArr2 = Arrays.copyOf(newArr, newArr.length);
        return newArr2;
    }

    public static String[] removeValue(String[] objectArray, String objectToRemove) {
        List<String> list = new ArrayList<>(Arrays.asList(objectArray));
        list.removeAll(Arrays.asList(objectToRemove));
        objectArray = list.toArray(new String[0]);


        return objectArray;
    }

    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        int count = 0;
        for (Object s : objectArray) {
            if (s.equals(objectToCount)) {
                count++;
            }
        }
        return count;
    }
}
