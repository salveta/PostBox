package com.salvaperez.data

import com.salvaperez.data.repository.UserRepository
import com.salvaperez.data.source.RemoteUserDataSource
import com.salvaperez.domain.*
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UsersRepositoryTest {

    @Mock
    lateinit var remoteUserRepositoryDataSource: RemoteUserDataSource
    lateinit var usersRepository: UserRepository


    @Before
    fun setUp() {
        usersRepository = UserRepository(remoteUserRepositoryDataSource)
    }

    @Test
    fun `getUsers give you the users list`() {
        runBlocking {

            val remoteUsers = listOf(mochedUser.copy(Address("city", Geo("lat", "long"), "street", "suite", "zipcode")))
            whenever(remoteUserRepositoryDataSource.getUserList()).thenReturn(remoteUsers)

            val users = usersRepository.getUsers()

            Assert.assertEquals(users, remoteUsers)
        }
    }


    private val mochedUser = User(
        Address("city", Geo("lat", "long"), "street", "suite", "zipcode"),
        Company("bs", "catchPhrase", "name"),
        "email",
        2,
        "bob",
        "6484948494",
        "bob spencer",
        "www.mywebsite.com"
    )
}