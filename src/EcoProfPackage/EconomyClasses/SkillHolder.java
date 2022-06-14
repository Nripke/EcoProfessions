package EcoProfPackage.EconomyClasses;

import EcoProfPackage.PlayerData;
import EcoProfPackage.EconomyClasses.Skills.*;
/*
    Maintains instances of every skill class for ease. Primarily utilized in PlayerData
 */
public class SkillHolder
{
    private final PlayerData playerData;
    private Woodcutting wc;
    private Mining min;
    private Hunting hun;
    private Farming farm;

    public SkillHolder(PlayerData playerData, Woodcutting wc, Mining min, Hunting hun, Farming farm) {
        this.playerData = playerData;
        this.wc = wc;
        this.min = min;
        this.hun = hun;
        this.farm = farm;
    }

    public Woodcutting getWC() {
        return wc;
    }

    public Mining getMin() {
        return min;
    }

    public Hunting getHun() {
        return hun;
    }

    public Farming getFarm(){return farm;}

}
