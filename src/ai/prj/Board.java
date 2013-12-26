package ai.prj;
/**
 * Board Class represent physical board along with playes current location
 * @author Rahul
 *
 */
public class Board {
	
	private char[] array;
	final static int size = 21;
	final static int[][] neighbors = new int[][]{
			{1,2,6}, 	
			{0,11},  	
			{0,3,4,7}, 	
			{2,10}, 	
			{2,5,8}, 	
			{4,9}, 		
			{0,7,18}, 	
			{2,6,8,15}, 
			{4,7,12}, 	
			{5,10,14}, 	
			{3,9,11,17},
			{1,10,20}, 	
			{8,13}, 	
			{12,14,16},
			{9,13},		
			{7,16}, 	
			{13,15,17,19}, 	
			{10,16}, 	
			{6,19}, 	
			{16,18,20}, 
			{11,19}
		};
	
	public Board(String position) {
		this.array = position.toCharArray();
	}
	
	public Board(Board other) {
		this.array = other.array.clone();
	}

	public void swapColors()
	{
		for(int i = 0; i < size; i++){
			if(array[i] == 'W')
				array[i] = 'B';
			else if(array[i] == 'B')
				array[i] = 'W';
		}		
	}
	
	public int countWhitePlaces() {
		
		int numWhitePlaces = 0;
		for(int i = 0; i < size; i++)
			if(array[i] == 'W')
				numWhitePlaces++;
				
		return numWhitePlaces;
	}

	public int countBlackPlaces() {
		
		int numBlackPlaces = 0;
		for(int i = 0; i < size; i++)
			if(array[i] == 'B')
				numBlackPlaces++;
				
		return numBlackPlaces;
	}
	
	public boolean isEmptyAt(int location)
	{
		if(array[location] == 'x')
			return true;
		
		return false;
	}
	
	public boolean isWhiteAt(int location)
	{
		if(array[location] == 'W')
			return true;
		
		return false;
	}
	
	public boolean isBlackAt(int location)
	{
		if(array[location] == 'B')
			return true;
		
		return false;
	}
	
	public void setWhiteAt(int location)
	{
		array[location] = 'W';
	}
	
	public void setBlackAt(int location)
	{
		array[location] = 'B';
	}
	
	public void setEmptyAt(int location)
	{
		array[location] = 'x';
	}
	
	
	public int[] getNeighborsOf(int location)
	{
		
		return neighbors[location];
		
		/*
		switch(location)
		{
		case 0  : return neighbors[0];
		case 1  : return neighbors[1];  	
		case 2  : return neighbors[2]; 	
		case 3  : return neighbors[3]; 	
		case 4  : return neighbors[4]; 	
		case 5  : return neighbors[5]; 		
		case 6  : return neighbors[6]; 	
		case 7  : return neighbors[7]; 
		case 8  : return neighbors[8]; 	
		case 9  : return neighbors[9]; 	
		case 10 : return neighbors[10];
		case 11 : return neighbors[11]; 	
		case 12 : return neighbors[12]; 	
		case 13 : return neighbors[13];
		case 14 : return neighbors[14];		
		case 15 : return neighbors[15]; 	
		case 16 : return neighbors[16]; 	
		case 17 : return neighbors[17]; 	
		case 18 : return neighbors[18]; 	
		case 19 : return neighbors[19]; 
		case 20 : return neighbors[20];
		}	
		*/	
	
	}

	public boolean isCloseMill(int location) {

		
		char C = array[location];
		
		if(C != 'W' && C != 'B')
			return false;
		
		switch(location)
		{
			case 0:
				if((array[6] == C && array[18] == C) || (array[2] == C && array[4] == C))
					return true;
			break;
			case 1:
				if((array[11] == C && array[20] == C))
					return true;
			break;
			case 2:
				if((array[0] == C && array[4] == C) || (array[7] == C && array[15] == C))
					return true;
			break;
			case 3:
				if((array[10] == C && array[17] == C))
					return true;
			break;
			case 4:
				if((array[0]== C && array[2] == C) || (array[8] == C && array[12] == C) )
					return true;
			break;
			case 5:
				if((array[9] == C && array[14] == C))
					return true;
			break;
			case 6:
				if((array[7] == C && array[8] == C) || (array[0] == C && array[18] == C))
					return true;
			break;
			case 7:
				if((array[2] == C && array[15] == C) || (array[6] == C && array[8] == C))
					return true;
			break;
			case 8:
				if((array[4] == C && array[12] == C) || (array[6] == C && array[7] == C))
					return true;
			break;
			case 9:
				if((array[5] == C && array[14] == C) || (array[10] == C && array[11] == C))
					return true;
			break;
			case 10:
				if((array[9] == C && array[11] == C) || (array[3] == C && array[17] == C))
					return true;
			break;
			case 11:
				if((array[1] == C && array[20] == C) || (array[9] == C && array[10] == C))
					return true;
			break;
			case 12:
				if((array[4] == C && array[8] == C) || (array[13] == C && array[14] == C))
					return true;
			break;
			case 13:
				if((array[12] == C && array[14] == C) || (array[16] == C && array[19] == C))
					return true;
			break;
			case 14:
				if((array[5] == C && array[9] == C) || (array[12] == C && array[13] == C))
					return true;
			break;
			case 15:
				if((array[2] == C && array[7] == C) ||  (array[16] == C && array[17] == C) )
					return true;
			break;
			case 16:
				if((array[13] == C && array[19] == C) || (array[15] == C && array[17] == C))
					return true;
			break;
			case 17:
				if((array[3] == C && array[10] == C) || (array[15] == C && array[16] == C))
					return true;
			break;
			case 18:
				if((array[0] == C && array[6] == C) || (array[19] == C && array[20] == C))
					return true;
			break;
			case 19:
				if((array[13] == C && array[16] == C) || (array[18] == C && array[20] == C))
					return true;
			break;
			case 20:
				if((array[1] == C && array[11] == C) || (array[18] == C && array[19] == C))
					return true;
			break;
		}

		return false;
	}

	public int countFreedom()
	{
		int noOfPossibleMoves=0;
		for(int i = 0; i < size;i++){
			int[] neighborList = getNeighborsOf(i);
			
			for(int neighbor:neighborList){
				if(isEmptyAt(neighbor))
					noOfPossibleMoves++;
			}
		}
		return noOfPossibleMoves;
	}
	
	public int countOpenMills()
	{
		int noOf2s=0;
		for(int i = 0; i < size;i++){
			if(isEmptyAt(i)){
				setWhiteAt(i);
				if(isCloseMill(i))
					noOf2s++;
				setEmptyAt(i);
			}
		}
		return noOf2s;
	}
	
	public int millBlocked()
	{
		int blocked = 0;
		for(int i = 0; i < size;i++){
			if(isCloseMill(i)){
				if(isWhiteAt(i))
					blocked++;
				else
					blocked--;
			}
		}
		return blocked;
	}
	
	public int countMills() {
		int millCount= 0;
		for(int i = 0; i < size;i++){
			if(isWhiteAt(i) && isCloseMill(i))
				millCount++;
		}
		return millCount/3;
	}
	
	@Override
	public String toString() {
		return new String(array);
	}



	public int countDoubleMorris() {
		
	int doubleMorris = 0;
	
		for(int i = 0; i < size;i++){
			if(isCloseMill(i)){
				int[] neighborList = getNeighborsOf(i);
				
				for(int neighbor:neighborList){
					if(isEmptyAt(neighbor)){
						setWhiteAt(i);
						if(isCloseMill(i))
							doubleMorris++;
						setEmptyAt(i);
					}
				}
			}
		}
		return doubleMorris;
	}

}
