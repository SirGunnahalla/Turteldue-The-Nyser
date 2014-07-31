package pr2.nyser; 
import java.util.Random; 
  
public class Rat extends Monsters 
{ 
    Random rand = new Random(); 
      
    public Rat( int lv ) 
    { 
        setName("Rat"); 
        setLevel( lv ); 
        setDamageMin( getLevel() ); 
        setDamageMax( getLevel() * 2 ); 
        setHealth( 11 * lv ); 
        setExpGiven( lv * 100 ); 
    } 
      
    public int dano() 
    { 
        return ( this.getDamageMin() + rand.nextInt( this.getDamageMax() ) ); 
    } 
      
    public void attack( SonsOfOdin Thing )
    { 
        int danoNow = this.dano(); 
        Thing.setHealth( Thing.getHealth() - danoNow ); 
        System.out.println("The " + getName() + " attacked you and it hits: " + danoNow);
        if ( Thing.getHealth() <= 0 )
        {
        	// shut down
        	System.out.println ("You are dead. Game over.");
        }
        else
        	System.out.println( "Your current life: " + Thing.getHealth() );
        
    } 
      
} 