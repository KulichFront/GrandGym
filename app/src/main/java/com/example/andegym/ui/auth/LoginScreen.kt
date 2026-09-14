package com.example.andegym.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.example.andegym.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices.PIXEL_6
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun LoginScreen(
    onAuthSuccess:()->Unit
) {

    val auth = FirebaseAuth.getInstance()
    var nickname by remember{mutableStateOf("")}
    var email by remember{ mutableStateOf("") }
    var password by remember{mutableStateOf("")}
    val firestore= FirebaseFirestore.getInstance()
    var errortext by remember { mutableStateOf("") }
    if(auth.currentUser!=null){
        LaunchedEffect(Unit){
            onAuthSuccess()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .statusBarsPadding()
            .navigationBarsPadding()

            , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(80.dp))
                Text(
                    text="GrandGym",
                    fontSize = 48.sp,
                    fontFamily = FontFamily(Font(R.font.jura_bold)),
                    color=Color(0xFFE0E0E0),
                    modifier = Modifier.padding(bottom = 80.dp)
                )
        OutlinedTextField(
            value = nickname,
            onValueChange = {nickname=it},
            placeholder = {Text("Твой Никнейм")},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape= RoundedCornerShape(16.dp)
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            placeholder = {Text("Email")},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape= RoundedCornerShape(16.dp)
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            placeholder = {Text("Пароль")},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape= RoundedCornerShape(16.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(32.dp))
        Button(onClick = {
            auth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener { onAuthSuccess() }
                .addOnFailureListener {
                    exception -> errortext="Неверная почта или пароль"
                }
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C5CE7)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                .height(56.dp))
        {
            Text(
                text="ВОЙТИ",
                fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                fontSize = 14.sp,
                color=Color.White
            )
        }
        Button(onClick = {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { result ->

                    val userId = result.user?.uid ?: return@addOnSuccessListener
                    val userData=hashMapOf(
                        "nickname" to nickname,
                        "email" to email,
                        "level" to 1,
                        "xp" to 0
                    )
                    firestore.collection("users")
                        .document(userId)
                        .set(userData)
                        .addOnSuccessListener {
                            onAuthSuccess()
                        }
                }
                .addOnFailureListener { exception ->
                    errortext =  exception.message ?: "Ошибка"
                }
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A3A)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp,  end = 16.dp, bottom = 24.dp)
                .height(56.dp))
        {
            Text(
                text="РЕГИСТРАЦИЯ",
                fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                fontSize = 14.sp,
                color=Color(0xFFE0E0E0)
            )
        }
        if(errortext.isNotEmpty()){
            Text(
                text=errortext,
                color=Color(0xFFFF6B6B),
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier=Modifier.fillMaxWidth()
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true,
    device = PIXEL_6)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onAuthSuccess = {})
}