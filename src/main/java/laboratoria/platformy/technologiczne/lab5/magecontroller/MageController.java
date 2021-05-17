package laboratoria.platformy.technologiczne.lab5.magecontroller;

import laboratoria.platformy.technologiczne.lab5.magerepository.MageRepository;
import laboratoria.platformy.technologiczne.lab5.mage.Mage;

import java.util.Optional;

public class MageController {

    /**
     * repository of mages
     */
    private MageRepository repository;

    /**
     * initialize the object
     * @param repository repository for mages
     */
    public MageController(MageRepository repository) {
        this.repository = repository;
    }


    /**
     * find mage using name
     * @param name name of the mage
     * @return name of the found mage
     */
    public String find(String name) {
        Optional<Mage> mage = repository.find(name);

        if( mage.isPresent() )
            return mage.get().getName();
        else
            return "not found";
    }


    /**
     * delete mage using mage' name
     * @param name name of the mage
     */
    public String delete(String name) {
        try{
            this.repository.delete(name);
            return "done";
        } catch(IllegalArgumentException ex) {
            return "not found";
        }
    }


    /**
     * save new mage in repository
     * @param name name of the mage
     * @param level level of the mage
     */
    public String save(String name, int level) {
        Mage newMage = Mage.builder()
                .name(name)
                .level(level)
                .build();
        try {
            this.repository.save(newMage);
            return "done";
        } catch( IllegalArgumentException ex ) {
            return "bad request";
        }
    }


    public int add( int a, int b ) {
        return a + b;
    }

    public int sub( int a, int b ) {
        return a * b;
    }
}
