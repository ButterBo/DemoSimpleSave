package sg.edu.rp.c346.id21044912.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Step 1: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Step 2: Create a SharedPreferences Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 3: Set a key-value pair in the editor
        prefEdit.putString("greetings","Hello!");
        //Step 4 call commit() to save changes made to SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*
        Original
        String msg = "No greetings!";
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
         */
        //Step1: obtain SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Step2: Retrieve saved data from SharedPreferences with a default value if no matching data
        String msg = prefs.getString("greetings", "No greetings name");
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

    }
}