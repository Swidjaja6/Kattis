
public class minion implements Comparable<minion>{
	int low, high;
	public minion(int low, int high) {
		this.low = low;
		this.high = high;
	}
	int range = high - low + 1;
	public minion intersection(minion m) {
		if(high < m.low || m.high < low) {
			return null;
		}
		return new minion(Math.max(low, m.low), Math.min(high, m.high));
	}
	@Override
	public int compareTo(minion i) {
		return high - i.high;
	}
	public String toString() {
		return "[" + low + ", " + high + "]";
	}
}
