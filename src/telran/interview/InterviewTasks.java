package telran.interview;

import java.util.HashMap;
import java.util.HashSet;

public class InterviewTasks {
/**
 * 
 * @param ar array of integer numbers
 * @param sum integer number
 * @return true if the given array contains two numbers, the sum of which equals the given sum value
 */
	public static boolean isSum2(int [] ar, int sum) {
		
		boolean running = true;
		HashSet<Integer> setHelper = new HashSet<>();
		int i = 0;
		while(i < ar.length && running) {
			if(setHelper.contains(sum - ar[i])) {
				running = false;
			} else {
				setHelper.add(ar[i]);
				i++;
			}
		}
		return !running;
}
	/**
	 * 
	 * @param ar array of integer numbers
	 * @param sum integer number
	 * @return true if the given array contains two numbers, the sum of which equals the given sum value
	 */
	public static boolean isSum2N2(int[] ar, int sum) {
		int i = 1;
		int j = 0;
		boolean running = true;
		while(i < ar.length && running) {
			j = i - 1;
			while(j >= 0 ) {
				if(ar[j] + ar[i] == sum) {
					running = false;
					break;
				}
				j--;
			}
			i++;
		}
		return !running;
	}
	/**
	 * 
	 * @param ar array of integer numbers
	 * @return maximal positive number having negative number with the same absolute value
	 */
	public static int getMaxPositiveWithNegativeValue (int ar[]) {
		int res = -1;
		HashSet<Integer> setHelper = new HashSet<>();
		
		for(int num: ar) {
			if(setHelper.contains(-num)) {
				res = Math.max(res, Math.abs(num));
			} else {
				setHelper.add(num);
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param strings - array of strings
	 * @return Map where key - string, value - number of occurrences in the array
	 */
	public static HashMap<String, Long> getMapOccurrences(String[] strings) {
	
		//Optionally, additional bonus if you apply the method "merge" of the interface Map
		//try to understand this method https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction- 
		//it uses Functional interface BiFunction
		HashMap<String, Long> map = new HashMap<String, Long>();
		for (String s : strings)
		{
			map.merge(s, 1L, Long::sum);
		}
		return map;
	}
	/**
	 * Anagram of a string is another string containing all the symbols
	 * from the string, but in different order (see the test cases)
	 * @param string
	 * @param anagram
	 * @return true if the second parameter presents an anagram
	 *  of the string from the first parameter, otherwise false
	 */
	public static boolean isAnagram(String string, String anagram) {
		boolean res = false;
		if(!string.equals(anagram) && string.length() == anagram.length()) {
			HashMap<Character, Integer> mapOccurrences = getStringMap(string);
			res = anagramCheck(anagram, mapOccurrences);
		}
		return res;
	}
	
	private static boolean anagramCheck(String anagram, HashMap<Character, Integer> mapOccurrences) {
		boolean res = true;
		char[] symbols = anagram.toCharArray();
		int i = 0;
		while (i < symbols.length && res) {
			if(mapOccurrences.merge(symbols[i], -1, Integer::sum) < 0) {
				res = false;
			} else {
				i++;
			}
		}
		return res;
	}
	
	private static HashMap<Character, Integer> getStringMap(String string) {
		HashMap<Character, Integer> res = new HashMap<>();
		for(char symbol: string.toCharArray()) {
			res.merge(symbol, 1, Integer::sum);
		}
		return res;
	}
	
}