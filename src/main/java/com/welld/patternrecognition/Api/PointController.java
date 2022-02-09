package com.welld.patternrecognition.Api;

import com.welld.patternrecognition.Model.Point;
import com.welld.patternrecognition.Service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointController {
    @Autowired
    private PointsService pointsService;

    @GetMapping("/space")
    public List<Point> all_points(){
        return pointsService.getAllPointsList();
    }

    @PostMapping(value = "/point", consumes = {"application/json"})
    public void addPoint(@RequestBody Point point){
        pointsService.addPoint(point);
    }

    @DeleteMapping("/space")
    public void deleteSpace(){
        pointsService.deleteSpace();
    }
    @GetMapping("/lines/{n}")
    public List<List<Point>> getAllLines(@PathVariable("n") int n){
        return pointsService.getAllLines(n);
    }
}
