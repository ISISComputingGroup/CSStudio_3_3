/**
 * Copyright (C) 2010-14 pvmanager developers. See COPYRIGHT.TXT
 * All rights reserved. Use is subject to license terms. See LICENSE.TXT
 */
package org.epics.pvmanager.util;

import java.util.Collection;

/**
 * Utility class to handle null values.
 *
 * @author carcassi
 */
public class NullUtils {

    /**
     * Returns true if both objects are null or they are equal.
     *
     * @param obj1 first object
     * @param obj2 second object
     * @return true if equals or both are null
     * @deprecated use Java7 method java.util.Objects.equals
     */
    @Deprecated
    public static boolean equalsOrBothNull(Object obj1, Object obj2) {
        if (obj1 == null)
            return obj2 == null;
        else
            return obj1.equals(obj2);
    }
    
    /**
     * Checks whether the collection contains a null value.
     * 
     * @param args a collection; can't be null
     * @return true if one of the value is null
     */
    public static boolean containsNull(Collection<Object> args) {
        for (Object object : args) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }
}
