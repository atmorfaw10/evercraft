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

    public boolean isSuccessfulRoll(int dieRoll) {
       return getSubject().roll(dieRoll) >= getTarget().getArmorClass();
    }
}
