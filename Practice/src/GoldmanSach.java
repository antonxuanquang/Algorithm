import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;

public class GoldmanSach {
	static void StairCase(int n) {
		for (int i = 0; i <= n; i++) {
			String space = append(' ', n - i);
			String pow = append('#', i);
			System.out.println(space + pow);
		}
	}
	
	static String append(char character, int number) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(character);
		}
		return sb.toString();
	}
	
	static String runLengthEncode(String input) {
		if (input.length() == 0) return "";
		
        StringBuilder sb = new StringBuilder();
        char current_char = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (current_char != input.charAt(i)) {
            	sb.append(count);
            	sb.append(current_char);
                current_char = input.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(current_char);
        return sb.toString();
    }
	
	static int countPairs(int k, int[] a) {
        
        
        /* O(n^2) solution
        
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((i != j) && (a[i] + a[j] == k)) {
                    count++;
                }
            }
        }
        
        */
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: a) {
        	if (map.containsKey(num)) {
        		int count = map.get(num);
        		count++;
        		map.put(num, count);
        	} else {
        		map.put(num, 1);
        	}
        }
        
        int count = 0;
        for (int key: map.keySet()) {
        	if (key > k) continue;
        	int number = k - key;
        	if (map.containsKey(number)) {
        		count += map.get(key);
        	}
        }
        
        return count / 2;
    }
	
	static int firstIndex(int number, int startIndex, int lowerBound, int [] array) {
		while (startIndex >= lowerBound && array[startIndex] == number) {
			startIndex--;
		}
		return startIndex + 1;
	}
	
	public static void main (String[]args) {
//		StairCase(10);
//		System.out.println(runLengthEncode(""));
		int [] a =  {5,2,3,3,2,4,2,5};
		System.out.println(countPairs(6, a));
	}
}
