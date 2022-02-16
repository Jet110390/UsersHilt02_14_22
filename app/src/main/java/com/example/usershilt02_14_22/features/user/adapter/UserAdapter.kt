package com.example.usershilt02_14_22.features.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usershilt02_14_22.databinding.UserItemBinding
import com.example.usershilt02_14_22.network.models.User

class UserAdapter (
    private val userList: List<User>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            with(binding) {
                identityTv.text =
                    "${user.name}\nid: ${user.id} \nusername: ${user.username}"
                addressTv.text =
                    "Address: ${user.address.street},${user.address.suite}\nArea: ${user.address.city}, ${user.address.zipcode}\n Location: latitude - ${user.address.geo.lat} longitude - ${user.address.geo.lng}"
                contactInfoTv.text =
                    "Email ${user.email}\nPhone Number: ${user.phone}\nWebsite: ${user.website}"
                companyTv.text =
                    "Company: ${user.company.name} - ${user.company.bs}\n Service: ${user.company.catchPhrase}"
            }

        }
    }
}