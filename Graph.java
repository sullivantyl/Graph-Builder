import java.util.HashMap;
import java.util.Iterator;

class Graph {
	final boolean debug = Main.debug;

	// map node names (Strings) to Node objects
	HashMap<String, Node> allNodes = new HashMap<String, Node>();

	/** create a new Node with given name, if not already in existence
	 * (if already there, use that)
	 * @return new/existing Node
	 */
	Node addNode(String name) {
		Node newOne;
		// see if it exists already
		newOne = allNodes.get(name);
		if (newOne!= null) {
			// is it an error if it doesn't exist?  Don't want a second one.
			System.out.println("Node " + name + " already exists");
		} else {
			// not in existence.  Create new one and remember it
			newOne = new Node(name);
			allNodes.put(name, newOne);
			if (debug) 
				System.out.println(" Adding node " + name);
		}
		return newOne;
	}

	/** add an edge, both ways, between specified nodes.
	 * (Could Create nodes quietly if desired (easier on user))
	 */
	void addEdge(String from, String to) {
		Node fromNode = allNodes.get(from);
		Node toNode = allNodes.get(to);
	
		if (fromNode == null || toNode == null) {
			System.out.println("One of these nodes does not exist yet: "
					   + from + ", " + to);
			if(fromNode == null) {
				System.out.println(from + " did not exist...");
				addNode(from);
			}
			if(toNode == null) {
				System.out.println(to + " did not exist...");
				addNode(to);
			}
			addEdge(from, to);
			return;
		} else if (fromNode == toNode) {
			System.out.println("Cannot link to self.");
		} else {
			fromNode.addEdge(toNode);
			toNode.addEdge(fromNode);
		}
	}

	/** show entire graph */
	void show() {
		// cycle through all Nodes in hashmap
		for (Node n : allNodes.values()) {
			n.show();
		}
	}

	// same as show, but using "Iterator" explicitly, and keySet as other option
	void show1() {
		Iterator<Node> itr = allNodes.values().iterator();
		while (itr.hasNext()) {
			Node n = itr.next();
			n.show();
		}
	}
	
	void depthWalk(String from) {
		(allNodes.get(from)).walk();
		Iterator<Node> itr = allNodes.values().iterator();
		while (itr.hasNext()) {
			Node n = itr.next();
			n.resetMark();
		}
		System.out.println("|| end");
	}
}
