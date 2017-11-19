package tw.fili.notebookdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FiDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "FiDB.db";  //名稱自取
    public static final int DB_VERSION = 1;  //以後有變更資料表格式時,增加之

    public FiDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    private static final String SQL_CREATE =
            "CREATE TABLE finote (" +
            "title TEXT," +
            "detail TEXT," +
            "moddate TEXT" +
            ")";
    private static final String SQL_SAMPLE =
            "insert into finote (title,detail,moddate) values\n" +
            " (\"標題1\", \"內容1\", \"2017-11-01 01:02:03\")\n" +
            ",(\"標題二\", \"內容2\", \"2017-11-02 04:05:06\")\n" +
            ",(\"標題參\", \"內容3\", \"2017-11-03 07:08:09\")";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( SQL_CREATE  );
        sqLiteDatabase.execSQL( SQL_SAMPLE );
    }


    private  static final  String SQL_DELETE =
            "DROP TABLE IF EXISTS finote";


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( SQL_DELETE  );
        sqLiteDatabase.execSQL( SQL_CREATE  );
        sqLiteDatabase.execSQL( SQL_SAMPLE );
    }
}
