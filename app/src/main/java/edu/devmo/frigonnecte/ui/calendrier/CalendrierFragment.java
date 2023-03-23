package edu.devmo.frigonnecte.ui.calendrier;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.devmo.frigonnecte.R;
import edu.devmo.frigonnecte.databinding.FragmentCalendrierBinding;
import edu.devmo.frigonnecte.ui.recettes.RecettesFragment;
import edu.devmo.frigonnecte.ui.recettes.Recipe;
import edu.devmo.frigonnecte.ui.recettes.RecipeListAdapter;
import edu.devmo.frigonnecte.ui.recettes.RecipeViewModel;

public class CalendrierFragment extends Fragment {
    CalendrierViewModel calendrierViewModel;
    private FragmentCalendrierBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendrierViewModel =
                new ViewModelProvider(this).get(CalendrierViewModel.class);

        binding = FragmentCalendrierBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Database
        TimeSlotViewModel mTimeSlotViewModel;
        mTimeSlotViewModel = new ViewModelProvider(this).get(TimeSlotViewModel.class);

        // End of Database

        ImageView m1View = getView().findViewById(R.id.matinJour1);
        String recipe = mTimeSlotViewModel.getWithDayTime("Lundi", "midi");
        if (recipe == null) {
            m1View.setImageResource(R.drawable.plus);
        } else {
            switch (recipe) {
                case "Pâtes bolo":
                    m1View.setImageResource(R.drawable.recette1);
                    break;
                case "Soupe aux légumes":
                    m1View.setImageResource(R.drawable.recette2);
                    break;
                default:
                    m1View.setImageResource(R.drawable.plus);
            }
        }

        ImageView m2View = getView().findViewById(R.id.matinJour2);
        System.out.println(mTimeSlotViewModel.getWithDayTime("Mardi", "midi"));
        m2View.setImageResource(R.drawable.plus);

        ImageView m3View = getView().findViewById(R.id.matinJour3);
        System.out.println(mTimeSlotViewModel.getWithDayTime("Mercredi", "midi"));
        m3View.setImageResource(R.drawable.plus);
        Log.i("Calendrier", "onViewCreated");
    }

    public static CalendrierFragment newInstance() {
        return new CalendrierFragment();
    }

    public void addRecipe(String day, String time, Recipe recipe){
        TimeSlotViewModel.addRecipeInCalendar(day, time, recipe);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}