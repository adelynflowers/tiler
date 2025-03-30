package io.github.adelynflowers.tiler.tiles

class SimpleTile(private val rows: Int, private val cols: Int, private val terrain: List<Terrain>) :
    Tile {
  init {
    if (terrain.size != (rows * cols)) {
      throw IllegalArgumentException("terrain must be exactly of length rows*cols")
    }
  }

  override fun terrainAt(point: Point): Terrain {
    if (point.x > rows || point.y > cols) {
      throw OutOfBoundsException(
          "(${point.x},${point.y}) exceeds the tile bounds, size is ${rows}x${cols}")
    }
    return terrain.elementAt((point.x * rows) + (point.y))
  }

  override fun rows(): Int {
    return rows
  }

  override fun cols(): Int {
    return cols
  }
}
