package com.accenture.boot.camp.evercraft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterSheet {

    protected String name;
    protected String alignment;
    protected int armorClass;
    protected int hitPoints;

    public CharacterSheet(String name, String alignment) {
       setName(name);
       setAlignment(alignment);
       setArmorClass(10);
       setHitPoints(5);
    }


    public int roll(int dieNumber) {
        if (dieNumber >= 1 && dieNumber <= 20) {
            return dieNumber;
        } else {
            return -1;
        }
    }

    public void takeDamage(int damage) {
        setHitPoints(getHitPoints() - damage);
    }

    public boolean getIsAlive(){
        return getHitPoints() > 0;
    }




}
