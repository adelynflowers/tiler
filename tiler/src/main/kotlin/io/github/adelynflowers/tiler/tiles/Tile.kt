package io.github.adelynflowers.tiler.tiles

/** An interface representing a game tile. */
interface Tile {
  /**
   * @param point the point to check.
   * @return the terrain type.
   * @throws OutOfBoundsException if the point requested isn't on the tile
   */
  fun terrainAt(point: Point): Terrain

  /** @return the number of rows on the tile. */
  fun rows(): Int

  /** @return the number of columns on the tile. */
  fun cols(): Int
}
