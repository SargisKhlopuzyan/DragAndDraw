package com.example.sargiskh.draganddraw;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by sargiskh on 12/6/2016.
 */

public class Box implements Parcelable{

    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {
        mCurrent = current;
    }

    public PointF getOrigin() {
        return mOrigin;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    /** save object in parcel */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(mOrigin.x);
        parcel.writeFloat(mOrigin.y);
        parcel.writeFloat(mCurrent.x);
        parcel.writeFloat(mCurrent.y);

    }

    // Creator
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Box createFromParcel(Parcel in) {
            return new Box(in);
        }

        public Box[] newArray(int size) {
            return new Box[size];
        }
    };

    /** recreate object from parcel */
    public Box(Parcel in) {
        float originX = in.readFloat();
        float originY = in.readFloat();
        float currentX = in.readFloat();
        float currentY = in.readFloat();
        mOrigin = new PointF(originX, originY);
        mCurrent = new PointF(currentX, currentY);
    }

}
