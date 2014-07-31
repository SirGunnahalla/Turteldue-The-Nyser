package pr2.nyser;

public class Key extends Weapon
{
	public Key( String name, int danoMin, int danoMax ) 
    {   
    	this.setName( name );
        this.setWeaponDamageMin( danoMin );  
        this.setWeaponDamageMax( danoMax );  
        this.setWeight(1);
    } 
	
	public void use( Character Dario )
    {
		System.out.println("You equipped a/an " + this.getName() + ".");
		Dario.setCurrentWeapon( this );
    }
}
