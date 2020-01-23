package com.salvaperez.postbox.data.entities

import com.salvaperez.domain.Address
import com.salvaperez.domain.Company
import com.salvaperez.domain.Geo
import com.salvaperez.domain.User


fun UserEntity.toDomain(): User =
    User(
        address = address.toDomain(),
        company = company.toDomain(),
        email = email,
        id = id,
        name = name,
        phone = phone,
        username = username,
        website = website
    )

fun AddressEntity.toDomain(): Address =
    Address(
        city = city,
        geo = geo.toDomain(),
        street = street,
        suite = suite,
        zipcode = zipcode
    )

fun CompanyEntity.toDomain(): Company =
    Company(
        bs = bs,
        catchPhrase = catchPhrase,
        name = name
    )

fun GeoEntity.toDomain(): Geo =
    Geo(
        lat = lat,
        lng = lng
    )