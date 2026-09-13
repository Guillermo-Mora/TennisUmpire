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
public val femaleIcon: ImageVector
  get() {
    if (_female != null) {
      return _female!!
    }
    _female =
      ImageVector.Builder(
          name = "female",
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
            moveTo(11f, 19f)
            horizontalLineTo(10f)
            quadTo(9.58f, 19f, 9.29f, 18.71f)
            quadTo(9f, 18.43f, 9f, 18f)
            reflectiveQuadTo(9.29f, 17.29f)
            quadTo(9.58f, 17f, 10f, 17f)
            horizontalLineToRelative(1f)
            verticalLineTo(14.9f)
            quadTo(9.03f, 14.55f, 7.76f, 13.01f)
            reflectiveQuadTo(6.5f, 9.45f)
            quadTo(6.5f, 7.18f, 8.11f, 5.59f)
            reflectiveQuadTo(12f, 4f)
            quadToRelative(2.28f, 0f, 3.89f, 1.59f)
            quadTo(17.5f, 7.18f, 17.5f, 9.45f)
            quadToRelative(0f, 2.03f, -1.26f, 3.56f)
            reflectiveQuadTo(13f, 14.9f)
            verticalLineTo(17f)
            horizontalLineToRelative(1f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(15f, 18f)
            reflectiveQuadToRelative(-0.29f, 0.71f)
            reflectiveQuadTo(14f, 19f)
            horizontalLineTo(13f)
            verticalLineToRelative(1f)
            quadToRelative(0f, 0.43f, -0.29f, 0.71f)
            reflectiveQuadTo(12f, 21f)
            reflectiveQuadTo(11.29f, 20.71f)
            quadTo(11f, 20.43f, 11f, 20f)
            verticalLineTo(19f)
            close()
            moveToRelative(3.48f, -7.03f)
            quadTo(15.5f, 10.95f, 15.5f, 9.5f)
            reflectiveQuadTo(14.48f, 7.02f)
            reflectiveQuadTo(12f, 6f)
            reflectiveQuadTo(9.53f, 7.02f)
            reflectiveQuadTo(8.5f, 9.5f)
            reflectiveQuadToRelative(1.03f, 2.47f)
            reflectiveQuadTo(12f, 13f)
            reflectiveQuadToRelative(2.48f, -1.03f)
            close()
          }
        }
        .build()
    return _female!!
  }

private var _female: ImageVector? = null
