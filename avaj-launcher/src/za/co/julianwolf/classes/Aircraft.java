package za.co.julianwolf.classes;

import za.co.julianwolf.classes.Coordinates;

public class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private long nextId() { return this.id + 1; };
}