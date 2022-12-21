/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.daemon;

import org.testng.annotations.Test;

public class RunDaemon {

  @Test
  public void runDaemon() {
    run(new String[] {"--statistics"});
  }


  private synchronized void run(String[] args) {
    new foodpandaDaemon().start(args);
    try {
      wait();   // keep it running...
    }
    catch (InterruptedException e) {}
  }

}