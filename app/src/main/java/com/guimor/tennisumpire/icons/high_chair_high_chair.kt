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
public val high_chairIcon: ImageVector
  get() {
    if (_high_chair != null) {
      return _high_chair!!
    }
    _high_chair =
      ImageVector.Builder(
          name = "high_chair",
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
            moveTo(7.1f, 21f)
            quadTo(6.68f, 21f, 6.36f, 20.68f)
            reflectiveQuadTo(6.1f, 19.93f)
            lineTo(7f, 10.05f)
            lineTo(6.2f, 5.32f)
            quadTo(6.08f, 4.67f, 6.51f, 3.84f)
            reflectiveQuadTo(8.45f, 3f)
            quadToRelative(1.47f, 0f, 2.59f, 0.95f)
            reflectiveQuadToRelative(1.36f, 2.4f)
            lineTo(12.85f, 9f)
            horizontalLineTo(17f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(18f, 10f)
            reflectiveQuadToRelative(-0.29f, 0.71f)
            reflectiveQuadTo(17f, 11f)
            horizontalLineTo(16.1f)
            lineToRelative(0.8f, 8.93f)
            quadToRelative(0.05f, 0.43f, -0.25f, 0.75f)
            reflectiveQuadTo(15.9f, 21f)
            quadToRelative(-0.4f, 0f, -0.66f, -0.26f)
            reflectiveQuadTo(14.93f, 20.1f)
            lineTo(14.83f, 19f)
            horizontalLineTo(8.18f)
            lineToRelative(-0.1f, 1.1f)
            quadTo(8.03f, 20.48f, 7.76f, 20.74f)
            reflectiveQuadTo(7.1f, 21f)
            close()
            moveTo(8.45f, 9f)
            horizontalLineToRelative(2.38f)
            lineTo(10.43f, 6.68f)
            quadTo(10.3f, 5.95f, 9.74f, 5.47f)
            reflectiveQuadTo(8.45f, 5f)
            horizontalLineTo(8.18f)
            lineTo(8.45f, 9f)
            close()
            moveToRelative(0f, 0f)
            quadToRelative(1.78f, 0f, 2.07f, 0f)
            reflectiveQuadToRelative(0.3f, 0f)
            horizontalLineTo(8.45f)
            close()
            moveToRelative(-0.1f, 8f)
            horizontalLineToRelative(6.28f)
            lineTo(14.45f, 15f)
            horizontalLineTo(8.55f)
            lineToRelative(-0.2f, 2f)
            close()
            moveTo(8.73f, 13f)
            horizontalLineToRelative(5.55f)
            lineToRelative(-0.2f, -2f)
            horizontalLineTo(8.9f)
            lineTo(8.73f, 13f)
            close()
          }
        }
        .build()
    return _high_chair!!
  }

private var _high_chair: ImageVector? = null
