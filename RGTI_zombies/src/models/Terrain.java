package models;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Terrain extends Model3D {
    Texture text = null;

    public Terrain() {
        try {
            // load texture from PNG file
            text = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("/Users/Aljaz/Documents/InteliJ workspace/Zombies-RGTI/RGTI_zombies/textures/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render() {

        glEnable(GL_TEXTURE_2D);
        glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE );

        glBegin(GL_QUADS);

        if (text != null) {
            glBindTexture(GL_TEXTURE_2D, text.getTextureID());
//            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        }

        glColor4f(1.0f, 1.0f, 1.0f, 0.0f);

        glTexCoord2f(0,0);
        glVertex3f(1.0f, 0.0f, 1.0f);
        glTexCoord2f(1,0);
        glVertex3f(-1.0f, 0.0f, 1.0f);
        glTexCoord2f(1,1);
        glVertex3f(-1.0f, 0.0f, -1.0f);
        glTexCoord2f(0,1);
        glVertex3f(1.0f, 0.0f, -1.0f);

        glEnd();

        glDisable(GL_TEXTURE_2D);

    }
}
