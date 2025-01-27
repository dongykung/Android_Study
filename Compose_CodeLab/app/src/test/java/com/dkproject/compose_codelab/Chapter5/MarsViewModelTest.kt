package com.dkproject.compose_codelab.Chapter5

import com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen.MarsUiState
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen.MarsViewModel
import com.dkproject.compose_codelab.Chapter5.fake.FakeDataSource
import com.dkproject.compose_codelab.Chapter5.fake.FakeNetworkMarsPhotosRepository
import com.dkproject.compose_codelab.Chapter5.rules.TestDispatcherRule
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
        val marsViewModel = MarsViewModel(marsPhotosRepository = FakeNetworkMarsPhotosRepository())
        assertEquals(MarsUiState.Success(FakeDataSource.photosList), marsViewModel.marsUiState)
    }
}