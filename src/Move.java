public class Move
{
	private BoardSquare from;
	private BoardSquare over;
	private BoardSquare to;

	private String route;

	public Move(BoardSquare from, BoardSquare over, BoardSquare to)
	{
		super();
		this.from = from;
		this.over = over;
		this.to = to;
		this.route = "SRC: (" + from + ") DEST: (" + to + ")";
	}

	public void doMove()
	{
		from.setPegChar(Board.OPEN);
		over.setPegChar(Board.OPEN);
		to.setPegChar(Board.PEG);
	}

	public void undoMove()
	{
		from.setPegChar(Board.PEG);
		over.setPegChar(Board.PEG);
		to.setPegChar(Board.OPEN);
	}

	@Override
	public String toString()
	{
		return route;
	}

}