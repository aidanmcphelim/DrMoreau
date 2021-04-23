package combat;

import combat.abilities.Ability;
import combat.abilities.AbilityFactory;
import combat.abilities.effects.DamageEffect;
import combat.abilities.effects.Effect;
import combat.stats.Stat;
import combat.view.animation.AttackAnimation;
import combat.view.mobview.MobView;
import combat.view.mobview.MobViewBuilder;
import combat.view.mobview.PhysicalAttributes;
import data.framework.IBodyPart;
import data.framework.PartType;
import data.mob.MobCombatData;

import java.util.ArrayList;
import java.util.List;

public class EnemyController implements MobController {

    private AbilityFactory abilityFactory;
    private MobCombatData mobCombatData;
    private MobView mobView;

    public EnemyController(MobCombatData mobCombatData){
        this.mobCombatData = mobCombatData;
        this.abilityFactory = new AbilityFactory(AttackAnimation.DIRECTION.LEFT);
        createMobView();
    }

    public void attachController(CombatController ctrl) {
        ctrl.executeAbility(abilityFactory.basicDamageAbility());
    }

    private void createMobView(){
        IBodyPart body = mobCombatData.getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(1150, 400));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && mobCombatData.hasPart(type))
                mobViewBuilder.addPart(type, mobCombatData.getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public MobCombatData getMobData(){
        return mobCombatData;
    }

    public MobView getMobView() {
        return mobView;
    }
}
