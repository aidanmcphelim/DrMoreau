package data.framework;

import org.newdawn.slick.SlickException;

import java.util.Map;

public interface BodyPartLoader {
    Map<String, IBodyPart> getBodyParts() throws SlickException;
}
