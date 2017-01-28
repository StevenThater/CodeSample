package net.steventhater.sql;

/**
 * Created by Steven Thater on 1/27/2017.
 */
public class Column<T> {

    // Name of the column
    private final String name;
    // Data type
    private final DataType<T> dataType;

    public Column(String name, DataType<T> dataType) {
        this(name, dataType, null);
    }

    /**
     * Creates a Column with a name, sql data type and optional default. Leave def null for no default.
     * @param name Name of the column
     * @param dataType The type of data the column will store
     * @param def The default value to fill the column with
     */
    public Column(String name, DataType<T> dataType, T def) {
        this.name = name;
        this.dataType = dataType.withDefault(def);
    }

    public String getName() {
        return this.name;
    }

    public DataType<T> getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        return getName();
    }
}
