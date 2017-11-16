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

    private NoteArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FiNote> mList;
        mList = new ArrayList<>();

        //測試資料
        mList.add( new FiNote("aaa","test aaa") );
        mList.add( new FiNote("bbbb","bbb test") );

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
                title = bundle.getString("title");
                detail = bundle.getString("detail");

                //新增到清單中
                FiNote note = new FiNote(title, detail);
                mAdapter.add( note );
            }else{
                //點選 CANCEL 取消回來的
                //啥事也不用做?
            }
        }

        //如果有其他傳回值的話...
    }
}
