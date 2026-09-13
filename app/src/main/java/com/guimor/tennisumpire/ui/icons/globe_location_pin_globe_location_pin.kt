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
public val globe_location_pinIcon: ImageVector
  get() {
    if (_globe_location_pin != null) {
      return _globe_location_pin!!
    }
    _globe_location_pin =
      ImageVector.Builder(
          name = "globe_location_pin",
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
            moveTo(12f, 22f)
            quadTo(9.93f, 22f, 8.1f, 21.21f)
            quadTo(6.28f, 20.43f, 4.93f, 19.08f)
            quadTo(3.58f, 17.73f, 2.79f, 15.9f)
            reflectiveQuadTo(2f, 12f)
            quadTo(2f, 9.92f, 2.79f, 8.1f)
            quadTo(3.58f, 6.27f, 4.93f, 4.93f)
            quadTo(6.28f, 3.57f, 8.1f, 2.79f)
            quadTo(9.93f, 2f, 12f, 2f)
            quadToRelative(3.53f, 0f, 6.19f, 2.11f)
            reflectiveQuadTo(21.68f, 9.5f)
            quadToRelative(0.13f, 0.4f, -0.09f, 0.75f)
            reflectiveQuadToRelative(-0.61f, 0.47f)
            reflectiveQuadToRelative(-0.75f, -0.1f)
            reflectiveQuadTo(19.75f, 10f)
            quadTo(19.28f, 8.17f, 18.04f, 6.75f)
            quadTo(16.8f, 5.32f, 15f, 4.6f)
            verticalLineTo(5f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(13f, 7f)
            horizontalLineTo(11f)
            verticalLineTo(9f)
            quadToRelative(0f, 0.42f, -0.29f, 0.71f)
            reflectiveQuadTo(10f, 10f)
            horizontalLineTo(8f)
            verticalLineToRelative(2f)
            horizontalLineToRelative(6f)
            quadToRelative(0.38f, 0f, 0.58f, 0.34f)
            quadToRelative(0.2f, 0.34f, 0f, 0.69f)
            quadToRelative(-0.3f, 0.58f, -0.44f, 1.2f)
            reflectiveQuadTo(14f, 15.5f)
            quadToRelative(0f, 1.32f, 0.6f, 2.49f)
            reflectiveQuadToRelative(1.32f, 2.21f)
            quadToRelative(0.2f, 0.3f, 0.13f, 0.65f)
            reflectiveQuadToRelative(-0.43f, 0.47f)
            quadToRelative(-0.85f, 0.35f, -1.76f, 0.51f)
            reflectiveQuadTo(12f, 22f)
            close()
            moveTo(11f, 19.95f)
            verticalLineTo(18f)
            quadTo(10.18f, 18f, 9.59f, 17.41f)
            reflectiveQuadTo(9f, 16f)
            verticalLineTo(15f)
            lineTo(4.2f, 10.2f)
            quadTo(4.13f, 10.65f, 4.06f, 11.1f)
            reflectiveQuadTo(4f, 12f)
            quadToRelative(0f, 3.03f, 1.99f, 5.3f)
            reflectiveQuadTo(11f, 19.95f)
            close()
            moveToRelative(8.2f, 1.95f)
            quadTo(19.08f, 21.8f, 19.03f, 21.65f)
            quadTo(18.75f, 20.78f, 18.25f, 20.02f)
            reflectiveQuadTo(17.18f, 18.55f)
            quadTo(16.65f, 17.9f, 16.33f, 17.13f)
            reflectiveQuadTo(16f, 15.5f)
            quadToRelative(0f, -1.45f, 1.03f, -2.48f)
            reflectiveQuadTo(19.5f, 12f)
            reflectiveQuadToRelative(2.48f, 1.02f)
            reflectiveQuadTo(23f, 15.5f)
            quadToRelative(0f, 0.85f, -0.34f, 1.61f)
            reflectiveQuadToRelative(-0.84f, 1.44f)
            quadToRelative(-0.58f, 0.72f, -1.08f, 1.47f)
            reflectiveQuadToRelative(-0.77f, 1.63f)
            quadTo(19.93f, 21.8f, 19.8f, 21.9f)
            reflectiveQuadTo(19.5f, 22f)
            reflectiveQuadTo(19.2f, 21.9f)
            close()
            moveToRelative(0.3f, -2.72f)
            quadToRelative(0.25f, -0.43f, 0.55f, -0.79f)
            reflectiveQuadToRelative(0.57f, -0.74f)
            quadToRelative(0.35f, -0.47f, 0.61f, -1.01f)
            reflectiveQuadTo(21.5f, 15.5f)
            quadToRelative(0f, -0.83f, -0.59f, -1.41f)
            reflectiveQuadTo(19.5f, 13.5f)
            quadToRelative(-0.82f, 0f, -1.41f, 0.59f)
            quadTo(17.5f, 14.68f, 17.5f, 15.5f)
            quadToRelative(0f, 0.6f, 0.26f, 1.14f)
            quadToRelative(0.26f, 0.54f, 0.61f, 1.01f)
            quadToRelative(0.3f, 0.38f, 0.59f, 0.74f)
            reflectiveQuadToRelative(0.54f, 0.79f)
            close()
            moveTo(18.61f, 16.39f)
            quadTo(18.25f, 16.02f, 18.25f, 15.5f)
            reflectiveQuadToRelative(0.36f, -0.89f)
            reflectiveQuadTo(19.5f, 14.25f)
            quadToRelative(0.53f, 0f, 0.89f, 0.36f)
            quadToRelative(0.36f, 0.36f, 0.36f, 0.89f)
            reflectiveQuadToRelative(-0.36f, 0.89f)
            reflectiveQuadTo(19.5f, 16.75f)
            quadToRelative(-0.52f, 0f, -0.89f, -0.36f)
            close()
          }
        }
        .build()
    return _globe_location_pin!!
  }

private var _globe_location_pin: ImageVector? = null
