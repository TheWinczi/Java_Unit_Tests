package laboratoria.platformy.technologiczne.lab5;

import laboratoria.platformy.technologiczne.lab5.magerepository.MageRepository;
import laboratoria.platformy.technologiczne.lab5.mage.Mage;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


import java.util.Optional;


public class MageRepositoryTest {

    @Test
    public void saveNewMageTest() {
        MageRepository repository = new MageRepository();
        repository.save(new Mage("Markov", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveExistingMageTest() {
        MageRepository repository = new MageRepository();
        repository.save(new Mage("Markov", 100));
        repository.save(new Mage("Markov", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveNullMageTest() {
        MageRepository repository = new MageRepository();
        repository.save(null);
    }

    @Test
    public void deleteExistingMageTest() {
        MageRepository repository = new MageRepository();
        Mage mage = new Mage("Markov", 100);
        repository.save(mage);
        repository.delete(mage.getName());
    }

    @Test(expected = Exception.class)
    public void deleteNotExistingMageTest() {
        MageRepository repository = new MageRepository();
        repository.delete("Name");
    }

    @Test(expected = Exception.class)
    public void deleteNullNameMageTest() {
        MageRepository repository = new MageRepository();
        repository.delete(null);
    }

    @Test
    public void findExistingMageTest() {
        MageRepository repository = new MageRepository();
        Mage mage = new Mage("Markov", 100);
        repository.save(mage);
        Optional<Mage> result = repository.find(mage.getName());

        assertThat(result).isNotEmpty()
                .get().isEqualTo(mage);
    }

    @Test
    public void findNotExistingMageTest() {
        MageRepository repository = new MageRepository();
        Optional<Mage> result = repository.find("Name");
        assertThat(result).isEmpty();
    }


}
