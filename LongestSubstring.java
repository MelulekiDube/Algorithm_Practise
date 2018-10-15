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
public class LongestSubstring {

    private final Set<Character> set = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
	int max = 0;
	for (int i = 0; i < s.length(); i++) {
	    for (int j = i; j < s.length(); j++) {
		if (!set.add(s.charAt(j))) {
		    max = Math.max(max, set.size());
		    break;
		} else {
		}
	    }
	    if(set.size() >= s.length()-1) break;
	    max = Math.max(max, set.size());
	    set.clear();
	}
	return max;
    }

    public static void main(String[] args) {
	LongestSubstring ls = new LongestSubstring();
	System.out.println(ls.lengthOfLongestSubstring("jbpnbwwd"));
    }
}
