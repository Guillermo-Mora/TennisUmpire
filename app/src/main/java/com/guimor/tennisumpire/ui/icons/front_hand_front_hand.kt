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
public val front_handIcon: ImageVector
  get() {
    if (_front_hand != null) {
      return _front_hand!!
    }
    _front_hand =
      ImageVector.Builder(
          name = "front_hand",
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
            moveTo(13.71f, 1.29f)
            quadTo(14f, 1.57f, 14f, 2f)
            verticalLineToRelative(9f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(13f, 12f)
            quadToRelative(-0.42f, 0f, -0.71f, -0.29f)
            quadTo(12f, 11.43f, 12f, 11f)
            verticalLineTo(2f)
            quadTo(12f, 1.57f, 12.29f, 1.29f)
            reflectiveQuadTo(13f, 1f)
            reflectiveQuadToRelative(0.71f, 0.29f)
            close()
            moveToRelative(-4f, 1f)
            quadTo(10f, 2.57f, 10f, 3f)
            verticalLineToRelative(8f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(9f, 12f)
            quadTo(8.58f, 12f, 8.29f, 11.71f)
            quadTo(8f, 11.43f, 8f, 11f)
            verticalLineTo(3f)
            quadTo(8f, 2.57f, 8.29f, 2.29f)
            quadTo(8.58f, 2f, 9f, 2f)
            quadTo(9.43f, 2f, 9.71f, 2.29f)
            close()
            moveTo(12.5f, 23f)
            quadTo(8.95f, 23f, 6.48f, 20.53f)
            reflectiveQuadTo(4f, 14.5f)
            verticalLineTo(5f)
            quadTo(4f, 4.57f, 4.29f, 4.29f)
            reflectiveQuadTo(5f, 4f)
            reflectiveQuadTo(5.71f, 4.29f)
            reflectiveQuadTo(6f, 5f)
            verticalLineToRelative(9.5f)
            quadToRelative(0f, 2.73f, 1.89f, 4.61f)
            reflectiveQuadTo(12.5f, 21f)
            reflectiveQuadToRelative(4.61f, -1.89f)
            reflectiveQuadTo(19f, 14.5f)
            verticalLineTo(11f)
            quadToRelative(-0.43f, 0f, -0.71f, 0.29f)
            reflectiveQuadTo(18f, 12f)
            verticalLineToRelative(3f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(17f, 16f)
            horizontalLineTo(15f)
            quadToRelative(-0.82f, 0f, -1.41f, 0.59f)
            quadTo(13f, 17.18f, 13f, 18f)
            verticalLineToRelative(1f)
            quadToRelative(0f, 0.43f, -0.29f, 0.71f)
            reflectiveQuadTo(12f, 20f)
            reflectiveQuadTo(11.29f, 19.71f)
            quadTo(11f, 19.43f, 11f, 19f)
            verticalLineTo(18f)
            quadToRelative(0f, -1.65f, 1.18f, -2.83f)
            reflectiveQuadTo(15f, 14f)
            horizontalLineToRelative(1f)
            verticalLineTo(11.15f)
            verticalLineTo(4f)
            quadTo(16f, 3.57f, 16.29f, 3.29f)
            reflectiveQuadTo(17f, 3f)
            reflectiveQuadToRelative(0.71f, 0.29f)
            reflectiveQuadTo(18f, 4f)
            verticalLineTo(9.17f)
            quadTo(18.25f, 9.1f, 18.49f, 9.05f)
            reflectiveQuadTo(19f, 9f)
            horizontalLineToRelative(1f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(21f, 10f)
            verticalLineToRelative(4.5f)
            quadToRelative(0f, 3.55f, -2.47f, 6.02f)
            reflectiveQuadTo(12.5f, 23f)
            close()
            moveToRelative(1f, -8f)
            close()
          }
        }
        .build()
    return _front_hand!!
  }

private var _front_hand: ImageVector? = null
