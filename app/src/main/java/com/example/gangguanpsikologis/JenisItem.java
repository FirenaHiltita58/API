package com.example.gangguanpsikologis;

import android.os.Parcel;
import android.os.Parcelable;

public class JenisItem implements Parcelable {

    private String nama, penjelasan;

    public JenisItem(String nama, String penjelasan) {

        this.nama = nama;
        this.penjelasan = penjelasan;

    }


    public static final Creator<JenisItem> CREATOR = new Creator<JenisItem>() {
        @Override
        public JenisItem createFromParcel(Parcel in) {
            return new JenisItem(in);
        }

        @Override
        public JenisItem[] newArray(int size) {
            return new JenisItem[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.penjelasan);
    }

    public JenisItem(){}

    protected JenisItem(Parcel in ) {
        this.nama = in.readString();
        this.penjelasan = in.readString();

        final Parcelable.Creator<JenisItem> CREATOR = new Parcelable.Creator<JenisItem>() {

            @Override
            public JenisItem createFromParcel(Parcel source) {
                return new JenisItem(source);
            }

            @Override
            public JenisItem[] newArray(int size) {
                return new JenisItem[size];
            }
        };
    }
}