package combat;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import util.MyFont;
import util.buttons.AbilityListener;
import util.buttons.AbilitySubject;

import java.util.ArrayList;
import java.util.List;

public class AbilityButton implements AbilitySubject, ComponentListener {

    private static final int WIDTH = 350, HEIGHT = 65;

    private MouseOverArea area;
    private float x, y;
    private Attack attack;

    private List<AbilityListener> listeners;

    private Font font;

    public AbilityButton(Attack attack, float x, float y) throws SlickException {
        this.x = x;
        this.y = y;
        this.attack = attack;

        listeners = new ArrayList<>();
        font = MyFont.createFont(30);
    }

    public void init(GameContainer gc) throws SlickException {
        Image image = new Image(WIDTH, HEIGHT);
        image.getGraphics().setColor(new Color(0, 0, 0, 0.8f));
        image.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);
        image.getGraphics().flush();

        Image hoverImage = new Image(WIDTH, HEIGHT);
        hoverImage.getGraphics().setColor(new Color(0, 0, 0, 1f));
        hoverImage.getGraphics().fillRect(0, 0, WIDTH, HEIGHT);
        hoverImage.getGraphics().flush();

        area = new MouseOverArea(gc, image, (int) x, (int) y);
        area.setMouseOverImage(hoverImage);
        area.addListener(this);
    }

    public void render(GameContainer gc, Graphics g) {
        area.render(gc, g);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(attack.getName(), x + 20, y + 20);
    }

    @Override
    public void addListener(AbilityListener listener) {
        listeners.add(listener);
    }

    @Override
    public void componentActivated(AbstractComponent abstractComponent) {
        for(AbilityListener listener : listeners)
            listener.movePerformed(attack);
    }
}