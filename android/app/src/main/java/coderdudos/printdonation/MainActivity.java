package coderdudos.printdonation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import coderdudos.printdonation.connection.Connection;
import coderdudos.printdonation.connection.ConnectionMessages;
import coderdudos.printdonation.uielements.listviewadapters.ModelAdapter;

public class MainActivity extends AppCompatActivity implements Observer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connection.getInstance().addObserver(this);

        ListView modelList = (ListView) findViewById(R.id.modelList);
        modelList.setAdapter(new ModelAdapter(getLayoutInflater().getContext()));
        modelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getLayoutInflater().getContext(), ViewModel.class);
                Bundle b = new Bundle();
                ModelAdapter.ModelData data = (ModelAdapter.ModelData) parent.getAdapter().getItem(position);
                b.putLong("id", id);
                b.putString("name", data.getModelName());
                b.putFloat("price", data.getPrice());
                intent.putExtras(b);
                startActivity(intent);
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

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public void update(Observable observable, final Object data) {
        if((ConnectionMessages.valueOf((String) data).equals(ConnectionMessages.CONNECTED))) {
            Log.d("Update", "chegou ao update");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
