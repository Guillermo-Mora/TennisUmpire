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
public val library_booksIcon: ImageVector
  get() {
    if (_library_books != null) {
      return _library_books!!
    }
    _library_books =
      ImageVector.Builder(
          name = "library_books",
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
            moveTo(11f, 14f)
            horizontalLineToRelative(2f)
            quadToRelative(0.43f, 0f, 0.71f, -0.29f)
            quadTo(14f, 13.43f, 14f, 13f)
            reflectiveQuadTo(13.71f, 12.29f)
            reflectiveQuadTo(13f, 12f)
            horizontalLineTo(11f)
            quadToRelative(-0.42f, 0f, -0.71f, 0.29f)
            reflectiveQuadTo(10f, 13f)
            reflectiveQuadToRelative(0.29f, 0.71f)
            reflectiveQuadTo(11f, 14f)
            close()
            moveToRelative(0f, -3f)
            horizontalLineToRelative(6f)
            quadToRelative(0.43f, 0f, 0.71f, -0.29f)
            quadTo(18f, 10.43f, 18f, 10f)
            quadTo(18f, 9.57f, 17.71f, 9.29f)
            reflectiveQuadTo(17f, 9f)
            horizontalLineTo(11f)
            quadTo(10.58f, 9f, 10.29f, 9.29f)
            reflectiveQuadTo(10f, 10f)
            reflectiveQuadToRelative(0.29f, 0.71f)
            reflectiveQuadTo(11f, 11f)
            close()
            moveTo(11f, 8f)
            horizontalLineToRelative(6f)
            quadToRelative(0.43f, 0f, 0.71f, -0.29f)
            quadTo(18f, 7.43f, 18f, 7f)
            reflectiveQuadTo(17.71f, 6.29f)
            reflectiveQuadTo(17f, 6f)
            horizontalLineTo(11f)
            quadTo(10.58f, 6f, 10.29f, 6.29f)
            reflectiveQuadTo(10f, 7f)
            reflectiveQuadToRelative(0.29f, 0.71f)
            reflectiveQuadTo(11f, 8f)
            close()
            moveTo(8f, 18f)
            quadTo(7.18f, 18f, 6.59f, 17.41f)
            reflectiveQuadTo(6f, 16f)
            verticalLineTo(4f)
            quadTo(6f, 3.17f, 6.59f, 2.59f)
            reflectiveQuadTo(8f, 2f)
            horizontalLineTo(20f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            reflectiveQuadTo(22f, 4f)
            verticalLineTo(16f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(20f, 18f)
            horizontalLineTo(8f)
            close()
            moveTo(8f, 16f)
            horizontalLineTo(20f)
            verticalLineTo(4f)
            horizontalLineTo(8f)
            verticalLineTo(16f)
            close()
            moveTo(4f, 22f)
            quadTo(3.18f, 22f, 2.59f, 21.41f)
            reflectiveQuadTo(2f, 20f)
            verticalLineTo(7f)
            quadTo(2f, 6.57f, 2.29f, 6.29f)
            reflectiveQuadTo(3f, 6f)
            reflectiveQuadTo(3.71f, 6.29f)
            reflectiveQuadTo(4f, 7f)
            verticalLineTo(20f)
            horizontalLineTo(17f)
            quadToRelative(0.43f, 0f, 0.71f, 0.29f)
            reflectiveQuadTo(18f, 21f)
            reflectiveQuadToRelative(-0.29f, 0.71f)
            reflectiveQuadTo(17f, 22f)
            horizontalLineTo(4f)
            close()
            moveTo(8f, 4f)
            verticalLineTo(16f)
            verticalLineTo(4f)
            close()
          }
        }
        .build()
    return _library_books!!
  }

private var _library_books: ImageVector? = null
