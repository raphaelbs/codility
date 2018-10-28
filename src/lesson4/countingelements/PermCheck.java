package lesson4.countingelements;

import java.util.HashMap;

import utils.IExecuter;
import utils.Log;

public class PermCheck {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 4, 1, 3, 2 });
			}
		});
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(new int[] { 4, 1, 3 });
			}
		});
	}
	
	public static int solution(int[] A) {
		HashMap<Integer, Boolean> dic = new HashMap<>(A.length + 1);
		
		for (int i=0; i<A.length; i++) {
			dic.put(i + 1, true);
		}
		
		for (int a: A) {
			dic.remove(a);
		}
		
		if (dic.size() > 0) {
			return 0;
		}
		
		return 1;
	}

}
