package org.iqkv.boutique.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class CustomerDetailsSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("gender", table, columnPrefix + "_gender"));
        columns.add(Column.aliased("phone", table, columnPrefix + "_phone"));
        columns.add(Column.aliased("address_line_1", table, columnPrefix + "_address_line_1"));
        columns.add(Column.aliased("address_line_2", table, columnPrefix + "_address_line_2"));
        columns.add(Column.aliased("city", table, columnPrefix + "_city"));
        columns.add(Column.aliased("country", table, columnPrefix + "_country"));

        return columns;
    }
}
