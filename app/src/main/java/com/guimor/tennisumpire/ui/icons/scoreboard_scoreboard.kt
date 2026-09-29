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
public val scoreboardIcon: ImageVector
  get() {
    if (_scoreboard != null) {
      return _scoreboard!!
    }
    _scoreboard =
      ImageVector.Builder(
          name = "scoreboard",
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
            moveTo(15.5f, 15f)
            quadToRelative(-0.42f, 0f, -0.71f, -0.29f)
            reflectiveQuadTo(14.5f, 14f)
            verticalLineTo(10f)
            quadToRelative(0f, -0.43f, 0.29f, -0.71f)
            reflectiveQuadTo(15.5f, 9f)
            horizontalLineTo(18f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(19f, 10f)
            verticalLineToRelative(4f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(18f, 15f)
            horizontalLineTo(15.5f)
            close()
            moveTo(16f, 13.5f)
            horizontalLineToRelative(1.5f)
            verticalLineToRelative(-3f)
            horizontalLineTo(16f)
            verticalLineToRelative(3f)
            close()
            moveToRelative(-9.5f, 0f)
            horizontalLineTo(8.75f)
            quadToRelative(0.33f, 0f, 0.54f, 0.21f)
            quadTo(9.5f, 13.93f, 9.5f, 14.25f)
            reflectiveQuadTo(9.29f, 14.79f)
            quadTo(9.08f, 15f, 8.75f, 15f)
            horizontalLineTo(6f)
            quadTo(5.58f, 15f, 5.29f, 14.71f)
            reflectiveQuadTo(5f, 14f)
            verticalLineTo(12.5f)
            quadTo(5f, 12.08f, 5.29f, 11.79f)
            reflectiveQuadTo(6f, 11.5f)
            horizontalLineTo(8f)
            verticalLineToRelative(-1f)
            horizontalLineTo(5.75f)
            quadToRelative(-0.32f, 0f, -0.54f, -0.21f)
            reflectiveQuadTo(5f, 9.75f)
            quadTo(5f, 9.42f, 5.21f, 9.21f)
            reflectiveQuadTo(5.75f, 9f)
            horizontalLineTo(8.5f)
            quadTo(8.93f, 9f, 9.21f, 9.29f)
            reflectiveQuadTo(9.5f, 10f)
            verticalLineToRelative(1.5f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(8.5f, 12.5f)
            horizontalLineToRelative(-2f)
            verticalLineToRelative(1f)
            close()
            moveTo(4f, 20f)
            quadTo(3.18f, 20f, 2.59f, 19.41f)
            reflectiveQuadTo(2f, 18f)
            verticalLineTo(6f)
            quadTo(2f, 5.18f, 2.59f, 4.59f)
            reflectiveQuadTo(4f, 4f)
            horizontalLineTo(7f)
            verticalLineTo(3f)
            quadTo(7f, 2.57f, 7.29f, 2.29f)
            reflectiveQuadTo(8f, 2f)
            reflectiveQuadTo(8.71f, 2.29f)
            reflectiveQuadTo(9f, 3f)
            verticalLineTo(4f)
            horizontalLineToRelative(6f)
            verticalLineTo(3f)
            quadTo(15f, 2.57f, 15.29f, 2.29f)
            reflectiveQuadTo(16f, 2f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(17f, 3f)
            verticalLineTo(4f)
            horizontalLineToRelative(3f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            quadTo(22f, 5.18f, 22f, 6f)
            verticalLineTo(18f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(20f, 20f)
            horizontalLineTo(4f)
            close()
            moveTo(4f, 18f)
            horizontalLineToRelative(7.25f)
            verticalLineTo(17.25f)
            quadToRelative(0f, -0.32f, 0.21f, -0.54f)
            reflectiveQuadTo(12f, 16.5f)
            reflectiveQuadToRelative(0.54f, 0.21f)
            quadToRelative(0.21f, 0.21f, 0.21f, 0.54f)
            verticalLineTo(18f)
            horizontalLineTo(20f)
            verticalLineTo(6f)
            horizontalLineTo(12.75f)
            verticalLineTo(6.75f)
            quadToRelative(0f, 0.32f, -0.21f, 0.54f)
            reflectiveQuadTo(12f, 7.5f)
            reflectiveQuadTo(11.46f, 7.29f)
            reflectiveQuadTo(11.25f, 6.75f)
            verticalLineTo(6f)
            horizontalLineTo(4f)
            verticalLineTo(18f)
            close()
            moveToRelative(0f, 0f)
            verticalLineTo(6f)
            verticalLineTo(18f)
            close()
            moveToRelative(7.46f, -7.21f)
            quadTo(11.25f, 10.58f, 11.25f, 10.25f)
            quadToRelative(0f, -0.33f, 0.21f, -0.54f)
            reflectiveQuadTo(12f, 9.5f)
            reflectiveQuadToRelative(0.54f, 0.21f)
            reflectiveQuadToRelative(0.21f, 0.54f)
            reflectiveQuadToRelative(-0.21f, 0.54f)
            reflectiveQuadTo(12f, 11f)
            reflectiveQuadTo(11.46f, 10.79f)
            close()
            moveToRelative(0f, 3.5f)
            quadTo(11.25f, 14.08f, 11.25f, 13.75f)
            reflectiveQuadToRelative(0.21f, -0.54f)
            reflectiveQuadTo(12f, 13f)
            reflectiveQuadToRelative(0.54f, 0.21f)
            quadToRelative(0.21f, 0.21f, 0.21f, 0.54f)
            reflectiveQuadToRelative(-0.21f, 0.54f)
            reflectiveQuadTo(12f, 14.5f)
            reflectiveQuadTo(11.46f, 14.29f)
            close()
          }
        }
        .build()
    return _scoreboard!!
  }

private var _scoreboard: ImageVector? = null
