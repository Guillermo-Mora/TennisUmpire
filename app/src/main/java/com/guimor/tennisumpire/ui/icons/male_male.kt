package com.guimor.tennisumpire.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val maleIcon: ImageVector
  get() {
    if (_male != null) {
      return _male!!
    }
    _male =
      ImageVector.Builder(
          name = "male",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero,
          ) {
            moveTo(20f, 5f)
            verticalLineTo(9f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(19f, 10f)
            reflectiveQuadTo(18.29f, 9.71f)
            reflectiveQuadTo(18f, 9f)
            verticalLineTo(7.43f)
            lineToRelative(-3.97f, 3.95f)
            quadToRelative(0.47f, 0.7f, 0.72f, 1.49f)
            reflectiveQuadTo(15f, 14.5f)
            quadToRelative(0f, 2.3f, -1.6f, 3.9f)
            reflectiveQuadTo(9.5f, 20f)
            reflectiveQuadTo(5.6f, 18.4f)
            reflectiveQuadTo(4f, 14.5f)
            reflectiveQuadTo(5.6f, 10.6f)
            reflectiveQuadTo(9.5f, 9f)
            quadToRelative(0.83f, 0f, 1.63f, 0.24f)
            quadToRelative(0.8f, 0.24f, 1.48f, 0.74f)
            lineTo(16.58f, 6f)
            horizontalLineTo(15f)
            quadTo(14.58f, 6f, 14.29f, 5.71f)
            quadTo(14f, 5.43f, 14f, 5f)
            reflectiveQuadTo(14.29f, 4.29f)
            reflectiveQuadTo(15f, 4f)
            horizontalLineToRelative(4f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(20f, 5f)
            close()
            moveTo(7.03f, 12.02f)
            quadTo(6f, 13.05f, 6f, 14.5f)
            reflectiveQuadToRelative(1.03f, 2.48f)
            reflectiveQuadTo(9.5f, 18f)
            reflectiveQuadToRelative(2.48f, -1.02f)
            reflectiveQuadTo(13f, 14.5f)
            reflectiveQuadTo(11.98f, 12.02f)
            reflectiveQuadTo(9.5f, 11f)
            reflectiveQuadTo(7.03f, 12.02f)
            close()
          }
        }
        .build()
    return _male!!
  }

private var _male: ImageVector? = null
