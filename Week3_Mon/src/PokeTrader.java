import java.util.Scanner;

public class PokeTrader

{
	//Created a static method to swap names 
		public static String []SWAP(String [] pokeParty,int index1, int index2){
			String temp = pokeParty[index1];
			pokeParty[index1] = pokeParty[index2];
			pokeParty[index2] = temp;
			
			return pokeParty;
			
		}
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		String[] pokeParty = { "PIKACHU", "CHARMELEON", "GEODUDE", "GYARADOS", "BUTTERFREE", "MANKEY" };

		int x;

		do
		{
			System.out.println("EXCHANGE POKEMON\n");
			System.out.println("0. " + pokeParty[0]);
			for ( int i=1; i<pokeParty.length; i++ )
				System.out.println("\t" + i + ". " + pokeParty[i]);

			System.out.println("\nChoose a Pokemon to exchange with " + pokeParty[0] + ". (Or enter 0 to quit.)");
			System.out.print("> ");

				x = keyboard.nextInt();
			
			pokeParty = SWAP(pokeParty,0,x);

			// add code here to swap the Pokemon in slot 0 with the Pokemon in slot x

		} while ( x > 0 );
	}
}