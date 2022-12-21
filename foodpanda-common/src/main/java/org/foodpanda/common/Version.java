/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.common;

import java.util.ResourceBundle;


/**
 * Holds versioning information.
 */
public class Version {

  // to avoid i18n test errors (not annotated with @Bundle)
  private static final String VERSION_STR = "version";
  private static final String DATE_STR = "date";


  /** the artifact version **/
  public static final String RELEASE = getBundle().getString(VERSION_STR);

  /** the build timestamp **/
  public static final String DATE = getBundle().getString(DATE_STR);

  /**
   * Gets the bundle.
   *
   * @return the resource bundle
   */
  public static ResourceBundle getBundle() {
    return ResourceBundle.getBundle(Version.class.getName());
  }


  private Version() {}

}
