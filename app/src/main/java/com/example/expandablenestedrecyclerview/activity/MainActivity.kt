package com.example.expandablenestedrecyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablenestedrecyclerview.R
import com.example.expandablenestedrecyclerview.adapter.ParentRecyclerViewAdapter
import com.example.expandablenestedrecyclerview.data.ChildItem
import com.example.expandablenestedrecyclerview.data.ParentItem

class MainActivity : AppCompatActivity() {

    private lateinit var parentRecyclerView:RecyclerView
    private lateinit var parentList:ArrayList<ParentItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parentRecyclerView=findViewById(R.id.parentRecyclerView)

        parentRecyclerView.setHasFixedSize(true)
        parentRecyclerView.layoutManager=LinearLayoutManager(this)

        parentList= ArrayList()
        prepareData()
        val adapter= ParentRecyclerViewAdapter(parentList)
        parentRecyclerView.adapter=adapter
    }

    private fun prepareData() {

        val childItem1=ArrayList<ChildItem>()
        childItem1.add(ChildItem("Java", R.drawable.java))
        childItem1.add(ChildItem("Kotlin", R.drawable.kotlin))
        childItem1.add(ChildItem("Xml", R.drawable.xml))
        childItem1.add(ChildItem("Jetpack Compose", R.drawable.jetpack_compose))

        parentList.add(ParentItem("Android Development", R.drawable.android_development,childItem1))

        val childItem2=ArrayList<ChildItem>()
        childItem2.add(ChildItem("Html", R.drawable.html))
        childItem2.add(ChildItem("Css", R.drawable.css))
        childItem2.add(ChildItem("Javascript", R.drawable.javascript))


        parentList.add(ParentItem("FrontEnd Development", R.drawable.frontend_development,childItem2))


        val childItem3=ArrayList<ChildItem>()
        childItem3.add(ChildItem("PHP", R.drawable.php))
        childItem3.add(ChildItem("MongoDB", R.drawable.mongodb))
        childItem3.add(ChildItem("Python", R.drawable.python))


        parentList.add(ParentItem("BackEnd Development", R.drawable.backend,childItem3))



        val childItem4=ArrayList<ChildItem>()
        childItem4.add(ChildItem("GO", R.drawable.go))
        childItem4.add(ChildItem("Python", R.drawable.python))
        childItem4.add(ChildItem("Solidity", R.drawable.solidity))
        childItem4.add(ChildItem("Ruby", R.drawable.ruby))

        parentList.add(ParentItem("BlockChain Development", R.drawable.blockchain,childItem4))



        val childItem5=ArrayList<ChildItem>()
        childItem5.add(ChildItem("MongoDB", R.drawable.mongodb))
        childItem5.add(ChildItem("ExpressJs", R.drawable.expressjs))
        childItem5.add(ChildItem("ReactNative", R.drawable.reactnative))
        childItem5.add(ChildItem("NodeJs", R.drawable.nodejs))

        parentList.add(ParentItem("Mern Stack Development", R.drawable.fullstack,childItem5))


        val childItem6=ArrayList<ChildItem>()
        childItem6.add(ChildItem("MongoDB", R.drawable.mongodb))
        childItem6.add(ChildItem("ExpressJs", R.drawable.expressjs))
        childItem6.add(ChildItem("Angular", R.drawable.angular))
        childItem6.add(ChildItem("NodeJs", R.drawable.nodejs))

        parentList.add(ParentItem("Mean Stack Development", R.drawable.fullstack,childItem6))
    }
}