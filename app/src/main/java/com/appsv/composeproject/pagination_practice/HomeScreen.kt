package com.appsv.composeproject.pagination_practice

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.appsv.composeproject.pagination_practice.dto.Data
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {


    val res = viewModel.pager.collectAsLazyPagingItems()

    LazyColumn {
        items(res) { item ->
            FakeItem(item!!)
        }
        res.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .align(
                                        Alignment.Center
                                    )
                            )
                        }
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .align(
                                        Alignment.Center
                                    )
                            )
                        }
                    }
                }
                loadState.prepend is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .align(
                                        Alignment.Center
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FakeItem(item: Data) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = item.airline[0].country,
            style = TextStyle(
                color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp,
            ),
            modifier = Modifier.padding(8.dp),
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = item.airline[0].slogan,
            style = TextStyle(color = Color.White, fontWeight = FontWeight.Medium, fontSize = 16.sp)
        )
        HorizontalDivider()

    }

}