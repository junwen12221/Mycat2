package cn.lightfish.sql.persistent.impl;

import cn.lightfish.sql.ast.expr.booleanExpr.BooleanExpr;
import cn.lightfish.sql.persistent.*;
import cn.lightfish.sql.schema.MycatTable;
import cn.lightfish.sql.schema.TableColumnDefinition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DefaultPersistentImpl implements Persistent {


  final List<Object[]> rows = new ArrayList<>();
  private MycatTable table;

  public DefaultPersistentImpl(MycatTable table) {
    this.table = table;
  }

  @Override
  public InsertPersistent createInsertPersistent(TableColumnDefinition[] columnNameList,
      Map<String, Object> persistentAttributes) {
    return new InsertPersistent(table,rows);
  }

  @Override
  public QueryPersistent createQueryPersistent(TableColumnDefinition[] columnNameList,
      Map<String, Object> persistentAttributes) {
    return new QueryPersistentImpl(table,rows.iterator());
  }

  @Override
  public UpdatePersistent createUpdatePersistent(TableColumnDefinition[] columnNameList, Map<String, Object> persistentAttributes) {
    return new UpdatePersistent(table,rows.iterator());
  }
}