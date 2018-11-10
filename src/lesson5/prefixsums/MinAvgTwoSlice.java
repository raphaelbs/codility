package lesson5.prefixsums;

import java.util.LinkedList;

import utils.IExecuter;
import utils.Log;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }); 
			}
		});
	}
	
	public static int solution(final int[] A) {
		AverageManager[] avgManager = new AverageManager[A.length];
		int beginAt = 0;
		double minimun = Double.MAX_VALUE;
		
		for (int i=0; i<A.length; i++) {
			avgManager[i] = new AverageManager(i, A[i]);
			for (int j=i+1; j<A.length; j++) {
				avgManager[i].add(A[j], j);
			}
			if (avgManager[i].minimun < minimun) {
				minimun = avgManager[i].minimun;
				beginAt = avgManager[i].beginAt;
			}
		}
			
		
		return beginAt;
	}
}

class AverageManager {
	private final LinkedList<Average> avgs;
	final int beginAt;
	double minimun = Double.MAX_VALUE;
	
	public AverageManager(final int beginAt, final int baseValue) {
		avgs = new LinkedList<Average>();
		add(new Average(baseValue, baseValue, 2));
		this.beginAt = beginAt;
	}
	
	public void add(final int newValue, final int indexValue) {
		add(new Average( avgs.getLast().avg, newValue, indexValue + 1 ));
	}
	
	private void add(final Average avg) {
		avgs.add(avg);
		if (avg.avg < minimun) {
			minimun = avg.avg;
		}
	}
}

class Average {
	final double avg;
	
	public Average(final double prevAvg, final int newValue, final int indexValue) {
		avg = prevAvg / indexValue + (newValue * indexValue - prevAvg)/(indexValue * (indexValue + 1));
	}
}
