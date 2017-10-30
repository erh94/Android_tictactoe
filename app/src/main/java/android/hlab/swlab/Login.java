package android.hlab.swlab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Userid;
    private EditText Password;
    private Button _btnLogin;
    private Button _btnRegisterHere;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        _btnLogin=(Button)findViewById(R.id.btnLoginLogin);
        _btnRegisterHere=(Button)findViewById(R.id.btnLoginRegister);
        Userid=(EditText)findViewById(R.id.etLoginUserID);
        if( Userid.getText().toString().length() == 0 )
            Userid.setError( "UserID is required!" );
        Password=(EditText)findViewById(R.id.etLoginPassword);
        if( Password.getText().toString().length() == 0 )
            Password.setError( "Password is required!" );

        _btnRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(Login.this,MainActivity.class);
                startActivity(register);

            }
        });

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = Userid.getText().toString();
                if(userid.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"userid cannot be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                String pass = Password.getText().toString();
                if(pass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Password cannot be empty",Toast.LENGTH_SHORT).show();
                    return;
                }


                cursor= db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5 + "=? AND "+ DatabaseHelper.COL_4 + "=?",new String[]{userid, pass});
                if(cursor!=null){
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(getApplicationContext(),"Logged In Successfully",Toast.LENGTH_SHORT).show();
                        Intent research = new Intent(Login.this,GameActivity.class);
                        startActivity(research);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Error Try Registering First!",Toast.LENGTH_SHORT).show();
//                        Intent game = new Intent(Login.this,ResearchForum.class);
//                        startActivity(game);
                    }
                }

            }
        });
    }
}
