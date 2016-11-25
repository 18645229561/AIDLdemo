package aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by renpeng on 16/11/25.
 */
public class Book implements Parcelable{

    public String bookName;

    public int bookId;

    public Book(String bookName,int bookId){

        this.bookId = bookId;

        this.bookName = bookName;
    }

    protected Book(Parcel in) {
        bookName = in.readString();
        bookId = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeInt(bookId);
    }
}
