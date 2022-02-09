package com.welld.patternrecognition.Service;

import com.welld.patternrecognition.Model.Point;
import org.springframework.stereotype.Service;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PointsService {
    private List<Point> pointList = new ArrayList<>();


    public List<Point> getAllPointsList(){
        return pointList;
    }

    private Point2D modelToJavaPoint(Point p){
        return new Point2D.Double(p.getX(),p.getY());
    }

    public List<List<Point>> getAllLines(int n){
        double abs = 1e-3;
        HashMap<Line2D,List<Point>> pointsOnLine = new HashMap<>();
        List<Line2D> lines= new ArrayList<>();
        for(int i=0;i<pointList.size();i++){
            for(int j=i+1;j<pointList.size();j++){
                Point2D point1= modelToJavaPoint(pointList.get(i));
                Point2D point2= modelToJavaPoint(pointList.get(j));
                Line2D line = new Line2D.Double(point1,point2);
                lines.add(line);
            }
        }
        for(Line2D line : lines){
            List<Point> pointsInline = new ArrayList<>();
            for(Point p : pointList){
                Point2D temp=modelToJavaPoint(p);
                if(line.relativeCCW(temp)<=abs){
                    pointsInline.add(p);
                }
            }
            pointsOnLine.put(line,pointsInline);
        }
        return pointsOnLine.values().stream().filter(l->l.size()>=n).collect(Collectors.toList());
    }


    public void addPoint(Point point) {
        pointList.add(point);
    }
    public void deleteSpace() {
        pointList.clear();
    }
}
