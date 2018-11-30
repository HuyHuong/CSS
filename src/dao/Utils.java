package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
	public static List<Integer> convertStringArrayToIntegerList(String[] stringArray) {
		List<Integer> intList = new ArrayList<>();
		int i;
		List<String> stringList = Arrays.asList(stringArray);
		for(String s: stringList) {
			i = Integer.parseInt(s);
			intList.add(i);
		}
		return intList;
	}
	
}
