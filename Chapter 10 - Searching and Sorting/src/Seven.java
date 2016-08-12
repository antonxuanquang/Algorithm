import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.validation.Validator;

import externalSort.ExternalSort;

public class Seven {

	/*
	 * 
	 * Missing Int: Given an input file with four billion non-negative integers,
	 * provide an algorithm to generate an integer that is not contained in the
	 * file. Assume you have 1 GB of memory available for this task
	 * 
	 * FOLLOW UP: What if you have only 10 MB of memory?? Assume that all values
	 * are distinct and we now have no more than one billion non-negative
	 * integers.
	 */

	public static int findOpenNumber(String filename)
			throws FileNotFoundException {
		int rangeSize = (1 << 18);

		/* Get count of number of values within each block */
		int[] blocks = getCountPerBlock(filename, rangeSize);

		/* Find a block with a missing value */
		int blockIndex = findBlockWithMissing(blocks, rangeSize);
		if (blockIndex < 0)
			return -1;

		/* Create bit vector for items within this range */
		byte[] bitVector = getBitVectorForRange(filename, blockIndex, rangeSize);

		/* Find a zero in the bit vector */
		int offset = findZero(bitVector);
		if (offset < 0)
			return -1;

		/* Compute missing value */
		return blockIndex * rangeSize + offset;
	}

	private static int[] getCountPerBlock(String filename, int rangeSize)
			throws FileNotFoundException {
		int arraySize = Integer.MAX_VALUE / rangeSize + 1;
		int[] blocks = new int[arraySize];

		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNextInt()) {
			int value = in.nextInt();
			blocks[value / rangeSize]++;
		}
		in.close();
		return blocks;
	}

	private static int findBlockWithMissing(int[] blocks, int rangeSize)
			throws FileNotFoundException {
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < rangeSize) {
				return i;
			}
		}
		return -1;
	}

	private static byte[] getBitVectorForRange(String filename, int blockIndex,
			int rangeSize) throws FileNotFoundException {
		int startRange = blockIndex * rangeSize;
		int endRange = startRange + rangeSize;
		byte[] bitVector = new byte[rangeSize / Byte.SIZE];
		
		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNextInt()) {
			int value = in.nextInt();
			
			/* If the number is inside the block that's missing numbers,
			 * we record it*/
			if (startRange <= value && value < endRange) {
				int offset = value - endRange;
				int mask = (1 << (offset & Byte.SIZE));
				bitVector[offset / Byte.SIZE] |= mask;
			}
		}
		in.close();
		return bitVector;
	}

	private static int findZero(byte[] bitVector) {
		for (int i = 0; i < bitVector.length; i++) {
			if (bitVector[i] != ~0) { // if not all 1s
				int bitIndex = findZero(bitVector[i]);
				return i * Byte.SIZE + bitIndex;
			}
		}
		return -1;
	}

	private static int findZero(byte b) {
		for (int i = 0; i < Byte.SIZE; i++) {
			int mask = 1 << i;
			if ((b & mask) == 0) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * 
	 * 1GB RAM's solution
	 * 
	 */
	
	public static int findOpenNumber2(String fileName) throws FileNotFoundException{
		long numberOfInts = ((long) Integer.MAX_VALUE + 1);
		byte[] bitField = new byte[(int) (numberOfInts / 8)];
		
		Scanner in = new Scanner(new FileReader(fileName));
		while (in.hasNextInt()) {
			int n = in.nextInt();
			bitField[n / 8] |= 1 << (n % 8);
		}
		
		for (int i = 0; i < bitField.length; i++) {
			for (int j = 0; j < 8; i++) {
				if ((bitField[i] & (1 << j)) == 0) {
					return i * 8 + j;
				}
			}
		}
		return -1;
	}
	
	public static void main (String[]args) {
		Random random = new Random();
		try {
			Writer wr = new FileWriter("number.txt");
			for (int i = 0; i < 20000000; i++) {
				wr.write(random.nextInt(20000000) + "\n");
			}
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			System.out.println(findOpenNumber2("number.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<File> files = new ArrayList<File>();
//		files.add(new File("number.txt"));
//		File outFile = new File("sorted.txt");
//		try {
//			ExternalSort.mergeSortedFiles(files, outFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
