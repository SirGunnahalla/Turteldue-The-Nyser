package pr2.nyser; 
import java.util.Random; 
  
public class Orc extends Monsters 
{ 
    Random rand = new Random(); 
      
    public Orc( int lv ) 
    { 
        setName("Orc"); 
        setLevel( lv ); 
        setDamageMin( getLevel() * 8 ); 
        setDamageMax( getLevel() * 5); 
        setHealth( 50 * lv ); 
        setExpGiven( lv * 5000 ); 
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