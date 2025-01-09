package com.umt.practicecompose

import android.view.Surface
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

//@Composable
//fun practiceStates(){
//
//    var number = mutableStateOf("From")
//
//    Column {
//        OutlinedTextField(value=number,
//            onValueChange = {
//                number.value = it
//            })
//    }



@Composable
fun UnitConverter(){

    // drop down expansion
    var from by remember { mutableStateOf(false) }
    var to by remember { mutableStateOf(false) }

    var fromText by remember { mutableStateOf("Centimeters") }

    var toText by remember { mutableStateOf("Meters") }


    var convertionFactor by remember { mutableStateOf(0.01) }

    var outputConvertionFactor by remember { mutableStateOf(0.01) }


    var result by remember { mutableStateOf("Units") } // output

    // input from user

    var number by remember { mutableStateOf("") }

    fun converTheUnits(){
        val inputUnits = number.toDoubleOrNull() ?: 0.0
        val total = (  inputUnits* convertionFactor * 100 / outputConvertionFactor  ).roundToInt() / 100.0
        result = total.toString()
    }

//    Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
//
//
//        Box( modifier =  Modifier.background(Color.Red)
//            .width(200.dp)
//            .height(200.dp)
//            .verticalScroll(rememberScrollState())
//
//
//        )
//        {
//
//            Text("This is a box, hello , hi hhhhhhh")
//
//
//        }
//
//    }

// it will override max size of above box

    // alignment is on cross axis
    // arrangement is on main axis

    // For Row Alignment -> Top, Bottom, CenterVertically
    // For column Alignment -> Start, End, Center Horizontally

    // Arrangement -> Column -> Top, Center , Bottom
    // Alignment -> Row -> Start, Center, End
    // Space between, Space around, Space Evenly, Absolute
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value=number,
            onValueChange = {
                number = it
                converTheUnits()
            },
            label = {Text("Enter value:")})

        // padding reusibility
        //for consistance spacing go for spacer otherwise manual padding

        // onValueChange is an anoynomous function having no name, passing string to it
        Row{


            val context = LocalContext.current // gives current UI like which activity

            // Input Box
            Box {

                // Input Button
                Button ( onClick = {      to = !to

                } ) {

                    Text(toText)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down of Selector")

                }

                DropdownMenu(
                    expanded = to, onDismissRequest = { to = !to  } // call back when menu dismissed}
                )
                {

                    DropdownMenuItem(
                        text = { Text("Centimeters")  },
                        onClick =  {

                            toText =  "Centimeters"
                            to = !to
                            convertionFactor = 0.01
                            converTheUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("MiliMeters")  },
                        onClick =  {
                            toText =  "MiliMeters"
                            to = !to
                            convertionFactor = 0.001
                            converTheUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet")  },
                        onClick =  {

                            toText =  "Feet"
                            to = !to
                            convertionFactor = 0.3048
                            converTheUnits()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Meters")  },
                        onClick =  {
                            toText =  "Meters"
                            to = !to
                            convertionFactor = 1.0
                            converTheUnits()
                        }
                    )


                }


            }
            Spacer(modifier =  Modifier.width(16.dp))

            Box {
                Button ( onClick = { from  = !from } ) {

                    Text(fromText)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Drop Down of Selector")

                }


                DropdownMenu(
                    expanded = from, onDismissRequest = { from  = !from  } // call back when menu dismissed}
                )
                {

                    DropdownMenuItem(
                        text = { Text("Centimeters")  },
                        onClick =  {   fromText  =  "Centimeters"
                            from  = !from
                            outputConvertionFactor  = 0.01
                            converTheUnits()

                        }
                    )



                    DropdownMenuItem(
                        text = { Text("MiliMeters")  },
                        onClick =  { fromText  =  "MiliMeters"
                            from  = !from
                            outputConvertionFactor = 0.001
                            converTheUnits()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Feet")  },
                        onClick =  {

                            fromText =  "Feet"
                            from  = !from
                            outputConvertionFactor  = 0.3048
                            converTheUnits()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Meters")  },
                        onClick =  { fromText  =  "Meters"
                            from  = !from
                            outputConvertionFactor = 1.0
                            converTheUnits()
                        }
                    )


                }

            }



        }
        Text("RESULT : $result")
    }


}



@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()

}

@Preview(showBackground = true)
@Composable
fun CaptainGamePreview(){
    CaptainsGame()

}

@Composable
fun CaptainsGame(){
    // total drugs discovered
    // whenever our UI recompose it will update the value accrdingly
    // Recompose mean building those UI elements whose state has been changed
    // like default value is 0 then if user clicks then goes to 1
    // so observer will look at drugsDiscovered variable of mutablestate object
    // Jetpack Compose acts as the observer, and you don’t need to explicitly observe state changes—Compose
    // will handle this based on which composables read the state.
    val drugsDiscovered = remember {   mutableStateOf(0)   }
    // mutable state automatically changes your ui if there is change , so automatic observer and updater of UI
    // by keyword is part of delegate mechanism
    var drugsDiscoveredUsingBy by remember { mutableStateOf(0) }

    Column{
        Spacer( modifier =  Modifier.height(32.dp))
        // .value to access value of mutable state object
        Text("Your drugs -> ${drugsDiscoveredUsingBy}")

        Button(onClick = {drugsDiscoveredUsingBy+=1}) {
            Text("Hey!! Click me")
        }

    }

}

@Composable
fun Portfolio(){

    Spacer(modifier = Modifier.height(40.dp))
    var isOpen by remember { mutableStateOf(false) }
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxWidth().padding(30.dp)
    ) {



        Column( horizontalAlignment = Alignment.CenterHorizontally, modifier =  Modifier.padding(12.dp)){

            Image(painter = painterResource(R.drawable.ic_person)
                , contentDescription = "Profile Pic",
                modifier = Modifier.size(60.dp))
            Spacer(modifier = Modifier.height(12.dp))

            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
//        Divider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(text="Talha Atif", style = TextStyle(color = Color.Green, fontSize = 18.sp, fontWeight = FontWeight.Bold))
            Text(text="Android Developer", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Image(painter = painterResource(R.drawable.ic_night)
                    , contentDescription = "Random Pic",
                    modifier = Modifier.size(15.dp))
                Text(text="Instagram", style = TextStyle(color = Color.Black, fontSize = 8.sp, fontWeight = FontWeight.Normal))
            }
            Row {
                Image(painter = painterResource(R.drawable.ic_night)
                    , contentDescription = "Random Pic",
                    modifier = Modifier.size(15.dp))
                Text(text="Linkedin", style = TextStyle(color = Color.Black, fontSize = 8.sp, fontWeight = FontWeight.Normal))
            }
            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = { isOpen = ! isOpen }){
                Text("My Projects")
            }
            if( isOpen){

                LazyColumn {
                    items(getProjects()){ // container
                        // it is item of our data list class that is of Data type
                        MakeItemRender(it)
                    }
                }

            }


        }


    }

}
// rv_layout
@Composable
fun MakeItemRender(item : Data){
    Row (modifier = Modifier.fillMaxWidth().padding(12.dp)){
        Image(painter = painterResource(R.drawable.ic_person)
            , contentDescription = "Project",
            modifier = Modifier.size(40.dp))
        Spacer(Modifier.width(12.dp))
        Column {
            Text(text=item.name, style = MaterialTheme.typography.headlineLarge)
            Text(text=item.description, style = MaterialTheme.typography.bodyMedium)
        }

    }

}

