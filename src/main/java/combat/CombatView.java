package combat;

import combat.mobview.MobView;
import combat.mobview.MobViewBuilder;
import combat.mobview.PhysicalAttributes;
import combat.stats.Stat;
import data.framework.BodyPart;
import data.framework.PartType;
import org.newdawn.slick.*;
import util.MyFont;
import util.ResourceLoader;
import util.buttons.AttackButton;

import java.util.HashMap;
import java.util.Map;

public class CombatView {

    private AbilityButton ability;
    private PlayerMobController player;

    private CombatController ctrl;
    private Image background;
    private MobView mobView, playerView;
    private HealthBar mobHealth, playerHealth;

    public CombatView(CombatController ctrl, PlayerMobController mobController) throws SlickException {

        this.ctrl = ctrl;
        Attack basicAttack = new Attack("Basic Attack", 0,0, ctrl.getSidekick().getStat(Stat.ATTACK_DMG));
        ability = new AbilityButton(basicAttack, 0, 70);
        ability.addListener(mobController);

        player = mobController;
        background = ResourceLoader.getImage("battleBackground");

        createEnemyView();
        createPlayerView();

        mobHealth = new HealthBar(ctrl.getMob(), 1100, 55);
        playerHealth = new HealthBar(ctrl.getSidekick(), 400, 55);
    }

    private void createPlayerView(){
        BodyPart body = ctrl.getSidekick().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(400, 380));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getSidekick().getPart(type));
        }
        playerView = mobViewBuilder.finalise(false);
    }

    public MobView getPlayerView(){
        return playerView;
    }

    public MobView getMobView(){
        return mobView;
    }

    private void createEnemyView(){
        BodyPart body = ctrl.getMob().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, new PhysicalAttributes(1150, 400));
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && ctrl.getMob().hasPart(type))
                mobViewBuilder.addPart(type, ctrl.getMob().getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public void init(GameContainer gc) throws SlickException {
        ability.init(gc);
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        g.setFont(MyFont.createFont(12));

        ability.render(gc, g);

        mobHealth.render(g);
        playerHealth.render(g);
        mobView.render(gc, g);
        playerView.render(gc, g);
    }
}
