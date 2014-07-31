package pr2.nyser; 
import java.util.Random; 
  
public class Spider extends Monsters 
{ 
    Random rand = new Random(); 
      
    public Spider( int lv ) 
    { 
        setName("Spider"); 
        setLevel( lv ); 
        setDamageMin( getLevel() * 2 ); 
        setDamageMax( getLevel() * 4); 
        setHealth( 15 * lv ); 
        setExpGiven( lv * 250 ); 
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