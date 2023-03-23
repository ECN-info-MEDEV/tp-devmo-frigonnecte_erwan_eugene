package edu.devmo.frigonnecte;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.devmo.frigonnecte.databinding.ActivityMainBinding;
import edu.devmo.frigonnecte.ui.calendrier.CalendrierFragment;
import edu.devmo.frigonnecte.ui.recettes.RecettesFragment;
import edu.devmo.frigonnecte.ui.recettes.Recipe;
import edu.devmo.frigonnecte.ui.recettes.RecipeListAdapter;
import edu.devmo.frigonnecte.ui.recettes.RecipeViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final int TEXT_REQUEST = 1;
    private static boolean addToCalendar = false;
    private ImageView calendarButton;
    private NavController navController;

    private edu.devmo.frigonnecte.databinding.ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private BottomNavigationView navView;

    private String selectedRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        // Database
//        RecipeViewModel mRecipeViewModel;
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerview);
//        final RecipeListAdapter adapter = new RecipeListAdapter(new RecipeListAdapter.RecipeDiff());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        mRecipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
//        mRecipeViewModel.getAllRecipes().observe(this, recipes -> {
//            // Update the cached copy of the words in the adapter.
//            adapter.submitList(recipes);
//        });
//        // End of Database

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_frigo, R.id.navigation_calendrier, R.id.navigation_recettes)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart_second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume_second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause_second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop_second");
    }

    public void clickImage(View view) {

        navController.navigate(R.id.navigation_recettes);
        calendarButton = findViewById(view.getId());
    }


    public void clickImage2(View view) {

        calendarButton = findViewById(view.getId());
        calendarButton.setImageResource(R.drawable.recette3);

    }
    public void addRecette(View view) {
        navController.popBackStack();
    }
    public void selectRecipe(View view) {
        selectedRecipe = ((Button) view).getText().toString();
        System.out.println("Vous avez cliqué sur :");
        System.out.println(selectedRecipe);
        CalendrierFragment.newInstance().addRecipe("Mardi", "midi", new Recipe("Couscous"));
    }
}