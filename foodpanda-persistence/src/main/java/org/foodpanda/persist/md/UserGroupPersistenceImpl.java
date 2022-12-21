/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.persist.md;

import org.foodpanda.pdo.md.User;
import org.foodpanda.pdo.md.User2Group;
import org.foodpanda.pdo.md.UserGroup;
import org.foodpanda.pdo.md.persist.UserGroupPersistence;
import org.foodpanda.persist.md.rmi.UserGroupRemoteDelegate;

import org.tentackle.dbms.DbModificationType;
import org.tentackle.dbms.DbObjectClassVariables;
import org.tentackle.dbms.ModificationType;
import org.tentackle.dbms.PreparedStatementWrapper;
import org.tentackle.dbms.ResultSetWrapper;
import org.tentackle.misc.IdentifiableMap;
import org.tentackle.misc.TrackedArrayList;
import org.tentackle.misc.TrackedList;
import org.tentackle.misc.TrackedListListener;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;
import org.tentackle.pdo.PdoCache;
import org.tentackle.pdo.PersistentDomainObject;
import org.tentackle.pdo.PersistentObjectService;
import org.tentackle.persist.PersistentObjectClassVariables;
import org.tentackle.session.PersistenceException;
import org.tentackle.session.Session;
import org.tentackle.sql.Backend;
import org.tentackle.sql.JoinType;
import org.tentackle.validate.ValidationFailedException;
import org.tentackle.validate.ValidationResult;
import org.tentackle.validate.ValidationScope;
import org.tentackle.validate.ValidationUtilities;

import java.io.Serial;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Persistence implementation for UserGroup.
 */
@PersistentObjectService(UserGroup.class)
public class UserGroupPersistenceImpl extends OrgUnitPersistenceImpl<UserGroup, UserGroupPersistenceImpl> implements UserGroupPersistence {

  @Serial
  private static final long serialVersionUID = 1L;

  // @wurblet classVariables ClassVariables

  //<editor-fold defaultstate="collapsed" desc="code 'classVariables' generated by wurblet ClassVariables">//GEN-BEGIN:classVariables

  /** Variables common to all instances of UserGroupPersistenceImpl. */
  @SuppressWarnings({"unchecked", "rawtypes", "FieldNameHidesFieldInSuperclass"})
  public static final PersistentObjectClassVariables<UserGroup, UserGroupPersistenceImpl> CLASSVARIABLES =
            PersistentObjectClassVariables.create(
                    UserGroup.class,
                    UserGroupPersistenceImpl.class,
                    "ug",
                    OrgUnitPersistenceImpl.CLASSVARIABLES,
                    null);

  @Override
  public PersistentObjectClassVariables<UserGroup, UserGroupPersistenceImpl> getClassVariables() {
    return CLASSVARIABLES;
  }

  //</editor-fold>//GEN-END:classVariables


  // @wurblet columnNames ColumnNames

//<editor-fold defaultstate="collapsed" desc="code 'columnNames' generated by wurblet ColumnNames">//GEN-BEGIN:columnNames


//</editor-fold>//GEN-END:columnNames


  // @wurblet declare Declare

//<editor-fold defaultstate="collapsed" desc="code 'declare' generated by wurblet Declare">//GEN-BEGIN:declare


//</editor-fold>//GEN-END:declare


  //<editor-fold defaultstate="collapsed" desc="constructors">

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   * @param context the domain context
   */
  public UserGroupPersistenceImpl(UserGroup pdo, DomainContext context) {
    super(pdo, context);
  }

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   * @param session the session
   */
  public UserGroupPersistenceImpl(UserGroup pdo, Session session) {
    super(pdo, session);
  }

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   */
  public UserGroupPersistenceImpl(UserGroup pdo) {
    super(pdo);
  }

  /**
   * Creates a persistent object.
   */
  public UserGroupPersistenceImpl() {
    super();
  }

  //</editor-fold>

  // @wurblet methods MethodsImpl

  //<editor-fold defaultstate="collapsed" desc="code 'methods' generated by wurblet MethodsImpl">//GEN-BEGIN:methods


  @Override
  public UserGroupRemoteDelegate getRemoteDelegate() {
    return (UserGroupRemoteDelegate) super.getRemoteDelegate();
  }

  @Override
  public void getFields(ResultSetWrapper rs) {
    super.getFields(rs);
    rs.configureSection(CLASSVARIABLES);
    if (rs.getRow() <= 0) {
      throw new PersistenceException(getSession(), "no valid row");
    }
  }

  /**
   * Sets the values of all UserGroup-columns in the given statement.
   *
   * @param st the prepared statement
   * @return the number of columns set
   */
  public int setFieldsUserGroup(PreparedStatementWrapper st) {
    int ndx = 0;
    st.setLong(++ndx, getId());
    return ndx;
  }

  /**
   * Creates the SQL code for the UserGroup insert statement.
   *
   * @return the SQL code
   */
  public String createInsertSqlUserGroup() {
    return Backend.SQL_INSERT_INTO + CLASSVARIABLES.getTableName() + Backend.SQL_LEFT_PARENTHESIS +
           CN_ID +
           Backend.SQL_INSERT_VALUES +
           Backend.SQL_PAR + Backend.SQL_RIGHT_PARENTHESIS;
  }

  /**
   * Creates the SQL code for the UserGroup update statement.
   *
   * @return the SQL code
   */
  public String createUpdateSqlUserGroup() {
    return Backend.SQL_UPDATE + CLASSVARIABLES.getTableName() + Backend.SQL_SET +
           CN_ID + Backend.SQL_EQUAL + CN_ID +
           Backend.SQL_WHERE + CN_ID + Backend.SQL_EQUAL_PAR;
  }

  /**
   * Creates the SQL code for the UserGroup delete statement.
   *
   * @return the sql code
   */
  public String createDeleteSqlUserGroup() {
    return Backend.SQL_DELETE + Backend.SQL_FROM + CLASSVARIABLES.getTableName() +
           Backend.SQL_WHERE + CN_ID + Backend.SQL_EQUAL_PAR;
  }

  @Override
  public StringBuilder createSelectAllInnerSql() {
    StringBuilder sql = new StringBuilder();
    sql.append(OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(Backend.SQL_ALLSTAR));
    sql.append(Backend.SQL_COMMA).append(UserGroupPersistenceImpl.CLASSVARIABLES.getColumnName(Backend.SQL_ALLSTAR));
    sql.append(Backend.SQL_FROM);
    sql.append(OrgUnitPersistenceImpl.CLASSVARIABLES.getTableName()).
        append(getBackend().sqlAsBeforeTableAlias()).append(OrgUnitPersistenceImpl.CLASSVARIABLES.getTableAlias());
    sql.append(getBackend().sqlJoin(JoinType.INNER,
               UserGroupPersistenceImpl.CLASSVARIABLES.getTableName(), UserGroupPersistenceImpl.CLASSVARIABLES.getTableAlias(),
               OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(CN_ID) + Backend.SQL_EQUAL +
               UserGroupPersistenceImpl.CLASSVARIABLES.getColumnName(CN_ID)));
    sql.append(Backend.SQL_WHEREALL);
    return sql;
  }

  @Override
  public StringBuilder createSelectAllByIdInnerSql() {
    StringBuilder sql = createSelectAllInnerSql();
    sql.append(Backend.SQL_AND).
        append(OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(CN_ID)).
        append(Backend.SQL_EQUAL_PAR);
    return sql;
  }

  @Override
  protected void updateImpl(DbObjectClassVariables<UserGroupPersistenceImpl> classVariables,
                            Supplier<String> sqlsupplier) {
    super.updateImpl(classVariables, sqlsupplier);
    PreparedStatementWrapper st = getBatchablePreparedStatement(DbModificationType.UPDATE, CLASSVARIABLES.updateStatementId, this::createUpdateSqlUserGroup);
    setFieldsUserGroup(st);
    assertThisRowAffected(st.executeUpdate());
  }

  @Override
  protected void insertImpl(DbObjectClassVariables<UserGroupPersistenceImpl> classVariables,
                            Supplier<String> sqlsupplier) {
    super.insertImpl(classVariables, sqlsupplier);
    PreparedStatementWrapper st = getBatchablePreparedStatement(DbModificationType.INSERT, CLASSVARIABLES.insertStatementId, this::createInsertSqlUserGroup);
    setFieldsUserGroup(st);
    assertThisRowAffected(st.executeUpdate());
  }

  @Override
  protected void deleteImpl(DbObjectClassVariables<UserGroupPersistenceImpl> classVariables,
                            Supplier<String> sqlsupplier) {
    PreparedStatementWrapper st = getBatchablePreparedStatement(DbModificationType.DELETE, CLASSVARIABLES.deleteStatementId, this::createDeleteSqlUserGroup);
    st.setLong(1, getId());
    assertThisRowAffected(st.executeUpdate());
    super.deleteImpl(classVariables, sqlsupplier);
  }

  //</editor-fold>//GEN-END:methods


  // @wurblet relations PdoRelations

  //<editor-fold defaultstate="collapsed" desc="code 'relations' generated by wurblet PdoRelations">//GEN-BEGIN:relations


  // composite list of User2Group nmLinks via User2Group#userGroupId (NmLinks)
  private TrackedList<User2Group> nmLinks;
  private boolean nmLinksLoaded;
  private transient TrackedList<User2Group> nmLinksSnapshot;
  private transient TrackedList<User> users;

  @Override
  public TrackedList<User2Group> getNmLinks()  {
    if (!nmLinksLoaded) {
      nmLinks = isNew() ? new TrackedArrayList<>(false) : on(User2Group.class).selectByUserGroupId(getId());
      if (isImmutable()) {
        nmLinks.setImmutable(true);
      }
      nmLinksLoaded = true;
      nmLinks.addListener(new TrackedListListener<>() {

        @Override
        public void added(User2Group element) {
          getUsers().addIfAbsent(element.getUser());
        }

        @Override
        public void removed(User2Group element) {
          getUsers().remove(element.getUser());
        }
      });
    }
    return nmLinks;
  }

  /**
   * Gets nmLinks without performing a select if not loaded.
   *
   * @return nmLinks NmLinks
   */
  public TrackedList<User2Group> getNmLinksBlunt() {
    if (!nmLinksLoaded) {
      nmLinks = new TrackedArrayList<>(false);
      if (isImmutable()) {
        nmLinks.setImmutable(true);
      }
      nmLinksLoaded = true;
    }
    return nmLinks;
  }

  @Override
  public TrackedList<User> getUsers() {
    if (users == null) {
      users = new TrackedArrayList<>() {

        @Override
        public boolean isModified() {
          return getNmLinks().isModified();
        }
      };

      for (User2Group obj: getNmLinks()) {
        users.add(obj.getUser());
      }

      users.addListener(new TrackedListListener<>() {

        @Override
        public void added(User element) {
          User2Group obj = on(User2Group.class);
          obj.setUser(element);
          getNmLinks().add(obj);
        }

        @Override
        public void removed(User element) {
          for (Iterator<User2Group> iter = getNmLinks().iterator(); iter.hasNext(); ) {
            User2Group obj = iter.next();
            if (Objects.equals(obj.getUser(), element)) {
              iter.remove();
              break;
            }
          }
        }
      });
    }
    return users;
  }

  @Override
  public boolean isNmLinksLoaded() {
    return nmLinksLoaded;
  }

  @Override
  public void setSession(Session session)  {
    super.setSession(session);
    session.applyTo(nmLinks);
  }

  @Override
  public void setDomainContext(DomainContext context)  {
    super.setDomainContext(context);
    context.applyTo(nmLinks);
  }

  /**
   * Deletes all referencing composite relations that have been removed from the PDO.<br>
   * The database cascades down via referential integrity.
   */
  public void deleteRemovedReferencingRelations() {
    if (nmLinks != null && nmLinks.isSomeRemoved()) {
      delete(nmLinks.getRemovedObjects());
    }
  }

  @Override
  public void saveReferencingRelations(boolean update)  {
    super.saveReferencingRelations(update);
    if (update) {
      deleteRemovedReferencingRelations();
    }
    if (nmLinks != null) {
      getDomainContext().applyTo(nmLinks);
      for (User2Group obj: nmLinks)  {
        obj.setUserGroupId(getId());
      }
      save(nmLinks, true);
    }
  }

  @Override
  public List<ValidationResult> validate(String validationPath, ValidationScope scope) {
    List<ValidationResult> results = super.validate(validationPath, scope);
    try {
      if (nmLinks != null) {
        results.addAll(ValidationUtilities.getInstance().validateCollection(
                  nmLinks, validationPath + ".nmLinks", scope));
      }
    }
    catch (ValidationFailedException vfx) {
      vfx.reThrow(results);
    }
    return results;
  }

  @Override
  public void setImmutable(boolean immutable) {
    super.setImmutable(immutable);
    if (nmLinks != null) {
      nmLinks.setImmutable(immutable);
    }
  }

  @Override
  public boolean isModified()  {
    return super.isModified()
           || isModified(nmLinks)
           ;
  }

  @Override
  public boolean isComposite()  {
    return true;
  }


  @Override
  public IdentifiableMap<? extends PersistentDomainObject<?>> loadComponents(boolean onlyLoaded) {
    IdentifiableMap<PersistentDomainObject<?>> components = new IdentifiableMap<>();
    addComponents(components, onlyLoaded);
    return components;
  }

  @Override
  public int addComponents(IdentifiableMap<PersistentDomainObject<?>> components, boolean onlyLoaded)  {
    int count = 0;
    count += super.addComponents(components, onlyLoaded);
    if (!onlyLoaded || nmLinksLoaded) {
      count += addComponents(components, getNmLinks(), onlyLoaded);
    }
    return count;
  }

  @Override
  public void insertPlainWithComponents()  {
    insertPlain();
    insertPlainWithComponents(getNmLinks());
  }

  @Override
  public void deletePlainWithComponents()  {
    // components are deleted via database referential integrity constraints
    deletePlain();
  }

  @Override
  public void markDeleted() {
    super.markDeleted();
    markDeleted(nmLinks);
  }

  /**
   * Updates the components in snapshot object.<br>
   * The snapshot object is assumed to be a clone of this object.
   *
   * @param snapshot the snapshot
   */
  protected void createComponentsInSnapshot(UserGroupPersistenceImpl snapshot) {
    super.createComponentsInSnapshot(snapshot);
    snapshot.nmLinksSnapshot = TrackedList.createSnapshot(nmLinks);
  }

  /**
   * Reverts all components of this object to a given snapshot.
   *
   * @param snapshot the snapshot object
   */
  protected void revertComponentsToSnapshot(UserGroupPersistenceImpl snapshot) {
    super.revertComponentsToSnapshot(snapshot);
    nmLinks = TrackedList.revertToSnapshot(nmLinks, snapshot.nmLinksSnapshot);
    nmLinksLoaded = snapshot.nmLinksLoaded;
    users = null;
  }

  //</editor-fold>//GEN-END:relations


  // @wurblet cache PdoCache --preload

  //<editor-fold defaultstate="collapsed" desc="code 'cache' generated by wurblet PdoCache">//GEN-BEGIN:cache


  /** the cache. */
  private static PdoCache<UserGroup> cache;

  /**
   * Creates the cache singleton if it does not exist.
   *
   * @return the cache singleton
   */
  private static synchronized PdoCache<UserGroup> createCache() {
    if (cache == null) {
      cache = Pdo.createPdoCache(UserGroup.class, true, true, false);
      Pdo.listen(ev -> cache.expire(ev.getSerial()), UserGroup.class);
    }
    return cache;
  }

  @Override
  public PdoCache<UserGroup> getCache() {
    return cache == null ? createCache() : cache;
  }

  @Override
  public boolean isCountingModification(ModificationType modType) {
    return true;
  }

  @Override
  public boolean isReadAllowed() {
    return true;
  }

  @Override
  public boolean expireCache(long maxSerial) {
    getCache().expire(maxSerial);
    return true;
  }

  @Override
  public UserGroup selectCachedOnly(long id) {
    return getCache().select(getDomainContext(), id, false);
  }

  @Override
  public UserGroup selectCached(long id) {
    return getCache().select(getDomainContext(), id);
  }

  @Override
  public List<UserGroup> selectAllCached() {
    return getCache().selectAll(getDomainContext());
  }

  //</editor-fold>//GEN-END:cache


}
