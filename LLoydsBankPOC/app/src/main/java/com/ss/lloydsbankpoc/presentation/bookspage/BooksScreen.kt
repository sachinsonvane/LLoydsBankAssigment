package com.ss.lloydsbankpoc.presentation.bookspage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ss.lloydsbankpoc.common.Route
import com.ss.lloydsbankpoc.data.models.allevents.BooksEvents
import com.ss.lloydsbankpoc.presentation.bookspage.viewmodel.BooksViewModel
import com.ss.lloydsbankpoc.R;

@Composable
fun BooksScreen(navController: NavController,
                booksViewModel: BooksViewModel  = hiltViewModel()
) {

    val booksState = booksViewModel.state.value
    val isVisible = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        booksViewModel.onEvent(BooksEvents.GetAllBooks)
    }

    LaunchedEffect(Unit) {
        isVisible.value = true
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        if (isVisible.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.logo_img),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = stringResource(id = R.string.logo_title),
                            fontSize = 22.sp,
                            color = Color("#05350B".toColorInt())
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(booksState.allBooksData) {
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Row(modifier = Modifier.padding(10.dp).background(Color.Transparent)
                                .clickable(
                                    onClick = {
                                        navController.navigate(Route.SPELLS_SCREEN)
                                    }
                                )) {
                                AsyncImage(
                                    model = it.cover,
                                    contentDescription = null,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Column {
                                    Text(
                                        text = it.title,
                                        color = Color("#05350B".toColorInt()),
                                        fontSize = 18.sp
                                    )
                                    Spacer(modifier = Modifier.size(8.dp))
                                    Text(
                                        text = it.originalTitle,
                                        color = Color("#05350B".toColorInt()),
                                        fontSize = 15.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }else{
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    progress = 0.89f,
                )
            }
        }
    }

}