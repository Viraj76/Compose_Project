package com.appsv.composeproject.uis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import com.appsv.composeproject.R
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.composeproject.ui.theme.ColorPrimary
import com.appsv.composeproject.ui.theme.ColorSecondary
import com.appsv.composeproject.ui.theme.ColorSecondaryVariant
import com.appsv.composeproject.ui.theme.DarkGrayishPurple
import com.appsv.composeproject.ui.theme.GrayishBlue
import com.appsv.composeproject.ui.theme.GrayishPurple
import com.appsv.composeproject.ui.theme.LightGrayishBlue

@Preview
@Composable
fun ScreenOne(modifier: Modifier = Modifier) {

    val navItemList = listOf(
        NavItem("Dashboard", icon = NavIcon.Vector(Icons.Default.Home)),
        NavItem("Settings", icon = NavIcon.Resource(R.drawable.baseline_more_horiz_24))
    )


    var selectedIndex by remember {
        mutableIntStateOf(0)
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorSecondaryVariant,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                Spacer(modifier = Modifier.weight(1f))

                navItemList.forEachIndexed { index, navItem ->
                    val iconAndTextColor = if(selectedIndex == index) ColorSecondary else GrayishBlue

                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors().copy(
                            selectedIndicatorColor = Color.Transparent
                        ),
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            when (val icon = navItem.icon) {
                                is NavIcon.Vector -> {
                                    Icon(
                                        modifier = Modifier.size(35.dp),
                                        imageVector = icon.imageVector,
                                        contentDescription = navItem.label,
                                        tint = iconAndTextColor,
                                    )
                                }
                                is NavIcon.Resource -> {
                                    Icon(
                                        modifier = Modifier.size(35.dp),
                                        painter = painterResource(id = icon.resId),
                                        contentDescription = navItem.label,
                                        tint = iconAndTextColor
                                    )
                                }
                            }
                        },
                        label = {
                            Text(
                                text = navItem.label,
                                color = iconAndTextColor
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }

        },
        floatingActionButton = {
            ExtendedFloatingActionButton(

                onClick = { /* Handle click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 0.dp, start = 100.dp, end = 100.dp),
                containerColor = ColorPrimary,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Icon",
                    tint =  Color.White
                )
                Text(
                    text = "Add New",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center


    )
    { innerPadding ->
        Content(modifier = Modifier.padding(innerPadding))
    }

}

@Composable
fun Content(modifier: Modifier = Modifier) {

   Column(
       modifier = modifier
   ) {
       SearchBar()

       Spacer(modifier = Modifier.height(20.dp))

       Text(
           modifier = Modifier.padding(horizontal = 12.dp),
           text = "Recent Transactions",
           color = GrayishPurple,
           fontSize = 18.sp,
           fontWeight = FontWeight.Bold
       )

       RecentTransactions()
   }
    
}


@Composable
fun SearchBar() {

    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(Color.White),

    ){
        TextField(
            value = "",
            onValueChange = { /* Search functionality */ },
            modifier = Modifier
                .padding(horizontal = 18.dp, vertical = 12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)), // Apply rounded corners here
            placeholder = { Text("Search") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = LightGrayishBlue,
                focusedIndicatorColor = LightGrayishBlue,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

    }

}

@Composable
fun RecentTransactions() {
    val transactions = listOf(
        Transaction(
            transactionType = "Expense",
            transactionNumber = 1,
            description = "Groceries",
            date = "2024-12-06",
            amount = 45.50
        ),
        Transaction(
            transactionType = "Income",
            transactionNumber = 2,
            description = "Salary",
            date = "2024-12-01",
            amount = 1500.00
        ),
        Transaction(
            transactionType = "Expense",
            transactionNumber = 3,
            description = "Electricity Bill",
            date = "2024-12-05",
            amount = 75.30
        ),
        Transaction(
            transactionType = "Income",
            transactionNumber = 4,
            description = "Freelance Project",
            date = "2024-12-02",
            amount = 500.00
        ),
        Transaction(
            transactionType = "Expense",
            transactionNumber = 5,
            description = "Dining Out",
            date = "2024-12-04",
            amount = 60.75
        )
    )


    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(transactions) { transaction ->
            TransactionCard(transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    transaction.transactionType,
                    style = MaterialTheme.typography.bodyMedium,
                    color = DarkGrayishPurple,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "₹ ${transaction.amount}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = DarkGrayishPurple,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${transaction.transactionType} #${transaction.transactionNumber}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = GrayishPurple
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                transaction.date,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 13.sp
            )
        }
    }
}

data class Transaction(
    val transactionType: String,
    val transactionNumber: Int,
    val description : String,
    val date: String,
    val amount: Double
)