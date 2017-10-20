public class BoardSquare
{
	private char pegChar;
	private int row;
	private int col;
	private boolean visited = false;

	public BoardSquare()
	{
	}

	public BoardSquare(int r, int c, char peg)
	{
		row = r;
		col = c;
		pegChar = peg;
	}

	public int getRow()
	{
		return row;
	}

	public boolean getVisited()
	{
		return visited;
	}

	public void setVisited(boolean x)
	{
		if (x)
			visited = true;
		else
			visited = false;
	}

	public int getCol()
	{
		return col;
	}

	public void setPegChar(char pegChar)
	{
		this.pegChar = pegChar;
	}

	public char getPegChar()
	{
		return pegChar;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public void setCol(int col)
	{
		this.col = col;
	}
	/*
	 * @Override public String toString() { return "[pegChar=" + pegChar +
	 * ", row=" + (row - 2) + ", col=" + (col - 2) + "]"; }
	 */

	@Override
	public String toString()
	{
		return (row - 2) + ", " + (col - 2);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardSquare other = (BoardSquare) obj;
		if (col != other.col)
			return false;
		if (pegChar != other.pegChar)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
