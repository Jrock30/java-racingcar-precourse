package domain;

import util.Const;

import java.util.Arrays;
import java.util.List;

public class Car {

    private List<String> cars;

    public Car(String cars) {
        validateCars(cars);
    }

    public Car(List<String> cars) {
        validateCars(cars);
    }

    private void validateCars(String cars) {
        if (isEmptyString(cars)) {
            throw new IllegalArgumentException("자동차를 입력하여 주세요.");
        }
        List<String> tempCars = Arrays.asList(cars.split(","));

        ValidateCarNames(tempCars);
    }

    private void validateCars(List<String> cars) {
        if (isEmptyCollection(cars)) {
            throw new IllegalArgumentException("자동차를 입력하여 주세요.");
        }
        List<String> tempCars = cars;
        ValidateCarNames(tempCars);
    }

    private boolean isEmptyString(String cars) {
        return cars == null || cars.length() == 0;
    }

    private boolean isEmptyCollection(List<String> cars) {
        return cars == null || cars.size() == 0;
    }

    private void ValidateCarNames(List<String> tempCars) {
        tempCars.forEach(this::isSizeFiveCar);
        this.cars = tempCars;
    }

    private void isSizeFiveCar(String car) {
        if (car.length() > Const.CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public List<String> getCars() {
        return cars;
    }
}
