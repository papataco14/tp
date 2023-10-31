package seedu.address.model.company;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Company's recruiter name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class RecruiterName {

    public static final String MESSAGE_CONSTRAINTS_NON_EMPTY =
            "Oops! Recruiter's name should not be blank! Please try again with a valid recruiter name.";

    public static final String MESSAGE_CONSTRAINTS_INVALID_REGEX =
            "Oops! Recruiter's name should only contain alphanumeric characters and spaces! Please try again with"
                    + " a valid recruiter name.";
    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String fullName;

    /**
     * Constructs a {@code RecruiterName}.
     *
     * @param name A valid name.
     */
    public RecruiterName(String name) {
        requireNonNull(name);
        checkArgument(!name.isBlank(), MESSAGE_CONSTRAINTS_NON_EMPTY);
        checkArgument(isValidName(name), MESSAGE_CONSTRAINTS_INVALID_REGEX);
        fullName = name;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RecruiterName)) {
            return false;
        }

        RecruiterName otherName = (RecruiterName) other;
        return fullName.equals(otherName.fullName);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
