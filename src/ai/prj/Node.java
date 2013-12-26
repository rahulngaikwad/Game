package ai.prj;
/**
 * Node Class represent Tree Node
 * @author Rahul
 *
 */
public class Node {
	Board board;
	int estimate;
	
	public Node()
	{
		board = null;
		estimate = 0;
	}
	
	public Node(Board board) {
		this.board = board;
		this.estimate = 0;
	}

	public Node(Board board, int estimate) {
		this.board = board;
		this.estimate = estimate;
	}

	@Override
	public String toString() {
		return "Node [board=" + board + ", estimate=" + estimate + "]";
	}
	
}
