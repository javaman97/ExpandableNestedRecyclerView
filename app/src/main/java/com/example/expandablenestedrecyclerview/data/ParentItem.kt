package com.example.expandablenestedrecyclerview.data

data class ParentItem(
    val title:String,
    val image:Int,
    val childList:ArrayList<ChildItem>,
    var isExpandable:Boolean=false
)
