package dev.windly.limbo.utility

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import java.util.Optional

/**
 * Allows to wrap nullable type as optional value.
 */
@RequiresApi(VERSION_CODES.N)
fun <T : Any> T?.asOptional(): Optional<T> =
  this?.let { Optional.of(it) } ?: Optional.empty()
