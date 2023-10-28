package com.example.retrofitpracticeday2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//Pass the context and userList in the constructor and userList type as which data class you want to show
class UserAdapter(val context:Activity,val userList:List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val userImage = itemView.findViewById<ImageView>(R.id.userImage)

        val name = itemView.findViewById<TextView>(R.id.name)

        val userAge = itemView.findViewById<TextView>(R.id.userAge)

        val userBloodGroup = itemView.findViewById<TextView>(R.id.userBloodGroup)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.name.text = currentUser.firstName
        holder.userAge.text = currentUser.age.toString()
        holder.userBloodGroup.text = currentUser.bloodGroup

        Picasso.get()
            .load(currentUser.image)
            .into(holder.userImage)

    }


}