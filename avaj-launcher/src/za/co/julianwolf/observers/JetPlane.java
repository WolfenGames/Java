package za.co.julianwolf.observers;

import za.co.julianwolf.classes.Aircraft;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.logger.MyLogger;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates)
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
		String pre ="JetPlane#" + this.name + "(" + this.id + "): ";
		switch (condition)
		{
			case "RAIN":
				this.coordinates.latitude += 5;
				MyLogger.getLogger().log(pre + "I can still see");
				break;
			case "SUN":
				this.coordinates.latitude += 10;
				this.coordinates.height += 2;
				MyLogger.getLogger().log(pre + "I am no longer able to see");
				break;
			case "SNOW":
				this.coordinates.height -= 7;
				MyLogger.getLogger().log(pre + "I can see people freezing");
				break;
			case "FOG":
				this.coordinates.latitude += 1;
				MyLogger.getLogger().log(pre + "I cant see");
				break;
		}
		if (this.coordinates.getHeight() > 100) this.coordinates.height = 100;
		if (this.coordinates.getHeight() < 1)
		{
			this.coordinates.height = 0;
			MyLogger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ") Landing.");
			MyLogger.getLogger().log("JetPlane#" + this.name + "(" + this.id + ") Long:" + this.coordinates.getLongitude() + " Lat:" + this.coordinates.getLatitude() + " Height:" + this.coordinates.getHeight());
			this.weatherTower.unregister(this);
		}
	}
}
