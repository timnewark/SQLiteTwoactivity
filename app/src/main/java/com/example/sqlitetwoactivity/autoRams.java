
package com.example.sqlitetwoactivity;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Locale;

public class autoRams extends AppCompatActivity{

    // references to buttons/arrays and other controls on the layout. Need to be here to be accessible throughout
    // references
    String[] examinerNames = {"TN","KA","GD","AT","RGS","PJ"};
    String[] weather = {"Rain ","Rain - heavy ","Sunny ","Mild "};

    private CheckBox mWorkingAtHeight, mFallingObjects, mAccessToSite, mTM, mLiftingOperations, mLiveElectric, mEnvironmental, mLoneWorking, mUnfamiliarStructure;
    //private Button finalDoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dateAndTimeAdd();
        setContentView(R.layout.activity_autorams);
        //gets the searchTerm string
        Intent myIntent = getIntent();
        String IDtosearchfromIntent = getIntent().getStringExtra("nameString");
        //Toast.makeText(getApplicationContext(), myIntent.getStringExtra("username")), Toast.LENGTH_SHORT.show();
        //Toast.makeText(this, "Intent:"+this.getIntent().getExtras().getString("nameString"),Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "Intent:"+myIntent.getExtras().getString("nameString"),Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "IntentOtherWOrk"+ myIntent.getStringExtra("username"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "EditTextWork"+ myIntent.getStringExtra("nameString"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "IDtoSearch: "+ IDtosearchfromIntent, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), myIntent.getStringExtra("username")), Toast.LENGTH_SHORT.show();
        //Toast.makeText(getApplicationContext(), myIntent.getStringExtra("nameString")), Toast.LENGTH_SHORT.show();
        //Toast.makeText(this,"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        Log.i("INTENT INFO " , myIntent.getStringExtra("nameString"));
        Log.i("INTENT INFO " , myIntent.getStringExtra("username"));
        //Log.i("VAR " , IDtosearch);


        Toast.makeText(this, "IDtoSearch: "+ IDtosearchfromIntent, Toast.LENGTH_SHORT).show();

        //searchNumber varSendToSetter = new searchNumber(nameString2); //SENDS NAMESTRING TO searchNumber.class
        //varSendToSetter.setSearchNumber(nameString2); // Set the value of the setSearchNumber variable to "user inputted value of nameString
        //searchNumber varGotFromGetter = new searchNumber(nameString2);
        //String gotFromGetter = "sdgdsg";
        //String newString = varSendToSetter.getSearchNumber();
        //Toast.makeText(this, "THIS:"+ newString,Toast.LENGTH_SHORT).show();

       //String returnedFromGetter =  varSendToSetter.getSearchNumber();
        //all update code here. get from database. the code is in IDtosearch which is in a string
        //you want to open the database, find the relevant id and then update
       // DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
       //SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        // dont think its this: // Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age = IDtosearch", null);
       // Cursor queryString = db.rawQuery("SELECT * FROM users WHERE age = IDtosearch", null);
       // Log.i("QueryString " , queryString.toString());
       // if (cursor.moveToFirst()){
       //     return true;
      //  }
       // else {
       //     return false;
       // }

        //end of updated code.

        //below block of code just does the automatic date/time autofill
        EditText autoDate = (EditText)findViewById(R.id.EditTextDate);
        EditText autoTime = (EditText)findViewById(R.id.EditTextTime);

        SimpleDateFormat dateF = new SimpleDateFormat("E D/M/y", Locale.getDefault());
        SimpleDateFormat timeF = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String date = dateF.format(Calendar.getInstance().getTime());
        String time = timeF.format(Calendar.getInstance().getTime());

        autoDate.setText(date);
        autoTime.setText(time);
        // end of date/time autofill

        // below set of code is the examiner name dropdown
        // the gold standard would be api population from a database
        ArrayAdapter<String> adapterForName = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, examinerNames);
        ArrayAdapter<String> adapterForWeather = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, weather);
        //Find TextView control
        AutoCompleteTextView acTextView  = (AutoCompleteTextView) findViewById(R.id.editTextExaminerName);
        AutoCompleteTextView acTextView2  = (AutoCompleteTextView) findViewById(R.id.editTextWeather);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(1);
        acTextView2.setThreshold(1);
        //Set the adapter
        acTextView.setAdapter(adapterForName);
        acTextView2.setAdapter(adapterForWeather);
        // End of examiner name dropdown

        //spinner weather start of code here
        //get the spinner from the xml.
        Spinner dropdownWeather = findViewById(R.id.WeatherSpinner);
        Spinner dropdownRAMS = findViewById(R.id.RAMSSpinner);
        //create a list of items for the spinner.
        String[] SpinnerStringWeather = new String[]{"Mild", "Cloudy", "Rain", "Wind", "Storm", "Snow"};
        String[] SpinnerStringRAMS = new String[]{"DE: CBL_BBR_CH_RGS_MS1v2","VE: CBL_BBR_CH_RGS_MS2"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> SpinneradapterWeather = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SpinnerStringWeather);
        ArrayAdapter<String> SpinneradapterRAMS = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SpinnerStringRAMS);
        //set the spinners adapter to the previously created one.
        dropdownWeather.setAdapter(SpinneradapterWeather);
        dropdownRAMS.setAdapter(SpinneradapterRAMS);
        //spinner weather end of code here

        //initialisation of checkboxes for safe/unsafe questions
        mWorkingAtHeight =(CheckBox)findViewById(R.id.checkBox_workingAtHeight);
        mFallingObjects =(CheckBox)findViewById(R.id.checkBox_fallingObjects);
        //mAccessToSite =(CheckBox)findViewById(R.id.sw);
        mLoneWorking =(CheckBox)findViewById(R.id.checkBox_loneWorking);
        mTM =(CheckBox)findViewById(R.id.checkBox_TM);
        mLiftingOperations =(CheckBox)findViewById(R.id.checkBox_liftingOperations);
        mLiveElectric =(CheckBox)findViewById(R.id.checkBox_liveElectric);
    }
//dont need
//    public boolean deleteOne(CustomerModel customerModel){
        // find customer model in the database.  if it is found deleve it and return true.
        //if it is not found return false.
//        SQLiteDatabase db = this.getWritableDatabase(); //get Instance of DB
        // will delete so needs to be writable
 //       String queryString = "DELETE FROM " + CUSTOMER_TABLE + " WHERE " + COLUMN_ID + " = " + customerModel.getId();

//        Cursor cursor = db.rawQuery(queryString, null);//cursor variable required
//       if (cursor.moveToFirst()){
//            return true;
//        }
//        else {
//            return false;
 //       }

 //   }
    // end of dont need
    // BELOW IS FUNCTION FOR WHEN DONE BUTTON IS PRESSED
    public void checkIfCheckboxesAreChecked(View v)
    {
        String FFHtickbox="";
        String FOBtickbox="";

        // isChecked() is used to check whether the CheckBox is in true state or not.

        if(mWorkingAtHeight.isChecked()) {
            FFHtickbox = FFHtickbox + "Working at height safe";
            Toast.makeText(getApplicationContext(), FFHtickbox,
                    Toast.LENGTH_SHORT).show();
        }
        else{
            FFHtickbox = FFHtickbox + "Working at height unsafe";
            Toast.makeText(getApplicationContext(), FFHtickbox,
                    Toast.LENGTH_SHORT).show();
        }
        if(mFallingObjects.isChecked()) {
            FOBtickbox = FOBtickbox + "Falling objects safe";
            Toast.makeText(getApplicationContext(), FOBtickbox,
                    Toast.LENGTH_SHORT).show();
        }
        else{
            FOBtickbox = FOBtickbox + "Falling objects unsafe";
            Toast.makeText(getApplicationContext(), FOBtickbox,
                    Toast.LENGTH_SHORT).show();
        }
        // Toast is created to display the message using show() method - DUPLICATE - LESS BOILERPLATE LEAVE FOR NOW
        Toast.makeText(getApplicationContext(), FFHtickbox,
                Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), FOBtickbox,
                Toast.LENGTH_SHORT).show();


    }
    // END OF FUNCTION FOR WHEN DONE BUTTON IS PRESSED

}