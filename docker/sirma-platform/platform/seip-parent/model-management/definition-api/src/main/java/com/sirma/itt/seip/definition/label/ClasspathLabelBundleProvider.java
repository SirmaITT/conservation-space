package com.sirma.itt.seip.definition.label;

import java.util.Locale;
import java.util.ResourceBundle;

import com.sirma.itt.seip.domain.definition.label.LabelResolverProvider;
import com.sirma.itt.seip.domain.definition.label.LabelResolver;

/**
 * Provider for resource bundles located in the classpath. The implementors should provide only the basename of the
 * resource bundle.
 *
 * @author Adrian Mitev
 */
public abstract class ClasspathLabelBundleProvider implements LabelResolverProvider {

	@Override
	public LabelResolver getLabelResolver(Locale locale) {
		return LabelResolver.wrap(ResourceBundle.getBundle(getBaseName(), locale));
	}

	/**
	 * Used by the implementors. Should provide basename (path to the bundle like "com.sirma.itt.emf.messages") for the
	 * bundle.
	 *
	 * @return bundle base name.
	 */
	protected abstract String getBaseName();

}
