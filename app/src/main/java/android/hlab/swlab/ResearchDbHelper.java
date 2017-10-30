package android.hlab.swlab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ResearchDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="research.db";
    public static final String TABLE_NAME="papers";
    public static final String COL_1="ID";
    public static final String COL_2="Title";
    public static final String COL_3="Abstract";
    public static final String COL_4="Userid";
    public static final String COL_5="Published";

    public ResearchDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Title TEXT,Abstract TEXT,Userid TEXT,Published TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
}
