package pr2.nyser;

public class Bow extends Weapon
{
	private int dexMin;
	
	public Bow( String name, int danoMin, int danoMax, int dexMin, int weight)
	{
		this.setName(name);
		this.setDexMin(dexMin);
		this.setWeaponDamageMin(danoMin);
		this.setWeaponDamageMax(danoMax);
		this.setWeight(weight);
	
	}

	public void use( Character Legolas )
    {
    	if( Legolas.getDex() < dexMin )
    	{
    		int dexNeeded = this.getDexMin() - Legolas.getDex();
    		System.out.println("You are not able to use this bow, you need more " + dexNeeded + " points of dexterity");
    	}
    	else
    	{
    		System.out.println("You equipped a/an " + this.getName() + ".");
    		Legolas.setCurrentWeapon( this );
    	}
    }
	
	//Getters and setters
	public int getDexMin() {
		return dexMin;
	}

	public void setDexMin(int dexMin) {
		this.dexMin = dexMin;
	}
}
