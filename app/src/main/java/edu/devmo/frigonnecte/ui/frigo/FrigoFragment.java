package edu.devmo.frigonnecte.ui.frigo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.devmo.frigonnecte.databinding.FragmentFrigoBinding;

public class FrigoFragment extends Fragment {

    private FragmentFrigoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FrigoViewModel frigoViewModel =
                new ViewModelProvider(this).get(FrigoViewModel.class);

        binding = FragmentFrigoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFrigo;
        frigoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}