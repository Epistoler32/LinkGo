package com.friendevs.linkgo.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.friendevs.linkgo.R
import com.friendevs.linkgo.navigation.Screens

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)

        ) {
            item(){ ProfileHeader() }
            item() { StatsRow() }
            item { Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){Text("MY CIRCLES", style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold) }}
            item { CirclesSection() }
            item { SettingsSection() }
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Text("You", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

        Text(
            "Downtown Manhattan",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun StatsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        StatItem("3", "Circles",R.drawable.ic_launcher_foreground)
        StatItem("12", "Snaps", R.drawable.ic_launcher_foreground)
        StatItem("82%", "Battery", R.drawable.ic_launcher_foreground)
    }
}

@Composable
fun StatItem(number: String, label: String, picRsrc: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


        Card(
            modifier = Modifier.width(30.dp),
            shape = RoundedCornerShape(16.dp)
        ){
        Image(
            painterResource(picRsrc),
            contentDescription = "Stat Image",
            Modifier.size(35.dp),
        )}

        Text(number, fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text(label, color = Color.Gray)
    }
}

@Composable
fun CirclesSection() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        CircleCard("🔥", "Squad", "7 day streak")
        CircleCard("🏠", "Family", "14 day streak")
        CircleCard("💼", "Work crew", "3 day streak")
    }
}

@Composable
fun CircleCard(icon: String, title: String, streak: String) {
    Card(
        modifier = Modifier.width(120.dp).height(120.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(icon, fontSize = 25.sp)
            Text(title, fontWeight = FontWeight.Bold)
            Text(streak, color = Color.Red, fontSize = 15.sp)
        }
    }
}

@Composable
fun SettingsSection() {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        SettingItem("Notifications", "On")
        SettingItem("Privacy", "")
        SettingItem("Dark Mode", "On")
    }
}

@Composable
fun SettingItem(title: String, status: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title)
            Text(status, color = Color.Gray)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
        NavigationBar {
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Screens.Map.name) },
                icon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                label = { Text("MAP") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Screens.Feed.name) },
                icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                label = { Text("FEED") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Screens.Chat.name) },
                icon = { Icon(Icons.Default.Send, contentDescription = null) },
                label = { Text("CHAT") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Screens.Hotspots.name) },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text("HOTSPOTS") }
            )
            NavigationBarItem(
                selected = true,
                onClick = { navController.navigate(Screens.Profile.name) },
                icon = { Icon(Icons.Default.Person, contentDescription = null) },
                label = { Text("PROFILE") }
            )
        }
}

