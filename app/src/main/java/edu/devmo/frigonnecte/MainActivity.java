package edu.devmo.frigonnecte;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.devmo.frigonnecte.databinding.ActivityMainBinding;
import edu.devmo.frigonnecte.ui.recettes.RecipeListAdapter;
import edu.devmo.frigonnecte.ui.recettes.RecipeViewModel;

public class MainActivity extends AppCompatActivity {

    private String selectedRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        edu.devmo.frigonnecte.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Database
        RecipeViewModel mRecipeViewModel;

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final RecipeListAdapter adapter = new RecipeListAdapter(new RecipeListAdapter.RecipeDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        mRecipeViewModel.getAllRecipes().observe(this, recipes -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(recipes);
        });
        // End of Database

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_frigo, R.id.navigation_calendrier, R.id.navigation_recettes)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void clickImage(View view) {
        Log.i("oui", "c'est oui");
    }

    public void selectRecipe(View view) {
        selectedRecipe = ((Button) view).getText().toString();
        System.out.println(selectedRecipe);
    }
}