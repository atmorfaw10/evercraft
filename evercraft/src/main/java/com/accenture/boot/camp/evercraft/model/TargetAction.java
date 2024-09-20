package com.accenture.boot.camp.evercraft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetAction {
    protected CharacterSheet subject;
    protected CharacterSheet target;

    public TargetAction(CharacterSheet subject, CharacterSheet target) {
        setSubject(subject);
        setTarget(target);
    }

    public boolean isSuccessful(int dieRoll) {
       return getSubject().roll(dieRoll) >= getTarget().getArmorClass();
    }

    public int dealDamage(int dieRoll) {
        if(isSuccessful(dieRoll)) {
            target.setHitPoints(target.getHitPoints() - 1);
        }
        return target.getHitPoints();
    }
}
