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
public val sportsIcon: ImageVector
  get() {
    if (_sports != null) {
      return _sports!!
    }
    _sports =
      ImageVector.Builder(
          name = "sports",
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
            quadTo(8.5f, 19f, 6.75f, 17.25f)
            reflectiveQuadTo(5f, 13f)
            quadTo(5f, 12.73f, 5.03f, 12.45f)
            reflectiveQuadTo(5.1f, 11.9f)
            quadTo(4.98f, 11.95f, 4.8f, 11.98f)
            reflectiveQuadTo(4.5f, 12f)
            quadTo(3.45f, 12f, 2.73f, 11.27f)
            reflectiveQuadTo(2f, 9.5f)
            reflectiveQuadTo(2.69f, 7.72f)
            reflectiveQuadTo(4.43f, 7f)
            quadTo(5.25f, 7f, 5.91f, 7.46f)
            quadTo(6.58f, 7.93f, 6.85f, 8.65f)
            quadTo(7.68f, 7.9f, 8.74f, 7.45f)
            reflectiveQuadTo(11f, 7f)
            horizontalLineTo(21f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(22f, 8f)
            verticalLineToRelative(2f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(21f, 11f)
            horizontalLineTo(17f)
            verticalLineToRelative(2f)
            quadToRelative(0f, 2.5f, -1.75f, 4.25f)
            reflectiveQuadTo(11f, 19f)
            close()
            moveTo(5.21f, 10.21f)
            quadTo(5.5f, 9.92f, 5.5f, 9.5f)
            quadTo(5.5f, 9.07f, 5.21f, 8.79f)
            reflectiveQuadTo(4.5f, 8.5f)
            quadTo(4.08f, 8.5f, 3.79f, 8.79f)
            reflectiveQuadTo(3.5f, 9.5f)
            quadToRelative(0f, 0.42f, 0.29f, 0.71f)
            reflectiveQuadTo(4.5f, 10.5f)
            reflectiveQuadTo(5.21f, 10.21f)
            close()
            moveToRelative(7.2f, 4.2f)
            quadTo(13f, 13.83f, 13f, 13f)
            reflectiveQuadTo(12.41f, 11.59f)
            reflectiveQuadTo(11f, 11f)
            quadToRelative(-0.82f, 0f, -1.41f, 0.59f)
            quadTo(9f, 12.18f, 9f, 13f)
            reflectiveQuadToRelative(0.59f, 1.41f)
            reflectiveQuadTo(11f, 15f)
            reflectiveQuadToRelative(1.41f, -0.59f)
            close()
          }
        }
        .build()
    return _sports!!
  }

private var _sports: ImageVector? = null
