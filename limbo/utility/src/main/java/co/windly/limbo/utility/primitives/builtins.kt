package co.windly.limbo.utility.primitives

//region Int

/**
 * The zeroed Int.
 */
val Int.Companion.ZERO: Int
  get() = 0

/**
 * A handy method that allows to check if given Int is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Int.isZero(): Boolean =
  this == Int.ZERO

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Int) or zero if given value is
 * null.
 */
fun Int?.orZero(): Int =
  this ?: Int.ZERO

/**
 * An Int that is equal to one.
 */
val Int.Companion.ONE: Int
  get() = 1

/**
 * A handy method that allows to check if given Int is equal to one.
 * Useful especially for lambda operations or higher level functions.
 */
fun Int.isOne(): Boolean =
  this == Int.ONE

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Int) or one if given value is
 * null.
 */
fun Int?.orOne(): Int =
  this ?: Int.ONE

//endregion
