package com.example.langones_multicalc_1.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.langones_multicalc_1.Controller.Controller;
import com.example.langones_multicalc_1.R;

import java.util.Objects;

public class Geometry extends AppCompatActivity {

    TextView shapeName, j1, j2, j3, j4, j5, area, vol;
    EditText geoInput, geoInput2, geoInput3;
    Button calculate;

    Controller controller = new Controller();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.geometry);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        shapeName = findViewById(R.id.shapeName);
        j1 = findViewById(R.id.j1);
        j2 = findViewById(R.id.j2);
        j3 = findViewById(R.id.j3);
        j4 = findViewById(R.id.j4);
        j5 = findViewById(R.id.j5);
        area = findViewById(R.id.areaanswer);
        vol = findViewById(R.id.volanswer);
        geoInput = findViewById(R.id.geoinput);
        geoInput2 = findViewById(R.id.geoinput2);
        geoInput3 = findViewById(R.id.geoinput3);
        calculate = findViewById(R.id.calculate);

        Intent object = getIntent();
        String Shape = object.getStringExtra("shape");

        calculate.setOnClickListener(v -> {
            double j1 = Double.parseDouble(geoInput.getText().toString());
            double j2 = Double.parseDouble(geoInput2.getText().toString());
            double j3 = Double.parseDouble(geoInput3.getText().toString());
            controller.geometry(j1 ,j2, j3, Shape);
            controller.geometryAnswer(area, vol);
        });

        controller.geometryResult(shapeName, j1, j2, j3, Shape, geoInput2, geoInput3);
    }
}
