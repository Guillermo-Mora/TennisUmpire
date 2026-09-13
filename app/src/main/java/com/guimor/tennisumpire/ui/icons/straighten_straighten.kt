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
public val straightenIcon: ImageVector
  get() {
    if (_straighten != null) {
      return _straighten!!
    }
    _straighten =
      ImageVector.Builder(
          name = "straighten",
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
            moveTo(4f, 18f)
            quadTo(3.18f, 18f, 2.59f, 17.41f)
            reflectiveQuadTo(2f, 16f)
            verticalLineTo(8f)
            quadTo(2f, 7.18f, 2.59f, 6.59f)
            reflectiveQuadTo(4f, 6f)
            horizontalLineTo(20f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            quadTo(22f, 7.18f, 22f, 8f)
            verticalLineToRelative(8f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(20f, 18f)
            horizontalLineTo(4f)
            close()
            moveTo(4f, 16f)
            horizontalLineTo(20f)
            verticalLineTo(8f)
            horizontalLineTo(17f)
            verticalLineToRelative(3f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(16f, 12f)
            reflectiveQuadTo(15.29f, 11.71f)
            quadTo(15f, 11.43f, 15f, 11f)
            verticalLineTo(8f)
            horizontalLineTo(13f)
            verticalLineToRelative(3f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(12f, 12f)
            reflectiveQuadTo(11.29f, 11.71f)
            quadTo(11f, 11.43f, 11f, 11f)
            verticalLineTo(8f)
            horizontalLineTo(9f)
            verticalLineToRelative(3f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(8f, 12f)
            quadTo(7.58f, 12f, 7.29f, 11.71f)
            quadTo(7f, 11.43f, 7f, 11f)
            verticalLineTo(8f)
            horizontalLineTo(4f)
            verticalLineToRelative(8f)
            close()
            moveTo(8f, 12f)
            close()
            moveToRelative(4f, 0f)
            close()
            moveToRelative(4f, 0f)
            close()
            moveToRelative(-4f, 0f)
            close()
          }
        }
        .build()
    return _straighten!!
  }

private var _straighten: ImageVector? = null
