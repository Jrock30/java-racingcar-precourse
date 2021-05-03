package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름 빈 값 및 5자리 문자열 체크 성공")
    @Test
    void 자동차_이름_빈값_및_5자리_String_체크_성공() {
        Car car = new Car("엑센트,아반떼,소나타,그랜저,제네시스");

        assertThat(car.getCars()).containsExactly("엑센트", "아반떼", "소나타", "그랜저", "제네시스");
    }

    @DisplayName("자동차 이름 빈 값 및 5자리 리스트 체크 성공")
    @Test
    void 자동차_이름_빈값_및_5자리_List_체크_성공() {
        Car car = new Car(Arrays.asList("엑센트", "아반떼", "소나타", "그랜저", "제네시스"));

        assertThat(car.getCars()).containsExactly("엑센트", "아반떼", "소나타", "그랜저", "제네시스");
    }

    @DisplayName("자동차 이름 빈 값 및 5자리 문자열 체크 실패")
    @Test
    void 자동차_이름_빈값_및_5자리_String_체크_실패() {
        assertThatThrownBy(() -> {
            new Car("엑센트엑센트,아반떼,소나타,그랜저,제네시스");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름 빈 값 및 5자리 리스트 체크 실패")
    @Test
    void 자동차_이름_빈값_및_5자리_List_체크_실패() {


        assertThatThrownBy(() -> {
            new Car(Arrays.asList("엑센트", "아반떼아반떼", "소나타", "그랜저", "제네시스"));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}