package tw.fili.notebookdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FiNote> mList;
        mList = new ArrayList<>();

        //測試資料
        mList.add( new FiNote("aaa","test aaa") );
        mList.add( new FiNote("bbbb","bbb test") );


        NoteArrayAdapter mAdapter;
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
            startActivity( it );
        }
    };

}
