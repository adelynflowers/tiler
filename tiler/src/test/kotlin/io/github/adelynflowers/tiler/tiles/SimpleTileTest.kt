package io.github.adelynflowers.tiler.tiles

import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.api.assertThrows

class SimpleTileTest {
  private var sampleTile =
      SimpleTile(2, 2, listOf(Terrain.CLEAR, Terrain.HEATH, Terrain.FOREST, Terrain.MARSH))

  @Test
  fun testDimensions() {
    assertEquals(2, sampleTile.rows())
    assertEquals(2, sampleTile.cols())
  }

  @Test
  fun testTerrainAt() {
    assertEquals(Terrain.FOREST, sampleTile.terrainAt(Point(1, 0)))
    assertThrows<OutOfBoundsException> { sampleTile.terrainAt(Point(3, 1)) }
    assertThrows<OutOfBoundsException> { sampleTile.terrainAt(Point(1, 4)) }
  }

  @Test
  fun testInvalidConstruction() {
    assertThrows<IllegalArgumentException> { SimpleTile(1, 1, listOf()) }
  }
}
