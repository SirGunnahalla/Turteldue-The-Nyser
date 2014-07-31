package pr2.nyser;

public abstract class Monsters extends SonsOfOdin
{
	
	private int damageMin; // The minimum to hit in an attack
	private int damageMax; // The range of the damage
	

	public abstract void attack( SonsOfOdin Thing );
	
	//GETTERS AND SETTERS
	public int getDamageMin() 
	{
		return damageMin;
	}
	public void setDamageMin(int damageMin) 
	{
		this.damageMin = damageMin;
	}
	public int getDamageMax() 
	{
		return damageMax;
	}
	public void setDamageMax(int damageMax) 
	{
		this.damageMax = damageMax;
	}
	
}

