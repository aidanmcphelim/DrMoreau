package combat;

import combat.mobview.MobView;
import combat.mobview.MobViewBuilder;
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

    private AttackButton att1_button;
    private AbilityButton ability;
    private PlayerMobController player;

    private CombatController ctrl;
    private Image background;
    private MobView mobView, playerView;
    private HealthBar mobHealth, playerHealth;

    public CombatView(CombatController ctrl, PlayerMobController mobController){
        this.ctrl = ctrl;
        Attack basicAttack = new Attack("Basic Attack", 0,0, ctrl.getSidekick().getStat(Stat.ATTACK_DMG));
        att1_button = new AttackButton(basicAttack, 350, 700);
        ability = new AbilityButton(0, 70);
        player = mobController;
        background = ResourceLoader.getImage("battleBackground");

        createEnemyView();
        createPlayerView();

        mobHealth = new HealthBar(ctrl.getMob(), 1100, 55);
        playerHealth = new HealthBar(ctrl.getSidekick(), 400, 55);
    }

    private void createPlayerView(){
        BodyPart body = ctrl.getSidekick().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, 400, 380);
        for(PartType type : PartType.values()){
            if(type != PartType.BODY)
                mobViewBuilder.addPart(type, ctrl.getSidekick().getPart(type));
        }
        playerView = mobViewBuilder.finalise(false);
    }

    private void createEnemyView(){
        BodyPart body = ctrl.getMob().getPart(PartType.BODY);

        MobViewBuilder mobViewBuilder = new MobViewBuilder(body, 1150, 400);
        for(PartType type : PartType.values()){
            if(type != PartType.BODY && ctrl.getMob().hasPart(type))
                mobViewBuilder.addPart(type, ctrl.getMob().getPart(type));
        }
        mobView = mobViewBuilder.finalise(true);
    }

    public void init(GameContainer gc) throws SlickException {
        att1_button.init(gc);
        att1_button.addListener(player);

        ability.init(gc);
    }

    public void render(GameContainer gc, Graphics g) {
        g.drawImage(background, 0, 0);
        try {
            g.setFont(MyFont.createFont(12));
        } catch (Exception e) { e.printStackTrace(); }

        att1_button.render(gc, g);
        ability.render(gc, g);

        mobHealth.render(g);
        playerHealth.render(g);
        mobView.render(gc, g);
        playerView.render(gc, g);
    }
}
