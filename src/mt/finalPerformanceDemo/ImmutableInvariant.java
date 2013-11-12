package mt.finalPerformanceDemo;

public class ImmutableInvariant implements Invariant {
	private volatile ValueHolder myValues = new ValueHolder(0);

	private static class ValueHolder {
		private final int myA;
		private final int myB;
//		private final String text;
		private final byte[] dummy = new byte[Invariant.SIZE];

		ValueHolder(int a) {
			myA = a;
			myB = 42 - a;
			dummy[dummy.length/2] = (byte) System.nanoTime();
//			text = String.format("%d + %d", myA, myB);
		}

		ValueHolder updateA(int a) {
			return new ValueHolder(a);
		}
		ValueHolder updateB(int b) {
			return new ValueHolder(42 - b);
		}
		int sum() {
			return myA + myB + dummy[dummy.length/2];// + text.hashCode();
		}
	}

	public void setA(int newValue) {
		myValues = myValues.updateA(newValue);
	}

	public void setB(int newValue) {
		myValues = myValues.updateB(newValue);
	}

	public int sum() {
		return myValues.sum();
	}
}
