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
public val pending_actionsIcon: ImageVector
  get() {
    if (_pending_actions != null) {
      return _pending_actions!!
    }
    _pending_actions =
      ImageVector.Builder(
          name = "pending_actions",
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
            moveTo(13.46f, 20.54f)
            quadTo(12f, 19.08f, 12f, 17f)
            reflectiveQuadToRelative(1.46f, -3.54f)
            reflectiveQuadTo(17f, 12f)
            reflectiveQuadToRelative(3.54f, 1.46f)
            quadTo(22f, 14.93f, 22f, 17f)
            reflectiveQuadToRelative(-1.46f, 3.54f)
            reflectiveQuadTo(17f, 22f)
            reflectiveQuadTo(13.46f, 20.54f)
            close()
            moveTo(17.5f, 16.8f)
            verticalLineTo(14.5f)
            quadToRelative(0f, -0.2f, -0.15f, -0.35f)
            reflectiveQuadTo(17f, 14f)
            reflectiveQuadToRelative(-0.35f, 0.15f)
            reflectiveQuadTo(16.5f, 14.5f)
            verticalLineToRelative(2.27f)
            quadToRelative(0f, 0.2f, 0.07f, 0.39f)
            reflectiveQuadTo(16.8f, 17.5f)
            lineToRelative(1.52f, 1.52f)
            quadToRelative(0.15f, 0.15f, 0.35f, 0.15f)
            reflectiveQuadToRelative(0.35f, -0.15f)
            quadToRelative(0.15f, -0.15f, 0.15f, -0.35f)
            reflectiveQuadTo(19.03f, 18.33f)
            lineTo(17.5f, 16.8f)
            close()
            moveTo(5f, 21f)
            quadTo(4.18f, 21f, 3.59f, 20.41f)
            reflectiveQuadTo(3f, 19f)
            verticalLineTo(5f)
            quadTo(3f, 4.17f, 3.59f, 3.59f)
            reflectiveQuadTo(5f, 3f)
            horizontalLineTo(9.18f)
            quadTo(9.45f, 2.13f, 10.25f, 1.56f)
            reflectiveQuadTo(12f, 1f)
            quadToRelative(1f, 0f, 1.79f, 0.56f)
            reflectiveQuadTo(14.85f, 3f)
            horizontalLineTo(19f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            reflectiveQuadTo(21f, 5f)
            verticalLineTo(9f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(20f, 10f)
            reflectiveQuadTo(19.29f, 9.71f)
            reflectiveQuadTo(19f, 9f)
            verticalLineTo(5f)
            horizontalLineTo(17f)
            verticalLineTo(7f)
            quadToRelative(0f, 0.43f, -0.29f, 0.71f)
            reflectiveQuadTo(16f, 8f)
            horizontalLineTo(8f)
            quadTo(7.58f, 8f, 7.29f, 7.71f)
            quadTo(7f, 7.43f, 7f, 7f)
            verticalLineTo(5f)
            horizontalLineTo(5f)
            verticalLineTo(19f)
            horizontalLineTo(9.5f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(10.5f, 20f)
            reflectiveQuadToRelative(-0.29f, 0.71f)
            reflectiveQuadTo(9.5f, 21f)
            horizontalLineTo(5f)
            close()
            moveTo(12.71f, 4.71f)
            quadTo(13f, 4.42f, 13f, 4f)
            quadTo(13f, 3.57f, 12.71f, 3.29f)
            reflectiveQuadTo(12f, 3f)
            reflectiveQuadTo(11.29f, 3.29f)
            reflectiveQuadTo(11f, 4f)
            quadToRelative(0f, 0.42f, 0.29f, 0.71f)
            reflectiveQuadTo(12f, 5f)
            reflectiveQuadTo(12.71f, 4.71f)
            close()
          }
        }
        .build()
    return _pending_actions!!
  }

private var _pending_actions: ImageVector? = null
