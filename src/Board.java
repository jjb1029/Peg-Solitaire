import java.util.ArrayList;
import java.util.Arrays;

public class Board
{
	static final char PEG = 'P';
	static final char OPEN = 'O';
	private static final char UNUSABLE = 'X';

	private BoardSquare[][] gameboard;

	public Board(String[] gameConfigurationInput)
	{
		super();

		ArrayList<BoardSquare> gamepieces = new ArrayList<BoardSquare>();
		for (int i = 0; i < gameConfigurationInput.length; i++)
		{
			String line = gameConfigurationInput[i];
			char[] linecharacters = line.toCharArray();
			for (int x = 0; x < linecharacters.length; x++)
			{
				BoardSquare bs = new BoardSquare(i, x, linecharacters[x]);
				gamepieces.add(bs);
			}
		}

		gameboard = new BoardSquare[10][10];
		for (int row = 0; row < gameboard.length; row++)
		{
			for (int col = 0; col < gameboard[row].length; col++)
			{
				gameboard[row][col] = new BoardSquare(row, col, UNUSABLE);
			}
		}

		for (int i = 0; i < gamepieces.size(); i++)
		{
			BoardSquare realPiece = gamepieces.get(i);
			realPiece.setCol(realPiece.getCol() + 2);
			realPiece.setRow(realPiece.getRow() + 2);
			gameboard[realPiece.getRow()][realPiece.getCol()] = realPiece;
		}
	}

	public ArrayList<Move> canJump(BoardSquare piece)
	{
		int row = piece.getRow();
		int col = piece.getCol();
		char pin = piece.getPegChar();
		ArrayList<Move> jumpableLocations = new ArrayList<Move>();

		if (pin == PEG)
		{
			// Top Right
			if (gameboard[row - 1][col].getPegChar() == PEG && gameboard[row - 2][col].getPegChar() == OPEN)
			{
				jumpableLocations.add(new Move(piece, gameboard[row - 1][col], gameboard[row - 2][col]));
			}
			// Right
			if (gameboard[row][col + 1].getPegChar() == PEG && gameboard[row][col + 2].getPegChar() == OPEN)
			{
				jumpableLocations.add(new Move(piece, gameboard[row][col + 1], gameboard[row][col + 2]));
			}
			// Bottom Right
			if (gameboard[row + 1][col + 1].getPegChar() == PEG && gameboard[row + 2][col + 2].getPegChar() == OPEN)
			{
				jumpableLocations.add(new Move(piece, gameboard[row + 1][col + 1], gameboard[row + 2][col + 2]));
			}
			// Bottom Left
			if (gameboard[row + 1][col].getPegChar() == PEG && gameboard[row + 2][col].getPegChar() == OPEN)
			{
				jumpableLocations.add(new Move(piece, gameboard[row + 1][col], gameboard[row + 2][col]));
			}
			// Left
			if (gameboard[row][col - 1].getPegChar() == PEG && gameboard[row][col - 2].getPegChar() == OPEN)
			{
				jumpableLocations.add(new Move(piece, gameboard[row][col - 1], gameboard[row][col - 2]));
			}
			// Top Left
			if (gameboard[row - 1][col - 1].getPegChar() == PEG && gameboard[row - 2][col - 2].getPegChar() == OPEN)
			{
				jumpableLocations.add(new Move(piece, gameboard[row - 1][col - 1], gameboard[row - 2][col - 2]));
			}
		}

		return jumpableLocations;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < gameboard.length - 2; i++)
		{
			for (int j = 2; j < gameboard[i].length - 2; j++)
			{
				if (gameboard[i][j].getPegChar() != UNUSABLE)
				{
					sb.append(gameboard[i][j].getPegChar());
				} else
				{
					break;
				}
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	public String toJumpableMovesString()
	{
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < gameboard.length; row++)
		{
			for (int col = 0; col < gameboard[row].length; col++)
			{
				ArrayList<Move> canJump = canJump(gameboard[row][col]);
				if (!canJump.isEmpty())
				{
					sb.append(gameboard[row][col]);
					sb.append(" - ");
					sb.append(canJump);
					sb.append(System.lineSeparator());
				}
			}
		}
		return sb.toString();
	}

	public BoardSquare getPiece(int r, int c)
	{
		return gameboard[r][c];
	}

	public ArrayList<ArrayList<Move>> getAllPossibleMoves()
	{
		ArrayList<ArrayList<Move>> allMoves = new ArrayList<ArrayList<Move>>();
		BoardSquare[][] gamepieces = getGameboard();
		for (BoardSquare[] row : gamepieces)
		{
			for (BoardSquare piece : row)
			{
				ArrayList<Move> moves = canJump(piece);
				if (!moves.isEmpty())
				{
					allMoves.add(moves);
				}
			}
		}
		return allMoves;
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
		Board other = (Board) obj;
		if (!Arrays.deepEquals(gameboard, other.gameboard))
			return false;
		return true;
	}

	public BoardSquare[][] getGameboard()
	{
		return gameboard;
	}

	public void setGameboard(BoardSquare[][] gameboard)
	{
		this.gameboard = gameboard;
	}

}