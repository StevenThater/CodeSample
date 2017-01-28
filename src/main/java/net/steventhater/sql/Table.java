package net.steventhater.sql;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Thater on 1/27/2017.
 */
public class Table {

    // Table name
    private final String name;
    // Columns
    private final List<Column<?>> columnList;

    public Table(String name, List<Column<?>> columnList) {
        if (columnList.size() == 0) {
            throw new IllegalArgumentException("Column list must contain at least one column.");
        }

        this.name = name;
        this.columnList = columnList;
    }

    public String getName() {
        return this.name;
    }

    public List<Column<?>> getColumnList() {
        return Collections.unmodifiableList(columnList);
    }

    @Override
    public String toString() {
        return getName();
    }

    public List<String> columnToNameTypeList() {
        return columnList.stream()
                .map(c -> c + " " + c.getDataType().getTypeName())
                .collect(Collectors.toList());
    }
}
