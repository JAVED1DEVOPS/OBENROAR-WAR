/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.common;

import org.tentackle.common.StringHelper;
import org.tentackle.session.Session;

/**
 * Global static methods.
 */
public class foodpandaHelper {


  private static final char[] SALT = {'T', 'T', '2' };


  /**
   * Gets the session info of the running application.
   *
   * @return the session info
   */
  public static foodpandaSessionInfo getSessionInfo() {
    return (foodpandaSessionInfo) Session.getCurrentSession().getSessionInfo();
  }


  /**
   * Builds a hash sum from an array of chars.
   *
   * @param input is the input password, null or empty if none
   * @return the hash sum, null if input was null or empty
   */
  public static String hash(char[] input) {
    if (input != null && input.length == 0) {
      input = null;
    }
    return StringHelper.hash("SHA-256", SALT, input);
  }


  private foodpandaHelper() {}

}
