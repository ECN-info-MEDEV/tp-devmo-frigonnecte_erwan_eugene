package edu.devmo.frigonnecte.ui.recettes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import edu.devmo.frigonnecte.R;
import edu.devmo.frigonnecte.databinding.FragmentRecettesBinding;

public class RecettesFragment extends Fragment {

    private FragmentRecettesBinding binding;

    private static Button vButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecettesViewModel recettesViewModel =
                new ViewModelProvider(this).get(RecettesViewModel.class);

//        if (displayVButton) {
            View rootView = inflater.inflate(R.layout.fragment_recettes, container, false);
            vButton = (Button)rootView.findViewById(R.id.validate_recettes);

//            vButton = requireActivity().findViewById(R.id.validate_recettes);
            Log.i("thisid", String.valueOf(vButton.getText()));
            vButton.setVisibility(View.VISIBLE);
            Log.i("mon taff", "c'est fait");
//        }

        binding = FragmentRecettesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Log.i("rfrag", "création recettes fragment");

        final TextView textView = binding.textRecettes;
        recettesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Database
        RecipeViewModel mRecipeViewModel;

        RecyclerView recyclerView = requireView().findViewById(R.id.recyclerview);
        final RecipeListAdapter adapter = new RecipeListAdapter(new RecipeListAdapter.RecipeDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        // Update the cached copy of the words in the adapter.
        mRecipeViewModel.getAllRecipes().observe(getViewLifecycleOwner(), adapter::submitList);
        // End of Database
    }

    public static RecettesFragment newInstance() {
        Log.i("newnew", "c'est new");
//        Log.i("thisid", (String) vButton.getText());
//        vButton.setVisibility(View.VISIBLE);
        return new RecettesFragment();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}