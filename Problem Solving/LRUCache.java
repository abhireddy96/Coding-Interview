

import java.util.Deque; 
import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Iterator; 

/** https://www.geeksforgeeks.org/lru-cache-implementation/ **/

public class LRUCache { 
	
	// store keys of cache 
	static Deque<Integer> dq; 

	// store references of key in cache 
	static HashSet<Integer> map; 

	// maximum capacity of cache 
	static int cacheSize; 

	LRUCache(int n) 
	{ 
		dq = new LinkedList<>(); 
		map = new HashSet<>(); 
		cacheSize = n; 
	} 

	/* Refers key x with in the LRU cache */
	public void refer(int x) 
	{ 
		if (!map.contains(x)) { 
			if (dq.size() == cacheSize) { 
				int last = dq.removeLast(); 
				map.remove(last); 
			} 
		} 
		else { 
			/* The found page may not be always the last element, even if it's an 
			intermediate element that needs to be removed and added to the start 
			of the Queue */
			int index = 0;
			Iterator<Integer> itr = dq.iterator(); 
			while (itr.hasNext()) { 
				if (itr.next() == x) 
					break; 
				index++; 
			} 
			dq.remove(index); 
		} 
		dq.push(x); 
		map.add(x); 
	} 

	// display contents of cache 
	public void display() 
	{ 
		Iterator<Integer> itr = dq.iterator(); 
		while (itr.hasNext()) { 
			System.out.print(itr.next() + " "); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		LRUCache cache = new LRUCache(4); 
		cache.refer(1); 
		cache.refer(2); 
		cache.refer(3); 
		cache.refer(1); 
		cache.refer(4); 
		cache.refer(5); 
		cache.display(); 
	} 
} 
