package za.co.julianwolf.observers;

import za.co.julianwolf.classes.Aircraft;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.interfaces.Flyable;

public class Plane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	public Plane(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		if (this.weatherTower != weatherTower)
			this.weatherTower = weatherTower;
	}

	@Override
	public void updateConditions() {
		weatherTower.getWeather(coordinates); // ???
	}
}