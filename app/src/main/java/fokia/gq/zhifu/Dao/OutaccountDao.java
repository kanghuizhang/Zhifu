package fokia.gq.zhifu.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fokia.gq.zhifu.model.Income;
import fokia.gq.zhifu.model.Outlay;

/**
 * Created by archie on 6/13/17.
 */

public class OutaccountDao extends BaseDBDao{

    private int id;
    private double money;
    private String note;
    private String date;
    private String type;
    private String address;

    public static List<Outlay> outlays = new ArrayList<>();

    public OutaccountDao(SQLiteDatabase db, String id) {
        super(db, id);
    }

    @Override
    public void insert(SQLiteDatabase db, String id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("money", money);
        contentValues.put("date", date);
        contentValues.put("type", type);
        contentValues.put("address", address);
        contentValues.put("mark",note);
        db.insert("tb_outaccount", null, contentValues);
    }

    @Override
    public void delete(SQLiteDatabase db, String id) {
        db.delete("tb_outaccount", "id=?", new String[]{id});
    }

    @Override
    public void update(SQLiteDatabase db, String id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("money", money);
        contentValues.put("date", date);
        contentValues.put("type", type);
        contentValues.put("address", address);
        contentValues.put("mark",note);
        db.update("tb_account", contentValues, "id=?", new String[]{id});
    }

    @Override
    public Cursor query(SQLiteDatabase db, String id) {
        return  db.query("tb_outaccount", null, "where=?", new String[]{id}, null, null, null);
    }

    public static void getOutlays(SQLiteDatabase db){
        Cursor cursor = db.query("tb_outaccount", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            outlays.add(new Outlay(cursor.getDouble(1), cursor.getString(5), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
        }
    }
}
