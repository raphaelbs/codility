package lesson3.timecomplexity;

import utils.IExecuter;
import utils.Log;

public class FrogJmp {
	
	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(10, 85, 30);
			}
		});
	}
	
	public static int solution(int X, int Y, int D) {
		return (int) Math.ceil(((double)Y - (double)X) / (double)D);
	}

}
