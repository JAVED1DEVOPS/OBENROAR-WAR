/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.common;

import org.tentackle.pdo.DefaultDomainContext;
import org.tentackle.session.Session;

import java.io.Serial;

/**
 * Application specific domain context.
 */
public class foodpandaDomainContext extends DefaultDomainContext {

  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * Creates a domain context.
   *
   * @param session the session
   * @param sessionImmutable true if session cannot be changed anymore
   */
  public foodpandaDomainContext(Session session, boolean sessionImmutable) {
    super(session, sessionImmutable);
  }

  /**
   * Creates a mutable domain context.
   *
   * @param session the session
   */
  public foodpandaDomainContext(Session session) {
    super(session);
  }

}
