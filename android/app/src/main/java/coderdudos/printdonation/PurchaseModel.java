package coderdudos.printdonation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devmarvel.creditcardentry.library.CreditCard;
import com.devmarvel.creditcardentry.library.CreditCardForm;

public class PurchaseModel extends AppCompatActivity {

    private LinearLayout linearLayout;
    private CreditCardForm form;
    private int id;
    private String name;
    private float price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_model);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        name = b.getString("name");
        price = b.getFloat("price");

        linearLayout = (LinearLayout) findViewById(R.id.formLayer);

        form = (CreditCardForm) findViewById(R.id.credit_card_form);

        TextView modelName = (TextView) findViewById(R.id.model_name);
        modelName.setText(name);

        TextView priceView = (TextView) findViewById(R.id.price);
        priceView.setText(price + "€");

        Button buttonAuthorize = (Button) findViewById(R.id.buttonAuthorize);
        buttonAuthorize.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (form.isCreditCardValid()) {
                    CreditCard card = form.getCreditCard();
                    Toast.makeText(getApplicationContext(), "Success!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Credit Card information no valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_purchase_model, menu);
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
