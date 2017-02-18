//     Project: scalajs-rxjs
// Description: Common base class for utest-based tests

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import rxjs.TestBase.ObservableFuture
import utest._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration
import scala.concurrent._
import scala.scalajs.js
import scala.util.{Failure, Try}

abstract class TestBase extends TestSuite {
  implicit val ec = scalajs.concurrent.JSExecutionContext.queue

//  def future[T](o: Observable[T]): ObservableFuture[T] = new ObservableFuture[T](o)
}

object TestBase {
  class ObservableFuture[T](obs: Observable[T]) extends Future[Seq[T]] {
    private var _data  = js.Array[T]()
    private val p = Promise[Seq[T]]()
    private lazy val future = p.future
    obs.subscribe((e:T)=> this.synchronized(_data.push(e)),
      (err:Any) => p.failure(new RuntimeException(err.toString)),
      () => p.success(_data) )

    override def onComplete[U](f: (Try[Seq[T]]) => U)(implicit executor: ExecutionContext): Unit = future.onComplete(f)
    override def isCompleted: Boolean = future.isCompleted
    override def value: Option[Try[Seq[T]]] = future.value
    def expectFailure(f: (Throwable)=>Any)(implicit ec: ExecutionContext): Future[Seq[T]] = {
      future.onSuccess{ case _ => throw new RuntimeException("expected Failure")}
      future.recover{
        case x =>
          f(x)
          Seq()
      }
    }

    @throws[Exception](classOf[Exception])
    override def result(atMost: Duration)(implicit permit: CanAwait): Seq[T] = future.result(atMost)

    @throws[InterruptedException](classOf[InterruptedException])
    @throws[TimeoutException](classOf[TimeoutException])
    override def ready(atMost: Duration)(implicit permit: CanAwait): ObservableFuture.this.type = ???

    // additional members since 2.12.0
    def transform[S](f: scala.util.Try[Seq[T]] => scala.util.Try[S])(implicit executor: scala.concurrent.ExecutionContext): scala.concurrent.Future[S] = ???
    def transformWith[S](f: scala.util.Try[Seq[T]] => scala.concurrent.Future[S])(implicit executor: scala.concurrent.ExecutionContext): scala.concurrent.Future[S] = ???
  }
}
