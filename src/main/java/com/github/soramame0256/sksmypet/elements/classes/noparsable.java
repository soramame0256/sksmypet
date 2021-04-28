package com.github.soramame0256.sksmypet.elements.classes;

import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;

public class noparsable<T> extends Parser<T> {
    @Override
    public boolean canParse(ParseContext context) {
        return false;
    }

    @Override
    public T parse(String s, ParseContext context) {
        return null;
    }

    @Override
    public String toString(T o, int flags) {
        return o.toString();
    }

    @Override
    public String toVariableNameString(T o) {
        return o.toString();
    }

    @Override
    public String getVariableNamePattern() {
        return ".*";
    }
}
