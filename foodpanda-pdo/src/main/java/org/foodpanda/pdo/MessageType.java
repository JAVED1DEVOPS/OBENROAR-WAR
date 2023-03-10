/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.pdo;

import org.tentackle.misc.Convertible;
import org.tentackle.pdo.PdoRuntimeException;

/**
 * Defined set of message types.
 */
public enum MessageType implements Convertible<String>{

  /**
   * User logged in.
   */
  LOGIN,

  /**
   * User logged out.
   */
  LOGOUT;

  // to be cont'd



  @Override
  public String toString() {
    return PdoBundle.getString(name());
  }

  @Override
  public String toExternal() {
    return name();
  }


  /**
   * Creates an event source from an external value.
   *
   * @param external the external value
   * @return the type
   */
  public static MessageType toInternal(String external) {
    if (external != null) {
      return MessageType.valueOf(external);
    }
    return null;
  }

  /**
   * Creates a default type.<br>
   * There is no default type.
   *
   * @return the type
   * @throws PdoRuntimeException always
   */
  public static MessageType getDefault() {
    throw new PdoRuntimeException("there is no default message type");
  }

}
