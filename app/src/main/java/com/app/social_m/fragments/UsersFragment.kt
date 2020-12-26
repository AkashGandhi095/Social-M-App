package com.app.social_m.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.social_m.R
import com.app.social_m.adapter.UserAdapter
import com.app.social_m.model.Users
import com.app.social_m.retrofitUtils.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersFragment : Fragment() {

    companion object {
        private const val TAG = "UsersFragmentScreen"
    }

    private lateinit var userListRecyclerView :RecyclerView
    private lateinit var userAdapter :UserAdapter
    private lateinit var userList: ArrayList<Users>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListRecyclerView = view.findViewById(R.id.users_RecyclerV)
        userList = arrayListOf()
        userAdapter = UserAdapter(userList)
        userListRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter

        }
        fetchUsersList()
    }


    private fun fetchUsersList() {

        RetrofitService.apiService.fetchUsers().enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    showUsers(response.body())
                } else {
                    Log.d(TAG, "onResponse: errorResponse :${response.errorBody()} ")
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }

        })
    }

    private fun showUsers(users: List<Users>?) {
        users?.let {
            userAdapter.setUsersData(users)
        }
    }


}