package edu.devmo.frigonnecte.ui.recettes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.devmo.frigonnecte.databinding.FragmentRecettesBinding;

public class RecettesFragment extends Fragment {

    private FragmentRecettesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecettesViewModel recettesViewModel =
                new ViewModelProvider(this).get(RecettesViewModel.class);

        binding = FragmentRecettesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRecettes;
        recettesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}