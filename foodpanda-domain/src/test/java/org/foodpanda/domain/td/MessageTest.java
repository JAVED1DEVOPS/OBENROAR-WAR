/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.domain.td;

import org.foodpanda.pdo.MessageType;
import org.foodpanda.pdo.td.Message;
import org.testng.annotations.Test;
import org.tentackle.pdo.Pdo;

import static org.testng.Assert.*;

/**
 * Sample domain test.
 */
public class MessageTest {

  @Test
  public void justToShowHow() {
    // create PDO with persistence mock
    Message message = Pdo.create(Message.class);

    // configure
    message.setMessageNumber(message.nextMessageNumber());
    message.setMessageType(MessageType.LOGOUT);
    message.setText("blah");

    // test domain method
    String msg = message.toDiagnosticString();
    assertEquals(msg, "1000 - Logout @ null: blah");

    /*
     * As an alternative, you can use Mockito and mock the PersistentObject,
     * i.e. you don't need classes like MessagePersistenceMock at all:
     *
     *  MessagePersistence po = (MessagePersistence) mock(MockPersistentObject.class, withSettings().
     *         defaultAnswer(CALLS_REAL_METHODS).extraInterfaces(MessagePersistence.class));
     *  when(po.getMessageNumber()).thenReturn("1000");
     *  when(po.getMessageType()).thenReturn(MessageType.LOGOUT);
     *  when(po.getText()).thenReturn("blah");
     *  Message message = Pdo.create(Message.class, po);
     *  String msg = message.toDiagnosticString();
     *  ...
     *
     * Other Mockito hints:
     *  Mocking a concrete PDO instance works with:
     *  Message message = mock(Message.class, delegatesTo(Pdo.create(Message.class)));
     *
     *  Whereas mock(Message.class) creates a plain mockito proxy, not a tentackle proxy!
     */
  }
}
