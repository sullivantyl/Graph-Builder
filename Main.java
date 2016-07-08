import java.util.Scanner;

class Main {
	static public final boolean debug = true;
	
	static public void main (String[] args) {
		
		Scanner scn = new Scanner (System.in);
		Graph g = new Graph();

		help();
		while (scn.hasNext()) {
			String cmd = scn.next();
			if ("edge".startsWith(cmd)) {
				String from = scn.next();
				String to = scn.next();
				g.addEdge(from, to);
			} else if ("add".startsWith(cmd)) {
				g.addNode(scn.next());
			} else if ("print".startsWith(cmd) || "show".startsWith(cmd)) {
				g.show1();
			} else if ("walk".startsWith(cmd)) {
				g.depthWalk(scn.next());
			} else if ("quit".startsWith(cmd)) {
				break;
			} else {
				System.out.println("? do not recognize cmd '" + cmd + "', ignoring");
				help();
			}
		}
	}
	
	static void help() {
		System.out.println("Welcome to graph basics.  Commands are:\n" 
				   + "edge  A B    (add edge from A to B, create nodes if needed)\n"
				   + "add   A      (add node)\n"
				   + "print        (print all nodes, random order)\n"
				   + "quit");
	}
}
