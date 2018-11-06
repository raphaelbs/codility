package lesson5.prefixsums;

import java.util.ArrayList;

import utils.IExecuter;
import utils.Log;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution("CAGCCTA",
						new int[] { 2, 5, 0 },
						new int[] { 4, 5, 6 });
			}
		});
		Log.run(new IExecuter() {
			@Override
			public Object execute() {
				return solution("TACGT",
						new int[] { 3, 1, 0 },
						new int[] { 3, 3, 2 });
			}
		});
	}
	
	public static int[] solution(String S, int[] P, int[] Q) {
		Map map = new Map(S);
		int[] impactFactor = new int[P.length];
		
		for (int i = 0; i < P.length; i++) {
			impactFactor[i] = map.getMinimunAt(P[i], Q[i]);
		}
		
		return impactFactor;
	}
	
}

class Map {
	private final ArrayList<Integer> AMap, CMap, GMap, TMap;
	private final String S;
	private final int sLen;
	private final int[] translatedArr;
	
	public Map(String S) {
		this.S = S;
		sLen = S.length();
		translatedArr = new int[sLen];
		AMap = new ArrayList<Integer>(sLen);
		CMap = new ArrayList<Integer>(sLen);
		GMap = new ArrayList<Integer>(sLen);
		TMap = new ArrayList<Integer>(sLen);
		split();
	}
	
	private void split() {
		it : for (int i=0; i<sLen; i++) {
			switch (S.charAt(i)) {
			case 'A':
				AMap.add(i);
				translatedArr[i] = 1;
				continue it;
			case 'C':
				CMap.add(i);
				translatedArr[i] = 2;
				continue it;
			case 'G':
				GMap.add(i);
				translatedArr[i] = 3;
				continue it;
			case 'T':
				TMap.add(i);
				translatedArr[i] = 4;
				continue it;
			}
		}
		AMap.trimToSize();
		CMap.trimToSize();
		GMap.trimToSize();
		TMap.trimToSize();
	}

	public int getMinimunAt(int P, int Q) {
		if (Q - P == 0) return translatedArr[P];
		else if (Q - P == 1) return Math.min(translatedArr[P], translatedArr[Q]);
		
		return 1;
	}
}

class Tree {
	private Tree root, cRight, cLeft;
	public Tree() {
		
	}
}








