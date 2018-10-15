/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview_prep;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dube_
 */
public class OneAway {

    public Set<Character> set = new HashSet<>();

    public static boolean oneAway(String a, String b) {
	int distance = Math.abs(a.length() - b.length());
	int mismactchCounter = 0; // keeps tracks of the mismatch;
	int aIndex = 0, bIndex = 0;
	int limit = Math.min(a.length(), b.length());//terminating condition in the loop
	while (aIndex < limit && bIndex < limit) {
	    if (a.charAt(aIndex) != b.charAt(bIndex)) {
		++mismactchCounter;
	    } else {
		bIndex++;
	    }
	    aIndex++;
	}
	return Math.max(distance, mismactchCounter) < 2;
    }

    public static void main(String[] args) {
	System.out.println(oneAway(" ", "a"));
    }
}
