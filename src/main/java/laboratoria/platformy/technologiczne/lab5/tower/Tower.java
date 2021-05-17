package laboratoria.platformy.technologiczne.lab5.tower;

import laboratoria.platformy.technologiczne.lab5.mage.Mage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class Tower {

    /**
     * name of the tower
     */
    private String name;

    /**
     * height of the tower
     */
    private int height;

    /**
     * list of mages in tower
     */
    private List<Mage> mages;


    /**
     * initialize the Tower
     * @param name name of the tower
     * @param height height of the tower
     */
    public Tower(String name, int height) {
        this.name = name;
        this.height = height;
        this.mages = new ArrayList<Mage>();
    }


    /**
     * add new mage to tower mages list
     * @param newMage mage to add
     */
    public void addMage(Mage newMage) {
        this.mages.add(newMage);
    }


    public List<String> getAllNames( Tower tower ) {

        List<String> namesList = new ArrayList<>();
        int index = 0;
        String name;

        while( (name = getNextName(index, tower)) != null ) {
            namesList.add(name);
            index += 1;
        }
        return namesList;
    }

    public String getNextName(int index, Tower tower) {
        if( tower.getMages().size() - 1 < index )
            return null;

        return tower.getMages().get(index).getName();
    }
}
