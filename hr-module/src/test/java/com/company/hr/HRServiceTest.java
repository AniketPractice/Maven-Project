package com.company.hr;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HRServiceTest {

    private HRService hrService;

    @Before
    public void setUp() {

        hrService = new HRService();
    }
    @Test
    public void testOnboardEmployee_NullEmployeeName() {

        boolean result = hrService.onboardEmployee(null, "HR");
        assertFalse(result);
    }

    @Test
    public void testOnboardEmployee_EmptyEmployeeName() {

        boolean result = hrService.onboardEmployee("", "HR");
        assertFalse(result);
    }

}
