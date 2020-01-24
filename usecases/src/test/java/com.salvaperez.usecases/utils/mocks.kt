package com.salvaperez.usecases.utils

import com.salvaperez.domain.*

internal val mockedPost = Post(
"this is a body post",
    3,
    "this is title post",
    1
)

internal val mochedUser = User(
    Address("city", Geo("lat", "long"), "street", "suite", "zipcode"),
    Company("bs", "catchPhrase", "name"),
    "email",
    2,
    "bob",
"6484948494",
    "bob spencer",
    "www.mywebsite.com"
)

internal val mochedComment = Comment(
    "body",
    "email",
    2,
    "name",
1
)