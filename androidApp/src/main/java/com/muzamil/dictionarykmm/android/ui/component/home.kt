package com.muzamil.dictionarykmm.android.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muzamil.dictionarykmm.android.ui.viewmodel.AndroidDictionaryViewModel
import com.muzamil.dictionarykmm.data.remote.model.wordInfoItem
import com.muzamil.dictionarykmm.presentation.dictionaryviewmodel.UiEvent

@Composable
fun home(vm: AndroidDictionaryViewModel) {
    val uiState = vm.state.collectAsState().value

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            searchField(vm)
            Spacer(modifier = Modifier.heightIn(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                val wordInfoItem = uiState.wordDtoItem
                items(wordInfoItem ?: emptyList()) { item ->
                    if (wordInfoItem?.first() != item)
                        Spacer(modifier = Modifier.heightIn(16.dp))
                    itemInfo(item)
                    if (wordInfoItem?.last() != item || wordInfoItem.first() != item)
                        Divider()

                }
            }


        }

        if (uiState.Loading == true)
            loadingView()
    }

}


@Composable
fun searchField(vm: AndroidDictionaryViewModel) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { value ->
            text = value
            vm.getWordInfo(UiEvent.Search(value.text))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "Search icon"
            )
        },


        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        placeholder = { Text(text = "search..") },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, Color.LightGray)
            .background(color = MaterialTheme.colors.background)
    )
}


@Composable
fun itemInfo(wordInfoItem: wordInfoItem) {
    Column {
        Text(
            text = wordInfoItem.word,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Black
        )
        Text(text = wordInfoItem.phonetic, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.heightIn(16.dp))
        wordInfoItem.meanings?.forEach { meaning ->
            meaning.partOfSpeech?.let { Text(text = it, fontWeight = FontWeight.Bold) }
            meaning.definitions?.forEachIndexed { index, value ->
                Text(text = "${index + 1}  ${value.definition}")
                Spacer(modifier = Modifier.heightIn(8.dp))
                value?.example?.let {
                    Text(text = it)
                }
                Spacer(modifier = Modifier.heightIn(8.dp))
            }
            Spacer(modifier = Modifier.heightIn(12.dp))
        }
    }
}

