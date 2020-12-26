package com.app.social_m.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.social_m.R
import com.app.social_m.model.Users
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import kotlin.collections.ArrayList
import kotlin.random.Random

class UserAdapter(private val userDataList :ArrayList<Users>) : RecyclerView.Adapter<UserAdapter.DataHolder>() {


    fun setUsersData(userDataList: List<Users>) {
        this.userDataList.addAll(userDataList)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.DataHolder {
        return DataHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.user_rows, parent, false))
    }


    override fun onBindViewHolder(holder: UserAdapter.DataHolder, position: Int) {
        val user :Users = userDataList[position]
        holder.bindDataToViews(user)
    }

    override fun getItemCount(): Int = userDataList.size

    inner class DataHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        private val profileImageV :ShapeableImageView = itemView.findViewById(R.id.userProfile_ImgV)
        private val nameTextV :MaterialTextView = itemView.findViewById(R.id.userName_txtV)
        private val emailTextV :MaterialTextView = itemView.findViewById(R.id.userEmail_txtV)
        private val websiteTextV :MaterialTextView = itemView.findViewById(R.id.userWebsite_txtV)

        fun bindDataToViews(user :Users) {
            profileImageV.setImageResource(generateRandomProfileImage())
            nameTextV.text = user.name
            emailTextV.text = user.email
            websiteTextV.text = user.website
        }
    }

    private fun generateRandomProfileImage() :Int {

        return when (Random.nextInt(6)) {
            1 ->  R.drawable.image_1
            2 ->  R.drawable.image_2
            3 ->  R.drawable.image_3
            4 ->  R.drawable.image_4
            else ->  R.drawable.image_5
        }
    }
}