package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarResultMessageTest {

    @DisplayName("자동차 경주 결과 메세지")
    @Test
    void 자동차_경주_결과_메세지() {
        CarResultMessage carResultMessage = new CarResultMessage("아반떼");
        carResultMessage.addResultMessage(2);

        assertThat(carResultMessage.getResultMessage().toString()).isEqualTo("아반떼: --");
    }

    @DisplayName("자동차_우승자_결과_메세지")
    @Test
    void 자동차_우승자_결과_메세지() {
        List<String> winners = Arrays.asList("아반떼", "소나타");
        CarResultMessage carResultMessage = new CarResultMessage();
        carResultMessage.addWinnersMessage(winners);

        assertThat(carResultMessage.getResultMessage().toString()).isEqualTo("아반떼,소나타 가 최종 우승했습니다.");
    }
}