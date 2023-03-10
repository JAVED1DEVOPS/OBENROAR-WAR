/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.server.rmi;

import org.foodpanda.common.Version;

import org.tentackle.update.AbstractUpdateServiceImpl;

import java.io.Serial;
import java.rmi.RemoteException;


/**
 * Server side update service implementation.
 */
public class UpdateServiceImpl extends AbstractUpdateServiceImpl {

  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * Creates an update service object.
   *
   * @param port the tcp-port, 0 = system default
   * @param updateURL the http url where to download the updates from
   * @throws RemoteException if failed to export object
   */
  public UpdateServiceImpl(int port, String updateURL) throws RemoteException {
    super(port, updateURL);
  }

  @Override
  public String getArtifactName() {
    return "foodpanda-jlink-client";
  }

  @Override
  public String getVersion() {
    return Version.RELEASE;
  }

}
