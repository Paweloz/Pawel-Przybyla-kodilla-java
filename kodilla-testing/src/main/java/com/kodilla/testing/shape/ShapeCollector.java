package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> figures = new ArrayList<>();

    public List<Shape> getFigures() {
        return figures;
    }

    public void addFigure(Shape figure){
        figures.add(figure);

    }

    public boolean removeFigure(Shape figure){
        if(figures.contains(figure)){
            figures.remove(figure);
            return true;
        }else{
            return false;
        }
    }

    public Shape getFigure(int n){
        return figures.get(n);

    }
    public String showFigures(){
        String result="";
        for(int i=0;i<figures.size();i++){
            String shape = figures.get(i).getShape() + " with field : "+figures.get(i).getField();
            result += shape +", ";
        }
        return result;
    }
}
