package edu.devmo.frigonnecte;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.devmo.frigonnecte.databinding.ActivityMainBinding;
import edu.devmo.frigonnecte.ui.calendrier.CalendrierFragment;
import edu.devmo.frigonnecte.ui.recettes.RecettesFragment;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private static boolean addToCalendar = false;
    private ImageView calendarButton;
    private NavController navController;

    private edu.devmo.frigonnecte.databinding.ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

    public void clickImage(View view) {

        navController.navigate(R.id.navigation_recettes);
//        navController.navigateUp();
//        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);


        calendarButton = findViewById(view.getId());
//
//        addToCalendar = true;
//
//        // Instantiate the fragment.
//        RecettesFragment recettesFragment = RecettesFragment.newInstance();
//        // Get the FragmentManager and start a transaction.
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager
//                .beginTransaction();
//
//        // Add the SimpleFragment.
//        fragmentTransaction.replace(R.id.container,
//                recettesFragment).addToBackStack("searchRecipeFromCalendar").commit();

        Log.i("oui", "c'est oui");
    }

    public void addRecette(View view) {

        Log.i("le calendrier", String.valueOf(calendarButton.getId()));
        calendarButton.setImageResource(R.drawable.entonnoir_dev);
        Log.i("retour", "recettes");
        navController.popBackStack();
//        if (addToCalendar) {
//
//            Log.i("calendar", "toCalendar");
//
//            Log.i("test", String.valueOf(calendarButton.getId()));
//            // Instantiate the fragment.
//            CalendrierFragment calendrierFragment = CalendrierFragment.newInstance();
//            // Get the FragmentManager and start a transaction.
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager
//                    .beginTransaction();
//                fragmentTransaction.replace(R.id.container,
//                        calendrierFragment).addToBackStack("addRecipeToCalendar").commit();
//
//
////            // Update the Button text.
////            mButton.setText(R.string.open);
////            // Set boolean flag to indicate fragment is closed.
////            isFragmentDisplayed = false;
//        }
    }
}