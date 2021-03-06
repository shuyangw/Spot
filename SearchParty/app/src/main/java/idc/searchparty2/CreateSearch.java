package idc.searchparty2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 *  This class serves as the class for an intermediary page between the landing page and the map
 *  page. It prompts the user to input a nickname which the application will use to help distinguish
 *  between team members. Afterwards, a group and connetion will be created, awaiting other members
 *  to join.
 */
public class CreateSearch extends AppCompatActivity {
    /**
     *  This String serves as the unique identifier of the intent data passed from the Create Search
     *  screen to the map screen.
     */
    public static final String MESSAGE_NAME = "NAME";

    /**
     *  This method is called when the object is initialized. It initializes the .xml file that
     *  contains the GUI layout of the page and references to appropriate text instructions. Also
     *  initializes the Android back button which takes the user back to the landing page specified
     *  in the ../../manifests/AndroidManifest.xml file.
     *
     * @param savedInstanceState    Default argument passed into the <code> onCreate() </code>
     *                              method. Used to restore the object to a previous state using
     *                              the data in the <code> Bundle </code> object.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     *  This method is executed when the Create button is pressed at the bottom right. It will first
     *  read the text that the user put into the nickname text field, specify that the application
     *  will be entering the map from a Create Search page, and the method will introduce a new
     *  Intent and start the map activity.
     *
     *  The first value of the <code> name_desc </code> array is crucial as it determines whether
     *  the application of the user's phone will listen for existing connections or start a
     *  connection of its own. Specifically, the application will listen for other connections if
     *  the first value is "0" and search for other connections if the value is "1".
     *
     * @param view  Default argument passed into the <code> createButtonPress </code> and specifies
     *              the current display viewed by the user.
     */
    public void createButtonOnPress(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        EditText nickTextField = (EditText) findViewById(R.id.nickPrompt);
        String[] name_desc = {
                "0",
                nickTextField.getText().toString()
        };

        intent.putExtra(MESSAGE_NAME, name_desc);
        startActivity(intent);
    }
}
