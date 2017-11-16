package tw.fili.notebookdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
            String title, detail;

            //從介面中取得使用者輸入的資料
            EditText et;
            et = (EditText)findViewById(R.id.fiAddTxtTitle);
            title = et.getText().toString();
            et = (EditText)findViewById(R.id.fiAddTxtDetail);
            detail = et.getText().toString();

            //準備回傳的包裹
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("detail", detail);

            //回傳用的 intent
            Intent it = new Intent();
            it.putExtras(bundle);

            //回傳 OK, 結束此Activity
            setResult(Activity.RESULT_OK, it);
            finish();
        }
    };


    //點選 Cancel 時的事件處理
    private View.OnClickListener mCancel = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //回傳 CANCELED, 結束此Activity
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
    };
}
