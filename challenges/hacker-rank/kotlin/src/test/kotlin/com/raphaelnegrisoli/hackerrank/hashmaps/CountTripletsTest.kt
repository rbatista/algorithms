package com.raphaelnegrisoli.hackerrank.hashmaps

import org.junit.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class CountTripletsTest {

    @Test
    fun `test if i less then j less then k`() {

        assertEquals(countTriplets(listOf(1, 2, 1, 2, 4), 2), BigInteger("3"))
    }

    @Test
    fun `test if k greater than j`() {

        assertEquals(countTriplets(listOf(1, 2, 4, 1, 2), 2), BigInteger("1"))
    }

    @Test
    fun `test ratio 1`() {

        assertEquals(countTriplets(listOf(1, 1, 1, 1, 1), 1), BigInteger("10"))
    }

    @Test
    fun `test int division`() {

        assertEquals(countTriplets(listOf(1, 5, 15, 45), 3), BigInteger("1"))
    }

}