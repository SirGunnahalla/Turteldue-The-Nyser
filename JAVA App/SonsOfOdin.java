package pr2.nyser; 

import java.util.ArrayList;
  
public abstract class SonsOfOdin 
{  
    private int health; // Health
    private int dex; //dexterity 
    private int str; //strength 
    private int level; //level 
    private String name; 
    
    ArrayList<Weapon> inventory = new ArrayList<Weapon>();
    
    public void printInventory ()
    {
    	for (int i = 0; i < this.inventory.size(); i++)
    	{
    		System.out.print (this.inventory.get(i).getName() + ", ");
    	}
    }
    
      
    public String getName() { 
        return name; 
    } 
  
    public void setName(String name) { 
        this.name = name; 
    } 
  
    private int expGiven;//experience given by a SonsOfOdin object 
      
      
    //Getters and setters 
    public int getHealth() 
    { 
        return health; 
    } 
  
    public void setHealth(int health) 
    { 
        this.health = health; 
    } 
  
    public int getDex()  
    { 
        return dex; 
    } 
    public void setDex(int dex)  
    { 
        this.dex = dex; 
    } 
      
    public int getStr()  
    { 
        return str; 
    } 
      
    public void setStr(int str)  
    { 
        this.str = str; 
    } 
      
    public int getExpGiven() { 
        return expGiven; 
    } 
  
    public void setExpGiven(int expGiven)  
    { 
        this.expGiven = expGiven; 
    } 
      
    public int getLevel()  
    { 
        return level; 
    } 
  
    public void setLevel(int level)  
    { 
        this.level = level; 
    } 
} 