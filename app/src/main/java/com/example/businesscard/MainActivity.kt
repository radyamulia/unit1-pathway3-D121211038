package com.example.businesscard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentWrapper("Radya Mulia Panatagama", "Front-End Website Developer", "+62 856 5622 1961", "Radya Mulia", "radyamulia.dev@gmail.com")
                }
            }
        }
    }
}

@Composable
fun ContentWrapper(name: String, title: String, whatsapp: String, linkedin: String, email: String, modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(R.drawable.backgroundimg)
    Box(
        modifier = modifier
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            MainContent(name = name, title = title)
            Spacer(Modifier.height(100.dp))
            ContentDetails(whatsapp = whatsapp, linkedin = linkedin, email = email)
        }
    }
}

@Composable
fun MainContent(name: String, title: String, modifier: Modifier = Modifier) {
    val profileImage = painterResource(R.drawable.profileimg);
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = profileImage,
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(50.dp))
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.LightGray,
            modifier = Modifier
        )
    }
}

@Composable
fun ContentDetails(whatsapp: String, linkedin: String, email: String, modifier: Modifier = Modifier) {
    val whatsappIcon = painterResource(R.drawable.icon_whatsapp)
    val linkedinIcon = painterResource(R.drawable.icon_linkedin)
    val emailIcon = painterResource(R.drawable.icon_email)
    Column {
        ContentDetailsRow(painter = whatsappIcon, description = "+62 856 5622 1961", link = "https://wa.me/6285656221961")
        ContentDetailsRow(painter = linkedinIcon, description = "Radya Mulia", link = "https://linkedin.com/in/radyamulia")
        ContentDetailsRow(painter = emailIcon, description = "radyamulia.dev@gmail.com", link = "https://mail.google.com")
    }
}

@Composable
fun ContentDetailsRow(painter: Painter, description: String, link: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(link)) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(2.dp)
            .clickable(onClick = { context.startActivity(intent) })
    ) {
        Icon(
            painter = painter,
            contentDescription = "Linkedin Icon",
            modifier = Modifier.size(width = 20.dp, height = 20.dp),
            tint = Color.White
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = description,
            color = Color.White,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentPreview() {
    BusinessCardTheme {
        ContentWrapper("Radya Mulia Panatagama", "Front-End Website Developer", "+62 856 5622 1961", "Radya Mulia", "radyamulia.dev@gmail.com")
    }
}