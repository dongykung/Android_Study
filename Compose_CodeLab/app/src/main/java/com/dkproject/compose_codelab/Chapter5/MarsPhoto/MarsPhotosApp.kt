package com.dkproject.compose_codelab.Chapter5.MarsPhoto

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen.HomeScreen
import com.dkproject.compose_codelab.Chapter5.MarsPhoto.screen.MarsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsPhotosApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) }
    ) {  innerPadding->
        val viewModel: MarsViewModel = viewModel(factory = MarsViewModel.Factory)
        Surface(modifier = Modifier.fillMaxSize()) {
            HomeScreen(marsUiState = viewModel.marsUiState, retryAction = { viewModel.getMarsPhotos() } ,contentPaddingValues = innerPadding)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Mars Photos",
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}