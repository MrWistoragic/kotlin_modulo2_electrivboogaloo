package com.example.pr1_5

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random
import androidx.compose.ui.platform.LocalContext


data class Cart(
    val products: List <Product>
)
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)


@Preview
@Composable
fun ShoppingCartScreen() {
    // Исходный список товаров
    var products by remember { mutableStateOf(listOf(Product(0, "Товар #1", 100))) }

    // ВАЖНО: Вычисляем сумму и размер "на лету" (derived state)
    val totalSum = products.sumOf { it.price }
    val productSize = products.size

    Column(modifier = Modifier.padding(16.dp)) {
        // Вывод списка
        for (product in products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        // Передаем логику добавления
        AddProductSection(
            totalSum = totalSum,
            onAdd = {
                // Логика добавления
                val newProduct = Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(0, 100)
                )
                products = products + newProduct

                // Проверка на бесплатную доставку (Toast внутри onClick!)

            },
        )

        // Кнопка удаления
        RemoveProductSection(
            show = productSize > 0, // Управляем видимостью
            onRemove = {
                products = products.dropLast(1)
            }
        )
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit, totalSum: Int) {
    val context = LocalContext.current
    if (totalSum > 500) {
        Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
    }
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(show: Boolean, onRemove: () -> Unit) {
    if (show) { // Кнопка видна только если есть товары
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}