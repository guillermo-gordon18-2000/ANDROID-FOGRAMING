package com.example.frograming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.frograming.Adaptadores.OpcionesListViewAdapter;
import com.example.frograming.Entidades.OpcionesMenu;
import com.example.frograming.Adaptadores.OpcionesListViewAdapter;
import com.example.frograming.Entidades.OpcionesMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipalActivity extends AppCompatActivity {

    private OpcionesMenu opcionesMenu;
    ListView lstOpciones;
    List<OpcionesMenu> templist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        InicializarControles();
        PopularDatos(getIntent().getExtras());
        AttachtEvent();
    }

    private void InicializarControles() {
        lstOpciones = (ListView)findViewById(R.id.lstOpciones);
        CargarListView();
    }

    private void PopularDatos(Bundle datos) {
        if(datos!= null){
            opcionesMenu = new OpcionesMenu(
                    datos.getString("nombre"),
                    R.drawable.logo
            );
            AnadirNuevoElementoLista(opcionesMenu);
        }
        else{
        }
    }

    private void AnadirNuevoElementoLista(OpcionesMenu opcionesMenu) {
        List<OpcionesMenu> listaVieja = ObtenerOpciones();
        listaVieja.add(opcionesMenu);
        templist = listaVieja;
        OpcionesListViewAdapter adapterActualizado = new OpcionesListViewAdapter(this, listaVieja);
        lstOpciones.setAdapter(adapterActualizado);
    }

    private void AttachtEvent() {
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> datos, View view, int pos, long l) {
                List<OpcionesMenu> opciones = templist;
                int opcion;
                if(opciones.get(pos).getOpcionNombre()=="Leccion"){
                    opcion=0;
                    tematicaSeleccionada(opcion);
                    Toast.makeText(getApplicationContext() , "Has seleccionado la opcion " +opciones.get(pos).getOpcionNombre(),Toast.LENGTH_LONG).show();
                }
                else if(opciones.get(pos).getOpcionNombre()=="Jugar"){
                    opcion=1;
                    tematicaSeleccionada(opcion);
                    Toast.makeText(getApplicationContext() , "Has seleccionado la opcion "  +opciones.get(pos).getOpcionNombre(),Toast.LENGTH_LONG).show();
                }
                else if(opciones.get(pos).getOpcionNombre()=="Ranking"){
                    opcion=2;
                    tematicaSeleccionada(opcion);
                    Toast.makeText(getApplicationContext() , "Has seleccionado la opcion "  +opciones.get(pos).getOpcionNombre(),Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext() , "Has seleccionado la opcion "+opciones.get(pos).getOpcionNombre() ,Toast.LENGTH_LONG).show();
                OpcionesListViewAdapter adapterActualizado = new OpcionesListViewAdapter(getApplicationContext(),opciones);
                lstOpciones.setAdapter(adapterActualizado);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.botonHome:
                startActivity(new Intent(this,MenuPrincipalActivity.class));
                break;
            case R.id.verPerfil:
                startActivity(new Intent(this,EditarPerfilActivity.class));
                //startActivity(new Intent(this,VerPerfilActivity.class));
                break;
            case R.id.botonSalir:
                startActivity(new Intent(this,InicioSesionActivity.class));
                break;
            default:
                break;
        }

        return true;
    }

    public boolean tematicaSeleccionada(int opcion){
        switch (opcion){
            case 0:
                startActivity(new Intent(this, RegistroActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, RegistroActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, RegistroActivity.class));
                break;
            default:
                return true;
        }
        return true;
    }

    private void CargarListView() {
        List<OpcionesMenu> optMenu = this.ObtenerOpciones();
        templist = optMenu;
        OpcionesListViewAdapter adapter = new OpcionesListViewAdapter(this, optMenu);
        lstOpciones.setAdapter(adapter);
    }

    private List<OpcionesMenu> ObtenerOpciones() {
        List<OpcionesMenu> optMenu = new ArrayList<OpcionesMenu>();
        optMenu.add(new OpcionesMenu("Lección", R.drawable.leccion));
        optMenu.add(new OpcionesMenu("Jugar", R.drawable.jugar));
        optMenu.add(new OpcionesMenu("Ranking", R.drawable.ranking));
        return optMenu;
    }

    public void verPerfil(View v){
        startActivity(new Intent(this, VerPerfilActivity.class));
    }

}