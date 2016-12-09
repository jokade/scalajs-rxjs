//     Project: scalajs-rxjs
// Description: Tests for core.Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.test

import rxjs.{Observable, TestBase}
import utest._

import scala.concurrent.Promise

object ObservableObjectTest extends TestBase {
  val tests = TestSuite {
    'of-{
      Observable.of("hello").toFuture map { res =>
        assert(res.size == 1, res(0) == "hello" )
      }
      'throw-{
        future( Observable.throwError("error") ).expectFailure( x => assert(x.getMessage == "error") )
      }
      'concat-{
        Observable.concat( Observable.of(42), Observable.of("hello") ).count.toFuture.map( v => assert(v==2) )
      }
      'range-{
        Observable.range(1,10).toFuture.map( v => assert(v==10) )
      }
      'zip-{
        Observable.zip( Observable.of(42), Observable.of("hello") ).toFuture.map( v => assert(v(0)==42,v(1)=="hello") )
      }
      'zip2-{
        Observable.zip( Observable.of(42), Observable.of("hello"), (a:Int,b:String) => b + a ).toFuture.map( v => assert(v=="hello42") )
      }
      'zip3-{
        Observable.zip( Observable.of(42), Observable.of("hello"), Observable.of(1),(a:Int,b:String,c:Int) => b + (a + c) ).toFuture.map( v => assert(v=="hello43") )
      }
      'zip4-{
        Observable.zip( Observable.of(42), Observable.of("hello"), Observable.of(1), Observable.of(2), (a:Int,b:String,c:Int,d:Int) => b + (a + c + d )).toFuture.map( v => assert(v=="hello45") )
      }
      'zip5-{
        Observable.zip( Observable.of(42), Observable.of("hello"), Observable.of(1), Observable.of(2), Observable.of(3), (a:Int,b:String,c:Int,d:Int,e:Int) => b + (a + c + d + e)).toFuture.map( v => assert(v=="hello48") )
      }
      'zip6-{
        Observable.zip( Observable.of(42), Observable.of("hello"), Observable.of(1), Observable.of(2), Observable.of(3), Observable.of(4), (a:Int,b:String,c:Int,d:Int,e:Int,f:Int) => b + (a + c + d + e +f)).toFuture.map( v => assert(v=="hello52") )
      }

      'interval_take-{
        Observable.interval(1).take(10).toFuture.map( v => assert(v==9) )
      }
    }
  }
}


trait ObservableInstanceBehaviour extends TestBase {
  def just[T](value: T): Observable[T]
  def throwError[T](msg: T): Observable[T]

  val tests = TestSuite {
    'subscribe-{
      val p = Promise[Int]()
      'next-{
        just(42).subscribe(x => p.success(x))
        p.future.map(x => assert(x == 42))
      }
//      'err-{
//                  throwError[String]("error").subscribe((_: String) => {}, (err: js.Any) => {})
//      }
    }
    'toFuture-{
      just(42).toFuture.map ( v => assert(v==42) )
    }
    'count-{
      'simple- {
        Observable.range(0, 10).count.toFuture.map(v => assert(v == 10))
      }
      'predicate-{
        Observable.range(0, 10).count((i,_,_)=>i>5).toFuture.map(v => assert(v == 4))
      }
    }
    'concatAll-{
      Observable.of( Observable.range(1,5), Observable.range(1,5) ).concatAll().count.toFuture.map(v => assert(v==10))
    }
    'debounceTime-{
      Observable.interval(10).take(10).debounceTime(15).count.toFuture.map( v => assert(v==1) )
    }
    'elementAt-{
      Observable.range(1,10).elementAt(5).toFuture.map(v => assert(v==6))
    }
    'filter-{
      Observable.range(1,10).filter( (i,_) => i%2==0 ).count.toFuture.map(v => assert(v==5))
    }
    'find-{
      't-{
        Observable.range(1,10).find( (i,_) => i==5 ).toFuture.map(v => assert(v==5))
      }
//      'f-{
//        Observable.range(1,10).find( (i,_) => i==100 ).toFuture.map(v => println(v))
//      }
    }
    'map-{
      just(42).map( (i,_) => i+1 ).toFuture.map( v => assert(v==43) )
    }
    'take-{
      Observable.range(1,10).take(5).count.toFuture.map(v => assert(v==5) )
    }
  }
}


object ObservableInstanceTest extends ObservableInstanceBehaviour {
  override def just[T](value: T): Observable[T] = Observable.of(value)
  override def throwError[T](msg: T): Observable[T] = Observable.throwError(msg)
}
