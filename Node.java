import java.util.Vector;

class Node {
	
	final boolean debug = Main.debug;
	boolean mark = false;
	String label;
	Vector<Node>links = new Vector<Node>();

	Node(String name) {
		label = name;
	}

	void addEdge(Node to) {
		if (links.contains(to)) {
			System.out.println("Already linked " + label + " => " + to.label);
			return;
		}
		if (debug)
			System.out.println(" Edge " + label + " => " + to.label);
		// could check if link is already there, using "contains" function to search vector.
		// could check for edge to self, meaningless
		links.add(to);
	}

	void show() {
		// class Vector will do a pretty nice conversion to array notation for links.
		System.out.println("Node " + toString() + " " + links);
	}

	public String toString() {
		return label;
	}
	
	void mark() {
		mark = true;
	}
	
	boolean isMarked() {
		return mark;
	}
	
	void resetMark() {
		mark = false;
	}
	
	void walk() {
		System.out.print(label + "  = >  ");
		mark();
		for(int i = 0; i < links.size(); i++) {
			if ((links.get(i)).isMarked())
				continue;
			else
				(links.get(i)).walk();
		}
	}
}
