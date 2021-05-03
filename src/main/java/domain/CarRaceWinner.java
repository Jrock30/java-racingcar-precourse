package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarRaceWinner {

    private List<String> winners;

    public CarRaceWinner(Map<String, CarResult> resultMap) {
        winners = new ArrayList<>();
        setWinners(resultMap);
    }

    public List<String> getWinners() {
        return winners;
    }

    private void setWinners(Map<String, CarResult> resultMap) {
        int maxCount = setMaxCount(resultMap);
        for (String carName : resultMap.keySet()) {
            addWinner(resultMap.get(carName), maxCount);
        }
    }

    private void addWinner(CarResult carResult, int maxCount) {
        if (carResult.getPosition() == maxCount) {
            winners.add(carResult.getCarName());
        }
    }

    private int setMaxCount(Map<String, CarResult> resultMap) {
        int maxCount = 0;
        for (String carName : resultMap.keySet()) {
            maxCount = addCount(resultMap.get(carName), maxCount);
        }
        return maxCount;
    }

    private int addCount(CarResult carResult, int maxCount) {
        if (carResult.getPosition() > maxCount) {
            maxCount = carResult.getPosition();
        }
        return maxCount;
    }
}
