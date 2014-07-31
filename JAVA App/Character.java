package pr2.nyser; 

import java.util.Random;
import java.util.Scanner;
  
public abstract class Character extends SonsOfOdin 
{ 
	Random rand = new Random(); 
    Scanner input = new Scanner( System.in ); // input definition 
    int scanUserInt; // Keeps the read number
	
	private int healthStats; // points of health in the attributes
    private int int_; //intelligence will be used in the spells 
    private int exp = 0; 
    private int expPoints = 0; 
    private int weightMax = this.getStr() * 10 + 1;
      
	Weapon currentWeapon; 
     
    public abstract void battle ( Monsters bicho);
    
    public Character() 
    { 
        this.setLevel(1); 
    }
  
    public abstract void lvUp( ); // Method witch will be used when the character level's up 
      
    public abstract void basicAttack( SonsOfOdin Thing ); // Method to define the basic attacks from our classes
    
    public abstract void specialAttack( SonsOfOdin Thing); // Method to define the special attacks from our classes
    
    public void showStats()
    {
    	System.out.println( "Level: " + this.getLevel() + " - HP: " + this.getHealth() + "/" + this.getHealthStats() * 10 +" | Dex: " + this.getDex() + " | Int: " + this.getInt_() + " | Str: " + this.getStr() );
    }
    
    public void choose()
    {
    	// Defining the new atributes
    	
    	while( true )
        {
	        System.out.println ("Health: ");
	        scanUserInt = input.nextInt();
	        
	        if( scanUserInt > this.getExpPoints() || scanUserInt < 0 )
	        	if(scanUserInt > 0)
	        		System.out.println("You can only use "+ this.getExpPoints() + " points! Please, don't HU3");	
	        	else
	        		System.out.println("NO HU3 HERE! ONLY POSITIVE NUMBERS!");
	        else
	        {
	        	this.setHealthStats(this.getHealthStats() + scanUserInt);
		        this.setHealth( this.getHealthStats() * 10 );
		        this.setExpPoints( this.getExpPoints() - scanUserInt );
	        	break;
	        } 
        }
        
        while( true )
        {
	        System.out.println ("Dexterity: ");
	        scanUserInt = input.nextInt();
	        
	        if( scanUserInt > this.getExpPoints() || scanUserInt < 0 )
	        	if(scanUserInt > 0)
	        		System.out.println("You can only use "+ this.getExpPoints() + " points! Please, don't HU3");	
	        	else
	        		System.out.println("NO HU3 HERE! ONLY POSITIVE NUMBERS!");	
	        else
	        {
	        	this.setDex(this.getDex() + scanUserInt);
		        this.setExpPoints( this.getExpPoints() - scanUserInt );
	        	break;
	        } 
        }
        
        while( true )
        {
	        System.out.println ("Strength: ");
	        scanUserInt = input.nextInt();
	       
	        if( scanUserInt > this.getExpPoints() || scanUserInt < 0 )
	        	if(scanUserInt > 0)
	        		System.out.println("You can only use "+ this.getExpPoints() + " points! Please, don't HU3");	
	        	else
	        		System.out.println("NO HU3 HERE! ONLY POSITIVE NUMBERS!");
	        else
	        {
	        	this.setStr( this.getStr() + scanUserInt );
		        this.setExpPoints( this.getExpPoints() - scanUserInt );
	        	break;
	        } 
        }
       
        while( true )
        {
	        System.out.println ( "Intelligence: " );
	        scanUserInt = input.nextInt();
	        
	        if( scanUserInt > this.getExpPoints() || scanUserInt < 0 )
	        	if(scanUserInt > 0)
	        		System.out.println("You can only use "+ this.getExpPoints() + " points! Please, don't HU3");	
	        	else
	        		System.out.println("NO HU3 HERE! ONLY POSITIVE NUMBERS!");
	        else
	        {
	        	this.setInt_( this.getInt_() + scanUserInt );
		        this.setExpPoints( this.getExpPoints() - scanUserInt );
	        	break;
	        }
        }
    }
    
    //Getters and setters 
    public int getInt_()  
    { 
        return int_; 
    } 
      
    public void setInt_(int int_) 
    { 
        this.int_ = int_; 
    } 
  
    public int getExp()  
    { 
        return exp; 
    } 
  
    public void setExp(int exp)  
    { 
        this.exp = exp; 
    } 
      
    public int getExpPoints() 
    { 
        return expPoints; 
    } 
  
  
    public void setExpPoints(int expPoints) 
    { 
        this.expPoints = expPoints; 
    } 
  
    public Weapon getCurrentWeapon() { 
        return currentWeapon; 
    } 
  
    public void setCurrentWeapon(Weapon currentWeapon) { 
        this.currentWeapon = currentWeapon; 
    }
    public int getHealthStats() { 
        return healthStats; 
    } 
  
    public void setHealthStats(int healthStats) { 
        this.healthStats = healthStats; 
    } 
    
    /**
 	 * @return the weightMax
 	 */
 	public int getWeightMax() {
 		return weightMax;
 	}

 	/**
 	 * @param weightMax the weightMax to set
 	 */
 	public void setWeightMax(int weightMax) {
 		this.weightMax = weightMax;
 	}
 
  
      
} 