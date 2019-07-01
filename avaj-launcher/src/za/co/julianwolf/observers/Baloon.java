package za.co.julianwolf.observers;

import za.co.julianwolf.classes.Aircraft;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.interfaces.Flyable;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void registerTower(WeatherTower weatherTower) 
	{
		if (this.weatherTower != weatherTower)
			this.weatherTower = weatherTower;
	}

	@Override
	public void updateConditions() 
	{
		String condition = weatherTower.getWeather(coordinates);
		switch (condition)
		{
			case "RAIN":
				break;
			case "SUN":
				break;
			case "SNOW":
				break;
			case "FOG":
				break;
		}
	}
}