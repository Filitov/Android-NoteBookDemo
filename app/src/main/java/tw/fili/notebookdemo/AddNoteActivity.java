package tw.fili.notebookdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddNoteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        ImageButton btn;
        btn = (ImageButton)findViewById(R.id.fiAddBtnOK);
        btn.setOnClickListener(mOK);
        btn = (ImageButton)findViewById(R.id.fiAddBtnCancel);
        btn.setOnClickListener(mCancel);
    }

    //點選 OK 時的事件處理
    private View.OnClickListener mOK = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            finish();
        }
    };

    //點選 Cancel 時的事件處理
    private View.OnClickListener mCancel = new View.OnClickListener() {
        @Override
        public void onClick(View view) {



            finish();
        }
    };
}
