/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.server;

import org.testng.annotations.Test;

public class RunServer {

  @Test
  public void runServer() {
    run(new String[] {"--statistics"});
  }

  private synchronized void run(String[] args) {
    new foodpandaServer().start(args);
    try {
      wait();   // keep it running...
    }
    catch (InterruptedException e) {}
  }

}