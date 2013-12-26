package ai.prj;

public class Test {

	public static void main(String[] args)  {
		
		String boardPosition = "xxxBxWWWWWBBBBxxxxxxx";
		//String boardPosition = "WBBxxWxxxxWxxxxxBxxxx";
		int depth = 1;
		
		
		Board board = new Board(boardPosition);
		Node node;
		
	
		System.out.println(new Estimation().Opening(new Node(new Board("BxWWxBBBBBWWWWBxxxBWB"))));
		System.out.println(new Estimation().Opening(new Node(new Board("BWWWxBBBBBWWWWBxxxBWB"))));
		System.out.println(new Estimation().Opening(new Node(new Board("xWWWxBBBBBWWWWBxxWBWB"))));
		/*
		Estimation.counter = 0;
		MinMaxOpening minMaxOpening = new MinMaxOpening();
		MinMaxOpening.maxDepth = depth;
		node = minMaxOpening.MaxMin(new Node(board), 0);
		System.out.println();
		System.out.println("MinMaxOpening");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ Estimation.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		
		
		Estimation.counter = 0;
		MinMaxGame minMaxGame = new MinMaxGame();
		MinMaxGame.maxDepth = depth;
		node = minMaxGame.MaxMin(new Node(board), 0);
		System.out.println();
		System.out.println("MinMaxGame");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ Estimation.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		
		
		Estimation.counter = 0;
		ABOpening aBOpening = new ABOpening();
		ABOpening.maxDepth = depth;
		node = aBOpening.MaxMin(new Node(board),Integer.MIN_VALUE,Integer.MAX_VALUE, 0);
		System.out.println();
		System.out.println("ABOpening");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ Estimation.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		
		
		Estimation.counter = 0;
		ABGame aBGame = new ABGame();
		ABGame.maxDepth = depth;
		node = aBGame.MaxMin(new Node(board),Integer.MIN_VALUE,Integer.MAX_VALUE, 0);
		System.out.println();
		System.out.println("ABGame");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ Estimation.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		
		Estimation.counter = 0;
		MinMaxOpeningBlack minMaxOpeningBlack = new MinMaxOpeningBlack();
		MinMaxOpeningBlack.maxDepth = depth;
		node = minMaxOpeningBlack.MinMax(new Node(board), 0);
		System.out.println();
		System.out.println("MinMaxOpeningBlack");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ Estimation.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		
		Estimation.counter = 0;
		MinMaxGameBlack minMaxGameBlack = new MinMaxGameBlack();
		MinMaxGameBlack.maxDepth = depth;
		node = minMaxGameBlack.MinMax(new Node(board), 0);
		System.out.println();
		System.out.println("MinMaxGameBlack");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ Estimation.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
	
		
		EstimationImpoved.counter = 0;
		MinMaxOpeningImproved minMaxOpeningImproved = new MinMaxOpeningImproved();
		MinMaxOpeningImproved.maxDepth = depth;
		node = minMaxOpeningImproved.MaxMin(new Node(board), 0);
		System.out.println();
		System.out.println("MinMaxOpeningImproved");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ EstimationImpoved.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		
		EstimationImpoved.counter = 0;
		MinMaxGameImproved minMaxGameImproved = new MinMaxGameImproved();
		MinMaxGameImproved.maxDepth = depth;
		node = minMaxGameImproved.MaxMin(new Node(board), 0);
		System.out.println();
		System.out.println("MinMaxGameImproved");
		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ EstimationImpoved.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		System.out.println("---------------------------------------------------------------");
		*/
	}
	

}
