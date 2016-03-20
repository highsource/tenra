package org.hisrc.tenra.util;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.apache.commons.lang3.Validate;

public class Ensure {

	private Ensure() {
	}

	public static final <T> T propertyHasSingleItem(
			Iterable<? extends T> value, Object parent, String propertyName) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be equal have a single item, but it is null. Parent is [{0}].",
									parent, propertyName));
		} else {
			final Iterator<? extends T> iterator = value.iterator();
			if (!iterator.hasNext()) {
				throw new IllegalArgumentException(
						MessageFormat
								.format("Property [{1}] is expected to be equal have a single item, but it is empty. Parent is [{0}].",
										parent, propertyName));
			} else {
				final T result = iterator.next();
				if (iterator.hasNext()) {
					throw new IllegalArgumentException(
							MessageFormat
									.format("Property [{1}] is expected to be equal have a single item, but it has more: [{2}]. Parent is [{0}].",
											parent, propertyName, value));
				} else {
					return result;
				}
			}
		}
	}

	public static final void propertyStartsWith(String value, Object parent,
			String propertyName, String prefix) {
		Validate.notNull(propertyName);
		Validate.notNull(prefix);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be start with [{2}] but the value is null. Parent is [{0}].",
									parent, propertyName, prefix));
		} else if (!value.startsWith(prefix)) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be start with [{2}] but it does not: [{3}]. Parent is [{0}].",
									parent, propertyName, prefix, value));
		}
	}

	public static final void propertyEquals(Object value, Object parent,
			String propertyName, Object expectedValue) {
		Validate.notNull(propertyName);
		if (expectedValue == null ? value != null : !expectedValue
				.equals(value)) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be equal to [{2}] but the value is [{3}]. Parent is [{0}].",
									parent, propertyName, expectedValue, value));
		}
	}

	public static final void propertyIsNotNull(Object value, Object parent,
			String propertyName) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be not null, but it is. Parent is [{0}].",
									parent, propertyName, value));
		}
	}

	public static final void propertyIsNull(Object value, Object parent,
			String propertyName) {
		Validate.notNull(propertyName);
		if (value != null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be null, but it is not: [{2}]. Parent is [{0}].",
									parent, propertyName, value));
		}
	}

	public static final void propertyIsEmpty(Iterable<?> value, Object parent,
			String propertyName) {
		Validate.notNull(propertyName);
		if (value != null && value.iterator().hasNext()) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be empty but it is not: [{2}]. Parent is [{0}].",
									parent, propertyName, value));
		}
	}

	public static final void propertyIsNotEmpty(Iterable<?> value,
			Object parent, String propertyName) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be empty but it is null. Parent is [{0}].",
									parent, propertyName, value));
		} else if (!value.iterator().hasNext()) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be empty but it is. Parent is [{0}].",
									parent, propertyName, value));
		}

	}

	public static final void propertyIsNil(JAXBElement<?> value, Object parent,
			String propertyName) {
		Validate.notNull(propertyName);
		if (value != null && !value.isNil()) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be nil but it is not. Parent is [{0}].",
									parent, propertyName));
		}
	}

	public static final <T> void propertyHasNumberOfItems(
			Collection<? extends T> value, Object parent, String propertyName,
			int number) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be equal have [{2}] items, but it is null. Parent is [{0}].",
									parent, propertyName, number));
		} else {
			if (value.isEmpty()) {
				throw new IllegalArgumentException(
						MessageFormat
								.format("Property [{1}] is expected to be equal have [{2}] items, but it is empty. Parent is [{0}].",
										parent, propertyName, number));
			} else {
				if (number != value.size()) {
					throw new IllegalArgumentException(
							MessageFormat
									.format("Property [{1}] is expected to be equal [{2}] items, but it has [{3}]. Parent is [{0}].",
											parent, propertyName, number,
											value.size()));
				}
			}
		}
	}

	public static final <T> void propertyHasMultipleNumberOfItems(
			Collection<? extends T> value, Object parent, String propertyName,
			int number) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be equal have [{2}n] items, but it is null. Parent is [{0}].",
									parent, propertyName, number));
		} else {
			if (value.isEmpty()) {
				throw new IllegalArgumentException(
						MessageFormat
								.format("Property [{1}] is expected to be equal have [{2}n] items, but it is empty. Parent is [{0}].",
										parent, propertyName, number));
			} else {
				if ((value.size() % number) != 0) {
					throw new IllegalArgumentException(
							MessageFormat
									.format("Property [{1}] is expected to be equal [{2}n] items, but it has [{3}]. Parent is [{0}].",
											parent, propertyName, number,
											value.size()));
				}
			}
		}
	}

	public static <T> void propertyHasNoNulls(Iterable<? extends T> value,
			Object parent, String propertyName) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to have no null items but it is null. Parent is [{0}].",
									parent, propertyName));
		} else {
			int position = 0;
			for (T item : value) {
				if (item == null) {
					throw new IllegalArgumentException(
							MessageFormat
									.format("Property [{1}] is expected to have no null items but it has null at position [{2}]. Parent is [{0}].",
											parent, propertyName, position));
				}
				position++;
			}
		}
	}

	public static final <T> T propertyIsInstanceOf(Object value, Object parent,
			String propertyName, Class<T> theClass) {
		Validate.notNull(propertyName);
		if (value == null) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be an instance of [{2}], but it is null. Parent is [{0}].",
									parent, propertyName, theClass));
		} else if (!theClass.isInstance(value)) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be an instance of [{2}], but it is not: [{3}]. Parent is [{0}].",
									parent, propertyName, theClass, value));

		} else {
			@SuppressWarnings("unchecked")
			final T result = (T) value;
			return result;
		}
	}

	public static void propertyIsFiniteNumber(double value, Object parent,
			String propertyName) {
		if (Double.isNaN(value)) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be a number, but it is not a number: [{2}]. Parent is [{0}].",
									parent, propertyName, value));
		} else if (Double.isInfinite(value)) {
			throw new IllegalArgumentException(
					MessageFormat
							.format("Property [{1}] is expected to be a number, but it is infinite: [{2}]. Parent is [{0}].",
									parent, propertyName, value));
		}
	}

	public static <K, V> V mapContainsKey(Map<K, V> map, K key, String mapName) {
		Validate.notNull(map);
		Validate.notNull(mapName);
		if (key == null) {
			return null;
		} else {
			final V value = map.get(key);
			if (value == null) {
				throw new IllegalArgumentException(
						MessageFormat
								.format("The map [{0}] must contain values for the key [{1}] but it does not.",
										mapName, key));
			} else {
				return value;
			}
		}
	}
}
