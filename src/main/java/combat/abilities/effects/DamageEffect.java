package combat.abilities.effects;

import combat.stats.Stat;
import data.mob.Mob;

public class DamageEffect implements Effect{

    private float damage;
    private Mob subject;

    public DamageEffect(float damage){
        this.damage = damage;
    }

    public void attach(Mob attacker, Mob defender) {
        this.subject = defender;
        subject.applyEffect(this);
        onAttach();
    }

    public void onAttach() {
        float currentHp = subject.getStat(Stat.CURRENT_HP);
        float armor = subject.getStat(Stat.ARMOR);
        float maxHp = subject.getStat(Stat.MAX_HP);

        if(armor - damage < 0) {
            subject.setStat(Stat.ARMOR, 0);
            damage = damage - armor;

            if(currentHp - damage < 0)
                subject.setStat(Stat.CURRENT_HP, 0f);
            else
                subject.setStat(Stat.CURRENT_HP, Math.min(currentHp - damage, maxHp));
        }
        else{
            subject.setStat(Stat.ARMOR, armor - damage);
        }
    }

    public void resolveEndOfTurn(){}

    public int getRemainingDuration(){
        return 0;
    }

    @Override
    public boolean isComplete() {
        return this.getRemainingDuration() <= 0;
    }
}
