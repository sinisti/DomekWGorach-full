package com.example.domekwgorach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView likes;
    private Button like;
    private Button save;
    private Button delete;
    private int likesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // This should be called before findViewById

        // Initialize views after setContentView
        like = findViewById(R.id.like);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        likes = findViewById(R.id.likes);

        // Enable Edge-to-Edge UI (assuming you have the setup for this)
        EdgeToEdge.enable(this);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up the button click listener
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liked();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleted();
            }
        });
    }

    void liked(){
       likesi++;
       likes.setText(likesi + " polubień.");
    }
    void deleted(){
        likesi--;
        likes.setText(likesi + " polubień.");
    }
}