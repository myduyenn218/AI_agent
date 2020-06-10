
public class test {
	public static void main(String[] args) {

		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6); // ***
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
//		ISearchAlgo d = new DepthFirstSearchAlgo();
		ISearchAlgo b = new BreadthFirstSearchAlgo();
		System.out.println(NodeUtils.printPath(b.execute(nodeS, "G")).toString());

//		Node node40 = new Node("40");
//		Node node20 = new Node("20");
//		Node node50 = new Node("50");
//		Node node10 = new Node("10");
//		Node node30 = new Node("30");
//		Node node60 = new Node("60");
//		Node node70 = new Node("70");
//		node40.addEdge(node20, 5);
//		node40.addEdge(node10, 3);
//		node20.addEdge(node10, 4);
//		node20.addEdge(node30, 7);
//		node20.addEdge(node50, 3);
//		node20.addEdge(node60, 2);
//		node50.addEdge(node70, 9);
//		node10.addEdge(node30, 2);
//		node30.addEdge(node60, 6);
//		node60.addEdge(node70, 1);
//
//		d.execute(node40, "20", "70").printNode();

//		Node nodeA = new Node("A");
//		Node nodeB = new Node("B");
//		Node nodeC = new Node("C");
//		Node nodeD = new Node("D");
//		Node nodeE = new Node("E");
//		Node nodeF = new Node("F");
//		Node nodeG = new Node("G");
//		Node nodeH = new Node("H");
//		Node nodeI = new Node("I");
//		Node nodeJ = new Node("J");
//		Node nodeK = new Node("K");
//		Node nodeL = new Node("L");
//		Node nodeM = new Node("M");
//		Node nodeN = new Node("N");
//		Node nodeO = new Node("O");
//		Node nodeP = new Node("P");
//		Node nodeR = new Node("R");
//		Node nodeS = new Node("S");
//
//		nodeA.addEdge(nodeB);
//		nodeA.addEdge(nodeC);
//		nodeA.addEdge(nodeD);
//		nodeB.addEdge(nodeE);
//		nodeB.addEdge(nodeF);
//		nodeC.addEdge(nodeG);
//		nodeD.addEdge(nodeH);
//		nodeE.addEdge(nodeI);
//		nodeF.addEdge(nodeJ);
//		nodeF.addEdge(nodeK);
//		nodeG.addEdge(nodeL);
//		nodeH.addEdge(nodeM);
//		nodeH.addEdge(nodeN);
//		nodeK.addEdge(nodeO);
//		nodeK.addEdge(nodeP);
//		nodeL.addEdge(nodeR);
//		nodeN.addEdge(nodeS);
//
//		DepthLimitedSearch depth = new DepthLimitedSearch();
////		depth.execute(nodeA, 3);
//		System.out.println(NodeUtils.printPath(depth.execute(nodeA, "K", 3)).toString());
	}

}
