package pr2.nyser; 
import java.util.Scanner; 
import java.io.*; 
import java.util.Random;  
  
public class TheNyser 
{    
    private static Scanner input; //  Declaration of the command-line reader (only for Integers) 
  
    public static void main(String[] args) throws IOException 
    { 
        Random rand = new Random(); // Generates random numbers 
        input = new Scanner( System.in ); // input definition 
        int scanUserInt; // Keeps the read number 
        String scanUserStr; // Keeps the read sentence 
        Character Char = null; // Character object declaration 
        
        //Instructions
        System.out.println ("INSTRUCTIONS:\n 1) ONLY use numbers, except when typing your name.\n 2) When battling or picking an item type a number correspondent to the position of the monster/item.\n"
        		+ "    Ex: Rat, Spider | Type 1 to battle Rat and 2 to battle Spider.\n 3) HAVE FUN!\n\n");
        
        // Greatings
        System.out.println ( "Welcome to the best text adventure you've ever seen!\n\n          ----------------------------" +
        		"\n   | T u r t e l d u e :  T h e  N y s e r |\n          ----------------------------\n\n  -------------------------------------------------------------------------------");
        // Introduction
        System.out.println ( " | It's the year of 2042 and it is Christmas, a day when everyone is celebrating, |" +
        		"\n | but, unfortunately you aren't...                                               |" +
        		"\n | The society we are established in is monarchy based, and our Kingdom, the      |" +
        		"\n | Kjempebra Kingdom, is in war with the malicious kingdom of Ondsinnet.          |" +
        		"\n | You probably know this story already. However, now it's time I needed you.     |" +
        		"\n | My name is Lord Skummel and I am the leader of the Opprørers, a secret         |" +
        		"\n | brotherhood, and we need you to DESTROY ONDSINNET!                             |" +
        		"\n  -------------------------------------------------------------------------------" );
        
        // User chooses the desired class
        System.out.println("\nWhat's your profession?\n  (1) Mage  (2) Ranger  (3) Warrior");
        scanUserInt =  input.nextInt(); 
          
        // Choosing the proper class will result in distinct come outs 
        switch( scanUserInt ) 
        { 
            case 1: // Mage solution 
            	// Decides the name
                System.out.println ("What will be your name, my sagacious mage?"); 
                scanUserStr = new BufferedReader(new InputStreamReader(System.in)).readLine(); 
                Char = new Mage(); 
                Char.setName(scanUserStr); 
                System.out.println (scanUserStr + "! Your name shall bring you wisdom!"); 
                // Gives a staff to the character
                Staff brokenStaff = new Staff("Broken Staff", 1, 4, 4, 10 );
                Char.inventory.add (brokenStaff);
                System.out.println( "Just so you don't get too alone, take a staff." );
                brokenStaff.use( Char );
                
                break; 
            case 2: // Ranger solution 
            	// Decides the name
                System.out.println ("What will be your name, my swift ranger?"); 
                scanUserStr = new BufferedReader(new InputStreamReader(System.in)).readLine(); 
                Char = new Ranger(); 
                Char.setName(scanUserStr); 
                System.out.println (scanUserStr + "! This name will retrieve knowlegde to the most inner self!");
                // Gives a bow to the character
                Bow brokenBow = new Bow("Broken Bow", 2, 6, 4, 10 );
                Char.inventory.add (brokenBow);
                System.out.println( "Just so you can play, take a bow and some arrows." );
                brokenBow.use( Char );
                
                break; 
            case 3: // Warrior solution 
            	// Decides the name
                System.out.println ("What will be your name, my powerful warrior?"); 
                scanUserStr = new BufferedReader(new InputStreamReader(System.in)).readLine(); 
                Char = new Warrior(); 
                Char.setName(scanUserStr); 
                System.out.println (scanUserStr + "! This name must give strength to you!"); 
             	// Gives a sword to the character
                Sword brokenSword = new Sword("Broken Sword", 1, 6, 4, 20 );
                Char.inventory.add (brokenSword);
                System.out.println( "Just so you can have some fun, take a sword." );
                brokenSword.use( Char ); 
                
                break; 
            default: // Other stuff 
                System.out.println ( scanUserInt + "! DRA TIL HELVETE!" ); 
                break; 
        } 
        
        System.out.println("\nAfter Lord Skummel told you the story, he directed your way to the enemy Kingdom, " +
        		"\nand to do it you will need to go through a series of rooms 'till you reach your destiny. " +
        		"\nThe problem is: no one ever survived not even got to know if this series of rooms has a way" +
        		"\nout! Therefore, be careful! But no worries, we're sure you gonna make it! Good Luck!\n");
        
        int i = 1;
        
        while( true )
        {
        	int j = 0;
        	
        	Scenario Place = new Scenario( i ); 
	        Place.enterScenario();
	        for(int cont = 0; cont < Place.creatures.size(); cont++)
	        	Place.creatures.get(cont).inventory.add(null);
	       
	        int keyMonster = rand.nextInt(Place.creatures.size());
	        int firstSize = Place.creatures.size();
	        Weapon key = new Key ("Key" + i, 1, 3);
	        Place.creatures.get(keyMonster).inventory.set(0, key);
	        
	        while( j <= firstSize )
	        {  
		        if( Place.getLight()[ Place.getL() ] == "dark" )
		        {
		        	System.out.println( "\nYou see nothing, because you are in the deepest dark..." );
		        	System.out.println( "You can: Scream(1); Check your atributes(2); Try open the door(3); Search Ground(4);" );
		        	scanUserInt = input.nextInt();
		        	switch( scanUserInt )
		        	{
		        		case 1:
		        			if (j == firstSize)
		        			{
		        				System.out.println ("Nothing happens...\n");
		        				break;
		        			}
		        			else
		        			{
			        			int ale = rand.nextInt (Place.creatures.size());
			        			System.out.println( "You screamed: TAAAAMIORRRNYSAALEM!" );
			        			Place.creatures.get( ale ).attack(Char);
			        			Char.battle( Place.creatures.get( ale ) );
			        			if ( Place.creatures.get(ale).inventory.get(0) != null)
			        			{
			        				Place.creatures.get(ale).inventory.remove(0);
			        				Place.ground.add(key);	        				
			        			}
			        			Place.creatures.remove ( ale );
			        		
			        			j++;
			        			break;
		        			}
		        			
		        		case 2:
		        			Char.showStats();
		        			break;
		        		
		        		case 3:
		        			boolean open = false;
		        			for(int count = 0; count < Char.inventory.size(); count++)
			        			if ( Char.inventory.get(count).getName() == key.getName() )
			        			{
			        				i++;
			        				System.out.println("You open the door to the next scenario! CONGRATULATIONS!\n\n");
			        				open = true;
			        				firstSize = -1;
			        				break;
			        			}
		        			if(!open)
		        				System.out.println("The door is locked. You need the key to open it\n!");
		        			break;
		        			
		        		case 4:
		        			Place.searchGround();
		        			if(Place.ground.size() == 0)
		        				break;
		        			else
		        			{
		        				System.out.println( "What item do you want to take?" );
		        				scanUserInt = input.nextInt();
		        				Char.inventory.add( Place.ground.get(scanUserInt - 1) );
		        				System.out.println( "Now you have a " + Place.ground.get(scanUserInt - 1).getName() + " in your inventory!" );
		        				Place.ground.remove(scanUserInt - 1);
		        				break;
		        			}
		        	}
		        	
		        }
		        else
		        {
		        	if(j == firstSize)
		        		System.out.print( "There are no more monsters in the area! Good Job!" );
		        	else{
		        		System.out.print( "\nYou see: " );
		        		Place.printMonsters();
		        	}
		        	System.out.println( "\nYou can: Battle(1); Check your atributes(2); See your inventory(3); Try open the door(4); Search Ground(5);" );
		        	scanUserInt = input.nextInt();
		        	switch( scanUserInt )
		        	{
		        		case 1:
		        			System.out.println("Who do you want to attack first? ");
		        			scanUserInt = input.nextInt();

		        			Char.battle(Place.creatures.get(scanUserInt-1));
		        			
		        			if ( Place.creatures.get(scanUserInt - 1).inventory.get(0) != null)
		        			{
		        				System.out.println( "\nLooks like something fell from the " + Place.creatures.get(scanUserInt - 1).getName() );
		        				Place.creatures.get(scanUserInt -1).inventory.remove(0);
		        				Place.ground.add(key);	        				
		        			}
		        			
		        			Place.creatures.remove(scanUserInt -1);
		        			j++;
		        			break;
		        			
		        		case 2:
		        			Char.showStats();
		        			break;
		        			
		        		case 3:
		        			System.out.print ("You have these items in your inventory: ");
		        			Char.printInventory();
		        			break;
		        			
		        		case 4:
		        			boolean open = false;
		        			for(int count = 0; count < Char.inventory.size(); count++)
			        			if ( Char.inventory.get(count).getName() == key.getName() )
			        			{
			        				i++;
			        				System.out.println("You open the door to the next scenario! CONGRATULATIONS!\n\n");
			        				open = true;
			        				firstSize = -1;
			        				break;
			        			}
		        			if(!open)
		        				System.out.println("The door is locked. You need the key to open it!");
		        			break;
		        		
		        		case 5:
		        			Place.searchGround();
		        			if( Place.ground.size() == 0 )
		        				break;
		        			else{
		        				System.out.println( "What item do you want to take?" );
		        				scanUserInt = input.nextInt();
		        				Char.inventory.add( Place.ground.get(scanUserInt-1) );
		        				System.out.println( "Now you have a " + Place.ground.get(scanUserInt-1).getName() + " in your inventory!" );
		        				Place.ground.remove(scanUserInt-1);
		        				break;
		        			}
		        			
		        	} // end of switch
		        	
		        } // end of else
		        
	        } // end of second while
	        
        } // end of first while
        
    } // end of main 
    
} // end of class