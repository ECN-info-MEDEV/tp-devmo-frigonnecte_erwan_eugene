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

import edu.devmo.frigonnecte.R;
import edu.devmo.frigonnecte.databinding.FragmentCalendrierBinding;
import edu.devmo.frigonnecte.ui.recettes.RecettesFragment;

public class CalendrierFragment extends Fragment {

    private FragmentCalendrierBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalendrierViewModel calendrierViewModel =
                new ViewModelProvider(this).get(CalendrierViewModel.class);

        binding = FragmentCalendrierBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView m1View = getView().findViewById(R.id.matinJour1);
        m1View.setImageResource(R.drawable.plus);
        ImageView m2View = getView().findViewById(R.id.matinJour2);
        m2View.setImageResource(R.drawable.plus);
        ImageView m3View = getView().findViewById(R.id.matinJour3);
        m3View.setImageResource(R.drawable.plus);
        Log.i("Calendrier", "onViewCreated");
    }

    public static CalendrierFragment newInstance() {
        Log.i("newnew", "c'est new, mais calendrier");
//        Log.i("thisid", (String) vButton.getText());
//        vButton.setVisibility(View.VISIBLE);
        return new CalendrierFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}