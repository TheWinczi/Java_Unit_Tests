package laboratoria.platformy.technologiczne.lab5.mage;

import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Mage {

    /**
     * name of the mage
     */
    private String name;

    /**
     * level of the mage
     */
    private int level;

    public String tellJoke() {
        return "Haha, It was funny!";
    }
}
