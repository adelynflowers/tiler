package io.github.adelynflowers.tiler.board

import kotlin.test.Test
import kotlin.test.assertEquals

class TilePlacementExceptionTest {

  @Test
  fun testConstruction() {
    assertEquals("a", TilePlacementException("a").message)
  }
}
