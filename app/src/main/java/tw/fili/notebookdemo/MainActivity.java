package tw.fili.notebookdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    SQLiteDatabase mDB;

    private NoteArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDB = new FiDBHelper(this).getWritableDatabase();

        List<FiNote> mList;
        mList = new ArrayList<>();

        //查詢目前所有清單
        Cursor rr = mDB.query("finote", null, null, null, null, null, null, null);
        while( rr.moveToNext() ){
            String title, detail, moddate;
            title = rr.getString(0);
            detail = rr.getString(1);
            moddate = rr.getString(2);
            //將資料庫查得的資料加到清單中
            mList.add( new FiNote(title,detail,moddate) );

        }
        rr.close();

        mAdapter = new NoteArrayAdapter(this, R.layout.note_list_item_layout, mList);

        ListView mLV;
        mLV = (ListView)findViewById(R.id.fiListView);
        mLV.setAdapter(mAdapter);

        //設定點選「新增」按鈕的事件處理物件
        ImageButton btn = (ImageButton)findViewById(R.id.fiBtnAdd);
        btn.setOnClickListener( mAdd );
    }


    //點選「新增」時的事件處理
    private View.OnClickListener mAdd = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //開啟新增的介面 AddNoteActivity
            Intent it = new Intent();
            it.setClass( MainActivity.this, AddNoteActivity.class );
            startActivityForResult( it, 9527 );
        }
    };


    //開啟介面的回傳資料處理
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //「新增介面」的傳回值
        if( requestCode==9527 ){
            if( resultCode==Activity.RESULT_OK ){
                //點選 OK 完成回來的
                Bundle bundle = data.getExtras();
                String title, detail;
                title = bundle.getString("title", "no name");
                detail = bundle.getString("detail", "no detail");

                //新增到清單中
                FiNote note = new FiNote(title, detail);
                mAdapter.add( note );

                //加入一筆資料
                ContentValues cv = new ContentValues();
                cv.put( "title", note.getTitle() );
                cv.put( "detail", note.getDetail() );
                cv.put( "moddate", note.getModDateString() );
                mDB.insert("finote", null, cv);
            }else{
                //點選 CANCEL 取消回來的
                //啥事也不用做?
            }
        }

        //如果有其他傳回值的話...
    }
}
