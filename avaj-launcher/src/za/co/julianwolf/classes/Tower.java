package za.co.julianwolf.classes;

import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.logger.MyLogger;
import za.co.julianwolf.classes.Reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	public void register(Flyable flyable)
	{
		if (flyable != null && !this.observers.contains(flyable))
		{
			this.observers.add(flyable);
			flyable.registerTower((WeatherTower)this);
			String val = flyable.getClass().getSimpleName().toString();
			try
			{
				Field x = Reflection.getField(flyable.getClass(), "id");
				Field y = Reflection.getField(flyable.getClass(), "name");
				MyLogger.getLogger().log("Tower says: " +
								val +
								"#" +
								y.get(flyable) +
								"(" +
								x.getLong(flyable) +
								") " +
								" : Registered to weather tower");
			} catch (Exception e)
			{
				MyLogger.getLogger().log("Tower says: " + val + " (Undefined) " + " : Registered to tower");
			}

		}
	};

	public void unregister(Flyable flyable)
	{
		ArrayList<Flyable> holder = this.observers;
		this.observers = new ArrayList<Flyable>();
		for (Flyable f: holder)
		{
			if (f != flyable)
				this.observers.add(f);
		}
		String val = flyable.getClass().getSimpleName().toString();
		try
		{
			Field x = Reflection.getField(flyable.getClass(), "id");
			Field y = Reflection.getField(flyable.getClass(), "name");
			MyLogger.getLogger().log("Tower says: " +
							val +
							"#" +
							y.get(flyable) +
							"(" +
							x.getLong(flyable) +
							") " +
							" : UnRegistered to weather tower");
		} catch (Exception e)
		{
			MyLogger.getLogger().log("Tower says: " + val + " (Undefined) " + " : UnRegistered to tower");
		}
	};

	public void conditionsChanged()
	{
		for(Iterator<Flyable> iter = this.observers.iterator(); iter.hasNext();)
		{
			Flyable x = iter.next();
			x.updateConditions();
		}
	}
}
