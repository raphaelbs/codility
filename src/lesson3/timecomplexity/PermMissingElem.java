package lesson3.timecomplexity;
import java.util.ArrayList;
import java.util.Collections;

import utils.IExecuter;
import utils.Log;

public class PermMissingElem {
	
	public static void main(String[] args) {
		int size = 100000;
		ArrayList<Integer> s = new ArrayList<Integer>(size);
		for (int i = 1; i <= size; i++) {
		    s.add(i);
		}
		int rm = (int)Math.round(Math.random() * size);
		System.out.println("Numero removido: " + s.get(rm));
		s.remove(rm);
		s.add(size+1);
		Collections.shuffle(s);
		int [] ss = new int[s.size()];
		for (int i=0; i<ss.length; i++)
			ss[i] = s.get(i);
		
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution(ss.clone());
			}
		});
	}

	public static int solution(int[] A) {
        boolean[] B = new boolean[A.length + 1];
        for (int a: A) {
        	B[a - 1] = true;
        }
        for (int i=0; i<B.length; i++)
        	if (!B[i]) return i + 1;
        return 1;
    }
}
