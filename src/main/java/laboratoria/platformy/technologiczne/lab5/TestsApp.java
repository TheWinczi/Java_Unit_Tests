package laboratoria.platformy.technologiczne.lab5;

import laboratoria.platformy.technologiczne.lab5.magecontroller.MageController;
import laboratoria.platformy.technologiczne.lab5.magerepository.MageRepository;

public class TestsApp {

    public static void main(String[] args) {

        MageRepository repository = new MageRepository();
        MageController controller = new MageController( repository );

        System.out.println(controller.add(2, 5));
    }
}
