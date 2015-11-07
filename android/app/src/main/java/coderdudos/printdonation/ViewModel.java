package coderdudos.printdonation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import coderdudos.printdonation.connection.DownloadPhoto;
import coderdudos.printdonation.connection.StoredBmp;

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

        ImageView image = (ImageView) findViewById(R.id.imageView);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        ImageView image4 = (ImageView) findViewById(R.id.imageView4);

        StoredBmp bmp1 = new StoredBmp(null);
        StoredBmp bmp2 = new StoredBmp(null);
        StoredBmp bmp3 = new StoredBmp(null);
        StoredBmp bmp4 = new StoredBmp(null);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        DownloadPhoto.downloadPhoto(image, viewGroup, name + "0", bmp1);
        DownloadPhoto.downloadPhoto(image2, viewGroup, name + "1", bmp2);
        DownloadPhoto.downloadPhoto(image3, viewGroup, name + "2", bmp3);
        DownloadPhoto.downloadPhoto(image4, viewGroup, name + "3", bmp4);


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
