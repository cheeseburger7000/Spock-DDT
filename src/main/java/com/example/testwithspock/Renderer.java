package com.example.testwithspock;

import java.awt.*;

public class Renderer {
    private Palette palette;

    public Renderer() {
    }

    public Renderer(Palette palette) {
        this.palette = palette;
    }

    public void drawLine() {

    }

    public Color getForegroundColour() {
        return palette.getPrimaryColor();
    }
}
