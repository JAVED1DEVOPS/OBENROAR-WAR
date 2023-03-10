/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.persist.md.rmi;

import org.foodpanda.pdo.md.User;
import org.foodpanda.persist.md.UserPersistenceImpl;

import java.rmi.RemoteException;


/**
 * Remote delegate for {@link UserPersistenceImpl}.
 */
public interface UserRemoteDelegate
       extends OrgUnitRemoteDelegate<User,UserPersistenceImpl> {


  // @wurblet inclrmi Include --missingok .$classname/methods

  //<editor-fold defaultstate="collapsed" desc="code 'inclrmi' generated by wurblet Include">//GEN-BEGIN:inclrmi

  String selectPasswordHash(User obj) throws RemoteException;
  void updatePasswordHash(String password, User obj) throws RemoteException;

  //</editor-fold>//GEN-END:inclrmi


}
