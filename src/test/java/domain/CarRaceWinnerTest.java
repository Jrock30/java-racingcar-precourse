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

    @DisplayName("단일 우승자")
    @Test
    void 단일_우승자() {
        CarRaceWinner carRaceWinner = new CarRaceWinner(resultMap);
        List<String> winners = carRaceWinner.getWinners();

        assertThat(winners).containsExactly("자동차4");
    }

    @DisplayName("다수 우승자")
    @Test
    void 다수_우승자() {
        CarResult carResult;
        carResult = new CarResult();
        carResult.setPosition(4);
        carResult.setCarName("자동차5");
        resultMap.put("자동차5", carResult);

        CarRaceWinner carRaceWinner = new CarRaceWinner(resultMap);
        List<String> winners = carRaceWinner.getWinners();

        assertThat(winners).containsExactly("자동차4", "자동차5");
    }
}