package com.example.testwithspock;

public class ShareFactory {
    private Renderer renderer;

    public ShareFactory() {
    }

    public ShareFactory(Renderer renderer) {
        this.renderer = renderer;
    }

    public Polygon createDefaultPolygon() {
        return new Polygon(4, renderer);
    }
}
