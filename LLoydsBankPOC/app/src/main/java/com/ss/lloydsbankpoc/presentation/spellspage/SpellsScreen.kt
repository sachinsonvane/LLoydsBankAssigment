package com.ss.lloydsbankpoc.presentation.spellspage

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
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.common.Route
import com.ss.lloydsbankpoc.data.models.allevents.SpellsEvents
import com.ss.lloydsbankpoc.presentation.spellspage.viewmodel.SpellsViewModel
import java.util.Date

@Composable
fun SpellsScreen(navController: NavController,
                 spellsViewModel: SpellsViewModel = hiltViewModel()
) {

    val spellsState = spellsViewModel.state.value
    val nowDate = Date().toString()
    val isVisible = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        spellsViewModel.onEvent(SpellsEvents.GetAllSpells)
    }

    LaunchedEffect(Unit) {
        isVisible.value = true
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        if (isVisible.value)
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
                        Text(text= stringResource(id = R.string.spells_name),fontSize = 22.sp, color = Color("#05350B".toColorInt()))
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(spellsState.allSpellsData){
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Row(modifier = Modifier.padding(10.dp).background(Color.Transparent).clickable(
                                onClick = {
                                    navController.navigate(Route.WEASLEY_SCREEN)
                                }
                            )) {
                                Image(painter = painterResource(id = R.drawable.harry),
                                    contentDescription = null,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Column {
                                    Text(text = it.spell, color = Color("#05350B".toColorInt()),fontSize = 18.sp)
                                    Spacer(modifier = Modifier.size(8.dp))
                                    Text(text = it.use, color = Color("#05350B".toColorInt()),fontSize = 15.sp)
                                    Spacer(modifier = Modifier.size(8.dp))
                                    Text(text = nowDate, color = Color("#05350B".toColorInt()),fontSize = 15.sp)
                                }
                            }
                        }
                    }
                }
            }
    }
}