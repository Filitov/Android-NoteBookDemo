package tw.fili.notebookdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

    SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDB = new FiDBHelper(this).getWritableDatabase();

        //查詢目前所有清單
        Cursor rr = mDB.query("finote", null, null, null, null, null, null, null);
        //Cursor rr = mDB.query("finote", new String[]{"title","detail","moddate","rowid"}, null, null, null, null, null, null);
        while( rr.moveToNext() ){

            String title, detail, datestr;
            title = rr.getString(0);
            detail = rr.getString(1);
            datestr = rr.getString(2);
            //title   = rr.getString( rr.getColumnIndex("title")  );
            //detail  = rr.getString( rr.getColumnIndex("detail") );
            //datestr = rr.getString( rr.getColumnIndex("moddate"));
            //id      = rr.getString( rr.getColumnIndex("rowid")  );


        }
        rr.close();


        //加入一筆資料
        ContentValues cv = new ContentValues();
        cv.put( "title", "標題xx" );
        cv.put( "detail", "內容xx" );
        cv.put( "moddate", "2017-11-04 10:11:12" );
        mDB.insert("finote", null, cv);
        //mDB.insert("finote", "不在上面的欄位名稱", cv);


        //刪除一筆資料
        int del_cnt;
        del_cnt = mDB.delete("finote", "title=?", new String[]{"標題1"} );

        //更新
        ContentValues cv2 = new ContentValues();
        cv2.put( "title", "標題yy" );
        cv2.put( "detail", "內容yy" );
        cv2.put( "moddate", "2017-11-05 13:14:15" );
        int update_cnt;
        update_cnt = mDB.update("finote", cv2, "title=?", new String[]{"標題參"});

        //
    }

}
