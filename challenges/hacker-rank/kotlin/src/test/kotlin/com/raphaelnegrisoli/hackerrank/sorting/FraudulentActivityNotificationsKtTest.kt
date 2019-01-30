package com.raphaelnegrisoli.hackerrank.sorting

import org.junit.Test

import org.junit.Assert.*

class FraudulentActivityNotificationsKtTest {

    /**
     * median should be [2 + 3]
     */
    @Test
    fun `test count more than one for first median element`() {

        assertEquals(0,
            fraudulentActivity(listOf(1, 2, 1, 3, 4, 5, 5, 8, 2, 1, 4), 10)
        )
        assertEquals(1,
            fraudulentActivity(listOf(1, 2, 1, 3, 4, 5, 5, 8, 2, 1, 5), 10)
        )
    }

    /**
     * median should be [2 + 2]
     */
    @Test
    fun `test equal first and second median element `() {

        assertEquals(0,
            fraudulentActivity(listOf(1, 2, 1, 3, 3, 2, 5, 8, 2, 1, 3), 10)
        )
        assertEquals(1,
            fraudulentActivity(listOf(1, 2, 1, 3, 3, 2, 5, 8, 2, 1, 4), 10)
        )
    }

    @Test
    fun `test odd days`() {

        assertEquals(1, fraudulentActivity(listOf(10, 20, 30, 40, 50), 3))
    }
}