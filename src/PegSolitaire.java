import java.util.ArrayList;
import java.util.Stack;

public class PegSolitaire
{

	private Board startBoard;
	private Board endBoard;
	private Stack<Move> moveStack;

	public PegSolitaire()
	{
		super();
		this.moveStack = new Stack<Move>();
	}

	public PegSolitaire(Board startBoard, Board endBoard)
	{
		this();
		this.startBoard = startBoard;
		this.endBoard = endBoard;
	}

	public boolean play()
	{
		ArrayList<Move> list = new ArrayList<Move>(moveStack);
		// If game is solved print stack of moves and return true;
		if (startBoard.equals(endBoard))
		{
//			System.out.println("Equal!!!");
			System.out.println("\nMoves:");
			for(Move x : list)
				System.out.println(x);
			return true;
		}

		// Only executed if there are moves possible
		for (ArrayList<Move> singlePieceMoves : startBoard.getAllPossibleMoves())
		{
			for (Move singleMove : singlePieceMoves)
			{
				singleMove.doMove();
				moveStack.push(singleMove);
				if (play())
				{
					return true;
				}
				moveStack.pop().undoMove();
			}
		}

		return false;

	}

}
