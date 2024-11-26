package com.company.finance;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinanceServiceTest {

    private FinanceService financeService;

    @Before
    public void setUp() {

        financeService = new FinanceService();
    }

    @Test
    public void testProcessPayroll_NullEmployee() {

        boolean result = financeService.processPayroll(null, 5000.0);
        assertFalse(result);

    }

}
