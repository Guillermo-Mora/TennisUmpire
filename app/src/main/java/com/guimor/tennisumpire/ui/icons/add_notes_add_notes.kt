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
public val add_notesIcon: ImageVector
  get() {
    if (_add_notes != null) {
      return _add_notes!!
    }
    _add_notes =
      ImageVector.Builder(
          name = "add_notes",
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
            moveTo(17.5f, 18.5f)
            verticalLineToRelative(2f)
            quadToRelative(0f, 0.2f, 0.15f, 0.35f)
            reflectiveQuadTo(18f, 21f)
            reflectiveQuadToRelative(0.35f, -0.15f)
            reflectiveQuadTo(18.5f, 20.5f)
            verticalLineToRelative(-2f)
            horizontalLineToRelative(2f)
            quadToRelative(0.2f, 0f, 0.35f, -0.15f)
            reflectiveQuadTo(21f, 18f)
            reflectiveQuadTo(20.85f, 17.65f)
            reflectiveQuadTo(20.5f, 17.5f)
            horizontalLineToRelative(-2f)
            verticalLineToRelative(-2f)
            quadToRelative(0f, -0.2f, -0.15f, -0.35f)
            reflectiveQuadTo(18f, 15f)
            reflectiveQuadToRelative(-0.35f, 0.15f)
            reflectiveQuadTo(17.5f, 15.5f)
            verticalLineToRelative(2f)
            horizontalLineToRelative(-2f)
            quadToRelative(-0.2f, 0f, -0.35f, 0.15f)
            reflectiveQuadTo(15f, 18f)
            reflectiveQuadToRelative(0.15f, 0.35f)
            reflectiveQuadTo(15.5f, 18.5f)
            horizontalLineToRelative(2f)
            close()
            moveTo(18f, 23f)
            quadToRelative(-2.07f, 0f, -3.54f, -1.46f)
            reflectiveQuadTo(13f, 18f)
            reflectiveQuadToRelative(1.46f, -3.54f)
            reflectiveQuadTo(18f, 13f)
            reflectiveQuadToRelative(3.54f, 1.46f)
            reflectiveQuadTo(23f, 18f)
            reflectiveQuadToRelative(-1.46f, 3.54f)
            reflectiveQuadTo(18f, 23f)
            close()
            moveTo(8f, 9f)
            horizontalLineToRelative(8f)
            quadToRelative(0.43f, 0f, 0.71f, -0.29f)
            reflectiveQuadTo(17f, 8f)
            quadTo(17f, 7.57f, 16.71f, 7.29f)
            reflectiveQuadTo(16f, 7f)
            horizontalLineTo(8f)
            quadTo(7.58f, 7f, 7.29f, 7.29f)
            reflectiveQuadTo(7f, 8f)
            quadTo(7f, 8.42f, 7.29f, 8.71f)
            reflectiveQuadTo(8f, 9f)
            close()
            moveTo(5f, 21f)
            quadTo(4.18f, 21f, 3.59f, 20.41f)
            reflectiveQuadTo(3f, 19f)
            verticalLineTo(5f)
            quadTo(3f, 4.17f, 3.59f, 3.59f)
            reflectiveQuadTo(5f, 3f)
            horizontalLineTo(19f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            reflectiveQuadTo(21f, 5f)
            verticalLineToRelative(5.45f)
            quadToRelative(0f, 0.45f, -0.38f, 0.7f)
            reflectiveQuadToRelative(-0.8f, 0.1f)
            quadTo(19.4f, 11.13f, 18.94f, 11.06f)
            quadTo(18.48f, 11f, 18f, 11f)
            quadToRelative(-0.27f, 0f, -0.51f, 0.01f)
            reflectiveQuadTo(17f, 11.08f)
            quadTo(16.78f, 11.02f, 16.5f, 11.01f)
            quadTo(16.23f, 11f, 16f, 11f)
            horizontalLineTo(8f)
            quadTo(7.58f, 11f, 7.29f, 11.29f)
            reflectiveQuadTo(7f, 12f)
            reflectiveQuadToRelative(0.29f, 0.71f)
            reflectiveQuadTo(8f, 13f)
            horizontalLineToRelative(5.13f)
            quadToRelative(-0.45f, 0.42f, -0.81f, 0.92f)
            reflectiveQuadTo(11.68f, 15f)
            horizontalLineTo(8f)
            quadTo(7.58f, 15f, 7.29f, 15.29f)
            reflectiveQuadTo(7f, 16f)
            reflectiveQuadToRelative(0.29f, 0.71f)
            reflectiveQuadTo(8f, 17f)
            horizontalLineToRelative(3.08f)
            quadToRelative(-0.05f, 0.25f, -0.06f, 0.49f)
            reflectiveQuadTo(11f, 18f)
            quadToRelative(0f, 0.5f, 0.05f, 0.95f)
            reflectiveQuadToRelative(0.18f, 0.88f)
            reflectiveQuadToRelative(-0.13f, 0.8f)
            reflectiveQuadTo(10.43f, 21f)
            horizontalLineTo(5f)
            close()
          }
        }
        .build()
    return _add_notes!!
  }

private var _add_notes: ImageVector? = null
