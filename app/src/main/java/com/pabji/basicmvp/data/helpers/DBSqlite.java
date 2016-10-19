package com.pabji.basicmvp.data.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pabji.basicmvp.presentation.mvp.models.Recipe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Pablo Jiménez Casado on 19/10/2016.
 */

@Singleton
public class DBSqlite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "basicmvpdb.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE = "RecipeTable";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_URLPHOTO = "photo";

    private SQLiteDatabase database;

    String recipeTable = "CREATE TABLE " + DATABASE_TABLE + "("
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_NAME + " TEXT unique, "
            + KEY_URLPHOTO + " TEXT)";

    public DBSqlite(Context context) {
        super(context,
                context.getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + DATABASE_NAME,
                null, DATABASE_VERSION);
        getDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
        database.execSQL(recipeTable);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        database.execSQL(recipeTable);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }


    @Override
    public synchronized void close() {
        super.close();
        if (database != null) {
            database.close();
            database = null;
        }
    }

    public SQLiteDatabase getDatabase() {
        try {
            if ((database == null) || (!database.isOpen())) {
                database = this.getWritableDatabase();
            }
            return database;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Recipe> getRecipeList(){

        List<Recipe> list = new ArrayList<>();

        Cursor c = database.rawQuery("SELECT * FROM " + DATABASE_TABLE, null);
        if (c != null && c.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.id  = c.getLong(c.getColumnIndex(KEY_ID));
                recipe.name = c.getString(c.getColumnIndex(KEY_NAME));
                recipe.photo = c.getString(c.getColumnIndex(KEY_URLPHOTO));
                list.add(recipe);
            } while (c.moveToNext());
            c.close();
        }
        database.close();
        return list;
    }


}
