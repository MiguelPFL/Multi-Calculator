package com.example.langones_multicalc_1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.langones_multicalc_1.Model.Model;
import com.example.langones_multicalc_1.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button geometry,physics,prism,rectangular_prism,sphere,cylinder,speed,distance,time,density,force;

    Model object = new Model();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        geometry = findViewById(R.id.geometry);
        physics = findViewById(R.id.physics);
        prism = findViewById(R.id.prism);
        rectangular_prism = findViewById(R.id.rectangular_prism);
        sphere = findViewById(R.id.sphere);
        cylinder = findViewById(R.id.cylinder);
        speed = findViewById(R.id.speed);
        distance = findViewById(R.id.distance);
        time = findViewById(R.id.time);
        density = findViewById(R.id.density);
        force = findViewById(R.id.force);

        geometry.setOnClickListener(this);
        physics.setOnClickListener(this);
        prism.setOnClickListener(this);
        rectangular_prism.setOnClickListener(this);
        sphere.setOnClickListener(this);
        cylinder.setOnClickListener(this);
        speed.setOnClickListener(this);
        distance.setOnClickListener(this);
        time.setOnClickListener(this);
        density.setOnClickListener(this);
        force.setOnClickListener(this);

        start();
    }

    @Override
    @SuppressLint("NonConstantResourceId")
    public void onClick(View view){
        Intent geometry = new Intent(MainActivity.this,Geometry.class);
        Intent physics = new Intent(MainActivity.this,Physics.class);
        switch (view.getId()) {
            case R.id.geometry:
                geometry();
                break;
            case R.id.physics:
                physics();
                break;
            case R.id.prism:
                object.setShape("PRISM");
                geometry.putExtra("shape",object.getShape());
                startActivity(geometry);
                break;
            case R.id.rectangular_prism:
                object.setShape("RECTANGULAR PRISM");
                geometry.putExtra("shape",object.getShape());
                startActivity(geometry);
                break;
            case R.id.sphere:
                object.setShape("SPHERE");
                geometry.putExtra("shape",object.getShape());
                startActivity(geometry);
                break;
            case R.id.cylinder:
                object.setShape("CYLINDER");
                geometry.putExtra("shape",object.getShape());
                startActivity(geometry);
                break;
            case R.id.speed:
                object.setConcept("Speed");
                physics.putExtra("concept",object.getConcept());
                startActivity(physics);
                break;
            case R.id.distance:
                object.setConcept("Distance");
                physics.putExtra("concept",object.getConcept());
                startActivity(physics);
                break;
            case R.id.time:
                object.setConcept("Time");
                physics.putExtra("concept",object.getConcept());
                startActivity(physics);
                break;
            case R.id.density:
                object.setConcept("Density");
                physics.putExtra("concept",object.getConcept());
                startActivity(physics);
                break;
            case R.id.force:
                object.setConcept("Force");
                physics.putExtra("concept",object.getConcept());
                startActivity(physics);
        }
    }

    public void start() {
        geometry.setVisibility(View.VISIBLE);
        physics.setVisibility(View.VISIBLE);
        prism.setVisibility(View.GONE);
        rectangular_prism.setVisibility(View.GONE);
        sphere.setVisibility(View.GONE);
        cylinder.setVisibility(View.GONE);
        speed.setVisibility(View.GONE);
        distance.setVisibility(View.GONE);
        time.setVisibility(View.GONE);
        density.setVisibility(View.GONE);
        force.setVisibility(View.GONE);
    }

    public void geometry() {
        geometry.setVisibility(View.GONE);
        physics.setVisibility(View.GONE);
        prism.setVisibility(View.VISIBLE);
        rectangular_prism.setVisibility(View.VISIBLE);
        sphere.setVisibility(View.VISIBLE);
        cylinder.setVisibility(View.VISIBLE);
        speed.setVisibility(View.GONE);
        distance.setVisibility(View.GONE);
        time.setVisibility(View.GONE);
        density.setVisibility(View.GONE);
        force.setVisibility(View.GONE);
    }

    public void physics() {
        geometry.setVisibility(View.GONE);
        physics.setVisibility(View.GONE);
        prism.setVisibility(View.GONE);
        rectangular_prism.setVisibility(View.GONE);
        sphere.setVisibility(View.GONE);
        cylinder.setVisibility(View.GONE);
        speed.setVisibility(View.VISIBLE);
        distance.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
        density.setVisibility(View.VISIBLE);
        force.setVisibility(View.VISIBLE);
    }
}