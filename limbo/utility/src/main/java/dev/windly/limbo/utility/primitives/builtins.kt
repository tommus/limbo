package dev.windly.limbo.utility.primitives

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import dev.windly.limbo.utility.asOptional
import java.util.Optional

/**
 * Wraps nullable Boolean as optional value.
 *
 * NOTE: Keep in mind you should avoid such Schrödinger's Boolean
 * value. Whenever you need to represent a given state in more than
 * two (obvious) alternatives - consider using enum or sealed class.
 */
@RequiresApi(VERSION_CODES.N)
fun Boolean?.asOptional(): Optional<Boolean> = asOptional()

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

/**
 * The zeroed Byte.
 */
val Byte.Companion.ZERO: Byte
  get() = 0

/**
 * Wraps nullable Byte as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun Byte?.asOptional(): Optional<Byte> = asOptional()

/**
 * A handy method that allows to check if given Byte is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Byte.isZero(): Boolean =
  this == Byte.ZERO

/**
 * A handy method that allows to check if given Byte is not equal to
 * zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Byte.isNotZero(): Boolean =
  isZero().not()

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

/**
 * The zeroed Double.
 */
val Double.Companion.ZERO: Double
  get() = 0.0

/**
 * Wraps nullable Double as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun Double?.asOptional(): Optional<Double> = asOptional()

/**
 * A handy method that allows to check if given Double is equal to
 * zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Double.isZero(): Boolean =
  this == Double.ZERO

/**
 * A handy method that allows to check if given Double is not equal
 * to zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Double.isNotZero(): Boolean =
  isZero().not()

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
 * A handy method that allows to check if given Double is equal to
 * one. Useful especially for lambda operations or higher level
 * functions.
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

/**
 * The zeroed Float.
 */
val Float.Companion.ZERO: Float
  get() = 0f

/**
 * Wraps nullable Float as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun Float?.asOptional(): Optional<Float> = asOptional()

/**
 * A handy method that allows to check if given Float is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Float.isZero(): Boolean =
  this == Float.ZERO

/**
 * A handy method that allows to check if given Float is not equal to
 * zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Float.isNotZero(): Boolean =
  isZero().not()

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

/**
 * The zeroed Int.
 */
val Int.Companion.ZERO: Int
  get() = 0

/**
 * Wraps nullable Int as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun Int?.asOptional(): Optional<Int> = asOptional()

/**
 * A handy method that allows to check if given Int is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Int.isZero(): Boolean =
  this == Int.ZERO

/**
 * A handy method that allows to check if given Int is not equal to
 * zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Int.isNotZero(): Boolean =
  isZero().not()

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

/**
 * The zeroed Long.
 */
val Long.Companion.ZERO: Long
  get() = 0L

/**
 * Wraps nullable Long as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun Long?.asOptional(): Optional<Long> = asOptional()

/**
 * A handy method that allows to check if given Long is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Long.isZero(): Boolean =
  this == Long.ZERO

/**
 * A handy method that allows to check if given Long is not equal to
 * zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Long.isNotZero(): Boolean =
  isZero().not()

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

/**
 * The zeroed Short.
 */
val Short.Companion.ZERO: Short
  get() = 0

/**
 * Wraps nullable Short as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun Short?.asOptional(): Optional<Short> = asOptional()

/**
 * A handy method that allows to check if given Short is equal to zero.
 * Useful especially for lambda operations or higher level functions.
 */
fun Short.isZero(): Boolean =
  this == Short.ZERO

/**
 * A handy method that allows to check if given Short is not equal to
 * zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun Short.isNotZero(): Boolean =
  isZero().not()

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

/**
 * Wraps nullable String as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun String?.asOptional(): Optional<String> = asOptional()

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
