package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class CarRaceWinnerTest {

    Map<String, CarResult> resultMap = new LinkedHashMap<>();

    @BeforeEach
    void init() {
        CarResult carResult;
        for (int i = 0; i < 5; i++) {
            carResult = new CarResult();
            carResult.setPosition(i);
            carResult.setCarName("자동차" + i);
            resultMap.put("자동차" + i, carResult);
        }
    }

    @DisplayName("우승자 테스트")
    @Test
    void 우승자_여부_테스트() {
        CarRaceWinner carRaceWinner = new CarRaceWinner(resultMap);
        List<String> winners = carRaceWinner.getWinners();

        assertThat(winners).isNotNull();
    }
}