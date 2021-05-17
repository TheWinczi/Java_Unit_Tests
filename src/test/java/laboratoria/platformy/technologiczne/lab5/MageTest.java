package laboratoria.platformy.technologiczne.lab5;

import laboratoria.platformy.technologiczne.lab5.mage.Mage;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


public class MageTest {

    @Test
    public void getMageNameTest() {
        Mage mage = new Mage("Slawomir", 1);
        String result = mage.getName();
        assertThat(result).isEqualTo("Slawomir");
    }

    @Test
    public void getJokeMageTest() {

        Mage mage = Mockito.mock(Mage.class);
        when(mage.tellJoke()).thenReturn("This is real joke");


        String result = mage.tellJoke();
        assertThat(result).isEqualTo("Haha, It was funny!");
    }
}
