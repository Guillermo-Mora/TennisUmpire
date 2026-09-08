package com.guimor.tennisumpire.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val sports_tennisIcon: ImageVector
  get() {
    if (_sports_tennis != null) {
      return _sports_tennis!!
    }
    _sports_tennis =
      ImageVector.Builder(
          name = "sports_tennis",
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
            moveTo(13f, 14.55f)
            quadToRelative(-2.42f, 0f, -3.55f, 0.28f)
            reflectiveQuadTo(7.53f, 15.9f)
            lineToRelative(-3.4f, 3.4f)
            quadTo(3.85f, 19.58f, 3.44f, 19.58f)
            reflectiveQuadTo(2.73f, 19.3f)
            quadTo(2.43f, 19f, 2.43f, 18.59f)
            quadToRelative(0f, -0.41f, 0.3f, -0.71f)
            lineTo(6.1f, 14.5f)
            quadTo(6.88f, 13.73f, 7.16f, 12.56f)
            reflectiveQuadTo(7.45f, 9f)
            quadTo(7.45f, 7.55f, 8.1f, 6.15f)
            reflectiveQuadTo(9.95f, 3.55f)
            quadTo(12.23f, 1.27f, 14.98f, 0.97f)
            reflectiveQuadTo(19.5f, 2.5f)
            quadTo(21.3f, 4.3f, 21f, 7.05f)
            reflectiveQuadToRelative(-2.55f, 5f)
            quadToRelative(-1.2f, 1.2f, -2.6f, 1.85f)
            reflectiveQuadTo(13f, 14.55f)
            close()
            moveToRelative(-2.7f, -2.9f)
            quadToRelative(1.18f, 1.15f, 3.18f, 0.85f)
            reflectiveQuadToRelative(3.57f, -1.88f)
            quadToRelative(1.6f, -1.6f, 1.91f, -3.59f)
            reflectiveQuadTo(18.1f, 3.92f)
            quadTo(16.9f, 2.72f, 14.96f, 3.02f)
            quadToRelative(-1.94f, 0.3f, -3.56f, 1.9f)
            quadTo(9.83f, 6.5f, 9.49f, 8.49f)
            quadToRelative(-0.34f, 1.99f, 0.81f, 3.16f)
            close()
            moveToRelative(4.88f, 10.18f)
            quadTo(14f, 20.65f, 14f, 19f)
            reflectiveQuadToRelative(1.18f, -2.82f)
            reflectiveQuadTo(18f, 15f)
            reflectiveQuadToRelative(2.83f, 1.18f)
            reflectiveQuadTo(22f, 19f)
            reflectiveQuadToRelative(-1.17f, 2.82f)
            reflectiveQuadTo(18f, 23f)
            reflectiveQuadTo(15.18f, 21.83f)
            close()
            moveToRelative(4.24f, -1.41f)
            quadTo(20f, 19.83f, 20f, 19f)
            reflectiveQuadTo(19.41f, 17.59f)
            reflectiveQuadTo(18f, 17f)
            reflectiveQuadToRelative(-1.41f, 0.59f)
            quadTo(16f, 18.18f, 16f, 19f)
            reflectiveQuadToRelative(0.59f, 1.41f)
            reflectiveQuadTo(18f, 21f)
            reflectiveQuadToRelative(1.41f, -0.59f)
            close()
            moveTo(18f, 19f)
            close()
          }
        }
        .build()
    return _sports_tennis!!
  }

private var _sports_tennis: ImageVector? = null
