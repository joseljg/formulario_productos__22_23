package es.joseljg.formularioproductos2223;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import es.joseljg.formularioproductos2223.clases.Producto;

public class MainActivity extends AppCompatActivity {

    private Producto producto = null;
    private EditText edt_identificador_producto = null;
    private EditText edt_nombre_cliente = null;
    private EditText edt_direccion_envio = null;
    private EditText edt_telefono = null;
    private String tipoEnvio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_identificador_producto = (EditText) findViewById(R.id.edt_identificador_producto);
        edt_nombre_cliente = (EditText) findViewById(R.id.edt_nombre_cliente);
        edt_direccion_envio = (EditText) findViewById(R.id.edt_direccion_envio);
        edt_telefono = (EditText) findViewById(R.id.edt_telefono);
        tipoEnvio = "normal";
    }

    public void enviar(View view) {
        String identificadorp = String.valueOf(edt_identificador_producto.getText());
        String nombrec = String.valueOf(edt_nombre_cliente.getText());
        String direccione = String.valueOf(edt_direccion_envio.getText());
        String telefonoc = String.valueOf(edt_telefono.getText());
        producto = new Producto(identificadorp,nombrec,direccione,telefonoc,tipoEnvio);
        Toast.makeText(this,producto.toString(),Toast.LENGTH_LONG).show();
        Log.i("envio",tipoEnvio);
    }

    public void cambiar_precio_envio(View view) {
        RadioButton rb1 = (RadioButton) view;
        if(rb1.isChecked()) {
            switch (rb1.getId()) {
                case R.id.rb_opcion_urgente:
                    tipoEnvio = "urgente";
                    break;
                case R.id.rb_opcion_normal:
                    tipoEnvio = "normal";
                    break;
                case R.id.rb_opcion_lento:
                    tipoEnvio = "lento";
            }
        }
    }
}