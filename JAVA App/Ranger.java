package pr2.nyser; 
  
import java.util.Random; 
import java.util.Scanner;
  
public class Ranger extends Character  
{ 
    Random rand = new Random(); 
    Scanner input = new Scanner( System.in ); // input definition 
    int scanUserInt; // Keeps the read number 
    
    public Ranger() 
    { 
        this.setHealthStats(3); //health 
        this.setDex(5); //dexterity 
        this.setInt_(1); //intelligence 
        this.setStr(2); //strength 
        this.setHealth(this.getHealthStats() * 10); // HP 
    } 
      
    private int quiver = 10000; 
      
    public int dano()   
    {   
        return ( currentWeapon.getWeaponDamageMin() + rand.nextInt( currentWeapon.getWeaponDamageMax() + 1 ) + this.getStr() );   
    }  
    
    public void lvUp( ) 
    { 
        this.setExpPoints( 5 ); 
        this.setLevel( this.getLevel() + 1 ); 
        System.out.println ("Congratulations! You've reached level " + this.getLevel() ); 
        System.out.println ("You have more 5 points (Total points = "+ this.getExpPoints() + ") to use in your atributes. Choose how to put in wich atributes: ");
        
        choose();
        
        System.out.println ( "Do you wanna change something? Yes (1) No (0)" );
        scanUserInt = input.nextInt();
        this.showStats();        
        if(scanUserInt == 0)
        	System.out.println( "We have no killers" );
        else
        { 
        	System.out.println("I don't care.");
        }  
    }
      
    public void basicAttack( SonsOfOdin Thing ) 
    { 
        int danoNow;
        if(quiver == 0 || currentWeapon == null) 
        { 
        	Thing.setHealth( Thing.getHealth() - this.getStr() );  
            danoNow = this.getStr();
        } 
        else
        { 
            quiver--; 
            danoNow = this.dano();
            Thing.setHealth( Thing.getHealth() - danoNow );
        } 
          
        if(Thing.getHealth() <= 0)   
        {   
        	System.out.println("You attacked the " + Thing.getName() + " and you hit: " + danoNow);
        	System.out.println("The " + Thing.getName() + " is dead");
        	System.out.println("You received " + Thing.getExpGiven() + " points of experience");
        	if( this.getLevel() * this.getLevel() * 100 > this.getExp() + Thing.getExpGiven() )   
            {  
                this.setExp( this.getExp() + Thing.getExpGiven() );   
            }   
            else
            {   
                this.setExp( this.getExp() + Thing.getExpGiven() - this.getLevel() * this.getLevel() * 100);   
                lvUp();   
            }    
        	return;
        }   
        System.out.println("You attacked the " + Thing.getName() + " and you hit: " + danoNow);
        System.out.println( Thing.getName() + "'s life: " + Thing.getHealth() );
    }
    
    public void specialAttack(SonsOfOdin Thing)
    {
    	int choosePart = rand.nextInt(5);
    	
    	int givenDamage = (currentWeapon.getWeaponDamageMin() + rand.nextInt( currentWeapon.getWeaponDamageMax() + 1) + this.getStr()) + (this.getDex()*(choosePart+1));
    	
    	Thing.setHealth( Thing.getHealth() - givenDamage);
    	
    	String [] parts = {"foot", "knee", "stomach", "chest", "head"};
    	
    	
    	if(Thing.getHealth() <= 0)   
        {   
    		
        	System.out.println( "You shot an arrow in the " + Thing.getName() + "'s " + parts[choosePart] + " and you hit: " + givenDamage );
        	System.out.println( "The " + Thing.getName() + " is dead" );
        	System.out.println( "You received " + Thing.getExpGiven() + " points of experience" );
        	if( this.getLevel() * this.getLevel() * 100 > this.getExp() + Thing.getExpGiven() )   
            {  
                this.setExp( this.getExp() + Thing.getExpGiven() );   
            }   
            else
            {   
                this.setExp( this.getExp() + Thing.getExpGiven() - this.getLevel() * this.getLevel() * 100 );   
                lvUp();   
            }    
        	return ;
        }   
        System.out.println( "You shot an arrow in the " + Thing.getName() + "'s " + parts[choosePart] + " and you hit: " + givenDamage );
        System.out.println( Thing.getName() + "'s life: " + Thing.getHealth() );
    }
    
    public void battle ( Monsters bicho )
    {
    	double uses = this.getDex()/5;
    	uses = Math.floor(uses);
    	
    	while( bicho.getHealth() > 0)
    	{
	    	System.out.println("What do you want to do? ");
	    	System.out.println("(1) BasicAttack");
	    	System.out.println("(2) SpecialAttack");
	    	System.out.println("(3) Run");
	    	scanUserInt =  input.nextInt(); 
	    	
	    	switch( scanUserInt )
	    	{
	    		case 1:
	    			this.basicAttack( bicho );
	    			break;
	    		case 2:
	    			if( uses!=0 )
	    			{
	    				this.specialAttack( bicho );
	    				uses--;
	    			}
	    			else
	    				System.out.println( "You've already spent all your chances using Special Attacks" );
	    			break;
	    
	    		case 3:
	    			System.out.println( "You can't run!" );
	    			break;
	    	}
	    	
	    	if( bicho.getHealth() > 0 )
	    		bicho.attack( this );
	    	
	    	if ( this.getHealth() <= 0 )
	    	{
	    		return;
	    	}
	    }
	
    	
    }
    //GETTERS AND SETTERS

	public int getQuiver()
	{
		return quiver;
	}

	public void setQuiver(int quiver)
	{
		this.quiver = quiver;
	}
    
} 