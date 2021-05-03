package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CarRacePlayTest {

    CarRacePlay carRacePlay;

    @BeforeEach
    void init() {
        CarRaceDto carRaceDto = new CarRaceDto();
        carRaceDto.setRepeat(5);
        carRaceDto.setCars(Arrays.asList("아반떼" ,"소나타" ,"그랜저", "제네시스"));
        carRacePlay = new CarRacePlay(carRaceDto);
    }

    @DisplayName("자동차 레이싱 테스트")
    @Test
    void 자동차_레이싱_테스트() {
        carRacePlay.run();
    }
}