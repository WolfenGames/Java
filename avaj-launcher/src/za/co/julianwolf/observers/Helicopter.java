package za.co.julianwolf.observers;

import za.co.julianwolf.classes.Aircraft;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.logger.MyLogger;

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
		String condition = weatherTower.getWeather(coordinates);
		String pre ="Helicopter#" + this.name + "(" + this.id + "): ";
		switch (condition)
		{
			case "RAIN":
				this.coordinates.longitude += 5;
				MyLogger.getLogger().log(pre + "O gosh..");
				break;
			case "SUN":
				this.coordinates.longitude += 10;
				this.coordinates.height += 2;
				MyLogger.getLogger().log(pre + "ITS BRIGHT");
				break;
			case "SNOW":
				this.coordinates.height -= 12;
				MyLogger.getLogger().log(pre + "This is bumpy");
				break;
			case "FOG":
				this.coordinates.longitude += 1;
				MyLogger.getLogger().log(pre + "Hope I dont hit any zombies..");
				break;
		}
		if (this.coordinates.getHeight() > 100) this.coordinates.height = 100;
		if (this.coordinates.getHeight() < 1)
		{
			this.coordinates.height = 0;
			MyLogger.getLogger().log("Helicopter#" + this.name + "(" + this.id + ") Landing.");
			MyLogger.getLogger().log("Helicopter#" + this.name + "(" + this.id + ") Long:" + this.coordinates.getLongitude() + " Lat:" + this.coordinates.getLatitude() + " Height:" + this.coordinates.getHeight());
			this.weatherTower.unregister(this);
		}
	}
}
