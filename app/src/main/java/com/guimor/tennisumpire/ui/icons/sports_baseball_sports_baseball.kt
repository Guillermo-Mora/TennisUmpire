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
public val sports_baseballIcon: ImageVector
  get() {
    if (_sports_baseball != null) {
      return _sports_baseball!!
    }
    _sports_baseball =
      ImageVector.Builder(
          name = "sports_baseball",
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
            moveTo(4.18f, 18.23f)
            quadTo(3.13f, 16.88f, 2.56f, 15.29f)
            reflectiveQuadTo(2f, 12f)
            reflectiveQuadTo(2.56f, 8.71f)
            quadTo(3.13f, 7.13f, 4.18f, 5.77f)
            quadTo(5.63f, 6.9f, 6.45f, 8.54f)
            quadTo(7.28f, 10.17f, 7.28f, 12f)
            reflectiveQuadTo(6.45f, 15.46f)
            reflectiveQuadTo(4.18f, 18.23f)
            close()
            moveTo(8.56f, 21.4f)
            quadTo(6.93f, 20.8f, 5.58f, 19.65f)
            quadTo(7.3f, 18.23f, 8.28f, 16.24f)
            reflectiveQuadTo(9.25f, 12f)
            reflectiveQuadTo(8.28f, 7.76f)
            reflectiveQuadTo(5.58f, 4.35f)
            quadTo(6.93f, 3.2f, 8.56f, 2.6f)
            reflectiveQuadTo(12f, 2f)
            reflectiveQuadToRelative(3.44f, 0.6f)
            reflectiveQuadToRelative(2.99f, 1.75f)
            quadTo(16.7f, 5.77f, 15.73f, 7.76f)
            reflectiveQuadTo(14.75f, 12f)
            reflectiveQuadToRelative(0.98f, 4.24f)
            reflectiveQuadToRelative(2.7f, 3.41f)
            quadTo(17.08f, 20.8f, 15.44f, 21.4f)
            reflectiveQuadTo(12f, 22f)
            reflectiveQuadTo(8.56f, 21.4f)
            close()
            moveTo(19.83f, 18.23f)
            quadTo(18.38f, 17.1f, 17.55f, 15.46f)
            reflectiveQuadTo(16.73f, 12f)
            quadToRelative(0f, -1.83f, 0.82f, -3.46f)
            reflectiveQuadTo(19.83f, 5.77f)
            quadToRelative(1.05f, 1.35f, 1.61f, 2.94f)
            reflectiveQuadTo(22f, 12f)
            reflectiveQuadToRelative(-0.56f, 3.29f)
            reflectiveQuadToRelative(-1.61f, 2.94f)
            close()
          }
        }
        .build()
    return _sports_baseball!!
  }

private var _sports_baseball: ImageVector? = null
