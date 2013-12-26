package ai.prj;

import java.util.List;

/**
 * Estimation class used to get static estimation 
 * for current location of board
 * @author Rahul
 *
 */
public class Estimation {

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
			node.estimate = 10000;
		else if(numWhitePlaces <= 2)
			node.estimate = -10000;
		else
		{ 
			List<Board> list = new MoveGenBlack().genMovesMidgameEndgame(board);		
			int numBlackMoves = list.size();
			
			if(numBlackMoves == 0)
				node.estimate = 10000;
			else
				node.estimate = (1000*(numWhitePlaces - numBlackPlaces) - numBlackMoves);
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
		
	    node.estimate = (numWhitePlaces - numBlackPlaces);
	    
	    counter++;
	    return node;
	}
	
	

}
