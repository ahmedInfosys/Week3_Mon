import java.util.Scanner;

public class PokeTrader2
{
	//Created a static method to swap names 
			public static String []SWAP(String [] pokeParty,int index1, int index2){
				/*String temp = pokeParty[index1];
				pokeParty[index1] = pokeParty[index2];
				pokeParty[index2] = temp;*/
				
				//or.    
				pokeParty[index1] += pokeParty[index2];
				pokeParty[index2] = pokeParty[index1].substring(0,(pokeParty[index1].length()-pokeParty[index2].length())); 
				pokeParty[index1] = pokeParty[index1].substring(pokeParty[index2].length(),(pokeParty[index1].length()));

				
				return pokeParty;
				
			}
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		String[] pokeParty = { "PIKACHU", "CHARMELEON", "GEODUDE", "GYARADOS", "BUTTERFREE", "MANKEY" };

		int a;
		int b;

		do
		{
			System.out.println("EXCHANGE POKEMON\n");
			for ( int i=0; i<pokeParty.length; i++ )
				System.out.println("    " + i + ". " + pokeParty[i]);

			System.out.print("\nChoose a Pokemon (or -1 to quit). => ");
			a = keyboard.nextInt();

			if ( a >= 0 )
			{
				System.out.print("Choose a Pokemon to exchange with " + pokeParty[a] + ". => ");
				b = keyboard.nextInt();
				//added line to call SWAP method to swap selected Pokemons.
				pokeParty = SWAP(pokeParty,a,b);
				System.out.println("\nExchanging " + pokeParty[a] + " with " + pokeParty[b] + ".\n");

				// add code here to swap the Pokemon in slot a with the Pokemon in slot b
			}


		} while ( a >= 0 );

	}



}