package com.dkproject.compose_codelab.Chapter5

import com.dkproject.compose_codelab.Chapter5.MarsPhoto.data.NetworkMarsPhotosRepository
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen.MarsUiState
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen.MarsViewModel
import com.dkproject.compose_codelab.Chapter5.fake.FakeDataSource
import com.dkproject.compose_codelab.Chapter5.fake.FakeMarsApiService
import com.dkproject.compose_codelab.Chapter5.fake.FakeNetworkMarsPhotosRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class MarsPhotosTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {
        val repository = NetworkMarsPhotosRepository(marsApiService = FakeMarsApiService())
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }

}