package domain;

import util.Const;

import java.util.List;

public class CarResultMessage {

    private StringBuilder resultMessage;

    public CarResultMessage() {
        resultMessage = new StringBuilder();
    }

    public CarResultMessage(String carName) {
        this.resultMessage = new StringBuilder();
        resultMessage.append(carName + ": ");
    }

    public StringBuilder getResultMessage() {
        return resultMessage;
    }

    public void addResultMessage(int position) {
        for (int i = 0; i < position; i++) {
            resultMessage.append(Const.ROUND_DISPLAY);
        }
    }

    public void addWinnersMessage(List<String> winners) {
        for (String winner : winners) {
            resultMessage.append("," + winner);
        }
        resultMessage.append(" 가 최종 우승했습니다.");
        resultMessage.deleteCharAt(0);
    }
}
