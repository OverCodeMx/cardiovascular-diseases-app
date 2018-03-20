package mx.overcode.sintomasapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import mx.overcode.sintomasapp.adapters.EnfermedadesRecyclerViewAdapter;
import mx.overcode.sintomasapp.adapters.SintomasRecyclerViewAdapter;
import mx.overcode.sintomasapp.models.Enfermedad;

/**
 * Created by aldo on 3/17/18.
 */

public class SelectDiseasesFragment extends Fragment {

    List<Enfermedad> diseases = new ArrayList<>();
    List<Enfermedad> diseasesSelected = new ArrayList<>();
    EnfermedadesRecyclerViewAdapter recyclerViewAdapter;
    OnSelectDiseasesListener listener;

    public interface OnSelectDiseasesListener {
        // This can be any number of events to be sent to the activity
        void onContinue(List<Enfermedad> diseasesSelected);
    }

    public static SelectDiseasesFragment newInstance(List<Enfermedad> enfermedads, OnSelectDiseasesListener listener) {
        SelectDiseasesFragment fragmentDemo = new SelectDiseasesFragment();
        fragmentDemo.diseases = enfermedads;
        fragmentDemo.listener = listener;
        Bundle args = new Bundle();
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_select_diseases, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        RecyclerView rvRoutesList = view.findViewById(R.id.rvDiseases);
        Button btnContinue = view.findViewById(R.id.btnContinue);

        rvRoutesList.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setAutoMeasureEnabled(true);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRoutesList.setHasFixedSize(true);
        rvRoutesList.setLayoutManager(mLayoutManager);

        recyclerViewAdapter = new EnfermedadesRecyclerViewAdapter(getActivity(), diseases, new EnfermedadesRecyclerViewAdapter.OnItemListener() {
            @Override
            public void onCheckboxChange(int position, boolean b) {
                Enfermedad enfermedad = diseases.get(position);

                if(b){
                    diseasesSelected.add(enfermedad);
                }
                else{
                    diseasesSelected.remove(enfermedad);
                }

            }
        });
        rvRoutesList.setAdapter(recyclerViewAdapter);


        btnContinue.setOnClickListener(view1 -> {
            listener.onContinue(diseasesSelected);
        });


    }


}
