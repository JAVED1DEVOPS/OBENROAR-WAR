/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.server;

import org.foodpanda.common.Version;
import org.foodpanda.pdo.md.User;
import org.foodpanda.server.rmi.foodpandaRemoteDbConnectionImpl;
import org.foodpanda.server.rmi.UpdateServiceImpl;

import org.tentackle.log.Logger;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;
import org.tentackle.persist.app.ServerApplication;
import org.tentackle.update.ServerUpdateUtilities;


/**
 * Middle Tier Server.
 */
@SuppressWarnings("unchecked")        // due to getUser() below
public class foodpandaServer extends ServerApplication {

  private static final Logger LOGGER = Logger.get();


  /**
   * Creates the server.
   */
  public foodpandaServer() {
    super("foodpandaServer", Version.RELEASE, foodpandaRemoteDbConnectionImpl.class);
  }

  @Override
  @SuppressWarnings("unchecked")
  public User getUser(DomainContext context, long userId) {
    return Pdo.create(User.class, context).selectCached(userId);
  }

  @Override
  protected void finishStartup() {
    super.finishStartup();
    createUpdateService();
  }

  private void createUpdateService() {
    String updateService = getProperty("updateService");
    String updateURL = getProperty("updateURL");
    if (updateService != null && updateURL != null) {
      ServerUpdateUtilities.getInstance().exportUpdateService(updateService, updateURL, UpdateServiceImpl.class);
      LOGGER.info("update service for version {0} started at {1}", Version.RELEASE, updateService);
    }
  }


  /**
   * Starts the server.
   *
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    try {
      new foodpandaServer().start(args);
      LOGGER.info("server started successfully");
    }
    catch (final RuntimeException rex) {
      LOGGER.severe("starting server failed", rex);
      throw rex; // shutdown with hooks...
    }
  }

}
