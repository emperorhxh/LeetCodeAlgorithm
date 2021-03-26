package com.xhx.common.algorithm.pattern;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        FindMinima solver =
                new FindMinima();
        List<Double> line = Arrays.asList(
                1.0, 2.0, 1.0, 2.0, -1.0,
                3.0, 4.0, 5.0, 4.0 );
        solver.leastSquares();
        System.out.println(solver.applay(line));
        solver.perturbation();
        System.out.println(solver.applay(line));
    }
}
class FindMinima {
    Function<List<Double>, List<Double>> algorithm;

    public void leastSquares(){
        algorithm = (line) ->Arrays.asList(1.1, 2.2);
    }
    public void perturbation(){
        algorithm = (line) ->Arrays.asList(3.3, 4.4);
    }
    public void berturbation(){
        algorithm = (line) ->Arrays.asList(5.5, 6.6);
    }

    public List<Double> applay(List<Double> line){
        if(null != algorithm) return algorithm.apply(line);
        return null;
    }
}

