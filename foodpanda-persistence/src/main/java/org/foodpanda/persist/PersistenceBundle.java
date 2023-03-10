/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.persist;

import org.tentackle.common.Bundle;
import org.tentackle.common.BundleFactory;
import org.tentackle.common.LocaleProvider;

import java.util.ResourceBundle;

/**
 * Bundle for translations of the persistence module.
 */
@Bundle
public class PersistenceBundle {

  /**
   * Gets the bundle.
   *
   * @return the resource bundle
   */
  public static ResourceBundle getBundle() {
    return BundleFactory.getBundle(PersistenceBundle.class.getName(), LocaleProvider.getInstance().getLocale());
  }

  /**
   * Gets a string for the given key.
   *
   * @param key the key
   * @return the string from the bundle
   */
  public static String getString(String key) {
    return getBundle().getString(key);
  }

  private PersistenceBundle() {
  }

}
