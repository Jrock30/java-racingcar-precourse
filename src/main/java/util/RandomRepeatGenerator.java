package util;

import java.util.*;

public class RandomRepeatGenerator {

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(Const.RANDOM_MAX_NUMBER)+1;
    }
}
