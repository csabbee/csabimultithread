package mt.finalPerformanceDemo;

public class SynchronizedInvariant implements Invariant {
	private int myA = 42;
	private int myB = 0;
	//private String text;
	private final byte[] dummy = new byte[Invariant.SIZE];

	public SynchronizedInvariant() {
		dummy[dummy.length/2] = (byte) System.nanoTime();
	}

	public synchronized void setA(int newValue) {
		myA = newValue;
		myB = 42 - myA;
//		text = String.format("%d + %d", myA, myB);
	}
	public synchronized void setB(int newValue) {
		myB = newValue;
		myA = 42 - myB;
//		text = String.format("%d + %d", myA, myB);
	}
	public synchronized int sum() {
		return myA + myB + dummy[dummy.length/2];// + text.hashCode();
	}
}
