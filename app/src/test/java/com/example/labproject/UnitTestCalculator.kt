package com.example.labproject

import org.junit.Test
import com.example.labproject.ui.Calculate
import org.junit.Assert.*


class UnitTestCalculator {
    @Test
    fun addition_isCorrect() {
        assertEquals("5.0", Calculate(2.0, 3.0, '+'))
        assertEquals("-5.0", Calculate(-2.0, -3.0, '+'))
        assertEquals("1.11", Calculate(0.11, 1.0, '+'))
        assertEquals("4567.123", Calculate(4000.100, 567.023, '+'))
        assertEquals("8.877", Calculate(1.1, 7.777, '+'))
        assertEquals("457937.0", Calculate(402380.0, 55557.0, '+'))
    }

    @Test
    fun subtraction_isCorrect() {
        assertEquals("-1.0", Calculate(2.0, 3.0, '-'))
        assertEquals("1.0", Calculate(-2.0, -3.0, '-'))
        assertEquals("-7.123456789", Calculate(-0.0, 7.123456789, '-'))
        assertEquals("10.5", Calculate(21.0, 10.5, '-'))
        assertEquals("65.57", Calculate(70.1, 4.53, '-'))
        assertEquals("-671.1", Calculate(-600.0, 71.1, '-'))
    }

    @Test
    fun multiplication_isCorrect() {
        assertEquals("6.0", Calculate(2.0, 3.0, '*'))
        assertEquals("6.0", Calculate(-2.0, -3.0, '*'))
        assertEquals("5.2", Calculate(2.6, 2.0, '*'))
        assertEquals("1671.84", Calculate(51.6, 32.4, '*'))
        assertEquals("-5246.922274", Calculate(-585.398, 8.963, '*'))
        assertEquals("0.0", Calculate(-657487589.0, 0.0, '*'))
    }

    @Test
    fun division_isCorrect() {
        assertEquals("1.5", Calculate(3.0, 2.0, '/'))
        assertEquals("113383.625", Calculate(226767.25, 2.0, '/'))
        assertEquals("100.0", Calculate(200.00, 2.0, '/'))
        assertEquals("9.2", Calculate(41.676, 4.53, '/'))
        assertEquals("6.0", Calculate(-2116.14, -352.69, '/'))
        assertEquals("100.0", Calculate(10.0, 0.1, '/'))
    }

    @Test
    fun with_negative_isCorrect() {
        assertEquals("-1.0", Calculate(-3.0, 2.0, '+'))
        assertEquals("1.0", Calculate(3.0, -2.0, '+'))
        assertEquals("-5.0", Calculate(-3.0, -2.0, '+'))
        assertEquals("6.0", Calculate(3.0, -3.0, '-'))
        assertEquals("-6.0", Calculate(-3.0, 3.0, '-'))
        assertEquals("0.0", Calculate(-3.0, -3.0, '-'))
        assertEquals("-1.5", Calculate(-3.0, 2.0, '/'))
        assertEquals("-1.5", Calculate(3.0, -2.0, '/'))
        assertEquals("1.5", Calculate(-3.0, -2.0, '/'))
        assertEquals("-6.0", Calculate(-3.0, 2.0, '*'))
        assertEquals("-6.0", Calculate(3.0, -2.0, '*'))
        assertEquals("6.0", Calculate(-3.0, -2.0, '*'))
    }

    @Test
    fun argument_pos_isCorrect() {
        assertEquals("0.0", Calculate(5.0, -5.0, '+'))
        assertEquals("0.0", Calculate(-5.0, 5.0, '+'))
        assertEquals("10.0", Calculate(5.0, -5.0, '-'))
        assertEquals("-10.0", Calculate(-5.0, 5.0, '-'))
        assertEquals("-25.0", Calculate(-5.0, 5.0, '*'))
        assertEquals("-25.0", Calculate(5.0, -5.0, '*'))
        assertEquals("-1.0", Calculate(5.0, -5.0, '/'))
        assertEquals("-1.0", Calculate(-5.0, 5.0, '/'))
    }


}