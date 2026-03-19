import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    private HelloWorld helloWorld;

    @BeforeEach
    void setUp() {
        helloWorld = new HelloWorld();
    }

    // --- Happy paths ---

    @Test
    void greetings_returnsFormattedGreeting() {
        String result = helloWorld.greetings("John", "Doe");
        assertEquals("Hello John Doe", result);
    }

    @Test
    void greetings_includesFirstNameAndLastName() {
        String result = helloWorld.greetings("Jane", "Smith");
        assertTrue(result.contains("Jane"));
        assertTrue(result.contains("Smith"));
    }

    @Test
    void greetings_startsWithHello() {
        String result = helloWorld.greetings("Alice", "Brown");
        assertTrue(result.startsWith("Hello "));
    }

    @Test
    void greetings_firstNameAndLastNameSeparatedBySpace() {
        String result = helloWorld.greetings("Bob", "Jones");
        // "Hello Bob Jones" — names must be separated by a space
        assertEquals("Hello Bob Jones", result);
    }

    // --- Edge cases ---

    @Test
    void greetings_emptyFirstName() {
        String result = helloWorld.greetings("", "Doe");
        assertEquals("Hello  Doe", result);
    }

    @Test
    void greetings_emptyLastName() {
        String result = helloWorld.greetings("John", "");
        assertEquals("Hello John ", result);
    }

    @Test
    void greetings_bothNamesEmpty() {
        String result = helloWorld.greetings("", "");
        assertEquals("Hello  ", result);
    }

    @Test
    void greetings_singleCharacterNames() {
        String result = helloWorld.greetings("A", "B");
        assertEquals("Hello A B", result);
    }

    @Test
    void greetings_namesWithInternalSpaces() {
        String result = helloWorld.greetings("Mary Jane", "Watson");
        assertEquals("Hello Mary Jane Watson", result);
    }

    @Test
    void greetings_numericStrings() {
        String result = helloWorld.greetings("123", "456");
        assertEquals("Hello 123 456", result);
    }

    @Test
    void greetings_specialCharacters() {
        String result = helloWorld.greetings("O'Brien", "St. Claire");
        assertEquals("Hello O'Brien St. Claire", result);
    }

    @Test
    void greetings_unicodeNames() {
        String result = helloWorld.greetings("José", "García");
        assertEquals("Hello José García", result);
    }

    // --- Error / null states ---

    @Test
    void greetings_nullFirstName_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> helloWorld.greetings(null, "Doe"));
    }

    @Test
    void greetings_nullLastName_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> helloWorld.greetings("John", null));
    }

    @Test
    void greetings_bothNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> helloWorld.greetings(null, null));
    }
}
