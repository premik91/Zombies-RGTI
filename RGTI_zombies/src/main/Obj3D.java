package main;

import models.Model3D;
import org.lwjgl.opengl.GL11;
import glmodel.*;

import static org.lwjgl.opengl.GL11.*;

public class Obj3D extends Model3D {
    GLModel m_Obj = null;
    Obj3D(String p_strFileName) {
        try {
            m_Obj = new GLModel(p_strFileName);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void render() {
        // model view stack
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        // save current matrix
        glPushMatrix();

        // TRANSLATE
        glTranslatef(position.x, position.z, position.z);
        if (rotation.z!=0)
            GL11.glRotatef(rotation.z, 0, 0, 1);
        if (rotation.y!=0)
            GL11.glRotatef(rotation.y, 0, 1, 0);
        if (rotation.x!=0)
            GL11.glRotatef(rotation.x, 1, 0, 0);
        glScalef(scale.x, scale.y, scale.z);

        m_Obj.render();

        glPopMatrix();
    }
}
