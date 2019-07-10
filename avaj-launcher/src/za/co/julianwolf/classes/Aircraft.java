package za.co.julianwolf.classes;

import za.co.julianwolf.classes.Coordinates;

public class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	public Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}
	private long nextId() { return id++; }// UUID.randomUUID(); };
}
