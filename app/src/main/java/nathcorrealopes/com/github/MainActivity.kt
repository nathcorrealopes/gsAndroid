package nathcorrealopes.com.github

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import nathcorrealopes.com.github.adapter.ItemsAdapter
import nathcorrealopes.com.github.model.ItemModel
import nathcorrealopes.com.github.ui.theme.Nathalia_RM95907_RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.botaoinserir)
        val editTextpraia = findViewById<EditText>(R.id.edittextpraia)
        val editTextcidade = findViewById<EditText>(R.id.edittextcidade)
        val editTextestado = findViewById<EditText>(R.id.edittextestado)


        button.setOnClickListener {

            if (editTextpraia.text.isEmpty()){
                editTextpraia.error = "Preencha o campo Praia"
                return@setOnClickListener
            }
            if (editTextcidade.text.isEmpty()){
                editTextcidade.error = "Preencha o campo Cidade"
                return@setOnClickListener
            }
            if (editTextestado.text.isEmpty()){
                editTextestado.error = "Preencha o campo estado"
                return@setOnClickListener
            }


            val item = ItemModel(
                name = editTextpraia.text.toString(),
                name1 = editTextcidade.text.toString(),
                name2 = editTextestado.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }

            )

            itemsAdapter.addItem(item)
            editTextpraia.text.clear()
            editTextestado.text.clear()
            editTextcidade.text.clear()

        }

        }}