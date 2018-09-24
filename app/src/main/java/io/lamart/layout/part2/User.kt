package io.lamart.layout.part2

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

data class User(val name: String = "Danny", val age: Int = 27) {

    companion object {

        fun asDataSource(): Observable<User> =
                Observable
                        .interval(1, TimeUnit.SECONDS)
                        .scan(User()) { user, _ -> user.copy(age = user.age + 1) }
                        .observeOn(AndroidSchedulers.mainThread())

    }

}