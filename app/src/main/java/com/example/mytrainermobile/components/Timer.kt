package com.example.mytrainermobile.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.DefaultColor
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Timer(totalTime: Long, handleColor: Color, inactiveBarColor: Color, activeBarColor: Color,
          modifier: Modifier = Modifier, initialValue: Float = 1f, strokeWidth: Dp = 5.dp) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var value by remember {
        mutableStateOf(initialValue)
    }
    var currentTime by remember{
        mutableStateOf(totalTime)
    }
    var isRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isRunning) {
        if(currentTime > 0 && isRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = modifier.onSizeChanged { size = it }
    ) {
        Canvas( modifier = modifier.fillMaxWidth(1f)) {
            drawArc(
                color = inactiveBarColor,
                startAngle = -215f,
                sweepAngle = 250f,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = activeBarColor,
                startAngle = -215f,
                sweepAngle = 250f * value,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            val center = Offset(size.width / 2f, size.height / 2f)
            val beta = (250f * value + 145f) * (PI / 180f).toFloat()
            val r = size.width / 2f
            val a = cos(beta) * r
            val b = sin(beta) * r
            drawPoints(
                listOf(Offset(center.x + a, center.y + b)),
                pointMode = PointMode.Points,
                color = handleColor,
                strokeWidth = (strokeWidth * 3f).toPx(),
                cap = StrokeCap.Round
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text( text = (currentTime / 1000).toString(), fontSize = 24.sp, fontWeight = Bold, color = Color.White)
            IconButton(onClick= {
                if(currentTime <= 0L){
                    currentTime = totalTime
                    isRunning = true
                }else {
                    isRunning = !isRunning
                }
            },
            ) {
                if(isRunning && currentTime > 0L) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Stop",
                        tint = Color.Gray,
                    )
                }
                else{
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        tint = DefaultColor,
                    )
                }
            }
        }
    }
}