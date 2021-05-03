package domain;

import util.ValidateInputRepeat;
import view.ViewLayer;
import view.ViewLayerImpl;

public class CarRace {

    private ViewLayer viewLayer;

    public CarRace(ViewLayerImpl viewLayer) {
        this.viewLayer = viewLayer;
    }

    public void play() {
        CarRaceDto carRaceDto = new CarRaceDto();

        viewLayer.outValue("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분) : ");
        String inputCars = viewLayer.inputValue();
        carRaceDto.setCars(new Car(inputCars).getCars());

        viewLayer.outValue("시도할 횟수를 입력하세요. : ");
        String inputRepeat = viewLayer.inputValue();
        carRaceDto.setRepeat(new ValidateInputRepeat(inputRepeat).getRepeat());

        new CarRacePlay(carRaceDto).run();
    }
}
