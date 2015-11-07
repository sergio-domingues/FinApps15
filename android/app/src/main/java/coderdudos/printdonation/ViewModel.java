package coderdudos.printdonation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewModel extends AppCompatActivity {


    private int id;
    private String name;
    private float price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        name = b.getString("name");
        price = b.getFloat("price");

        TextView modelName = (TextView) findViewById(R.id.model_name);
        modelName.setText(name + "");

        Button purchaseButton = (Button) findViewById(R.id.purchaseModelbutton);
        purchaseButton.setText(price + "€");
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getLayoutInflater().getContext(), PurchaseModel.class);
                Bundle b = new Bundle();
                b.putLong("id", id);
                b.putString("name", name);
                b.putFloat("price", price);
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_model, menu);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
