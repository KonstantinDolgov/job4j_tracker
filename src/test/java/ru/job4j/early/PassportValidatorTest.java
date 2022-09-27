package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PassportValidatorTest {
    @Test
    void whenValidInput() {
        String expected = "Password created";
        String result = PassportValidator.validate("kjhfgd56526UFV&");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenNullInput() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Password don't entered");
    }

    @Test
    void whenInvalidLength() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate("kj566U&");
                });
        assertThat(exception.getMessage()).isEqualTo("Length of password is wrong");
    }

    @Test
    void whenInvalidUpper() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate("dvfsdv56526&");
                });
        assertThat(exception.getMessage()).isEqualTo("Must have an uppercase word");
    }

    @Test
    void whenInvalidLower() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate("56526UFV&");
                });
        assertThat(exception.getMessage()).isEqualTo("Must have an lowercase word");
    }

    @Test
    void whenInvalidDigits() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate("fsdfsdfsdUFV&");
                });
        assertThat(exception.getMessage()).isEqualTo("Must have an digit");
    }

    @Test
    void whenInvalidSpecials() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate("fsdfsd345fsdUFV");
                });
        assertThat(exception.getMessage()).isEqualTo("Must have an special symbol");
    }

    @Test
    void whenInvalidStandard() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PassportValidator.validate("QWerTy345$fsdUFV");
                });
        assertThat(exception.getMessage()).isEqualTo("Don't use standard words");
    }
}