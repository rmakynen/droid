package tol.oulu.fi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
    protected int bigInt = 0;
    protected int addThis = 0;
    protected int internalMemory = 0;
    protected TextView totalSum;

    //Options
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int item_id = item.getItemId();
        if (item_id == R.id.firstMenuItem)
        {
            bigInt = 0;
            totalSum = (TextView) findViewById(R.id.totalSum);
            String temp_str = "Calculator was reset";
            totalSum.setText(temp_str);
        }
        else if (item_id == R.id.secondMenuItem)
        {
            internalMemory = bigInt;
        }
        else if (item_id == R.id.thirdMenuItem)
        {
            bigInt = internalMemory;
            totalSum = (TextView) findViewById(R.id.totalSum);
            String temp_str = String.valueOf(bigInt);
            totalSum.setText(temp_str);
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //Listener for the activity
    @Override
    public void onClick(View view)
    {
        int btnID = view.getId();

        if (btnID == R.id.btn1)
        {
            addThis = 1;
        }
        else if (btnID == R.id.btn2)
        {
            addThis = 2;
        }
        else if (btnID == R.id.btn3)
        {
            bigInt += addThis;
            addThis = 0;
            totalSum = (TextView) findViewById(R.id.totalSum);
            String temp_str = String.valueOf(bigInt);
            totalSum.setText(temp_str);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(this);
        button = findViewById(R.id.btn2);
        button.setOnClickListener(this);
        button = findViewById(R.id.btn3);
        button.setOnClickListener(this);
    }
}