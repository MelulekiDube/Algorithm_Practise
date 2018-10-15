/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dube_
 */
public class SortingAlgs {

    public static int[] radixSorting(int[] original) {
	int maximum = Integer.MIN_VALUE;
	/* get the maximum number from the list */
	for (Integer integer : original) {
	    if (integer > maximum) {
		maximum = integer;
	    }
	}
	int numberOfDigits = (int) Math.ceil(Math.log10(maximum)) + 1;
	int powerOf10 = 0;
	List<Integer>[] a = new List[10];
	while (powerOf10 <= numberOfDigits) {
	    int divisor = (int) Math.pow(10, powerOf10);
	    for (int i = 0; i < original.length; ++i) {
		int n = original[i] / divisor;
		if (a[n % 10] == null) {
		    a[n % 10] = new ArrayList<>();
		}
		a[n % 10].add(original[i]); //create frequencist table
	    }
	    int i = 0;
	    for (List<Integer> list : a) {
		if (list != null) {
		    for (int j = 0; j < list.size(); ++j) {
			original[i++] = list.get(j);
		    }
		    list.clear();
		}
	    }

	    powerOf10++;
	}
	return original;
    }

    public static void merge(int[] array, int begin, int end) {
	int median = (end + begin) / 2;
	int leftIndex = begin;//this point to the left sub array that we are merging
	int rightIndex = median + 1; // this point to the ryt sub array to be merged
	int[] temArray = new int[(end - begin) + 1];
	int subArrayIndex = 0;
	while (leftIndex <= median && rightIndex <= end) {
	    if (array[leftIndex] <= array[rightIndex]) {
		//copy the item pointed to by leftIndex to tempArray and increment both indexes
		temArray[subArrayIndex++] = array[leftIndex++];
	    } else {
		//copy the item pointed to by leftIndex to tempArray and increment both indexes
		temArray[subArrayIndex++] = array[rightIndex++];
	    }
	}
	/*copy the remaining items to tempArray from the left sub array*/
	while (leftIndex <= median) {
	    temArray[subArrayIndex++] = array[leftIndex++];
	}
	/*copy the ramining items from the right sub array*/
	while (rightIndex <= end) {
	    temArray[subArrayIndex++] = array[rightIndex++];
	}
	for (int i = begin; i <= end; ++i) {
	    array[i] = temArray[i - begin];
	}
    }

    public static void mergeSort(int[] array, int begin, int end) {
	if ((end <= begin)) {
	    return;
	}
	int m = (begin + end) / 2;
	mergeSort(array, begin, m); //sort the left
	mergeSort(array, m + 1, end); // sort the right seperately
	merge(array, begin, end);
    }

    public static void main(String[] args) {
	int[] a = {2, 1};
	int[] extrem = {Integer.MAX_VALUE};
	int[] a1 = {170, 45, 75, 90, 802, 2, 66};
	mergeSort(a1, 0, a1.length - 1);
	System.out.println(Arrays.toString(radixSorting(a)));
	System.out.println(Arrays.toString(radixSorting(extrem)));
	System.out.println(Arrays.toString(radixSorting(a1)));
    }
}
