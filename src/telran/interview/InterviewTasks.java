package telran.interview;

import java.util.*;

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
		//TODO should be done with complexity O[N]
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
}