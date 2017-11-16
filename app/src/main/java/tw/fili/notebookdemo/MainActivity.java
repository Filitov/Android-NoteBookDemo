package tw.fili.notebookdemo;

import android.app.Activity;
import android.os.Bundle;
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
    }



}
