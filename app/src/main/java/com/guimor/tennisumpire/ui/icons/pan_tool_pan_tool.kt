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
public val pan_toolIcon: ImageVector
  get() {
    if (_pan_tool != null) {
      return _pan_tool!!
    }
    _pan_tool =
      ImageVector.Builder(
          name = "pan_tool",
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
            moveTo(10.05f, 23f)
            quadTo(9.3f, 23f, 8.65f, 22.66f)
            reflectiveQuadTo(7.58f, 21.7f)
            lineTo(1.68f, 13.05f)
            quadTo(1.48f, 12.75f, 1.5f, 12.4f)
            reflectiveQuadTo(1.8f, 11.8f)
            quadTo(2.28f, 11.33f, 2.93f, 11.25f)
            reflectiveQuadToRelative(1.18f, 0.3f)
            lineTo(7f, 13.58f)
            verticalLineTo(4f)
            quadTo(7f, 3.57f, 7.29f, 3.29f)
            reflectiveQuadTo(8f, 3f)
            reflectiveQuadTo(8.71f, 3.29f)
            reflectiveQuadTo(9f, 4f)
            verticalLineTo(15.5f)
            quadToRelative(0f, 0.6f, -0.54f, 0.89f)
            quadTo(7.93f, 16.68f, 7.43f, 16.33f)
            lineTo(5.3f, 14.83f)
            lineToRelative(3.92f, 5.73f)
            quadToRelative(0.13f, 0.2f, 0.35f, 0.32f)
            reflectiveQuadTo(10.05f, 21f)
            horizontalLineToRelative(3.47f)
            horizontalLineTo(17f)
            quadToRelative(0.82f, 0f, 1.41f, -0.59f)
            reflectiveQuadTo(19f, 19f)
            verticalLineTo(5f)
            quadTo(19f, 4.57f, 19.29f, 4.29f)
            reflectiveQuadTo(20f, 4f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(21f, 5f)
            verticalLineTo(19f)
            quadToRelative(0f, 1.65f, -1.17f, 2.82f)
            reflectiveQuadTo(17f, 23f)
            horizontalLineTo(10.05f)
            close()
            moveTo(12.71f, 1.29f)
            quadTo(13f, 1.57f, 13f, 2f)
            verticalLineToRelative(9f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(12f, 12f)
            quadToRelative(-0.42f, 0f, -0.71f, -0.29f)
            quadTo(11f, 11.43f, 11f, 11f)
            verticalLineTo(2f)
            quadTo(11f, 1.57f, 11.29f, 1.29f)
            reflectiveQuadTo(12f, 1f)
            reflectiveQuadToRelative(0.71f, 0.29f)
            close()
            moveToRelative(4f, 1f)
            quadTo(17f, 2.57f, 17f, 3f)
            verticalLineToRelative(8f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(16f, 12f)
            quadToRelative(-0.42f, 0f, -0.71f, -0.29f)
            quadTo(15f, 11.43f, 15f, 11f)
            verticalLineTo(3f)
            quadTo(15f, 2.57f, 15.29f, 2.29f)
            reflectiveQuadTo(16f, 2f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            close()
            moveTo(12.15f, 16.5f)
            close()
          }
        }
        .build()
    return _pan_tool!!
  }

private var _pan_tool: ImageVector? = null
