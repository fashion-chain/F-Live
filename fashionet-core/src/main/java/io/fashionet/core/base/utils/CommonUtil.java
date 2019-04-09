package io.fashionet.core.base.utils;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

public class CommonUtil {

    public static void print(String... messages) {
        for (String message: messages) {
            System.out.print(message);
        }
    }

    public static void println(String... messages) {
        for (String message: messages) {
            System.out.println(message);
        }
    }

    public static String getClassName(Class<?> clazz) {
        return clazz.getName();
    }

    public static String getTableName(EntityManager em, Class<?> entityClass) {
        /*
         * Check if the specified class is present in the metamodel.
         * Throws IllegalArgumentException if not.
         */
        Metamodel meta = em.getMetamodel();
        EntityType<?> entityType = meta.entity(entityClass);

        //Check whether @Table annotation is present on the class.
        Table t = entityClass.getAnnotation(Table.class);

        String tableName = (t == null)
                ? entityType.getName()
                : t.name();
        return tableName;
    }

    public static String printStackTraceElements(StackTraceElement[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement element: elements) {
            stringBuilder.append(element.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
