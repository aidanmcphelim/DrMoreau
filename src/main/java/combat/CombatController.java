package combat;

import main.Attack;
import main.Main;
import main.MainController;
import main.SidekickData;
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
    private CombatView view;
    private Mob mob;
    private Attack at1, at2, at3, at4, at5, at6;

    public CombatController(MainController main, Attack at1, Attack at2, Attack at3, Attack at4, Attack at5, Attack at6)
    {
        this.main = main;
        this.at1 = at1;
        this.at2 = at2;
        this.at3 = at3;
        this.at4 = at4;
        this.at5 = at5;
        this.at6 = at6;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        super.init(gc, sbg);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        startNewCombat(main.getActiveRoom().getMob());
        //startNewCombat(MobData.getMob("rat"));
        view = new CombatView(this, at1.getName(), at2.getName(), at3.getName(), at4.getName(), at5.getName(), at6.getName());
        view.init(gc);
    }

    public void startNewCombat(Mob mob)
    {
        this.mob = mob;
    }

    public void doAttack1(){doAttack(at1);}
    public void doAttack2(){doAttack(at2);}
    public void doAttack3(){doAttack(at3);}
    public void doAttack4(){doAttack(at4);}
    public void doAttack5(){doAttack(at5);}
    public void doAttack6(){doAttack(at6);}

    private void doAttack(Attack atk)
    {
        mob.setHp(atk.getDmg());
        main.getSidekick().attack(mob.getAttStat());
    }



    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        if(main.getSidekick().getCurrentHp() <= 0)
            main.enterState(Main.GAMEOVER);
        if(mob.getCurrentHp() <= 0)
            main.enterState(Main.UPGRADE);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
    {
        view.render(gc, g);
    }

    public Mob getMob(){
        return mob;
    }

    public SidekickData getSidekick(){
        return main.getSidekick();
    }
}
