package pr2.nyser;  
import java.util.ArrayList;
import java.util.Random;
    
public class Scenario   
{
    Random rand = new Random();  
    private int lv; // scenario level  
    int w = rand.nextInt(4); // weather variable  
    int l = rand.nextInt(5); // light variable  
    private int credits;
        
	String [] weather = {"wet", "dry", "hot", "cold"};  
    String [] light = {"bright", "dark", "shiny","radiant","luminous"};  
    String [] typesOfMonsters = { "Rat","Spider","Orc","Troll", "Balrog" }; 
    
    ArrayList<Monsters> creatures = new ArrayList<Monsters>();
    ArrayList<Weapon> ground = new ArrayList<Weapon>();
      
    // Scenario constructor for defining its variables  
    public Scenario ( int lev )  
    {  
        setLv( lev ); 
        setCredits ( lev*2 ); // How difficult is the scenario 
    }  
    
    // Print the monster in the scenario
    public void printMonsters()
    {
    	int i;
    	for(i=0; i < creatures.size() ; i++)
    	{
    		System.out.print( ( (Monsters) creatures.get(i) ).getName() + ", " );
    	}
    }
    
    public void searchGround()
    {
    	if(ground.size() == 0)
    		System.out.println( "You found nothing..." );
    	else
    		System.out.println("You've found " + this.ground.size() + " item(s) in the ground");
    	
    	for(int i = 0; i < this.ground.size(); i++)
    		System.out.println("Item " + (i + 1) + ": " + this.ground.get(i).getName());    	
    }
    
    // Describes the scenario conditions  
    public void informScenario ()  
    {  
        System.out .println ("You enter a " + light[l] + " and " + weather[w] + " place." );   
    }  
        
    public void enterScenario ()  
    {  
    	informScenario();
        int i = 0;  
        while( getCredits() > 0 )  
        {  
            switch(typesOfMonsters[rand.nextInt(5)])  
            {  
            case "Rat":  
                setCredits( credits - 1 );  
                Rat Twitch = new Rat( 1 + rand.nextInt(2) ); 
                creatures.add ( i, Twitch ); 
                i++;  
                break;  
            case "Spider":  
                if( getCredits() >= 2)  
                {  
                	setCredits( credits - 2 );
                    Spider Elise = new Spider( 1 + rand.nextInt(2) );  
                    creatures.add ( i, Elise );
                    i++;  
                    break;  
                }  
                else
                {  
                    break;  
                }  
            case "Orc":  
                if( getCredits()>=10 )  
                { 
                	setCredits( credits - 10 );
                    Orc Gorbag = new Orc( 1 + rand.nextInt(2) ); 
                    creatures.add ( i, Gorbag ); 
                    i++; 
                    break; 
                } 
                else
                { 
                    break; 
                } 
            case "Troll": 
                if( getCredits() >= 15) 
                { 
                	setCredits( credits - 15 ); 
                    Troll Trundle = new Troll( 1 + rand.nextInt(2) ); 
                    creatures.add ( i, Trundle); 
                    i++; 
                    break; 
                } 
                else
                { 
                    break; 
                } 
            case "Balrog": 
                if( getCredits() >= 50) 
                { 
                	setCredits( credits - 50 );
                    Balrog Baron = new Balrog( 1 ); 
                    creatures.add ( i, Baron ); 
                    i++; 
                    break; 
                } 
                else 
                    break;                  
            }// end of switch
        }// end of while      	
    }// end of enterScenario 
      
    //Getters and setters 
    public int getLv()  
    { 
        return lv; 
    } 
    
    public void setLv(int lv)  
    { 
        this.lv = lv; 
    } 
    
	public int getCredits()
	{
		return credits;
	}
	
	public void setCredits(int credits) 
	{
		this.credits = credits;
	}

	/**
	 * @return the l
	 */
	public int getL()
	{
		return l;
	}

	/**
	 * @return the light
	 */
	public String[] getLight() 
	{
		return light;
	}
	
	

}