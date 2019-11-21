package combat;

import combat.animation.AnimationManager;
import combat.animation.AnimationManagerImp;
import combat.animation.AttackAnimationToLeft;
import combat.animation.AttackAnimationToRight;
import combat.stats.Stat;
import data.Mob;
import main.Main;
import main.MainController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import screens.Screen;

public class CombatController extends Screen {
    public int getID() {
        return Main.FIGHT;
    }

    private MainController main;
    private PlayerMobController playerController;
    private CombatView view;
    private Mob mob;

    private AnimationManager animationManager;
    //private Thread t;
    private AttackManager turns;

    public CombatController(MainController main) {
        this.main = main;
        playerController = new PlayerMobController();
        playerController.enter(this);
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        super.init(gc, sbg);
        animationManager = new AnimationManagerImp();
        turns = new AttackManager(this, animationManager);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        startNewCombat(main.getActiveRoom().getMob());
        view = new CombatView(this, playerController);
        view.init(gc);
    }

    public void startNewCombat(Mob mob)
    {
        this.mob = mob;
    }

    public void doAttack(Attack atk) {
        turns.attack(atk);
        animationManager.doAnimation(new AttackAnimationToRight(view.getPlayerView().getAttributes()));
    }



    public synchronized void update(GameContainer gc, StateBasedGame sbg, int delta){
        turns.update();
        checkWins();
    }

    public boolean checkWins() {
        if(main.getSidekick().getStat(Stat.CURRENT_HP) <= 0) {
            main.enterState(Main.GAMEOVER);
            return true;
        }
        else if(mob.getName().equals("Dr.Moreau") && mob.getStat(Stat.CURRENT_HP) <= 0) {
            main.enterState(Main.VICTORY);
            return true;
        }
        else if(mob.getStat(Stat.CURRENT_HP) <= 0) {
            main.enterState(Main.UPGRADE);
            return true;
        }
        return false;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        view.render(gc, g);
    }

    public Mob getMob(){
        return mob;
    }

    public Mob getSidekick(){
        return main.getSidekick();
    }

    public CombatView getView(){
        return view;
    }
}
