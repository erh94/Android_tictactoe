package android.hlab.swlab;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public SQLiteOpenHelper openHelper;
    public SQLiteDatabase db;
    private Button _btnRegister;
    private Button _btnLogin;
    private EditText FirstName, LastName, Userid;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DatabaseHelper(this);
        _btnRegister=(Button)findViewById(R.id.btnRegRegister);
        _btnLogin=(Button)findViewById(R.id.btnRegLogin);
        FirstName=(EditText)findViewById(R.id.etRegFirstName);
        if( FirstName.getText().toString().length() == 0 )
            FirstName.setError( "First name is required!" );
        LastName=(EditText)findViewById(R.id.etRegLastName);
        if( LastName.getText().toString().length() == 0 )
            LastName.setError( "Last name is required!" );
        Userid=(EditText)findViewById(R.id.etReguid);
        if( Userid.getText().toString().length() == 0 )
            Userid.setError( "Userid must be unique!" );
        Password=(EditText)findViewById(R.id.etRegPassword);
        if( Password.getText().toString().length() == 0 )
            Password.setError( "First name is required!" );

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotologin = new Intent(MainActivity.this,Login.class);
                startActivity(gotologin);
            }
        });

        _btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=FirstName.getText().toString();
                if(fname.isEmpty())
                {Toast.makeText(getApplicationContext(),"Enter Firstname",Toast.LENGTH_SHORT).show();
                return;
                }
                String lname=LastName.getText().toString();
                if(lname.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Lastname",Toast.LENGTH_SHORT).show();
                    return;
                }
                String userid=Userid.getText().toString();
                if(userid.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"userid cannot be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                String pass=Password.getText().toString();
                if(pass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Password cannot be empty",Toast.LENGTH_SHORT).show();
                    return;
                }

                insertdata(fname,lname,pass,userid);
                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                Intent restart = new Intent(MainActivity.this,MainActivity.class);
                startActivity(restart);
            }
        });
    }

    public void insertdata(String fname, String lname, String pass, String userid){
        ContentValues dbwriter = new ContentValues(); //this class is used to write values to database
        dbwriter.put(DatabaseHelper.COL_2, fname);
        dbwriter.put(DatabaseHelper.COL_3, lname);
        dbwriter.put(DatabaseHelper.COL_4, pass);
        dbwriter.put(DatabaseHelper.COL_5, userid);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null , dbwriter);
    }
}
