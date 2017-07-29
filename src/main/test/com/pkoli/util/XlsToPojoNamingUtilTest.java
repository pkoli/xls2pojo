package com.pkoli.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pkoli on 16/7/17.
 */
public class XlsToPojoNamingUtilTest {

    private XlsToPojoNamingUtil util;

    @Before
    public void init() {
        util = new XlsToPojoNamingUtil();
    }

    @Test
    public void testClassNamingConventionWithAllSmallAlphabets() {
        assertEquals("Abc", util.applyClassNamingConvention("abc"));
    }

    @Test
    public void testClassNamingConventionWithSpaceSeparatedAlphabets() {
        assertEquals("Abc", util.applyClassNamingConvention("a b c"));
    }

    @Test
    public void testClassNamingConventionWithAllCapitalAlphabets() {
        assertEquals("Abc", util.applyClassNamingConvention("ABC"));
    }

    @Test
    public void testIdentifierNamingConventionWithAllSmallAlphabets() {
        assertEquals("abc", util.applyIdentifierNamingConvention("abc"));
    }

    @Test
    public void testIdentifierNamingConventionWithSpaceSeparatedAlphabets() {
        assertEquals("ABC", util.applyIdentifierNamingConvention("a b c"));
    }

    @Test
    public void testIdentifierNamingConventionWithAllCapitalAlphabets() {
        assertEquals("abc", util.applyIdentifierNamingConvention("ABC"));
    }


}