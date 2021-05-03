import domain.CarRace;
import view.ViewLayerImpl;

public class CarRaceApplication {

    public static void main(String[] args) {
        CarRace carRace = new CarRace(new ViewLayerImpl());
        carRace.play();
    }
}
