package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] storedArray;

    public ArrayUtility(T[] storedArray){
        this.storedArray = storedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value){
        Integer count = 0;
        for(T t: arrayToMerge){
            if(t.equals(value)){
                count++;
            }
        }
        return count + getNumberOfOccurrences(value);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        T mostCommonValue = null;
        Integer mostCommonAmount = 0;

        boolean[] beenCheckedStored = new boolean[storedArray.length];
        boolean[] beenCheckedToMerge = new boolean[arrayToMerge.length];

        for(int i = 0; i < storedArray.length; i++){
            if(!beenCheckedStored[i]){
                Integer amount = 1;
                T value = storedArray[i];
                for(int j = i+1; j < storedArray.length; j++){
                    if(value.equals(storedArray[j])){
                        amount++;
                        beenCheckedStored[j] = true;
                    }
                }
                for(int j = 0; j < arrayToMerge.length; j++){
                    if(value.equals(arrayToMerge[j])){
                        amount++;
                        beenCheckedToMerge[j] = true;
                    }
                }
                if(amount > mostCommonAmount){
                    mostCommonAmount = amount;
                    mostCommonValue = value;
                }
            }
        }
        
        for(int i = 0; i < arrayToMerge.length; i++){
            if(!beenCheckedToMerge[i]){
                Integer amount = 1;
                T value = arrayToMerge[i];
                for(int j = i+1; j < arrayToMerge.length; j++){
                    if(value.equals(arrayToMerge[j])){
                        amount++;
                        beenCheckedToMerge[j] = true;
                    }
                }
                if(amount > mostCommonAmount){
                    mostCommonAmount = amount;
                    mostCommonValue = value;
                }
            }
        }
        return mostCommonValue;
    }

    public Integer getNumberOfOccurrences(T value){
        Integer count = 0;
        for(T t: storedArray){
            if(t.equals(value)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T value){
        Integer count = 0;
        for(T t : storedArray){
            if(t.equals(value)){
                count++;
            }
        }
        T[] returnArray = (T[]) Array.newInstance(value.getClass(), storedArray.length - count);
        Integer index = 0;
        for(T t : storedArray){
            if(!t.equals(value)){
                returnArray[index] = t;
                index++;
            }
        }
        return returnArray;
    }
}
