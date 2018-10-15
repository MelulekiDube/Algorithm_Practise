/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview_prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arrayadd {

    public static Set<Integer> set = new HashSet<>();

    public static boolean invalid(int[] numbers) {
	return numbers == null || numbers.length < 2;
    }

    public static int[] addArray(int[] numbers, int Target) {
	if (invalid(numbers)) {
	    return null;
	}
	int[] answer = new int[2];
	for (int i : numbers) {
	    set.add(i);
	}
	for (int i = 0; i < numbers.length; i++) {
	    if (set.contains(Target - numbers[i])) {
		answer[0] = numbers[i];
		answer[1] = Target - numbers[i];
		return answer;
	    }
	}
	return null;
    }

    public static void main(String[] args) {
	int[] num = {2, 7, 11, 15};
	int[] answer = {1, 7};
	assert Arrays.equals(addArray(num, 9), answer) : "wrong answer";
    }
}
