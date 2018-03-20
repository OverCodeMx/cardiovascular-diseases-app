package mx.overcode.sintomasapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;

import com.github.channguyen.rsv.RangeSliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.overcode.sintomasapp.adapters.SintomasRecyclerViewAdapter;
import mx.overcode.sintomasapp.models.Enfermedad;
import mx.overcode.sintomasapp.models.Sintoma;

public class MainActivity extends AppCompatActivity {

    List<Enfermedad> allDiseases;
    List<Sintoma> sintomasList;
    RecyclerView rvSintomas;
    SintomasRecyclerViewAdapter recyclerViewAdapter;
    boolean isSelectingDiseases = false;

    double[] sintomas = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSintomas = findViewById(R.id.rvSintomas);
        rvSintomas.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setAutoMeasureEnabled(true);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSintomas.setHasFixedSize(true);
        rvSintomas.setLayoutManager(mLayoutManager);
        rvSintomas.setNestedScrollingEnabled(false);

        Enfermedad disease1 = new Enfermedad(1, "Ataque cardíaco o infarto", new double[] {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0});
        Enfermedad disease2 = new Enfermedad(2, "Presión arterial alta o hipertensión", new double[] {1,0,1,0,0,1,1,1,0,0,0,0,0,0,0});
        Enfermedad disease3 = new Enfermedad(3, "Angina de pecho", new double[] {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0});
        Enfermedad disease4 = new Enfermedad(4, "Arritmia cardíaca", new double[] {1,0,1,1,1,1,0,0,0,0,0,0,0,0,0});
        Enfermedad disease5 = new Enfermedad(5, "Fibrilación auricular", new double[] {1,0,0,0,1,1,0,1,0,1,0,0,0,0,0});
        Enfermedad disease6 = new Enfermedad(6, "Insuficiencia o falla cardíaca", new double[] {1,0,1,0,1,0,0,1,0,1,1,0,0,0,0});
        Enfermedad disease7 = new Enfermedad(7, "Enfermedad Arterial Periférico", new double[] {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0});
        Enfermedad disease8 = new Enfermedad(8, "Síndrome metabólico", new double[] {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0});
        Enfermedad disease9 = new Enfermedad(9, "Cardiopatía coronaria", new double[] {1,0,1,0,1,0,0,0,0,0,0,0,0,1,0});
        Enfermedad disease10 = new Enfermedad(10, "Síndrome del corazòn roto", new double[] {1,0,1,1,0,0,0,0,0,0,0,0,0,0,1});

        allDiseases = Arrays.asList(disease1, disease2, disease3, disease4, disease5, disease6, disease7, disease8, disease9, disease10);

        Sintoma sintoma1 = new Sintoma(1, "¿Sientes alguna presión o dolor en el área del pecho o los brazos?", R.drawable.sintoma1_left, R.drawable.sintoma1_right);
        Sintoma sintoma2 = new Sintoma(2, "¿Sientes nauseas, indigestión, ardor de estómago o dolor abdominal?", R.drawable.sintoma2_left, R.drawable.sintoma2_right);
        Sintoma sintoma3 = new Sintoma(3, "Tienes falta de aire o dificultad para respirar", R.drawable.sintoma3_left, R.drawable.sintoma3_right);
        Sintoma sintoma4 = new Sintoma(4, "¿Sudas más de lo normal o sudas frío?", R.drawable.sintoma4_left, R.drawable.sintoma4_right);
        Sintoma sintoma5 = new Sintoma(5, "¿Te sientes más cansado de lo normal?", R.drawable.sintoma5_left, R.drawable.sintoma5_right);
        Sintoma sintoma6 = new Sintoma(6, "¿Tienes mareos?", R.drawable.sintoma6_left, R.drawable.sintoma6_right);
        Sintoma sintoma7 = new Sintoma(7, "¿Tienes dolores de cabeza?", R.drawable.sintoma7_left, R.drawable.sintoma7_right);
        Sintoma sintoma8 = new Sintoma(8, "¿Sientes palpitaciones irregulares en el área del corazón?", R.drawable.sintoma8_left, R.drawable.sintoma8_right);
        Sintoma sintoma9 = new Sintoma(9, "¿Tienes palidez?", R.drawable.sintoma9_left, R.drawable.sintoma9_right);
        Sintoma sintoma10 = new Sintoma(10, "¿Te sientes cansado para realizar alguna actividad física?", R.drawable.sintoma10_left, R.drawable.sintoma10_right);
        Sintoma sintoma11 = new Sintoma(11, "¿Tienes hinchazón en las piernas, tobillos o pies?", R.drawable.sintoma11_left, R.drawable.sintoma11_right);
        Sintoma sintoma12 = new Sintoma(12, "¿Sientes entumecimiento o debilidad den las piernas?", R.drawable.sintoma12_left, R.drawable.sintoma12_right);
        Sintoma sintoma13 = new Sintoma(13, "¿Tienes sed extrema?", R.drawable.sintoma13_left, R.drawable.sintoma13_right);
        Sintoma sintoma14 = new Sintoma(14, "¿Sientes pesadez o una compresión en el área del corazón?", R.drawable.sintoma14_left, R.drawable.sintoma14_right);
        Sintoma sintoma15 = new Sintoma(15, "¿Te sientes cansado sin algún motivo?", R.drawable.sintoma15_left, R.drawable.sintoma15_right);

        sintomasList = Arrays.asList(sintoma1, sintoma2, sintoma3, sintoma4, sintoma5, sintoma6, sintoma7, sintoma8, sintoma9, sintoma10, sintoma11, sintoma12, sintoma13, sintoma14, sintoma15);

        recyclerViewAdapter = new SintomasRecyclerViewAdapter(this, sintomasList, new SintomasRecyclerViewAdapter.OnItemValueChangeListener() {
            @Override
            public void onValueChange(int position, double value) {
                sintomas[position] = value;
            }

            @Override
            public void onCalculareGeneric() {
                calcularEnfermedades(allDiseases);
            }

            @Override
            public void onCalcularSpecific() {
                isSelectingDiseases = true;
                SelectDiseasesFragment routesListFragment = SelectDiseasesFragment.newInstance(allDiseases, diseasesSelected -> {

                    isSelectingDiseases = false;
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("TAG2");
                    if (fragment != null)
                        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                    recyclerViewAdapter.notifyDataSetChanged();
                    rvSintomas.scrollToPosition(0);

                    calcularEnfermedades(diseasesSelected);

                });
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.selectDiseaseFragment, routesListFragment, "TAG2");
                ft.commit();
            }
        });
        rvSintomas.setAdapter(recyclerViewAdapter);

    }

    private void calcularEnfermedades(List<Enfermedad> diseases){

        double[][] min = new double[diseases.size()][2];

        for (int i=0; i < diseases.size() - 1; i++) {

            Enfermedad enfermedad = diseases.get(i);

            double sumaMinimos = 0;

            for (int j=0; j < enfermedad.getMatrix().length; j++) {

                if (sintomas[j] <= enfermedad.getMatrix()[j]) {
                    sumaMinimos += sintomas[j];
                } else {
                    sumaMinimos += enfermedad.getMatrix()[j];
                }

            }

            min[i][0] = sumaMinimos;
            min[i][1] = enfermedad.getId();
        }

        double umbral = .4;

        double maximo = 0;
        for (int i=0; i < diseases.size() - 1; i++) {
            if (min[i][0] >= maximo) {
                maximo = min[i][0];
            }
        }

        ArrayList<String> diseasesDiagnosed = new ArrayList<>();

        if (maximo >= umbral) {
            for (int i=0; i < diseases.size() - 1; i++) {
                if (maximo == min[i][0]) {
                    int enfermedadId = (int)min[i][1];
                    for (Enfermedad enfermedad: diseases){
                        if(enfermedad.getId() == enfermedadId){
                            diseasesDiagnosed.add(enfermedad.getName());
                        }
                    }
                }
            }
        }

        String text = "";
        if(diseasesDiagnosed.size() > 0){
            String coincidencias = TextUtils.join(", ", diseasesDiagnosed);
            text = "Las enfermedades diagnosticadas son: " + coincidencias;
        }
        else{
            text = "No se encontraron coincidencias";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder.setMessage(text)
                .setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if(isSelectingDiseases){
            Fragment fragment = getSupportFragmentManager().findFragmentByTag("TAG2");
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        else{
            super.onBackPressed();
        }

    }

}
