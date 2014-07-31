package pr2.nyser; 
import java.util.Random; 
  
public class Balrog extends Monsters 
{ 
    Random rand = new Random(); 
      
    public Balrog( int lv ) 
    { 
        setName("Balrog"); 
        setLevel( lv ); 
        setDamageMin( getLevel() * 100 ); 
        setDamageMax( getLevel() * 300 ); 
        setHealth( 1500 * lv ); 
        setExpGiven( lv * 100000 ); 
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
        	System.out.println ("You are dead. Game over.");
        }
        else
        	System.out.println( "Your current life: " + Thing.getHealth() );
        
    } 
      
} 