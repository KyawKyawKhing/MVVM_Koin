package com.kkk.mvvm_koin.network.NetworkResponse

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class NoticeListResponse {
    @SerializedName("notice_list")
    var noticeList: List<Notice> = ArrayList()
}

class Notice() : Parcelable {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("brief")
    var brief: String? = null
    @SerializedName("filesource")
    var fileSource: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        title = parcel.readString()
        brief = parcel.readString()
        fileSource = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(brief)
        parcel.writeString(fileSource)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Notice> {
        override fun createFromParcel(parcel: Parcel): Notice {
            return Notice(parcel)
        }

        override fun newArray(size: Int): Array<Notice?> {
            return arrayOfNulls(size)
        }
    }
}
