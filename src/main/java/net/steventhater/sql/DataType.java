package net.steventhater.sql;

/**
 * Created by Steven Thater on 1/27/2017.
 */
public class DataType<T> {

    // SQL qualified name
    private final String typeName;
    // Default value
    private final T def;

    public DataType(String typeName) {
        this(typeName, null);
    }

    /**
     * Create a DataType with a qualified SQL type name and optionally a default value.
     *
     * @param typeName qualified name in database software
     * @param def      default value, leave null for no default
     */
    public DataType(String typeName, T def) {
        this.typeName = typeName;
        this.def = def;
    }

    public final String getTypeName() {
        return typeName;
    }

    public final T getDefault() {
        return def;
    }

    public Object serializedDefault() {
        if (def == null) {
            return "";
        }

        return serialize(def);
    }

    @SuppressWarnings("unchecked")
    public T deserialize(Object value) {
        return (T) value;
    }

    public Object serialize(T value) {
        return value;
    }

    /**
     * Returns an identical DataType with the exception of having the default value specified. Serialization and
     * deserialization will occur in the same way.
     *
     * @param def default value
     * @return A new DataType with changed default
     */
    public final DataType<T> withDefault(T def) {
        if (def == null) return this;
        final DataType<T> result = this;
        return new DataType<T>(typeName, def) {
            @Override
            public T deserialize(Object value) {
                return result.deserialize(value);
            }

            @Override
            public Object serialize(T value) {
                return result.serialize(value);
            }
        };
    }

}
