package seven;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Edge {

	IN, OUT, STRAIGHT;

	private static final Edge[] VALUES = Edge.values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();

	public static Edge randomEdge() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}
	
	public boolean match(Edge edge) {
		if (edge != null && edge != this) return false;
		return true;
	}
}
