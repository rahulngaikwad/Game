package ai.prj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
/**
 * Class MinMaxOpeningImproved plays in Opening Phase for White
 * @author Rahul
 *
 */
public class MinMaxOpeningImproved {

	static int maxDepth;
	static EstimationImpoved estimationImproved = new EstimationImpoved();
	static  MoveGen moveGenWhite = new MoveGen();
	static MoveGenBlack moveGenBlack = new MoveGenBlack();
	
	public static void main(String[] args)  {
		
		String positions = null;//  = "WBBxxWxxxxWxxxxxBxxxx";
		//maxDepth = 4;

		
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader( new FileInputStream(args[0])));
		    positions = input.readLine().trim();
		    input.close();
		    maxDepth = Integer.parseInt(args[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		MinMaxOpeningImproved game = new MinMaxOpeningImproved();
		EstimationImpoved.counter = 0;
		
		Board board = new Board(positions);
		Node node = game.MaxMin(new Node(board), 0);
		

		System.out.println("Board Position: "+ node.board);
		System.out.println("Positions evaluated by static estimation: "+ EstimationImpoved.counter);
		System.out.println("MINIMAX estimate: " +node.estimate);
		
		try {
			PrintWriter output = new PrintWriter(new FileWriter(new File(args[1]), false));
			output.print( node.board);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * MaxMin Plays Move for White i.e Max during Opening Phase
	 * @param node
	 * @param depth
	 * @return
	 */
	public Node MaxMin(Node node,int depth)
	{
		if(depth == maxDepth){
			return estimationImproved.Opening(node);
		}
		
		Node tempMax = new Node(node.board, Integer.MIN_VALUE);
		 
		List<Board> list = moveGenWhite.genMovesOpening(node.board);
		
		for(Board possibleMove : list){
			Node childNode = new Node(possibleMove);
			Node temp = MinMax(childNode,depth+1);
			if(temp.estimate > tempMax.estimate){
				tempMax.estimate=temp.estimate;
				tempMax.board = childNode.board;
			}
		}
		
		if(list.size() == 0)
			return estimationImproved.Opening(node);
		
		return tempMax;
	}


	/**
	 * MinMax Plays Move for Black i.e Min
	 * @param node
	 * @param depth
	 * @return
	 */
	public Node MinMax(Node node,int depth)
	{
		if(depth == maxDepth){
			return estimationImproved.Opening(node);
		}
		
		Node tempMin = new Node(null, Integer.MAX_VALUE);
		 
		List<Board> list = moveGenBlack.genMovesOpening(node.board);
		
		for(Board possibleMove : list){
			Node childNode = new Node(possibleMove);
			Node temp = MaxMin(childNode,depth+1);
			
			if(temp.estimate < tempMin.estimate){
				tempMin.estimate=temp.estimate;
				tempMin.board = childNode.board;
			}
		}
	
		if(list.size() == 0)
			return estimationImproved.Opening(node);
		
		return tempMin;
	}
	
}
