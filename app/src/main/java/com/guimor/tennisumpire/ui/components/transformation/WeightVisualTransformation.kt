package com.guimor.tennisumpire.ui.components.transformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class WeightVisualTransformation(
    private val mask: String = "kg"
) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = if (text.text.isNotEmpty()) AnnotatedString("${text.text} $mask") else text,
            offsetMapping = object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int = offset

                override fun transformedToOriginal(offset: Int): Int =
                    if (text.text.isEmpty()) offset
                    else if (offset > text.text.length) text.text.length
                    else offset
            }
        )
    }
}