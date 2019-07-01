package za.co.julianwolf.factory;

import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.observers.*;

public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		switch (type)
		{
			case "Baloon":
				return new Baloon(name, coordinates);
			case "Helicopter":
				return new Helicopter(name, coordinates);
			case "Plane":
				return new Plane(name, coordinates);
			default:
				return null;
		}
	}
}