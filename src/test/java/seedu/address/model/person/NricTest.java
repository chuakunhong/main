package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class NricTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Nric(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidNric = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Nric(invalidNric));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        Assert.assertThrows(NullPointerException.class, () -> Nric.isValidNric(null));

        // invalid phone numbers
        assertFalse(Nric.isValidNric("")); // empty string
        assertFalse(Nric.isValidNric(" ")); // spaces only
        assertFalse(Nric.isValidNric("91")); // less than 3 numbers
        assertFalse(Nric.isValidNric("phone")); // non-numeric
        assertFalse(Nric.isValidNric("9011p041")); // alphabets within digits
        assertFalse(Nric.isValidNric("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(Nric.isValidNric("S9312154Z"));
    }
}
