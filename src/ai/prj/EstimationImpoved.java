package ai.prj;

import java.util.List;

/**
 * EstimationImpoved class used to get static estimation 
 * for current location of board
 * @author Rahul
 *
 */
public class EstimationImpoved {

	static int counter = 0;
	
	/**
	 * returns static estimation for current location of board
	 * for MidgameEndgame phase
	 * @param node
	 * @return update estimate of input node
	 */
	
	public Node MidgameEndgame(Node node)
	{
		Board board = node.board;
		int numWhitePlaces = board.countWhitePlaces();
		int numBlackPlaces = board.countBlackPlaces();
			
		if(numBlackPlaces <= 2)
			node.estimate = Integer.MAX_VALUE-1;
		else if(numWhitePlaces <= 2)
			node.estimate = Integer.MIN_VALUE+1;
		else
		{ 
			List<Board> list = new MoveGenBlack().genMovesMidgameEndgame(board);		
			int numBlackMoves = list.size();
			
			if(numBlackMoves == 0)
				node.estimate = Integer.MAX_VALUE-1;
			else
			{
		        int placeDiff = numWhitePlaces - numBlackPlaces;
		        int millNum         = board.countMills();
		        int openMillNum     = board.countOpenMills();
		        int doubleMorrisNum = board.countDoubleMorris();
		        
				node.estimate = (placeDiff*1000 + numBlackMoves*(-5) + millNum*100 + openMillNum*150 + doubleMorrisNum*300);
		        //node.estimate = (placeDiff*50 + numBlackMoves*(-10)  + openMillNum*150 + doubleMorrisNum*300);
		        //node.estimate = (1000*(numWhitePlaces - numBlackPlaces) - numBlackMoves);
			}	
		}
		
		counter++;
		return node;
	}	
	
	/**
	 * returns static estimation for current location of board
	 * for opening phase
	 * @param node
	 * @return update estimate of input node
	 */
	public Node Opening(Node node)
	{
		Board board = node.board;
		int numWhitePlaces = board.countWhitePlaces();
		int numBlackPlaces = board.countBlackPlaces();
	
		int noOfPossibleMoves= board.countFreedom();

		int noOf2s=board.countOpenMills();
		
		int placeDiff = numWhitePlaces - numBlackPlaces;
		
		//int millBlocked = board.millBlocked();
		
	    //node.estimate = (noOfPossibleMoves*10 + noOf2s*50 + placeDiff*100 + millBlocked*200);
		node.estimate = (placeDiff*100 + noOfPossibleMoves*5 + noOf2s*500 );
		//node.estimate = (50*placeDiff +noOfPossibleMoves);
		
	    counter++;
	    return node;
	}
	
	

}
