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
public val add_a_photoIcon: ImageVector
  get() {
    if (_add_a_photo != null) {
      return _add_a_photo!!
    }
    _add_a_photo =
      ImageVector.Builder(
          name = "add_a_photo",
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
            moveTo(11f, 13f)
            close()
            moveTo(3f, 21f)
            quadTo(2.18f, 21f, 1.59f, 20.41f)
            reflectiveQuadTo(1f, 19f)
            verticalLineTo(7f)
            quadTo(1f, 6.18f, 1.59f, 5.59f)
            reflectiveQuadTo(3f, 5f)
            horizontalLineTo(6.15f)
            lineTo(7.4f, 3.65f)
            quadTo(7.68f, 3.35f, 8.06f, 3.17f)
            reflectiveQuadTo(8.88f, 3f)
            horizontalLineTo(13f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(14f, 4f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(13f, 5f)
            horizontalLineTo(8.88f)
            lineTo(7.05f, 7f)
            horizontalLineTo(3f)
            verticalLineTo(19f)
            horizontalLineTo(19f)
            verticalLineTo(11f)
            quadToRelative(0f, -0.43f, 0.29f, -0.71f)
            reflectiveQuadTo(20f, 10f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(21f, 11f)
            verticalLineToRelative(8f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(19f, 21f)
            horizontalLineTo(3f)
            close()
            moveTo(19f, 5f)
            horizontalLineTo(18f)
            quadTo(17.58f, 5f, 17.29f, 4.71f)
            reflectiveQuadTo(17f, 4f)
            quadTo(17f, 3.57f, 17.29f, 3.29f)
            reflectiveQuadTo(18f, 3f)
            horizontalLineToRelative(1f)
            verticalLineTo(2f)
            quadTo(19f, 1.57f, 19.29f, 1.29f)
            reflectiveQuadTo(20f, 1f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(21f, 2f)
            verticalLineTo(3f)
            horizontalLineToRelative(1f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(23f, 4f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(22f, 5f)
            horizontalLineTo(21f)
            verticalLineTo(6f)
            quadToRelative(0f, 0.43f, -0.29f, 0.71f)
            reflectiveQuadTo(20f, 7f)
            reflectiveQuadTo(19.29f, 6.71f)
            quadTo(19f, 6.43f, 19f, 6f)
            verticalLineTo(5f)
            close()
            moveTo(11f, 17.5f)
            quadToRelative(1.88f, 0f, 3.19f, -1.31f)
            reflectiveQuadTo(15.5f, 13f)
            reflectiveQuadTo(14.19f, 9.81f)
            reflectiveQuadTo(11f, 8.5f)
            reflectiveQuadTo(7.81f, 9.81f)
            reflectiveQuadTo(6.5f, 13f)
            reflectiveQuadToRelative(1.31f, 3.19f)
            reflectiveQuadTo(11f, 17.5f)
            close()
            moveToRelative(0f, -2f)
            quadToRelative(-1.05f, 0f, -1.78f, -0.72f)
            reflectiveQuadTo(8.5f, 13f)
            reflectiveQuadTo(9.23f, 11.23f)
            reflectiveQuadTo(11f, 10.5f)
            reflectiveQuadToRelative(1.78f, 0.72f)
            reflectiveQuadTo(13.5f, 13f)
            reflectiveQuadToRelative(-0.72f, 1.78f)
            reflectiveQuadTo(11f, 15.5f)
            close()
          }
        }
        .build()
    return _add_a_photo!!
  }

private var _add_a_photo: ImageVector? = null
