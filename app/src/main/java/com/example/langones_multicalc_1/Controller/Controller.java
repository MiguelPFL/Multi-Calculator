package com.example.langones_multicalc_1.Controller;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.langones_multicalc_1.Model.Model;

import org.w3c.dom.Text;

public class Controller {

    Model l = new Model();

    //Formulas for Geometry
    public void geometry(double a, double b, double c, String shape) {
        switch (shape) {
            case "PRISM":
                l.setShape(shape);
                l.setBase(a);
                l.setPerimeter(b);
                l.setHeight(c);
                l.setArea(2 * l.getBase() + (l.getPerimeter()* l.getHeight()));
                l.setVolume(l.getBase()* l.getHeight());
                break;
            case "RECTANGULAR PRISM":
                l.setShape(shape);
                l.setLength(a);
                l.setWidth(b);
                l.setHeight(c);
                l.setArea(2 * ((l.getLength() * l.getWidth()) + (l.getWidth() * l.getHeight()) + (l.getLength() * l.getHeight())));
                l.setVolume(l.getLength() * l.getWidth() * l.getHeight());
                break;
            case "SPHERE":
                l.setShape(shape);
                l.setRadius(a);
                l.setArea(4 * Math.PI * Math.pow(l.getRadius(), 2));
                l.setVolume(4 / 3d * Math.PI * Math.pow(l.getRadius(), 3));
                break;
            case "CYLINDER":
                l.setShape(shape);
                l.setRadius(a);
                l.setHeight(b);
                l.setVolume(Math.PI * Math.pow(l.getRadius(), 2) * l.getHeight());
                l.setArea(2 * Math.PI * l.getRadius() * l.getHeight() + 2 * Math.PI * Math.pow(l.getRadius(), 2));
                break;
        }
    }

    //Formulas for Physics
    public void physics(double a, double b, String concept) {
        switch (concept) {
            case "Speed":
                l.setConcept(concept);
                l.setDistance(a);
                l.setTime(b);
                l.setAnswer(l.getDistance()/l.getTime());
                break;
            case "Distance":
                l.setConcept(concept);
                l.setSpeed(a);
                l.setTime(b);
                l.setAnswer(l.getSpeed()*l.getTime());
                break;
            case "Time":
                l.setConcept(concept);
                l.setDistance(a);
                l.setSpeed(b);
                l.setAnswer(l.getDistance()/l.getSpeed());
                break;
            case "Density":
                l.setConcept(concept);
                l.setMass(a);
                l.setVolumedensity(b);
                l.setAnswer(l.getMass()/l.getVolumedensity());
                break;
            case "Force":
                l.setConcept(concept);
                l.setMass(a);
                l.setAcceleration(b);
                l.setAnswer(l.getMass()*l.getAcceleration());
        }
    }

    //geography outputView
    @SuppressLint("SetTextI18n")
    public void geometryResult(TextView Shape, TextView j1, TextView j2, TextView j3, String shape, EditText geoInput2, EditText geoInput3) {
        l.setConcept(shape);
        switch (shape) {
            case "PRISM":
                Shape.setText(shape);
                j1.setText("Base:");
                j2.setText("Perimeter:");
                j3.setText("Height:");
                break;
            case "RECTANGULAR PRISM":
                Shape.setText(shape);
                j1.setText("Length:");
                j2.setText("Width");
                j3.setText("Height:");
                break;
            case "SPHERE":
                Shape.setText(shape);
                j1.setText("Radius:");
                j2.setVisibility(View.INVISIBLE);
                j3.setVisibility(View.INVISIBLE);
                geoInput2.setVisibility(View.INVISIBLE);
                geoInput3.setVisibility(View.INVISIBLE);
                geoInput2.setText("1");
                geoInput3.setText("1");
                geoInput2.setEnabled(false);
                geoInput3.setEnabled(false);
                break;
            case "CYLINDER":
                Shape.setText(shape);
                j1.setText("Radius:");
                j2.setText("Height:");
                j3.setVisibility(View.INVISIBLE);
                geoInput3.setVisibility(View.INVISIBLE);
                geoInput3.setText("1");
                geoInput3.setEnabled(false);
        }
    }
    //physics outputView
    @SuppressLint("SetTextI18n")
    public void physicsResult(TextView k1, TextView k2, TextView k3, String concept) {
        l.setConcept(concept);
        switch (concept) {
            case "Speed":
                k1.setText("Distance:");
                k2.setText("Time:");
                k3.setText(concept + ":");
                break;
            case "Distance":
                k1.setText("Speed:");
                k2.setText("Time:");
                k3.setText(concept + ":");
                break;
            case "Time":
                k1.setText("Distance:");
                k2.setText("Speed:");
                k3.setText(concept + ":");
                break;
            case "Density":
                k1.setText("Mass:");
                k2.setText("Volume:");
                k3.setText(concept + ":");
                break;
            case "Force":
                k1.setText("Mass:");
                k2.setText("Acceleration:");
                k3.setText(concept + ":");
        }
    }
    //results
    public void geometryAnswer(TextView area, TextView volume) {
        area.setText(String.valueOf(l.getArea()));
        volume.setText(String.valueOf(l.getVolume()));
    }
    public void physicsAnswer(TextView answer) {
        answer.setText(String.valueOf(l.getAnswer()));
    }
}


