package tw.fili.notebookdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

//
// 用來管理自訂「清單項目layout」的 ArrayAdapter
//
public class NoteArrayAdapter extends ArrayAdapter<FiNote> {

    private LayoutInflater mInflater;
    private List<FiNote> mList;

    public NoteArrayAdapter(Context context, int resource, List<FiNote> objects) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        mList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //取得清單中第 position 位置的資料
        FiNote note = mList.get( position );

        if( convertView==null ){
            convertView = mInflater.inflate(R.layout.note_list_item_layout, parent, false);
        }

        TextView tvTitle, tvDate;
        tvTitle = convertView.findViewById(R.id.fiTxtListTitle);
        tvDate = convertView.findViewById(R.id.fiTxtListDate);

        tvTitle.setText( note.getTitle() );
        tvDate.setText( note.getModDateString() );

        //若清單筆數較多，將大量重複 findViewById，可用 ViewHolder 保存 View 物件來加快
        //https://developer.android.com/training/improving-layouts/smooth-scrolling.html
        //
        //ViewHolder holder;
        //
        //if( convertView==null ){
        //    convertView = mInflater.inflate(R.layout.note_list_item_layout, parent, false);
        //
        //    holder = new ViewHolder();
        //    holder.title = (TextView) convertView.findViewById(R.id.fiTxtListTitle);
        //    holder.date = (TextView) convertView.findViewById(R.id.fiTxtListDate);
        //    convertView.setTag( holder );
        //}else{
        //    holder = (ViewHolder) convertView.getTag();
        //}
        //
        //holder.title.setText( note.getTitle() );
        //holder.date.setText( note.getModDateString() );

        return convertView;
    }

    //若清單筆數較多，將大量重複 findViewById，可用 ViewHolder 保存 View 物件來加快
    //https://developer.android.com/training/improving-layouts/smooth-scrolling.html
    //static class ViewHolder {
    //    TextView title;
    //    TextView date;
    //}
}
