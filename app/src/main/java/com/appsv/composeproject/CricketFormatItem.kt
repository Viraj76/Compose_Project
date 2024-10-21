package com.appsv.composeproject

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun CricketFormatItems(
    format : Format =
        Format(
            cricketFormat = "T20I",
            isMen = true
        )

) {
    val mainColor = if(format.isMen) Color.Blue else colorResource(R.color.hard_pink)
    val itemBackground =  colorResource(if (format.isMen) R.color.light_blue1 else R.color.light_pink)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, mainColor, RoundedCornerShape(10.dp))
            .background(itemBackground)
        ,
        ) {

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = format.cricketFormat,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = mainColor
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "",
                    tint = mainColor
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = if(format.isMen) "Men" else "Women",
                    fontSize = 16.sp,
                    color = mainColor
                )
            }
        }

    }

}


@Composable
fun StagList(
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid (
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        verticalItemSpacing = 20.dp,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ){
        items(listOfFormat){
            CricketFormatItems(it)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposableF(modifier: Modifier = Modifier) {

    Text(
        modifier = Modifier.basicMarquee(),
        color = Color.White,
        text = buildAnnotatedString {
            append("Latest Rankings of ")
            // "  "
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline
                )) {
                append("Men's ")
            }

            append("and ")

            withStyle(
                style = SpanStyle(
                    color = colorResource(R.color.hard_pink),
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline
                )) {
                append("Women's")
            }
            append(" International Cricket Teams.")
        }
    )

}
data class Format(
    val cricketFormat: String,
    val isMen : Boolean
)
val listOfFormat = listOf(
    Format(
        cricketFormat = "T20I",
        isMen = true
    ),
    Format(
        cricketFormat = "T20I",
        isMen = false
    ),
    Format(
        cricketFormat = "ODI",
        isMen = true
    ),
    Format(
        cricketFormat = "ODI",
        isMen = false
    ),
    Format(
        cricketFormat = "TEST",
        isMen = true
    ),
    Format(
        cricketFormat = "TEST",
        isMen = false
    )
)