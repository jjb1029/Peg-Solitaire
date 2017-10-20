public class App
{

	public static void main(String[] args) 
	{
		System.out.print("");
		InputReader inputr = new InputReader();
//		System.out.println("Input beginning game configuration:");
		Board startConfiguration = new Board(inputr.readInputFromKeyboard());
		InputReader inpute = new InputReader();
//		System.out.println("Input end game configuration:");
		Board endConfiguration = new Board(inpute.readInputFromKeyboard());

		PegSolitaire pegSolitaire = new PegSolitaire(startConfiguration, endConfiguration);
		if(!pegSolitaire.play())
		{
			System.out.println("\nNo solution exists.");
		}
	}
}