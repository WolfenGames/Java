package za.co.julianwolf.observers;

import za.co.julianwolf.classes.Aircraft;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.logger.MyLogger;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates)
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
		String pre ="Baloon#" + this.name + "(" + this.id + "): ";
		switch (condition)
		{
			case "RAIN":
				this.coordinates.longitude -= 5;
				MyLogger.getLogger().log(pre + "IT'S WET!");
				break;
			case "SUN":
				this.coordinates.longitude += 2;
				this.coordinates.height += 4;
				MyLogger.getLogger().log(pre + "Sunny Day.");
				break;
			case "SNOW":
				this.coordinates.height -= 15;
				MyLogger.getLogger().log(pre + "IT'S COLD AND WET!");
				break;
			case "FOG":
				this.coordinates.height -= 3;
				MyLogger.getLogger().log(pre + "I CAN'T SEE JACKSHIT!");
				break;
		}
		if (this.coordinates.getHeight() > 100) this.coordinates.height = 100;
		if (this.coordinates.getHeight() < 1)
		{
			this.coordinates.height = 0;
			MyLogger.getLogger().log("Baloon#" + this.name + "(" + this.id + ") Landing.");
			MyLogger.getLogger().log("Baloon#" + this.name + "(" + this.id + ") Long:" + this.coordinates.getLongitude() + " Lat:" + this.coordinates.getLatitude() + " Height:" + this.coordinates.getHeight());
			this.weatherTower.unregister(this);
		}
	}
}
