package co.windly.limbo.utility.primitives

//region Float

/**
 * The zeroed Float.
 */
val Float.Companion.ZERO: Float
  get() = 0f

/**
 * A handy method that allows to check if given Float is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Float.isZero(): Boolean =
  this == Float.ZERO

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Float) or zero if given value is
 * null.
 */
fun Float?.orZero(): Float =
  this ?: Float.ZERO

/**
 * An Float that is equal to one.
 */
val Float.Companion.ONE: Float
  get() = 1f

/**
 * A handy method that allows to check if given Float is equal to one.
 * Useful especially for lambda operations or higher level functions.
 */
fun Float.isOne(): Boolean =
  this == Float.ONE

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Float) or one if given value is
 * null.
 */
fun Float?.orOne(): Float =
  this ?: Float.ONE

//endregion

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

//region Long

/**
 * The zeroed Long.
 */
val Long.Companion.ZERO: Long
  get() = 0L

/**
 * A handy method that allows to check if given Long is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Long.isZero(): Boolean =
  this == Long.ZERO

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Long) or zero if given value is
 * null.
 */
fun Long?.orZero(): Long =
  this ?: Long.ZERO

/**
 * An Long that is equal to one.
 */
val Long.Companion.ONE: Long
  get() = 1L

/**
 * A handy method that allows to check if given Long is equal to one.
 * Useful especially for lambda operations or higher level functions.
 */
fun Long.isOne(): Boolean =
  this == Long.ONE

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Long) or one if given value is
 * null.
 */
fun Long?.orOne(): Long =
  this ?: Long.ONE

//endregion
