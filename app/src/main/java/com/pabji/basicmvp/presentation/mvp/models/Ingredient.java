package com.pabji.basicmvp.presentation.mvp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pablo Jiménez Casado on 18/10/2016.
 */

public class Ingredient implements Parcelable{
    public long id;
    public String name;

    protected Ingredient(Parcel in) {
        id = in.readLong();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

}
