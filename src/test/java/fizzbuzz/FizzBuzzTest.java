package fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void number1shouldReturn1() {
        assertEquals("1", FizzBuzz.fizzbuzz(1));
    }

    @Test
    void number2shouldReturn2() {
        assertEquals("2", FizzBuzz.fizzbuzz(2));
    }

    @Test
    void number3shouldReturnFizz() {
        assertEquals("Fizz", FizzBuzz.fizzbuzz(3));
    }

    @Test
    void number6shouldReturnFizz() {
        assertEquals("Fizz", FizzBuzz.fizzbuzz(6));
    }

    @Test
    void number5shouldReturnBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzbuzz(5));
    }

    @Test
    void number15shouldReturnFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzbuzz(15));
    }

}