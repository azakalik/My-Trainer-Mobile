package com.example.mytrainermobile.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.mytrainermobile.R

@Composable
fun ShareButton(routineTitle: String) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, stringResource(id = R.string.shareText))
        putExtra(Intent.EXTRA_TITLE, routineTitle)
        type = "text/plain"
    }
    val context1 = LocalContext.current
    val shareIntent = Intent.createChooser(sendIntent, null)

    IconButton(onClick = { startActivity( context1, shareIntent, null) }) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier
                    .size(35.dp),
                imageVector = Icons.Filled.Share,
                contentDescription = "Share",
                tint = Color.White
            )
            Text(
                text = stringResource(id = R.string.share),
                color = Color.White
            )
        }
    }
}