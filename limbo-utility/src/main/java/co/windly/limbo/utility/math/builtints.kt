package co.windly.limbo.utility.math

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import co.windly.limbo.utility.asOptional
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Optional

/**
 * Wraps nullable BigDecimal as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun BigDecimal?.asOptional(): Optional<BigDecimal> = asOptional()

/**
 * A handy method that allows to check if given BigDecimal is equal
 * to zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun BigDecimal.isZero(): Boolean =
  compareTo(BigDecimal.ZERO) == 0

/**
 * A handy method that allows to check if given BigDecimal is not
 * equal to zero. Useful especially for lambda operations or higher
 * level functions.
 */
fun BigDecimal.isNotZero(): Boolean =
  isZero().not()

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null BigDecimal) or zero if given value is
 * null.
 */
fun BigDecimal?.orZero(): BigDecimal =
  this ?: BigDecimal.ZERO

/**
 * Wraps nullable BigInteger as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun BigInteger?.asOptional(): Optional<BigInteger> = asOptional()

/**
 * A handy method that allows to check if given BigInteger is equal
 * to zero. Useful especially for lambda operations or higher level
 * functions.
 */
fun BigInteger.isZero(): Boolean =
  compareTo(BigInteger.ZERO) == 0

/**
 * A handy method that allows to check if given BigInteger is not
 * equal to zero. Useful especially for lambda operations or higher
 * level functions.
 */
fun BigInteger.isNotZero(): Boolean =
  isZero().not()

/**
 * A null-safe shortcut elvis-alike method that returns the
 * identity value (for non-null BigInteger) or zero if given value is
 * null.
 */
fun BigInteger?.orZero(): BigInteger =
  this ?: BigInteger.ZERO
