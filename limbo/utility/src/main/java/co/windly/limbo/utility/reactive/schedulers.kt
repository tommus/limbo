package co.windly.limbo.utility.reactive

import io.reactivex.Scheduler

/**
 * Data object keeping a reference to the following schedulers:
 * - cpu - aka computation thread for heavy computations,
 * - db - especially designated thread for interaction with database,
 * - io - thread pool responsible for orchestrating I/O tasks,
 * - ui - main thread.
 */
data class Schedulers(
  val cpu: Scheduler,
  val db: Scheduler,
  val io: Scheduler,
  val ui: Scheduler
)
