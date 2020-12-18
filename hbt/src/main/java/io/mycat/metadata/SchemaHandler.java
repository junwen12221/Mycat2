package io.mycat.metadata;

import io.mycat.TableHandler;
import io.mycat.util.NameMap;

import java.util.Map;

public interface SchemaHandler {
    String getName();

    NameMap<TableHandler> logicTables();

    String defaultTargetName();
}