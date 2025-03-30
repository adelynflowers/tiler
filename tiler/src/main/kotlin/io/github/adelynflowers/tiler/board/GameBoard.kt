package io.github.adelynflowers.tiler.board

import io.github.adelynflowers.tiler.tiles.Point
import io.github.adelynflowers.tiler.tiles.Terrain
import io.github.adelynflowers.tiler.tiles.Tile

interface GameBoard {
  /** @return the terrain tile at a given point */
  fun terrainAt(point: Point): Terrain

  /**
   * Attempts to add a tile to the board with its top left space at the given point.
   *
   * @param tile the tile to place
   * @param point the location where the top left (0,0) space will be placed on the board
   * @throws TilePlacementException if the placement is invalid
   */
  fun placeTile(tile: Tile, point: Point)

  /** @return the total tile count */
  fun tileCount(): Int

  /**
   * @param tile a tile to add to the board
   * @return a list of valid points where the tile can be placed
   */
  fun validPlacements(tile: Tile): List<Point>

  /** @return a map of the total counts of each terrain type */
  fun terrainTotals(): Map<Terrain, Int>

  /** @return a map of the total counts of adjacent terrain type pairs */
  fun adjacencyTotals(): Map<Pair<Terrain, Terrain>, Int>
}
