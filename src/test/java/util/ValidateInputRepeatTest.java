package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidateInputRepeatTest {

    @DisplayName("반복 값을 체크한다.")
    @Test
    void 반복_값_체크() {
        Integer repeat = new ValidateInputRepeat("10").getRepeat();

        assertThat(repeat).isNotNull();
        assertThat(repeat).isEqualTo(10);
    }
}