package seedu.address.model.tag;

import seedu.address.testutil.Assert;

import org.junit.Test;

public class SpecialisationTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Specialisation(null));
    }

    @Test
    public void constructor_invalidSpecialisation_throwsIllegalArgumentException() {
        String invalidSpecialisationName = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Tag(invalidSpecialisationName));
    }

    @Test
    public void isValidSpecialisation() {
        // null specialisation
        Assert.assertThrows(NullPointerException.class, () -> Specialisation.isValidSpecialisation(null));
    }

}
