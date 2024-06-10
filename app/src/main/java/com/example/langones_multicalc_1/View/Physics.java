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

public class Physics extends AppCompatActivity {

    TextView k1,k2,k3,answer;
    EditText phyInput, phyInput2;
    Button calculate;

    Controller controller = new Controller();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.physics);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        k1 = findViewById(R.id.k1);
        k2 = findViewById(R.id.k2);
        k3 = findViewById(R.id.k3);
        phyInput = findViewById(R.id.phyinput);
        phyInput2 = findViewById(R.id.phyinput2);
        answer = findViewById(R.id.answer);
        calculate = findViewById(R.id.button);

        Intent object = getIntent();
        String concept = object.getStringExtra("concept");

        calculate.setOnClickListener(v -> {
            double k1 = Double.parseDouble(phyInput.getText().toString());
            double k2 = Double.parseDouble(phyInput2.getText().toString());
            controller.physics(k1, k2, concept);
            controller.physicsAnswer(answer);
        });

        controller.physicsResult(k1, k2, k3, concept);
    }
}
