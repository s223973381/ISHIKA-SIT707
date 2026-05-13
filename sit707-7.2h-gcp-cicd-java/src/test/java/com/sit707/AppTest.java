package com.sit707;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testAdd() {
        assertEquals(5, App.add(2, 3));
    }

    @Test
    public void testTaskStatusFailing() {
        assertEquals("D", App.getTaskStatus(85));
    }
}