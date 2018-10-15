/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview_prep;

/**
 *
 * @author dube_
 */
public class AddDigit {

    public int addDigits(int num) {
	int maximum_loop = (int) Math.ceil(Math.log10(num));
	int accumulator = 0;//answer is accumulated to this

	while (num > 9) {
	    for (int i = 0; i <= maximum_loop; ++i) {
		accumulator += num % 10;
		num /= 10;
	    }
	    num = accumulator;
	    accumulator = 0;
	}
	return num;
    }

    public static void main(String[] args) {
	assert args == null;
	AddDigit ad = new AddDigit();
	System.out.println(ad.addDigits(38));
    }

}
