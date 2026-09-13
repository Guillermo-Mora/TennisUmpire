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
public val weightIcon: ImageVector
  get() {
    if (_weight != null) {
      return _weight!!
    }
    _weight =
      ImageVector.Builder(
          name = "weight",
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
            moveTo(6f, 19f)
            horizontalLineTo(18f)
            lineTo(16.58f, 9f)
            horizontalLineTo(7.43f)
            lineTo(6f, 19f)
            close()
            moveTo(12f, 7f)
            quadToRelative(0.43f, 0f, 0.71f, -0.29f)
            quadTo(13f, 6.43f, 13f, 6f)
            reflectiveQuadTo(12.71f, 5.29f)
            reflectiveQuadTo(12f, 5f)
            reflectiveQuadTo(11.29f, 5.29f)
            reflectiveQuadTo(11f, 6f)
            reflectiveQuadToRelative(0.29f, 0.71f)
            reflectiveQuadTo(12f, 7f)
            close()
            moveToRelative(2.83f, 0f)
            horizontalLineToRelative(1.75f)
            quadToRelative(0.75f, 0f, 1.3f, 0.5f)
            reflectiveQuadToRelative(0.68f, 1.22f)
            lineToRelative(1.43f, 10f)
            quadToRelative(0.13f, 0.9f, -0.46f, 1.59f)
            reflectiveQuadTo(18f, 21f)
            horizontalLineTo(6f)
            quadTo(5.08f, 21f, 4.49f, 20.31f)
            reflectiveQuadTo(4.03f, 18.73f)
            lineToRelative(1.42f, -10f)
            quadTo(5.58f, 8f, 6.13f, 7.5f)
            reflectiveQuadTo(7.43f, 7f)
            horizontalLineTo(9.18f)
            quadTo(9.1f, 6.75f, 9.05f, 6.51f)
            reflectiveQuadTo(9f, 6f)
            quadTo(9f, 4.75f, 9.88f, 3.88f)
            reflectiveQuadTo(12f, 3f)
            reflectiveQuadToRelative(2.13f, 0.88f)
            reflectiveQuadTo(15f, 6f)
            quadToRelative(0f, 0.27f, -0.05f, 0.51f)
            reflectiveQuadTo(14.83f, 7f)
            close()
            moveTo(6f, 19f)
            horizontalLineTo(18f)
            horizontalLineTo(6f)
            close()
          }
        }
        .build()
    return _weight!!
  }

private var _weight: ImageVector? = null
