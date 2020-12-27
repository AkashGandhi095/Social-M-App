package com.app.social_m.model

import com.google.gson.annotations.SerializedName

data class Users(

    @SerializedName("id")
    val _id :Int ,

    val name :String ,

    val email :String ,

    val address :Address ,

    val phone :String ,

    val website :String ,

    val company: Company


)

data class Address(

    val street :String ,
    val suite :String ,
    val city :String ,

    @SerializedName("zipcode")
    val zipCode :String ,

    val geo :Geo

)

data class Geo(
    val lat :String ,
    @SerializedName("lng")
    val lon :String
)

data class Company(
    @SerializedName("name")
    val companyName :String ,

    val catchPhrase :String ,

    val bs :String

)






