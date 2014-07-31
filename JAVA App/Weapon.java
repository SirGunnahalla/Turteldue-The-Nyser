package pr2.nyser;

public abstract class Weapon 
{
	private int weaponDamageMin;
	private int weaponDamageMax;
	private String name;
	private int weight;
	
	//Getters and setters	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeaponDamageMin() 
	{
		return weaponDamageMin;
	}
	
	public void setWeaponDamageMin(int weaponDamageMin) 
	{
		this.weaponDamageMin = weaponDamageMin;
	}
	
	public int getWeaponDamageMax() 
	{
		return weaponDamageMax;
	}

	public void setWeaponDamageMax(int weaponDamageMax) 
	{
		this.weaponDamageMax = weaponDamageMax;
	}

	public int getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
	
}

