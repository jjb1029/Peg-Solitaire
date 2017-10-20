import java.util.Scanner;

public class InputReader
{

	public InputReader()
	{
		super();
	}

	public String[] readInputFromKeyboard()
	{
		Scanner scanner;
		String[] lines = null;
		try
		{
			scanner = new Scanner(System.in);
			lines = new String[6];
			for (int i = 0; i < lines.length; i++)
			{
				if (scanner.hasNextLine())
					lines[i] = scanner.nextLine();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return lines;
	}

}