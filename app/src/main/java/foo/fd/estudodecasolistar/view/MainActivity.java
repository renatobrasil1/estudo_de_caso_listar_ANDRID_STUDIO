package foo.fd.estudodecasolistar.view;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.net.HttpURLConnection;
import java.net.URL;

import foo.fd.estudodecasolistar.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListarEstadosAsyncTask task  = new ListarEstadosAsyncTask("fabricadedesenvolvedor");

        task.execute();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

         // criando uma classe assicrona

    public class ListarEstadosAsyncTask
            extends
            AsyncTask<String, String, String> {

        String api_token;

        HttpURLConnection conn;
        URL url = null;
        Uri.Builder builder;

        final String URL_WEB_SERVICE = "http://192.168.1.7/Documents/cursoudemyweb/APIListarEstados.php";
        final int READ_TIMEOUT = 10000; // MILISSEGUNDOS
        final int CONNECTION_TIMEOUT = 30000;
        public ListarEstadosAsyncTask(String token){
            this.api_token = token;
            this. builder = new Uri.Builder();
            builder.appendQueryParameter("api_token",api_token);

            

        }

        @Override
        protected void onPreExecute(){

            Log.i("APIListar","onPreExecute()");

        }

        @Override
        protected String doInBackground(String... strings) {

            Log.i("APIListar","doInBackground()");
            return "Processado com sucesso";

        }

        @Override
        protected void onPostExecute(String result){

            Log.i("APIListar","onPostExecute()-----> Result "+ result );

        }
    }

}
