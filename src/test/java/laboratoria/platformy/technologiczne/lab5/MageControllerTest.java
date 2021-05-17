package laboratoria.platformy.technologiczne.lab5;

import laboratoria.platformy.technologiczne.lab5.magecontroller.MageController;
import laboratoria.platformy.technologiczne.lab5.magerepository.MageRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.whenNew;


public class MageControllerTest {

    @Test
    public void saveNewMageTest(){
        MageController controller = new MageController( new MageRepository() );
        String result = controller.save( "Merghani", 113 );
        assertThat(result).isEqualTo("done");
    }


    @Test
    public void deleteExistingMageTest(){

        MageRepository repository = Mockito.mock(MageRepository.class);
        MageController controller = new MageController(repository);
        String result = controller.delete( "Merghani");
        assertThat(result).isEqualTo("done");
    }
}
