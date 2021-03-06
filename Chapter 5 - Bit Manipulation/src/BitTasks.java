
public class BitTasks {
	public static boolean getBit(int num, int position) {
		return ((num & (1 << position)) != 0);
	}
	
	public static int setBit(int num, int position) {
		return (num | (1 << position));
	}
	
	public static int clearBit(int num, int position) {
		int mask = ~(1 << position);
		return mask & num;
	}
	
	public static int clearBitsMSBThroughI(int num, int position) {
		int mask = (1 << position) - 1;
		return mask & num;
	}
	
	public static int clearBitsIThrough0(int num, int position) {
		int mask = (-1 << (position + 1));
		return mask & num;
	}
	
	public static int updateBit(int num, int position, boolean bitIs1) {
		int value = bitIs1 ? 1 : 0;
		int mask = ~(1 << position);
		return (num & mask) | (value << position); 
	}
}
