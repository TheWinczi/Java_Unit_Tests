package laboratoria.platformy.technologiczne.lab5.magerepository;

import laboratoria.platformy.technologiczne.lab5.mage.Mage;
import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;


@Getter
public class MageRepository {

    /**
     * collection of mages in repository
     */
    private Collection<Mage> collection;


    /**
     * initialize the object
     */
    public MageRepository() {
        this.collection = new HashSet<>();
    }

    /**
     * find mage using mage' name
     * @param name name of the mage
     * @return founded mage
     */
    public Optional<Mage> find(String name) {

        for( Mage mage : this.collection ) {
            if( mage.getName().equals(name) ){
                return Optional.of(mage);
            }
        }
        return Optional.empty();
    }


    /**
     * delete mage using mage' name
     * @param name name of the mage
     */
    public void delete(String name) throws IllegalArgumentException{

        if( name == null )
            throw new IllegalArgumentException();

        Optional<Mage> mage = this.find(name);

        if(mage.isPresent()) {
            this.collection.remove(mage.get());
        }
        else
            throw new IllegalArgumentException();
    }


    /**
     * save new mage in repository
     * @param mage new mage to add
     */
    public void save(Mage mage) throws IllegalArgumentException{

        if( mage != null ){
            if( this.find(mage.getName()).isEmpty() )
                this.collection.add(mage);
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
    }
}
