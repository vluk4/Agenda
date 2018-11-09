package br.com.alura.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.modelo.Prova;

public class ProvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);

        List<String> conteudoM = Arrays.asList("Trigonometria","Matrizes", "Logaritimos");
        Prova provaMatematica = new Prova("Matemática", "08/11/2018", conteudoM);

        List<String> conteudoH = Arrays.asList("Inquisisão Espanhola", "Guerra Fria", "Globalização");
        Prova provaHistoria = new Prova("Historia", "12/11/2018", conteudoH);

        List<Prova> provas = Arrays.asList(provaMatematica, provaHistoria);

        ArrayAdapter<Prova> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, provas);

        ListView lista = findViewById(R.id.prova_lista);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Prova prova = (Prova) adapterView.getItemAtPosition(i);
                Toast.makeText(ProvaActivity.this, "Clicou na prova de " + prova, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
