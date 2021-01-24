package com.example.testwithspock;

/**
 * 两种以上的化合物
 */
public class Polygon {
    private final int numberOfSides;

    private Renderer renderer;

    public Renderer getRenderer() {
        return renderer;
    }

    public Polygon(int numberOfSides, Renderer renderer) {
        this.numberOfSides = numberOfSides;
        this.renderer = renderer;
    }

    public Polygon(int numberOfSides) {
        if (numberOfSides <= 2) {
            throw new TooFewSidesException(
                    "You can't have fewer then 3 sides for a polygon", numberOfSides);
        }
        this.numberOfSides = numberOfSides;
    }



    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void draw() {
        for (int i = 0; i < numberOfSides; i++) {
            renderer.drawLine();
        }
    }
}
