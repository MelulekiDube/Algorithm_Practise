package interview_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dube_
 */
public class CaesarCipher {

    public boolean inRange(int lowest, int maximum, int number) {
	return number >= lowest && number <= maximum;
    }

    public String encrypt(String originlString, int shiftBy) {
	StringBuilder answer = new StringBuilder();
	int base = 0;
	int max = 0;
	boolean specialCharcter = false;
	for (char c : originlString.toCharArray()) {
	    char newChar = c;
	    if (inRange('A', 'Z', c)) { //if its an upper case
		base = 'A';
		max = 'Z';
	    } else if (inRange('a', 'z', c)) { //if its a lowe case letter
		base = 'a';
		max = 'z';
	    } else if (inRange('0', '9', c)) {//if its a number
		base = '0';
		max = '9';
	    } else {
		specialCharcter = true;
	    }
	    if (!specialCharcter) {
		int number = (((c) + shiftBy));
		if (shiftBy >= 0) {
		    newChar = (char) ((number > max) ? (number % (max + 1)) + base : number);
		} else {
		    newChar = (char) ((number < base) ? max+1-(base - number) : number);
		}
	    }
	    answer.append(newChar);
	    specialCharcter = false;
	}
	return answer.toString();
    }

    public static void main(String[] args) throws IOException {
	CaesarCipher cc = new CaesarCipher();
	BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	String inpput = consoleReader.readLine();
	System.out.println(cc.encrypt(inpput.split(":")[1], Integer.parseInt(inpput.split(":")[0])));
    }
}
