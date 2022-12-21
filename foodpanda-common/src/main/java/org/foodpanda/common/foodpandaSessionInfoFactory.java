/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.common;

import org.tentackle.common.Service;
import org.tentackle.session.SessionInfo;
import org.tentackle.session.SessionInfoFactory;

import java.util.Properties;

/**
 * Application specific session info factory.
 */
@Service(SessionInfoFactory.class)
public class foodpandaSessionInfoFactory implements SessionInfoFactory {

  @Override
  public SessionInfo create(String username, char[] password, String propertiesName) {
    return new foodpandaSessionInfo(username, password, propertiesName);
  }

  @Override
  public SessionInfo create(String propertiesName) {
    return new foodpandaSessionInfo(propertiesName);
  }

  @Override
  public SessionInfo create(Properties properties) {
    return new foodpandaSessionInfo(properties);
  }

  @Override
  public SessionInfo create() {
    return new foodpandaSessionInfo();
  }

}
