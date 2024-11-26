package com.company.it;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ITServiceTest {

    private ITService itService;

    @Before
    public void setUp() {
        itService = new ITService();
    }

    @Test
    public void testGiveAccess_NullEmployeeName() {

        boolean result = itService.giveAccess(null);
        assertFalse(result);
    }

    @Test
    public void testGiveAccess_EmptyEmployeeName() {

        boolean result = itService.giveAccess("");
        assertFalse(result);
    }

    @Test
    public void testGiveAccess_WhitespaceEmployeeName() {

        boolean result = itService.giveAccess("   ");
        assertFalse(result);
    }
}
