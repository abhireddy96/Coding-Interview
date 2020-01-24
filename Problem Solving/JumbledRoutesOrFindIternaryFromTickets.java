import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Problem:
 * Given a set of source->destination routes. 
 * Find proper route from source to destination if order of routes is jumbled.
 * 
 * Input: (Kochi->Bangalore), (Chandigarh->Leh), (Delhi->Chandigarh), (Bangalore->Delhi)
 * Output: Kochi->Bangalore->Delhi->Chandigarh->Leh
 * 
 * Solution:
 *  Create a HashMap
 *  Find Source which is never a destination in set of routes
 *  Loop over and find destinations by fetching from hashmap
 *  
 *  References:
 *  https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
 * 
 */

public class JumbledRoutesOrFindIternaryFromTickets {

	private static List<String> findRoute(String[][] routes) {

		Map<String, String> routeMap = new LinkedHashMap<>();
		List<String> resultList = new LinkedList<>();
		
		// Create hashmap of source->destination
		for (int i = 0; i < routes.length; i++)
			routeMap.put(routes[i][0], routes[i][1]);

		String source = null;
		String destination = null;

		// Find Initial Source among all routes
		for (int i = 0; i < routes.length; i++)
			if (!routeMap.containsValue(routes[i][0]))
				source = routes[i][0];

		resultList.add(source);

		while (true) {
			// Get Destination
			destination = routeMap.get(source);
			if (destination != null) {
				resultList.add(destination);
				//Make current destination as source inorder to find next city
				source = destination;
			} else
				break;
		}
		return resultList;
	}

	public static void main(String[] args) {
		String[][] routes = { { "Kochi", "Bangalore" }, { "Delhi", "Chandigarh" }, { "Bangalore", "Delhi" },
				{ "Chandigarh", "Leh" } };
		System.out.println(findRoute(routes));
	}
}
