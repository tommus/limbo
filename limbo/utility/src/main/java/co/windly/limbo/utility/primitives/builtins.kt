package co.windly.limbo.utility.primitives

//region Boolean

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Boolean) or false if given value is
 * null.
 */
fun Boolean?.orFalse(): Boolean =
  this ?: false

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Boolean) or true if given value is
 * null.
 */
fun Boolean?.orTrue(): Boolean =
  this ?: true

//endregion

//region Byte

/**
 * The zeroed Byte.
 */
val Byte.Companion.ZERO: Byte
  get() = 0

/**
 * A handy method that allows to check if given Byte is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Byte.isZero(): Boolean =
  this == Byte.ZERO

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Byte) or zero if given value is
 * null.
 */
fun Byte?.orZero(): Byte =
  this ?: Byte.ZERO

/**
 * An Byte that is equal to one.
 */
val Byte.Companion.ONE: Byte
  get() = 1

/**
 * A handy method that allows to check if given Byte is equal to one.
 * Useful especially for lambda operations or higher level functions.
 */
fun Byte.isOne(): Boolean =
  this == Byte.ONE

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Byte) or one if given value is
 * null.
 */
fun Byte?.orOne(): Byte =
  this ?: Byte.ONE

//endregion

//region Double

/**
 * The zeroed Double.
 */
val Double.Companion.ZERO: Double
  get() = 0.0

/**
 * A handy method that allows to check if given Double is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Double.isZero(): Boolean =
  this == Double.ZERO

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Double) or zero if given value is
 * null.
 */
fun Double?.orZero(): Double =
  this ?: Double.ZERO

/**
 * An Double that is equal to one.
 */
val Double.Companion.ONE: Double
  get() = 1.0

/**
 * A handy method that allows to check if given Double is equal to one.
 * Useful especially for lambda operations or higher level functions.
 */
fun Double.isOne(): Boolean =
  this == Double.ONE

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Double) or one if given value is
 * null.
 */
fun Double?.orOne(): Double =
  this ?: Double.ONE

//endregion

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

//region Short

/**
 * The zeroed Short.
 */
val Short.Companion.ZERO: Short
  get() = 0

/**
 * A handy method that allows to check if given Short is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Short.isZero(): Boolean =
  this == Short.ZERO

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Short) or zero if given value is
 * null.
 */
fun Short?.orZero(): Short =
  this ?: Short.ZERO

/**
 * An Short that is equal to one.
 */
val Short.Companion.ONE: Short
  get() = 1

/**
 * A handy method that allows to check if given Short is equal to one.
 * Useful especially for lambda operations or higher level functions.
 */
fun Short.isOne(): Boolean =
  this == Short.ONE

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null Short) or one if given value is
 * null.
 */
fun Short?.orOne(): Short =
  this ?: Short.ONE

//endregion

//region String

/**
 * A String for carriage return CR ("\r").
 */
val String.Companion.CR: String
  get() = "\r"

/**
 * The empty String "".
 */
val String.Companion.EMPTY: String
  get() = ""

/**
 * A String for linefeed LF ("\n").
 */
val String.Companion.LF: String
  get() = "\n"

/**
 * A String for a space character.
 */
val String.Companion.SPACE: String
  get() = " "

//endregion
