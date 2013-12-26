package ai.prj;

import java.util.List;
import java.util.ArrayList;

/**
 * MoveGen class used to generate move for white
 * @author Rahul
 *
 */

public class MoveGen  {


	/**
	 * Generate Moves of White during Opening Phase
	 * @param board
	 * @return List of board postion
	 */
	public List<Board> genMovesOpening(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
		 list = genAdd(board);
		 return list;
	}

	/**
	 * Generate Moves of White during MidgameEndgame Phase
	 * @param board
	 * @return List of board postion
	 */
	public List<Board> genMovesMidgameEndgame(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
		 
		 if(board.countWhitePlaces() == 3)
			 list = genHopping(board);
		 else
			 list = genMove(board);
		 
		 return list;
	}
	
	
	
	public List<Board> genAdd(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
	
		 for(int i = 0; i < Board.size; i++){
			 if(board.isEmptyAt(i)){
				 
				 Board newboard = new Board(board);
				 newboard.setWhiteAt(i);
				 
				 if(newboard.isCloseMill(i))
					 genRemove(newboard,list);
				 else
					 list.add(newboard);	 
			 }
		 }
		 
		 return list;
	}
	
	
	
	public List<Board> genHopping(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
		 
		 for(int i = 0; i < Board.size; i++){
			 
			 if(board.isWhiteAt(i)){
				 
				 for(int j = 0; j < Board.size; j++){
					 
					 if(board.isEmptyAt(j)){
						 
						 Board newboard = new Board(board);
						 newboard.setEmptyAt(i);
						 newboard.setWhiteAt(j);
						 
						 if(newboard.isCloseMill(j))
							 genRemove(newboard, list);
						 else
							 list.add(newboard); 
					 }
				 }
			 }
		 }
		 
		 return list;
	}
		

	
	public List<Board> genMove(Board board)
	{
		 List<Board> list = new  ArrayList<Board>();
		 for(int i = 0; i < Board.size; i++)
		 {
			 if(board.isWhiteAt(i)){
				 int[] neighbors = board.getNeighborsOf(i);
				 for(int j : neighbors){
					 if(board.isEmptyAt(j))
					 {
						 Board newboard = new Board(board);
						 newboard.setEmptyAt(i);
						 newboard.setWhiteAt(j);
						 if(newboard.isCloseMill(j))
							 genRemove(newboard, list);
						 else
							 list.add(newboard);
					 }
				 }
			 }
		 }
		 
		 return list;
	}
	

	
	public List<Board> genRemove(Board board, List<Board> list)
	{

		Boolean listUpdated = false;
		 for(int i = 0; i < Board.size; i++)
		 {
			 if(board.isBlackAt(i) && !board.isCloseMill(i)){
				 Board newboard = new Board(board);
				 newboard.setEmptyAt(i);
				 list.add(newboard);
				 listUpdated = true;
			 }
		 }
		 
		 if(!listUpdated)
			 list.add(board);
		 
		return list;
	}
	
	
}
