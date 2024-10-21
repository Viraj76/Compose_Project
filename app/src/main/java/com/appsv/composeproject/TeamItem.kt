package com.appsv.composeproject

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.appsv.composeproject.cricket.Ranking
import com.appsv.composeproject.cricket.TeamItemUI

@Preview
@Composable
fun TeamItemPreview(modifier: Modifier = Modifier) {

    TeamItem(
        teamItemUI = TeamItemUI(
            id=1,
            type = "T20I",
            gender = "women",
            name="India",
            code="IND",
            image_path="https://cdn.sportmonks.com/images/cricket/teams/10/10.png",
            ranking=Ranking(
                matches = 234,
                points = 2345,
                position = 1,
                rating = 345
            ),
        )
    )

}



@Composable
fun TeamItem(
    modifier: Modifier = Modifier,
    teamItemUI: TeamItemUI
) {

    val mainColor = if (teamItemUI.gender == "men") Color.Blue else colorResource(R.color.hard_pink)
    val itemBackground = colorResource(if (teamItemUI.gender == "men") R.color.light_blue1 else R.color.light_pink)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, mainColor, RoundedCornerShape(10.dp))
            .background(itemBackground)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(R.drawable.img),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.weight(1f).padding(3.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = teamItemUI.name,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = mainColor,
                    modifier = Modifier.padding(vertical = 4.dp)
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row () {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.sports_cricket_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                            contentDescription = "Matches",
                            tint = Color.Red,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = teamItemUI.ranking.matches.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    }

                    Row () {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "Matches",
                            tint = colorResource(R.color.yellow),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = teamItemUI.ranking.rating.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.yellow)
                        )
                    }

                    Row () {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "Matches",
                            modifier = Modifier.size(20.dp),
                            tint =  Color.Blue
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = teamItemUI.ranking.points.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                    }
                }
            }

            Text(
                modifier = Modifier.padding(),
                text = teamItemUI.ranking.position.toString(),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = mainColor,

            )
        }
    }
}
