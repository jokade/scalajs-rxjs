package rxjs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("rxjs/BehaviorSubject","BehaviorSubject")
class BehaviorSubject[T](initial:T) extends Observable[T] {
  def next(value: T): Unit = js.native
}