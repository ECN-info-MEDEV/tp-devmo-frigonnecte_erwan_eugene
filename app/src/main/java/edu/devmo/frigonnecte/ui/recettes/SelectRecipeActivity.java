package edu.devmo.frigonnecte.ui.recettes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.devmo.frigonnecte.R;

public class SelectRecipeActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.recipelistsql.REPLY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_recipe);

        final Button button = findViewById(R.id.button_select);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(button.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
                System.out.println("pas de texte ...");
            } else {
                String recipe = button.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, recipe);
                setResult(RESULT_OK, replyIntent);
                System.out.println("activity ok");
            }
            finish();
        });
    }
}
