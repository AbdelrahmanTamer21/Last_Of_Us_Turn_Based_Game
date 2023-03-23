package model.world;

public class TrapCell extends Cell 
{
	private int trapDamage;
	public TrapCell()
	{
		int [] a = {10,20,30};
		this.trapDamage = a[   (int)(Math.random()*3)   ];
	}
	
	public int getTrapDamage() {
		return trapDamage;
	}
	
}
