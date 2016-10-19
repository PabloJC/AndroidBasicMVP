package com.pabji.basicmvp.presentation.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class Recipe implements Parcelable{
    public long id;
    public  String name;
    public String photo;
    public List<Ingredient> ingredients;

    public Recipe (){}

    protected Recipe(Parcel in) {
        id = in.readLong();
        name = in.readString();
        photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
