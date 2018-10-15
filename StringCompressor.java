/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dube_
 */
public class StringCompressor {

    public static String compressString(String originalString) {
	if(originalString.length()<3) return originalString;
	int freq = 1; //default value for the frequency is 1 to signal that we have seen atleast this character we tokinig abotu
	StringBuilder compressedString = new StringBuilder();// we will build the answer here
	int current_index = 1;
	for (; current_index < originalString.length(); ++current_index) {
	    if (originalString.charAt(current_index - 1) == originalString.charAt(current_index)) {
		++freq;
	    } else {//if they are not equal
		compressedString.append(originalString.charAt(current_index - 1)).append(freq);
		freq = 1;//to indicate we have seen the character at this index
	    }
	}
	compressedString.append(originalString.charAt(current_index-1)).append(freq);
	return (compressedString.length() < originalString.length()) ? compressedString.toString() : originalString;
    }

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println(reader.readLine());
    }
}
