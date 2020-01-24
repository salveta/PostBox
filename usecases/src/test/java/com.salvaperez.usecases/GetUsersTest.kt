package com.salvaperez.usecases

import com.nhaarman.mockitokotlin2.whenever
import com.salvaperez.data.repository.UserRepository
import com.salvaperez.usecases.utils.mochedUser
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUsersTest {

    @Mock
    lateinit var userRepository: UserRepository

    lateinit var getUsers: GetUsers

    @Before
    fun setUp() {
        getUsers = GetUsers(userRepository)
    }

    @Test
    fun `invoke calls users repository`() {
        runBlocking {

            val users = listOf(mochedUser.copy())
            whenever(userRepository.getUsers()).thenReturn(users)

            val result = getUsers.invoke()

            Assert.assertEquals(users, result)
        }
    }
}