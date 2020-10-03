package ir.safari.show.utils;

import java.util.Collection;

public class CollectionUtils {
    public static boolean isNotEmpty(final Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    public static boolean isNullOrEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

}
