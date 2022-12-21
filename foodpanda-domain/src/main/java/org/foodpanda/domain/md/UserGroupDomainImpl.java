/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.domain.md;

import org.foodpanda.pdo.md.UserGroup;
import org.foodpanda.pdo.md.domain.UserGroupDomain;

import org.tentackle.pdo.DomainObjectService;

import java.io.Serial;

/**
 * Domain implementation for UserGroup.
 */
@DomainObjectService(UserGroup.class)
public class UserGroupDomainImpl extends OrgUnitDomainImpl<UserGroup, UserGroupDomainImpl> implements UserGroupDomain {

  @Serial
  private static final long serialVersionUID = 1L;

  //<editor-fold defaultstate="collapsed" desc="constructors">

  /**
   * Creates a domain object for a PDO.
   *
   * @param pdo the persistent domain object
   */
  public UserGroupDomainImpl(UserGroup pdo) {
    super(pdo);
  }

  /**
   * Creates a domain object.
   */
  public UserGroupDomainImpl() {
    super();
  }

  //</editor-fold>

  // @wurblet domainMethods DomainMethods

//<editor-fold defaultstate="collapsed" desc="code 'domainMethods' generated by wurblet DomainMethods">//GEN-BEGIN:domainMethods


//</editor-fold>//GEN-END:domainMethods

}