package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;


    @BeforeEach
    public void setUp() {
        Validator validator = new ArithmeticExpressionValidator();
        calculator = new Calculator(validator);
    }

    @Test
    public void two_plus_two_equals_four(){
        assertEquals(4, calculator.calculate("2+2"));
    }

    @Test
    public void forty_minus_twenty_equals_twenty(){
        assertEquals(20, calculator.calculate("40-20"));
    }

    @Test
    public void two_times_thirty_equals_sixty(){
        assertEquals(60, calculator.calculate("2*30"));
    }

    @Test
    public void six_divided_by_three_equals_two(){
        assertEquals(2, calculator.calculate("6/3"));
    }

    @Test
    public void space_returns_zero(){
        assertEquals(0, calculator.calculate(" "));
    }

    @Test
    public void multiple_spaces_return_zero(){
        assertEquals(0, calculator.calculate("           "));
    }

    @Test
    public void special_chars_return_zero(){
        assertEquals(0, calculator.calculate("!@#$"));
    }

    @Test
    public void more_special_chars_return_zero(){
        assertEquals(0, calculator.calculate("!@#$&*()^"));
    }

    @Test
    public void large_numbers_sum_correctly() {
        assertEquals(3000000, calculator.calculate("1000000+2000000"));
    }

    @Test
    public void large_numbers_subtract_correctly() {
        assertEquals(1111111, calculator.calculate("9999999-8888888"));
    }

    @Test
    public void division_by_zero_returns_zero() {
        assertEquals(0, calculator.calculate("10/0"));
    }

    @Test
    public void whitespace_around_numbers_is_ignored() {
        assertEquals(6, calculator.calculate("  2  *  3  "));
    }

    @Test
    public void multiple_spaces_between_operators_is_handled() {
        assertEquals(9, calculator.calculate("4    +     5"));
    }

    @Test
    public void mixed_numbers_and_special_characters_return_zero() {
        assertEquals(0, calculator.calculate("2a+3b"));
    }

    @Test
    public void unsupported_operator_returns_zero() {
        assertEquals(0, calculator.calculate("5^2")); // Assuming exponentiation is unsupported
    }

    @Test
    public void zero_input_returns_valid_results() {
        assertEquals(0, calculator.calculate("0+0"));
        assertEquals(-5, calculator.calculate("0-5"));
    }

    @Test
    public void input_with_newlines_returns_zero() {
        assertEquals(5, calculator.calculate("2\n+\n3"));
    }

    @Test
    public void empty_string_returns_zero() {
        assertEquals(0, calculator.calculate(""));
    }
}
