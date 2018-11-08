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
	private final ArrayList<Integer> AMap, CMap, GMap;
	private final TreeManager ATree, CTree, GTree;
	private final String S;
	private final int sLen;
	private final int[] translatedArr;
	
	public Map(final String S) {
		this.S = S;
		sLen = S.length();
		translatedArr = new int[sLen];
		AMap = new ArrayList<Integer>(sLen);
		CMap = new ArrayList<Integer>(sLen);
		GMap = new ArrayList<Integer>(sLen);
		populateMaps();
		ATree = new TreeManager(AMap);
		CTree = new TreeManager(CMap);
		GTree = new TreeManager(GMap);
	}
	
	private void populateMaps() {
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
				translatedArr[i] = 4;
				continue it;
			}
		}
		AMap.trimToSize();
		CMap.trimToSize();
		GMap.trimToSize();
	}

	public int getMinimunAt(final int P, final int Q) {
		if (ATree.containAnyBetween(P, Q)) return 1;
		if (CTree.containAnyBetween(P, Q)) return 2;
		if (GTree.containAnyBetween(P, Q)) return 3;
		return 4;
	}
}

class TreeManager { 
    private Node root;
    
    public TreeManager(final ArrayList<Integer> list) {
    	root = listToBST(list, 0, list.size() - 1);
    }
    
    private Node listToBST(final ArrayList<Integer> list, final int start, final int end) {
        if (start > end) { 
            return null; 
        }
        
        int mid = (start + end) / 2; 
        Node node = new Node(list.get(mid)); 
        node.left = listToBST(list, start, mid - 1);
        node.right = listToBST(list, mid + 1, end); 
          
        return node; 
    }

    public boolean containAnyBetween(final int P, final int Q) {
    	return containAny(root, P, Q);
    }
    
    private boolean containAny(final Node currentNode, final int P, final int Q) {
    	if (currentNode == null) return false;
    	if (currentNode.data == P || currentNode.data == Q) return true;
    	if (currentNode.data > P && currentNode.data < Q) return true;
    	if (currentNode.data > Q) return containAny(currentNode.right, P, Q);
    	if (currentNode.data < P) return containAny(currentNode.left, P, Q);
    	return false;
    }
}

class Node { 
    
    int data; 
    Node left, right; 
      
    Node(final int d) { 
        data = d; 
        left = right = null; 
    } 
} 






