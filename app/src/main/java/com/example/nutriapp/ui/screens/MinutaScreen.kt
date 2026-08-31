package com.example.nutriapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nutriapp.data.RecetasRepository
import com.example.nutriapp.model.Receta
import com.example.nutriapp.navigation.Screen
import androidx.compose.ui.Modifier


///////////////
@Composable
fun MinutaScreen(navController: NavHostController) {
    val recetas = RecetasRepository.recetas

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(24.dp, 24.dp, 24.dp, 8.dp)) {
            Text(
                text = "Tu minuta semanal",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Elige una receta para ver la información nutricional",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(recetas) { receta ->
                RecetaCard(
                    receta = receta,
                    onClick = {
                        navController.navigate(Screen.RecetaDetalle.createRoute(receta.id))
                    }
                )
            }
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(50.dp)
        ) {
            Text("Volver")
        }
    }
}

@Composable
private fun RecetaCard(receta: Receta, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(
            text = receta.dia,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = receta.nombre,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "${receta.calorias} kcal",
            style = MaterialTheme.typography.bodyMedium
        )
    }



}
