/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.persist.md;

import org.foodpanda.pdo.md.OrgUnit;
import org.foodpanda.pdo.md.User;
import org.foodpanda.pdo.md.UserGroup;
import org.foodpanda.pdo.md.persist.OrgUnitPersistence;
import org.foodpanda.pdo.td.Message;
import org.foodpanda.persist.AbstractPersistentMasterData;
import org.foodpanda.persist.md.rmi.OrgUnitRemoteDelegate;

import org.tentackle.common.StringHelper;
import org.tentackle.dbms.DbModificationType;
import org.tentackle.dbms.DbObjectClassVariables;
import org.tentackle.dbms.PreparedStatementWrapper;
import org.tentackle.dbms.ResultSetWrapper;
import org.tentackle.dbms.StatementId;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;
import org.tentackle.pdo.PersistentObjectService;
import org.tentackle.persist.AbstractPersistentObject;
import org.tentackle.persist.PersistentObjectClassVariables;
import org.tentackle.session.PersistenceException;
import org.tentackle.session.Session;
import org.tentackle.sql.Backend;
import org.tentackle.sql.JoinType;

import java.io.Serial;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Persistence implementation for OrgUnit.
 *
 * @param <T> the PDO class (interface)
 * @param <P> the persistence implementation class
 */
@PersistentObjectService(OrgUnit.class)
public class OrgUnitPersistenceImpl<T extends OrgUnit<T>, P extends OrgUnitPersistenceImpl<T, P>>
        extends AbstractPersistentMasterData<T, P> implements OrgUnitPersistence<T> {

  @Serial
  private static final long serialVersionUID = 1L;

  // @wurblet classVariables ClassVariables

  //<editor-fold defaultstate="collapsed" desc="code 'classVariables' generated by wurblet ClassVariables">//GEN-BEGIN:classVariables

  /** Variables common to all instances of OrgUnitPersistenceImpl. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static final PersistentObjectClassVariables CLASSVARIABLES =
            PersistentObjectClassVariables.create(
                    OrgUnit.class,
                    OrgUnitPersistenceImpl.class,
                    "ou",
                    null,
                    null);

  @Override
  @SuppressWarnings("unchecked")
  public PersistentObjectClassVariables<T,P> getClassVariables() {
    return CLASSVARIABLES;
  }

  //</editor-fold>//GEN-END:classVariables


  // @wurblet columnNames ColumnNames

  //<editor-fold defaultstate="collapsed" desc="code 'columnNames' generated by wurblet ColumnNames">//GEN-BEGIN:columnNames


  /** database column name for 'name'. */
  public static final String CN_NAME = "name";

  /** database column name for 'comment'. */
  public static final String CN_COMMENT = "ocomment";

  //</editor-fold>//GEN-END:columnNames


  // @wurblet declare Declare

  //<editor-fold defaultstate="collapsed" desc="code 'declare' generated by wurblet Declare">//GEN-BEGIN:declare


  /** short name. */
  private String name;

  /** optional comment. */
  private String comment;

  //</editor-fold>//GEN-END:declare


  //<editor-fold defaultstate="collapsed" desc="constructors">

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   * @param context the domain context
   */
  public OrgUnitPersistenceImpl(T pdo, DomainContext context) {
    super(pdo, context);
  }

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   * @param session the session
   */
  public OrgUnitPersistenceImpl(T pdo, Session session) {
    super(pdo, session);
  }

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   */
  public OrgUnitPersistenceImpl(T pdo) {
    super(pdo);
  }

  /**
   * Creates a persistent object.
   */
  public OrgUnitPersistenceImpl() {
    super();
  }

  //</editor-fold>

  // @wurblet methods MethodsImpl

  //<editor-fold defaultstate="collapsed" desc="code 'methods' generated by wurblet MethodsImpl">//GEN-BEGIN:methods


  @Override
  public OrgUnitRemoteDelegate<T,P> getRemoteDelegate() {
    return (OrgUnitRemoteDelegate<T,P>) super.getRemoteDelegate();
  }

  @Override
  public boolean isExplicitIdAliasRequiredInJoins() {
    return true;
  }

  @Override
  public boolean isRootEntity() {
    return true;
  }

  @Override
  public boolean isNormTextProvided() {
    return true;
  }

  @Override
  public boolean isTracked() {
    return true;    // invoking isModified() is ok
  }

  @Override
  public String orderBy() {
    StringBuilder sql = new StringBuilder();
    sql.append(OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(CN_NAME)).append(Backend.SQL_SORTASC);
    return sql.toString();
  }

  @Override
  public void getFields(ResultSetWrapper rs) {
    super.getFields(rs);
    if (rs.configureSection(CLASSVARIABLES)) {
      rs.configureColumn(CN_NORMTEXT);
      rs.configureColumn(CN_CLASSID);
      rs.configureColumn(CN_NAME);
      rs.configureColumn(CN_COMMENT);
      rs.configureColumn(CN_ID);
      rs.configureColumn(CN_SERIAL);
    }
    if (rs.getRow() <= 0) {
      throw new PersistenceException(getSession(), "no valid row");
    }
    setNormText(rs.getString());
    setClassId(rs.getInt());
    name = rs.getString();
    comment = rs.getString();
    setId(rs.getLong());
    setSerial(rs.getLong());
  }

  /**
   * Sets the values of all OrgUnit-columns in the given statement.
   *
   * @param st the prepared statement
   * @return the number of columns set
   */
  public int setFieldsOrgUnit(PreparedStatementWrapper st) {
    int ndx = 0;
    st.setString(++ndx, getNormText());
    st.setInt(++ndx, getClassId());
    st.setString(++ndx, name);
    st.setString(++ndx, comment);
    st.setLong(++ndx, getId());
    st.setLong(++ndx, getSerial());
    return ndx;
  }

  /**
   * Creates the SQL code for the OrgUnit insert statement.
   *
   * @return the SQL code
   */
  public String createInsertSqlOrgUnit() {
    return Backend.SQL_INSERT_INTO + CLASSVARIABLES.getTableName() + Backend.SQL_LEFT_PARENTHESIS +
           CN_NORMTEXT + Backend.SQL_COMMA +
           CN_CLASSID + Backend.SQL_COMMA +
           CN_NAME + Backend.SQL_COMMA +
           CN_COMMENT + Backend.SQL_COMMA +
           CN_ID + Backend.SQL_COMMA +
           CN_SERIAL +
           Backend.SQL_INSERT_VALUES +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR + Backend.SQL_RIGHT_PARENTHESIS;
  }

  /**
   * Creates the SQL code for the OrgUnit update statement.
   *
   * @return the SQL code
   */
  public String createUpdateSqlOrgUnit() {
    return Backend.SQL_UPDATE + CLASSVARIABLES.getTableName() + Backend.SQL_SET +
           CN_NORMTEXT + Backend.SQL_EQUAL_PAR_COMMA +
           CN_CLASSID + Backend.SQL_EQUAL_PAR_COMMA +
           CN_NAME + Backend.SQL_EQUAL_PAR_COMMA +
           CN_COMMENT + Backend.SQL_EQUAL_PAR_COMMA +
           CN_SERIAL + Backend.SQL_EQUAL + CN_SERIAL + Backend.SQL_PLUS_ONE +
           Backend.SQL_WHERE + CN_ID + Backend.SQL_EQUAL_PAR +
           Backend.SQL_AND + CN_SERIAL + Backend.SQL_EQUAL_PAR;
  }

  /**
   * Creates the SQL code for the OrgUnit delete statement.
   *
   * @return the sql code
   */
  public String createDeleteSqlOrgUnit() {
    return Backend.SQL_DELETE + Backend.SQL_FROM + CLASSVARIABLES.getTableName() +
           Backend.SQL_WHERE + CN_ID + Backend.SQL_EQUAL_PAR +
           Backend.SQL_AND + CN_SERIAL + Backend.SQL_EQUAL_PAR;
  }

  @Override
  public StringBuilder createSelectAllInnerSql() {
    StringBuilder sql = new StringBuilder();
    sql.append(OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(Backend.SQL_ALLSTAR));
    sql.append(Backend.SQL_COMMA).append(UserPersistenceImpl.CLASSVARIABLES.getColumnName(Backend.SQL_ALLSTAR));
    sql.append(Backend.SQL_COMMA).append(UserGroupPersistenceImpl.CLASSVARIABLES.getColumnName(Backend.SQL_ALLSTAR));
    sql.append(Backend.SQL_FROM);
    sql.append(OrgUnitPersistenceImpl.CLASSVARIABLES.getTableName()).
        append(getBackend().sqlAsBeforeTableAlias()).append(OrgUnitPersistenceImpl.CLASSVARIABLES.getTableAlias());
    sql.append(getBackend().sqlJoin(JoinType.LEFT,
               UserPersistenceImpl.CLASSVARIABLES.getTableName(), UserPersistenceImpl.CLASSVARIABLES.getTableAlias(),
               OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(CN_ID) + Backend.SQL_EQUAL +
               UserPersistenceImpl.CLASSVARIABLES.getColumnName(CN_ID)));
    sql.append(getBackend().sqlJoin(JoinType.LEFT,
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
  protected void updateImpl(DbObjectClassVariables<P> classVariables, Supplier<String> sqlsupplier) {
    PreparedStatementWrapper st = getBatchablePreparedStatement(DbModificationType.UPDATE, CLASSVARIABLES.updateStatementId, this::createUpdateSqlOrgUnit);
    setFieldsOrgUnit(st);
    assertThisRowAffected(st.executeUpdate());
  }

  @Override
  protected void insertImpl(DbObjectClassVariables<P> classVariables, Supplier<String> sqlsupplier) {
    PreparedStatementWrapper st = getBatchablePreparedStatement(DbModificationType.INSERT, CLASSVARIABLES.insertStatementId, this::createInsertSqlOrgUnit);
    setFieldsOrgUnit(st);
    assertThisRowAffected(st.executeUpdate());
  }

  @Override
  protected void deleteImpl(DbObjectClassVariables<P> classVariables, Supplier<String> sqlsupplier) {
    PreparedStatementWrapper st = getBatchablePreparedStatement(DbModificationType.DELETE, CLASSVARIABLES.deleteStatementId, this::createDeleteSqlOrgUnit);
    st.setLong(1, getId());
    st.setLong(2, getSerial());
    assertThisRowAffected(st.executeUpdate());
  }

  @Override
  public String getName()    {
    return name;
  }

  @Override
  public void setName(String name) {
    assertMutable();
    if (!Objects.equals(this.name, name)) {
      setModified(true);
    }
    this.name = name;
  }

  @Override
  public String getComment()    {
    return comment;
  }

  @Override
  public void setComment(String comment) {
    assertMutable();
    if (!Objects.equals(this.comment, comment)) {
      setModified(true);
    }
    this.comment = comment;
  }

  /**
   * Copies all attributes from a snapshot back to this object.
   *
   * @param snapshot the snapshot object
   */
  protected void revertAttributesToSnapshot(OrgUnitPersistenceImpl<T,?> snapshot) {
    super.revertAttributesToSnapshot(snapshot);
    name = snapshot.name;
    comment = snapshot.comment;
  }

  @Override
  public StringBuilder createAttributesNormText() {
    StringBuilder buf = super.createAttributesNormText();
    if (buf == null) {
      buf = new StringBuilder();
    }
    buf.append(getName()).append(',');
    buf.append(getComment()).append(',');
    return buf;
  }

  // selects by unique domain key
  // @wurblet selectByUniqueDomainKey PdoSelectUnique name

  //</editor-fold>//GEN-END:methods

  //<editor-fold defaultstate="collapsed" desc="code 'selectByUniqueDomainKey' generated by wurblet PdoSelectUnique/MethodsImpl">//GEN-BEGIN:selectByUniqueDomainKey


  private static final StatementId SELECT_BY_UNIQUE_DOMAIN_KEY_STMT = new StatementId();

  @Override
  public T selectByUniqueDomainKey(String name) {
    if (getSession().isRemote())  {
      try {
        T obj = getRemoteDelegate().selectByUniqueDomainKey(getDomainContext(), name);
        configureRemoteObject(getDomainContext(), obj);
        return obj;
      }
      catch (RemoteException e) {
        throw PersistenceException.createFromRemoteException(this, e);
      }
    }
    PreparedStatementWrapper st = getPreparedStatement(SELECT_BY_UNIQUE_DOMAIN_KEY_STMT,
      () -> {
        StringBuilder sql = createSelectAllInnerSql();
        sql.append(Backend.SQL_AND);
        sql.append(OrgUnitPersistenceImpl.CLASSVARIABLES.getColumnName(CN_NAME));
        sql.append(Backend.SQL_EQUAL_PAR);
        getBackend().buildSelectSql(sql, false, 0, 0);
        return sql.toString();
      }
    );
    int ndx = 1;
    st.setString(ndx, name);
    return executeFirstPdoQuery(st);
  }

  //</editor-fold>//GEN-END:selectByUniqueDomainKey


  // @wurblet relations PdoRelations

  //<editor-fold defaultstate="collapsed" desc="code 'relations' generated by wurblet PdoRelations">//GEN-BEGIN:relations


  // add referencing classes and their methods
  static {
    @SuppressWarnings("unchecked")
    AbstractPersistentObject<?,?> po = (AbstractPersistentObject<?,?>)
        Pdo.create(OrgUnit.class).getPersistenceDelegate();
    po.addReferencingClass(Message.class, "isReferencingOrgUnitByOrgUnitId");
  }

  //</editor-fold>//GEN-END:relations


  // @wurblet cache PdoCache --preload

  //<editor-fold defaultstate="collapsed" desc="code 'cache' generated by wurblet PdoCache">//GEN-BEGIN:cache


  @Override
  @SuppressWarnings("unchecked")
  public T selectCached(long id) {
    T pdo = (T) Pdo.create(User.class, getDomainContext()).selectCached(id);
    if (pdo == null) {
      pdo = (T) Pdo.create(UserGroup.class, getDomainContext()).selectCached(id);
    }
    return pdo;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T selectCachedOnly(long id) {
    T pdo = (T) Pdo.create(User.class, getDomainContext()).selectCachedOnly(id);
    if (pdo == null) {
      pdo = (T) Pdo.create(UserGroup.class, getDomainContext()).selectCachedOnly(id);
    }
    return pdo;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> selectAllCached() {
    List<T> pdos = new ArrayList<>();
    pdos.addAll((Collection<? extends T>) Pdo.create(User.class, getDomainContext()).selectAllCached());
    pdos.addAll((Collection<? extends T>) Pdo.create(UserGroup.class, getDomainContext()).selectAllCached());
    return pdos;
  }

  //</editor-fold>//GEN-END:cache


  @Override
  public String getShortText() {
    return getName();
  }

  @Override
  public String getLongText() {
    return StringHelper.firstLine(getComment());
  }
}
