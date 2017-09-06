package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyFX {
    private Vector2 position;
    private float time;
    private static Texture texture;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public MyFX() {
        if (texture == null)
            texture = new Texture("BOOM.png");
        active = false;
        position = new Vector2(0.0f, 0.0f);
    }

    public void setup(float x, float y) {
        active = true;
        position.x = x;
        position.y = y;
        time = 0.0f;
    }

    public void update() {
        if (isActive()) {
            time += 0.2f;
            if (time > 4.0f)
                active = false;
        }
    }

    public void render(SpriteBatch batch) {
        if (isActive())
            batch.draw(texture, position.x, position.y, (int) (time) * 40, 0, 40, 40);
    }
}
