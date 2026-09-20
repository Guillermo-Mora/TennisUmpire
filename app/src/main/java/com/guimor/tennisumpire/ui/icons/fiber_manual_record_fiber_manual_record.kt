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
public val fiber_manual_recordFilledIcon: ImageVector
  get() {
    if (_fiber_manual_record != null) {
      return _fiber_manual_record!!
    }
    _fiber_manual_record =
      ImageVector.Builder(
          name = "fiber_manual_record",
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
            moveTo(7.04f, 16.96f)
            quadTo(5f, 14.93f, 5f, 12f)
            quadTo(5f, 9.07f, 7.04f, 7.04f)
            reflectiveQuadTo(12f, 5f)
            reflectiveQuadToRelative(4.96f, 2.04f)
            reflectiveQuadTo(19f, 12f)
            reflectiveQuadToRelative(-2.04f, 4.96f)
            reflectiveQuadTo(12f, 19f)
            quadTo(9.08f, 19f, 7.04f, 16.96f)
            close()
          }
        }
        .build()
    return _fiber_manual_record!!
  }

private var _fiber_manual_record: ImageVector? = null
