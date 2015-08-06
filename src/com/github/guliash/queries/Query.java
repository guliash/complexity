package com.github.guliash.queries;

/**
 * Created by gulash on 03.08.15.
 */
public class Query {
    public int x, y, type;

    public Query(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String toString() {
        return String.format("%d %d %d", x, y, type);
    }
}
