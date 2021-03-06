package com.sirma.itt.seip.security.mocks;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.sirma.itt.seip.configuration.ConfigurationChangeListener;
import com.sirma.itt.seip.configuration.ConfigurationProperty;
import com.sirma.itt.seip.configuration.build.ConfigurationInstance;
import com.sirma.itt.seip.configuration.sync.Synchronizer;

/**
 * Simple configuration property mock
 *
 * @author BBonev
 * @param <T>
 *            the generic type
 */
public class ConfigurationPropertyMock<T> implements ConfigurationProperty<T> {
	private static final long serialVersionUID = -7175054227749081096L;

	private Supplier<T> supplier;

	public ConfigurationPropertyMock() {

	}

	/**
	 * Instantiates a new configuration property mock.
	 *
	 * @param value
	 *            the value
	 */
	public ConfigurationPropertyMock(T value) {
		this(() -> value);
	}

	/**
	 * Instantiates a new configuration property mock.
	 *
	 * @param supplier
	 *            the supplier
	 */
	public ConfigurationPropertyMock(Supplier<T> supplier) {
		this.supplier = supplier;
	}

	@Override
	public String getName() {
		// implement me!
		return null;
	}

	@Override
	public T get() {
		return supplier.get();
	}

	@Override
	public boolean isSet() {
		return supplier.get() != null;
	}

	@Override
	public Synchronizer getSynchronizer() {
		// implement me!
		return null;
	}

	@Override
	public ConfigurationInstance getDefinition() {
		return null;
	}

	@Override
	public void valueUpdated() {
		// nothing to do property value is always fetched
	}

	@Override
	public void addConfigurationChangeListener(ConfigurationChangeListener<T> callback) {
		// implement me!

	}

	@Override
	public void removeConfigurationChangeListener(ConfigurationChangeListener<T> callback) {
		// implement me!

	}

	public void setValue(T value) {
		supplier = () -> value;
	}

	public void setSupplier(Supplier<T> value) {
		supplier = value;
	}

	@Override
	public void addValueDestroyListener(Consumer<T> oldValueConsumer) {
		// implement me!

	}

	@Override
	public boolean isInitialized() {
		return true;
	}

}
