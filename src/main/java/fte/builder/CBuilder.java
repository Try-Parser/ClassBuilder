/**
 * 
 */
package fte.builder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Try-Parser
 * Class Builder
 */
public class CBuilder {

	public static class Builder<T> {
		private T instance;

		private Builder() {}

		public static <T> Builder<T> start(Class<T> klass) {
			try {
				Builder<T> bldr = new Builder<T>();
				bldr.setInstance(klass.getConstructor().newInstance());
				
				return bldr;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				new Throwable(e);
				return null;
			}
		}
		
		public Builder<T> setKey(String key, Object v) {
			Class<?> c = getInstance().getClass();
			
			try {
				Field newField = c.getDeclaredField(key);
				Boolean access = newField.canAccess(getInstance());
				newField.setAccessible(true);
				newField.set(getInstance(), v);
				newField.setAccessible(access);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				new Throwable(e);
			}
			return this;
		}
		
		public T build() {
			return (T) getInstance();
		}

		/**
		 * @return the instance
		 */
		public T getInstance() {
			return instance;
		}

		/**
		 * @param instance the instance to set
		 */
		public void setInstance(T instance) {
			this.instance = instance;
		}

	}
}

