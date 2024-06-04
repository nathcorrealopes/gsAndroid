package nathcorrealopes.com.github.model

import androidx.annotation.Size

data class ItemModel(
        @field:Size(min = 3, max = 50)
        val  name : String,
        val name1 : String,
        val name2 : String,
        val onRemove: (ItemModel) -> Unit= {}

    )
