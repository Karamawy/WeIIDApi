package com.welld.patternrecognition.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Point {
    @NotNull
    @Pattern(regexp="/^[0-9]+(\\\\.[0-9]+)?$")
    private final double x;
    
    @NotNull
    @Pattern(regexp="/^[0-9]+(\\\\.[0-9]+)?$")
    private final double y;

    public Point( double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
