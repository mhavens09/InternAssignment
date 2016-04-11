/* Matthew Havens
 * Date Created: 4/7/2016
 * Updated: 4/10/2016
 * 
 * ConvertNumber.java
 * 
 * This program is designed to output a string representation of an integer value
 * 
 * Assumptions:
 * 	- The integer input value is in the range -999,999 to 999,999
 *  - Only one integer value is entered at a time
 */

public class ConvertNumber {
	
    private static String outputString = "";
    
    // "tens" array declares String values for every 10 numbers 0 through 90
    private static final String[] tens = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

    // "ones" array declares String values for 0 through 19
    private static final String[] ones = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
    };
    
    //--------------------------------------------------------------------------
    // Calculate(subNumber) calculates the string representation of 'subNumber'
    // and updates 'outputString' by appending the correct string to the end.
    //--------------------------------------------------------------------------
	private static void calculate(int subNumber){
		int remainder = 0; // 'remainder' refers to nnnXXX part of 'subNumber'
		String hundred = "";
		
		if(subNumber < 1000){
			if(subNumber >= 100)
				hundred = " hundred";
			if(subNumber < 20)
				outputString = outputString + ones[subNumber/100] + hundred + ones[(subNumber%100)];
			else
				outputString = outputString + ones[subNumber/100] + hundred + tens[(subNumber%100)/10] + ones[(subNumber%100)%10];
		}
		else{
			remainder = subNumber % 1000;
			subNumber = subNumber / 1000;
			calculate(subNumber);
			outputString = outputString + " thousand";
			calculate(remainder);
		}
	}
	
	public static void main(String [ ] args){
		String inputString = args[0];

		int inputInt = Integer.parseInt(inputString);

		if(inputInt < 0){
			outputString = " negative";
			inputInt = inputInt*-1;
			calculate(inputInt);
		}
		else if(inputInt == 0){
			outputString = " zero";
		}
		else{
			calculate(inputInt);
		}	
		System.out.printf(" -->" + outputString);
	}
}
