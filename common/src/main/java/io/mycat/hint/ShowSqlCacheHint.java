package io.mycat.hint;

import java.text.MessageFormat;

public class ShowSqlCacheHint extends HintBuilder {

    @Override
    public String getCmd() {
        return "showSqlCaches";
    }

    @Override
    public String build() {
        return MessageFormat.format("/*+ mycat:{0}{1} */;",
                getCmd(),
                "");
    }

    public static String create() {
        ShowSqlCacheHint createSqlCacheHint = new ShowSqlCacheHint();
        return createSqlCacheHint.build();
    }
}