import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andegym.R
import com.example.andegym.data.model.ExercisePlan

/*
@Composable
fun Exercises(){
    Text(
        text="План на сегодня",
        fontSize = 14.sp,
        fontFamily=FontFamily(Font(R.font.manrope_semibold)),
        color=Color(0xFFA0A0A0),
        modifier=Modifier.padding(top=24.dp,start=16.dp)
    )
    Spacer(Modifier.height(12.dp))
    class Exercise(val name:String,val number:String)
    val listExercises=mutableListOf(Exercise("Жим лежа","4x8"),Exercise("Присед","3x10"),Exercise("Становая","4x6"),Exercise("Подтягивания","15x3"))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(start=16.dp)
    )
    {items(listExercises){
            item->
        Card(
            shape = RoundedCornerShape(12.dp),
            colors=CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),
            modifier = Modifier
                .height(100.dp)
                .width(140.dp)
        )
        {
            Column(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {
                Text(
                    text=item.name,
                    fontFamily=FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 16.sp,
                    color = Color(0xFFE0E0E0)
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text=item.number,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 14.sp,
                    color=Color(0xFFA0A0A0)
                )
                Icon(
                    imageVector = Icons.Default.FitnessCenter,
                    tint=Color(0xFF6C5CE7),
                    contentDescription = "Иконка упраженения",
                    modifier=Modifier.size(25.dp)
                )
            }
        }
    }

    }
}


 */

@Composable
fun CardGym(exercisePlan: ExercisePlan){
    Card(
        shape = RoundedCornerShape(12.dp),
        colors=CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),
        modifier = Modifier
            .height(100.dp)
            .width(140.dp)
    )
    {
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text(
                text=exercisePlan.name,
                fontFamily=FontFamily(Font(R.font.manrope_semibold)),
                fontSize = 16.sp,
                color = Color(0xFFE0E0E0)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text="${exercisePlan.sets}x${exercisePlan.reps}",
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color=Color(0xFFA0A0A0)
            )
            Icon(
                imageVector = Icons.Default.FitnessCenter,
                tint=Color(0xFF6C5CE7),
                contentDescription = "Иконка упраженения",
                modifier=Modifier.size(25.dp)
            )
        }
    }
}