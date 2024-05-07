package com.babak.firstexam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Todo (val name:String,val lastDay:Boolean,val level:Int):Parcelable
