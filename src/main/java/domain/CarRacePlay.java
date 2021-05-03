package domain;

import util.Const;
import util.RandomRepeatGenerator;
import view.ViewLayer;
import view.ViewLayerImpl;

import java.util.*;

public class CarRacePlay {

    private CarRaceDto carRaceDto;
    private ViewLayer viewLayer;
    private Map<String, CarResult> resultMap;

    public CarRacePlay(CarRaceDto carRaceDto) {
        this.carRaceDto = carRaceDto;
        this.viewLayer = new ViewLayerImpl();
        this.resultMap = initResultMap();
    }

    private Map<String, CarResult> initResultMap() {
        Map<String, CarResult> carResultMap = new LinkedHashMap<>();

        for (int i = 0; i < carRaceDto.getCars().size(); i++) {
            CarResult carResult = new CarResult();
            carResult.setPosition(0);
            carResult.setCarName(carRaceDto.getCars().get(i));
            carResultMap.put(carRaceDto.getCars().get(i), carResult);
        }
        return carResultMap;
    }

    public void run() {
        for (int i = 0; i < carRaceDto.getRepeat(); i++) {
            iteratorCar(resultMap);
            viewLayer.outValueLine("");
        }
        getWinner();
    }

    private void iteratorCar(Map<String, CarResult> carResultMap) {
        for (String carName : carResultMap.keySet()) {
            advance(carResultMap.get(carName));
        }
    }

    private void advance(CarResult carResult) {
        if (RandomRepeatGenerator.makeRandomNumber() >= Const.ADVANCE_NUMBER) {
            carResult.setPosition(carResult.getPosition() + Const.ROUND_ADD_NUMBER);
        }
        printResultMessage(carResult);
        resultMap.put(carResult.getCarName(), carResult);
    }

    private void printResultMessage(CarResult carResult) {
        CarResultMessage carResultMessage = new CarResultMessage(carResult.getCarName());
        carResultMessage.addResultMessage(carResult.getPosition());
        viewLayer.outValueLine(carResultMessage.getResultMessage().toString());
    }

    private void getWinner() {
        CarRaceWinner carRaceWinner = new CarRaceWinner(resultMap);
        List<String> winners = carRaceWinner.getWinners();
        CarResultMessage carResultMessage = new CarResultMessage();
        carResultMessage.addWinnersMessage(winners);
        viewLayer.outValue(carResultMessage.getResultMessage().toString());
    }
}
