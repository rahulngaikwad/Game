package ai.prj;

import java.util.List;
import java.util.ArrayList;

/**
 * MoveGen class used to generate move for black
 * @author Rahul
 *
 */
public class MoveGenBlack {

	static MoveGen moveGenWhite = new MoveGen();
	
	/**
	 * Generate Moves of White during Opening Phase
	 * @param board
	 * @return List of board postion
	 */
	
	public List<Board> genMovesOpening(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
		 
		 Board tempboard = new Board(board);
		 tempboard.swapColors();
		 
		 list = moveGenWhite.genMovesOpening(tempboard);
		 
		 for(Board b : list)
			 b.swapColors();
			 
		 return list;
	}
	
	/**
	 * Generate Moves of Black during MidgameEndgame Phase
	 * @param board
	 * @return List of board postion
	 */
	public List<Board> genMovesMidgameEndgame(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
		 
		 Board tempboard = new Board(board);
		 tempboard.swapColors();
		 
		 list = moveGenWhite.genMovesMidgameEndgame(tempboard);
		 
		 for(Board b : list)
			 b.swapColors();
			 
		 return list;
	}
	
	
	
}
