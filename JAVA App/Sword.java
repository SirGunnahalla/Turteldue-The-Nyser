package pr2.nyser;

public class Sword extends Weapon
{
	private int strMin;
	
	public Sword( String name, int danoMin, int danoMax, int strMin, int weight)
	{
		this.setName(name);
		this.setStrMin(strMin);
		this.setWeaponDamageMin(danoMin);
		this.setWeaponDamageMax(danoMax);
		this.setWeight(weight);
	}

	public void use( Character Gimli )
    {
    	if( Gimli.getStr() < strMin )
    	{
    		int strNeeded = this.getStrMin() - Gimli.getStr();
    		System.out.println("You are not able to use this sword, you need more " + strNeeded + " points of strength");
    	}
    	else
    	{
    		Gimli.setCurrentWeapon( this );
    		System.out.println("You equipped a/an " + this.getName() + "." );
    	}
    }
	
	
	public int getStrMin() {
		return strMin;
	}

	public void setStrMin(int strMin) {
		this.strMin = strMin;
	}
}
