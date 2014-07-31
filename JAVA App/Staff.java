package pr2.nyser; 
  
public class Staff extends Weapon { 
      
	private int int_Min;
	
    public Staff( String name, int danoMin, int danoMax, int int_Min, int weight ) 
    {   
    	this.setName( name );
    	this.setInt_Min( int_Min );
        this.setWeaponDamageMin( danoMin );  
        this.setWeaponDamageMax( danoMax );  
        this.setWeight(weight);
    } 
    
    public void use( Character Gandalf )
    {
    	if( Gandalf.getInt_() < int_Min )
    	{
    		int int_Needed = this.getInt_Min() - Gandalf.getInt_();
    		System.out.println("You are not able to use this staff, you need more " + int_Needed + " points of intelligence");
    	}
    	else
    	{
    		System.out.println("You equipped a/an " + this.getName() + "." );
    		Gandalf.setCurrentWeapon( this );
    	}
    }

    //Getters and setters
	public int getInt_Min() 
	{
		return int_Min;
	}

	public void setInt_Min(int int_Min) 
	{
		this.int_Min = int_Min;
	}
          
    
} 
