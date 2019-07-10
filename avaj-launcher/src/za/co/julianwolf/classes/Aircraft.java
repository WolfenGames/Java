package za.co.julianwolf.classes;

import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.logger.MyLogger;

public abstract class Aircraft
{
	private static long counter = 0;
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}
	private long nextId() { return counter++; }
}
