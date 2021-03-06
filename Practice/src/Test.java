import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {
	public static void main(String[] strings) {
		// System.out.println(add(5, 40));
		// System.out.println(add(20, 30));
		// System.out.println(add(4, 30));

		// System.out.println(findTheDifference("abcd", "abcde"));
		// int [] nums = {1,1,0,5, 0,3,6, 0, 12, 0};
		// int [] nums = {1 ,2 ,3 ,4 ,5};
		// moveZeroes(nums);
		// for (int num : nums) {
		// System.out.println(num);
		// }

		// System.out.println(longestPalindrome("civilwartestingwhetherthatnaption"
		// +
		// "oranynartionsoconceivedandsodedicatedcanlongendureWeareqmetona" +
		// "greatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthat" +
		// "fieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthat" +
		// "nationmightliveItisaltogetherfangandproperthatweshoulddothisBu" +
		// "tinalargersensewecannotdedicatewecannotconsecratewecannothallo" +
		// "wthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecr" +
		// "ateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittl" +
		// "enotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydi" +
		// "dhereItisforusthelivingrathertobededicatedheretotheulnfinishedw" +
		// "orkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherfo" +
		// "rustobeherededicatedtothegreattdafskremainingbeforeusthatfromth" +
		// "esehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygave" +
		// "thelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedea" +
		// "dshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirtho" +
		// "ffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshall" +
		// "notperishfromtheearth"));

		// List<String> time = readBinaryWatch(0);
		// for (String s : time) {
		// System.out.println(s);
		// }

		// System.out.println(addStrings("99999213456465", "13216546"));
		// System.out.println(addStrings("0", "9"));
		System.out.println(reverseVowels("holle"));
		int [][] array = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
			};
		System.out.println(array[0].length);
	}

	private static void spiralMatrix(int[][] matrix) {
	}
	
	public static int find(int[] array, int num) {
		// figure out the pivot, pivot being the tail of the array
		int pivot = pivot(array, num, 0, array.length);
		// do binary search
		if (num == array[pivot])
			return pivot;
		else if (num < array[pivot])
			return binarySearch(array, num, 0, pivot);
		else
			return binarySearch(array, num, pivot + 1, array.length - 1);
	}

	private static int pivot(int[] array, int num, int left, int right) {
		if (left > right)
			return right;
		int mid = (left + right) / 2;

		if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
			return pivot(array, num, mid + 1, right);
		} else {
			return pivot(array, num, left, mid - 1);
		}
	}

	private static int binarySearch(int[] array, int num, int left, int right) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (num == array[mid])
			return mid;
		else if (num < array[mid])
			return binarySearch(array, num, left, mid - 1);
		else
			return binarySearch(array, num, mid + 1, right);
	}

	public static String reverseVowels(String s) {
		char[] characters = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !isVowel(characters[left]))
				left++;
			while (left < right && !isVowel(characters[right]))
				right--;
			swap(characters, left, right);
			left++;
			right--;
		}

		return new String(characters);
	}

	private static void swap(char[] characters, int left, int right) {
		char temp = characters[left];
		characters[left] = characters[right];
		characters[right] = temp;
	}

	private static boolean isVowel(char c) {
		return c == 'e' || c == 'u' || c == 'a' || c == 'o' || c == 'i';
	}

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n >>>= 1;
		}
		return count;
	}

	private static class Adder {
		int number;
		int carry;

		public Adder(char c1, char c2, int carry) {
			int sum = (c1 - '0') + (c2 - '0') + carry;
			System.out.println(c2 - '0');
			number = sum % 10;
			this.carry = sum / 10;
		}

	}

	public static String addStrings(String num1, String num2) {
		String longer;
		String shorter;
		StringBuilder result = new StringBuilder();
		longer = num1.length() >= num2.length() ? num1 : num2;
		longer = new StringBuffer(longer).reverse().toString();

		shorter = num1.length() < num2.length() ? num1 : num2;
		shorter = new StringBuffer(shorter).reverse().toString();

		int counter = 0;
		int carry = 0;

		while (counter < shorter.length()) {
			Adder sum = new Adder(longer.charAt(counter),
					shorter.charAt(counter), carry);
			result.append(sum.number);
			carry = sum.carry;
			counter++;
		}

		while (counter < longer.length()) {
			Adder sum = new Adder(longer.charAt(counter), '0', carry);
			result.append(sum.number);
			carry = sum.carry;
			counter++;
		}

		return result.reverse().toString();
	}

	public int converter(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}

	}

	public List<String> readBinaryWatch2(int num) {
		List<String> list = new ArrayList<String>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount(h * 64 + m) == num) {
					list.add(String.format("%d:%02d", h, m));
				}
			}
		}
		return list;
	}

	public static List<String> readBinaryWatch(int num) {
		int maxLEDs = 10;
		if (num > maxLEDs)
			return new ArrayList<String>();
		else {
			StringBuilder seed = new StringBuilder();
			for (int i = 0; i < num; i++) {
				seed.append("1");
			}
			for (int i = 0; i < maxLEDs - num; i++) {
				seed.append("0");
			}
			List<String> permutations = generatePerms(seed.toString());
			List<String> result = new ArrayList<String>();
			for (String permutation : permutations) {
				String s = interprete(permutation);
				if (s.length() > 0) {
					result.add(s);
				}
			}
			return result;
		}
	}

	private static String interprete(String permutation) {
		String hString = permutation.substring(0, 4);
		String mString = permutation.substring(4, permutation.length());
		int hour = Integer.parseInt(hString, 2);
		int minute = Integer.parseInt(mString, 2);
		if (hour <= 11 && minute <= 59) {
			return hour + ":" + (minute < 10 ? "0" + minute : minute);
		} else {
			return "";
		}
	}

	public static List<String> generatePerms(String seed) {
		if (seed.length() == 0) {
			List<String> list = new ArrayList<String>();
			list.add("");
			return list;
		} else {
			List<String> list = new ArrayList<String>();
			int memo[] = new int[256];
			for (int i = 0; i < seed.length(); i++) {
				char firstChar = seed.charAt(i);
				if (memo[firstChar] == 0)
					memo[firstChar]++;
				else
					continue;
				String subString = seed.substring(0, i)
						+ seed.substring(i + 1, seed.length());
				List<String> newPerms = generatePerms(subString);
				for (String perm : newPerms) {
					String s = firstChar + perm;
					list.add(s);
				}
			}
			return list;
		}
	}

	public static int longestPalindrome(String s) {
		int maxLength = 0;
		int[] map = new int[256];
		char[] sChar = s.toCharArray();
		for (int i = 0; i < sChar.length; i++) {
			map[sChar[i]]++;
		}

		boolean anyOdd = false;
		for (int i = 0; i < map.length; i++) {
			if (map[i] % 2 == 0) {
				maxLength += map[i];
			} else {
				if (map[i] > 1)
					maxLength += map[i] - 1;
				anyOdd = true;
			}
		}
		if (anyOdd)
			maxLength++;
		return maxLength;
	}

	public static void moveZeroes(int[] nums) {
		int firstZero = 0;
		int firstNumber = 0;
		int length = nums.length;
		while (firstZero < length) {
			while (firstZero < length && nums[firstZero] != 0) {
				firstZero++;
			}
			if (firstZero == length)
				break;
			firstNumber = firstZero + 1;
			while (firstNumber < length && nums[firstNumber] == 0)
				firstNumber++;
			if (firstNumber == length)
				break;
			swap(nums, firstZero, firstNumber);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[j] ^ nums[i];
		nums[i] = nums[i] ^ nums[j];
	}

	private static int add(int a, int b) {
		if (b == 0)
			return a;
		int carry = (a & b) << 1;
		int sum = a ^ b;
		return add(sum, carry);
	}

	public static char findTheDifference(String s, String t) {
		int[] map = new int[256];
		for (int i = 0; i < t.length(); i++) {
			map[t.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]--;
		}
		for (int i = 0; i < map.length; i++) {
			if (map[i] != 0) {
				System.out.println((char) i);
				return (char) i;
			}
		}
		return '\0';
	}

	
}