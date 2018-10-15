/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview_prep;

import java.util.*;

/**
 *
 * @author dube_
 */
public class ThreeSum {

    public static boolean isInValid(int[] numbers) {
	return (numbers == null) || (numbers.length < 3);
    }

    public static Integer[][] threeSum(int[] numbers) {
	if (isInValid(numbers)) {
	    return null;
	}
	Set<Integer[]> answerAsList = new HashSet<>();//building the answer with dynamic datastructe
	Arrays.sort(numbers);
	for (int i = 0; i < numbers.length;) {
	    for (int j = i + 1; j < numbers.length;) {
		/*formation of the pairs*/
		int indexPossibleThird = Arrays.binarySearch(numbers, j+1, numbers.length, -1 * (numbers[i] + numbers[j]));

		if (indexPossibleThird > -1) {
		    Integer[] solution = {numbers[i], numbers[j], numbers[indexPossibleThird]};
		    answerAsList.add(solution);
		}
		++j;
		/*skip duplicates*/
		while (j < numbers.length && numbers[j] == numbers[j - 1]) {
		    ++j;
		}
	    }
	    ++i;
	    /*skip duplicates as that case is already checked*/
	    while (i < numbers.length && numbers[i] == numbers[i - 1]) {
		++i;
	    }
	}
	if (answerAsList.isEmpty()) {
	    return null;
	}
	Integer[][] answer = new Integer[answerAsList.size()][3];
	//copy the arraylist to an array
	Iterator<Integer[]> it = answerAsList.iterator();
	for (int i = 0; i < answerAsList.size(); ++i) {
	    answer[answerAsList.size() - i - 1] = it.next();//nvert the order of putting thngs in
	}
	return answer;
    }

    public static void main(String args[]) {
	int[] test = {-1, 0, 1, 2, -1, -4};
	Integer[][] result = threeSum(test);
	for (Integer[] answer : result) {
	    System.out.println(Arrays.toString(answer));
	}
    }
}
