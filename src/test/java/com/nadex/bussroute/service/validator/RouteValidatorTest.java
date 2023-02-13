package com.nadex.bussroute.service.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RouteValidatorTest {
    @Mock
    RouteValidator validator;

    StringBuilder getBuilder() {
        return new StringBuilder();
    }

    @Test
    void isValid_WhenGetsEmpty_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append(" ");

        assertThat(validator.isValid(builder)).isFalse();
    }

    @Test
    void isValid_WhenGetsIdWithLetterCharacters_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append("1d234").append(" ").append("54656");

        assertThat(validator.isValid(builder)).isFalse();
    }

    @Test
    void isValid_WhenNoPoints_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append("2345").append(" ");

        assertThat(validator.isValid(builder)).isFalse();
    }

    @Test
    void isValid_WhenIdZero_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append("0").append(" ").append("434");

        assertThat(validator.isValid(builder)).isFalse();
    }

    @Test
    void isValid_WhenIdLessThanZero_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append("-4545").append(" ").append("244");

        assertThat(validator.isValid(builder)).isFalse();
    }

    @Test
    void isValid_WhenIdGreaterThanIntMaxVal_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append(Integer.MAX_VALUE + 1 + " ").append("4545");

        assertThat(validator.isValid(builder)).isFalse();
    }

    @Test
    void isValid_WhenGetsOnlyId_ShouldReturnFalse() {
        StringBuilder builder = getBuilder().append("3422");

        assertThat(validator.isValid(builder)).isFalse();
    }
}
