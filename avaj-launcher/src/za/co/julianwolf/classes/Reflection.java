package za.co.julianwolf.classes;

import java.lang.reflect.Field;

public class Reflection
{
	public static Field getField(Class c, String fieldName) throws NoSuchFieldException {
        try {
            return c.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = c.getSuperclass();
            if (superClass == null) {
                throw e;
            } else {
                return getField(superClass, fieldName);
            }
        }
    }
}
