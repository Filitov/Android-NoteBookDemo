package tw.fili.notebookdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FiNote {
    //轉換日期到字串
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());

    //標題、內容、日期
    private String Title, Detail;
    private Date ModDate;

    // constructor -----------------------------------------------------------

    FiNote(String title, String detail, Date modDate){
        Title = title;
        Detail = detail;
        ModDate = modDate;
    }

    FiNote(){
        this("untitle","",new Date());
    }

    FiNote(String title, String detail){
        this(title, detail, new Date());
    }

    FiNote(String title, String detail, String datestr){
        Title = title;
        Detail = detail;
        try {
            ModDate = SDF.parse(datestr);
        } catch (ParseException e) {
            ModDate = new Date();
        }
    }

    // access-----------------------------------------------------------------

    public String getTitle() {
        return Title;
    }

    public String getDetail() {
        return Detail;
    }

    public Date getModDate() {
        return ModDate;
    }

    public String getModDateString() {
        return SDF.format(ModDate);
    }

    // access-----------------------------------------------------------------

    public void setTitle(String title) {
        Title = title;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public void setModDate(Date modDate) {
        ModDate = modDate;
    }

    public void setModDate() {
        ModDate = new Date();
    }

    public void setModDate(String modDateStr) {
        try {
            ModDate = SDF.parse(modDateStr);
        } catch (ParseException e) {
            //e.printStackTrace();
        }
    }

}
