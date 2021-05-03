package util;

public class ValidateInputRepeat {

    Integer repeat;

    public ValidateInputRepeat(String inputRepeat) {
        isEmpty(inputRepeat);
    }

    private void isEmpty(String inputRepeat) {
        try {
            repeat = Integer.parseInt(inputRepeat);
        } catch (IllegalArgumentException e) {
            new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public Integer getRepeat() {
        return repeat;
    }
}
