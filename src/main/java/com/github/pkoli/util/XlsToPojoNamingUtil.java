package com.github.pkoli.util;

import com.google.common.base.CaseFormat;

/**
 * Created by pkoli on 16/7/17.
 */
public class XlsToPojoNamingUtil {

    public String applyClassNamingConvention(String className) {

        className = className.replace(" ", "");
        className = className.toUpperCase().substring(0, 1) +
                className.toLowerCase().substring(1, className.length());
        return className;
    }

    public String applyIdentifierNamingConvention(String identifier) {

        if (!identifier.contains(" ")) {
            if (Character.isUpperCase(identifier.charAt(identifier.length() - 1)) &&
                    Character.isUpperCase(identifier.charAt(0))) {
                identifier = identifier.toLowerCase();
            } else {
                for (int i = 0; i < identifier.length() - 1; i++) {
                    if (Character.isUpperCase(identifier.charAt(i)) &&
                            Character.isUpperCase(identifier.charAt(i + 1))) {
                        identifier = new StringBuilder(identifier).
                                insert(i, identifier.toLowerCase().charAt(i)).toString();
                    }
                }
            }
        } else {
            identifier = identifier.trim().toLowerCase().replace(" ",
                    "_");
            if (identifier.contains("_")) {
                identifier = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, identifier);
            }
        }
        return identifier;
    }
}
