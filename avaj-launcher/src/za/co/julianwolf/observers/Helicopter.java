package za.co.julianwolf.observers;

import za.co.julianwolf.classes.Aircraft;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
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
		Coordinates newCoordinates = new Coordinates(0, 0, 0);
		String condition = weatherTower.getWeather(coordinates);
		switch (condition)
		{
			case "RAIN":
				newCoordinates.longitude = this.coordinates.getLongitude();
				newCoordinates.latitude = this.coordinates.getLatitude() + 1;
				newCoordinates.height = this.coordinates.getHeight();
				break;
			case "SUN":
				newCoordinates.longitude = this.coordinates.getLongitude();
				newCoordinates.latitude = this.coordinates.getLatitude() + 10;
				newCoordinates.height = this.coordinates.getHeight() + 2;
				break;
			case "SNOW":
				newCoordinates.longitude = this.coordinates.getLongitude();
				newCoordinates.latitude = this.coordinates.getLatitude();
				newCoordinates.height = this.coordinates.getHeight() - 7;
				break;
			case "FOG":
				newCoordinates.longitude = this.coordinates.getLongitude();
				newCoordinates.latitude = this.coordinates.getLatitude() + 1;
				newCoordinates.height = this.coordinates.getHeight();
				break;
		}
		if (newCoordinates.height > 100) newCoordinates.height = 100;
		if (newCoordinates.height < 1)
		{
			this.weatherTower.unregister(this);
		}
		this.coordinates = newCoordinates;
	}
}