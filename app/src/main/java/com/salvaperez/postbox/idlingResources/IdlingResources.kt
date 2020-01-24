package com.salvaperez.postbox.idlingResources

import androidx.annotation.Nullable

fun incrementIdlingResource(@Nullable mIdlingResource: SimpleIdlingResource?){
    if(mIdlingResource != null) {
        mIdlingResource.setIdleState(false)
        EspressoTestingIdlResource.increment()
    }
}

fun decrementIdlingResource(){
    if (!EspressoTestingIdlResource.idlingResource.isIdleNow) {
        EspressoTestingIdlResource.decrement()
    }
}