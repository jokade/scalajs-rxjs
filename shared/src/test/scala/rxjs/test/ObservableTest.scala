//     Project: scalajs-rxjs
// Description: Tests for core.Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.test

import rxjs.{Observable, TestBase}

import scalajs.js
import scala.util.Failure
import utest._

import scala.concurrent.Promise

object ObservableObjectTest extends TestBase {
  val tests = TestSuite {
    'of-{
      Observable.of("hello").toFuture map { res =>
        assert(res.size == 1, res(0) == "hello" )
      }
      'throw-{
         Observable.throwError("error").toFuture.recover{
           case ex: js.JavaScriptException => assert( ex.getMessage() == "error" )
         }
      }
      'concat-{
        Observable.concat( Observable.of(42), Observable.of("hello") ).count.toFuture.map( v => assert(v==2) )
      }
      'defer-{
        Observable.defer( () => Observable.of(42) ).toFuture.map( v => assert( v == 42 ) )
      }
      'range-{
        Observable.range(1,10).toFuture.map( v => assert(v==10) )
      }
      'zip-{
        Observable.zip( Observable.of(42), Observable.of("hello") ).toFuture.map( v => assert(v(0)==42,v(1)=="hello") )
      }

      'zip2-{
        Observable.zip( Observable.of(42), Observable.of("hello") 
        , (a:Int,b:String ) => b + (a ) ).toFuture.map( v => assert(v=="hello42") )
      } 
  
      'zip3-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3)
        , (a:Int,b:String ,p3:Int) => b + (a +p3) ).toFuture.map( v => assert(v=="hello45") )
      } 
  
      'zip4-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4)
        , (a:Int,b:String ,p3:Int,p4:Int) => b + (a +p3+p4) ).toFuture.map( v => assert(v=="hello49") )
      } 
  
      'zip5-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int) => b + (a +p3+p4+p5) ).toFuture.map( v => assert(v=="hello54") )
      } 
  
      'zip6-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int) => b + (a +p3+p4+p5+p6) ).toFuture.map( v => assert(v=="hello60") )
      } 
  
      'zip7-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int) => b + (a +p3+p4+p5+p6+p7) ).toFuture.map( v => assert(v=="hello67") )
      } 
  
      'zip8-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int) => b + (a +p3+p4+p5+p6+p7+p8) ).toFuture.map( v => assert(v=="hello75") )
      } 
  
      'zip9-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9) ).toFuture.map( v => assert(v=="hello84") )
      } 
  
      'zip10-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10) ).toFuture.map( v => assert(v=="hello94") )
      } 
  
      'zip11-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11) ).toFuture.map( v => assert(v=="hello105") )
      } 
  
      'zip12-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12) ).toFuture.map( v => assert(v=="hello117") )
      } 
  
      'zip13-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13) ).toFuture.map( v => assert(v=="hello130") )
      } 
  
      'zip14-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14) ).toFuture.map( v => assert(v=="hello144") )
      } 
  
      'zip15-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15) ).toFuture.map( v => assert(v=="hello159") )
      } 
  
      'zip16-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16) ).toFuture.map( v => assert(v=="hello175") )
      } 
  
      'zip17-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16), Observable.of(17)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int,p17:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+p17) ).toFuture.map( v => assert(v=="hello192") )
      } 
  
      'zip18-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16), Observable.of(17), Observable.of(18)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int,p17:Int,p18:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+p17+p18) ).toFuture.map( v => assert(v=="hello210") )
      } 
  
      'zip19-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16), Observable.of(17), Observable.of(18), Observable.of(19)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int,p17:Int,p18:Int,p19:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+p17+p18+p19) ).toFuture.map( v => assert(v=="hello229") )
      } 
  
      'zip20-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16), Observable.of(17), Observable.of(18), Observable.of(19), Observable.of(20)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int,p17:Int,p18:Int,p19:Int,p20:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+p17+p18+p19+p20) ).toFuture.map( v => assert(v=="hello249") )
      } 
  
      'zip21-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16), Observable.of(17), Observable.of(18), Observable.of(19), Observable.of(20), Observable.of(21)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int,p17:Int,p18:Int,p19:Int,p20:Int,p21:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+p17+p18+p19+p20+p21) ).toFuture.map( v => assert(v=="hello270") )
      } 
  
      'zip22-{
        Observable.zip( Observable.of(42), Observable.of("hello") , Observable.of(3), Observable.of(4), Observable.of(5), Observable.of(6), Observable.of(7), Observable.of(8), Observable.of(9), Observable.of(10), Observable.of(11), Observable.of(12), Observable.of(13), Observable.of(14), Observable.of(15), Observable.of(16), Observable.of(17), Observable.of(18), Observable.of(19), Observable.of(20), Observable.of(21), Observable.of(22)
        , (a:Int,b:String ,p3:Int,p4:Int,p5:Int,p6:Int,p7:Int,p8:Int,p9:Int,p10:Int,p11:Int,p12:Int,p13:Int,p14:Int,p15:Int,p16:Int,p17:Int,p18:Int,p19:Int,p20:Int,p21:Int,p22:Int) => b + (a +p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+p17+p18+p19+p20+p21+p22) ).toFuture.map( v => assert(v=="hello292") )
      } 


      'interval_take-{
        Observable.interval(1).take(10).toFuture.map( v => assert(v==9) )
      }
    }
  }
}


trait ObservableInstanceBehaviour extends TestBase {

  val tests = TestSuite {
    'subscribe-{
      val p = Promise[Int]()
      'next-{
        Observable.of(42).subscribe(x => p.success(x))
        p.future.map(x => assert(x == 42))
      }
//      'err-{
//                  throwError[String]("error").subscribe((_: String) => {}, (err: js.Any) => {})
//      }
    }
    'toFuture-{
      Observable.of(42).toFuture.map ( v => assert(v==42) )
    }
    'buffer-{
//      val obs = Observable.of(1, 2, 3, 4, 5)
//      val notifier = obs.share.filter( (i,_) => i==3 )
//      notifier.subscribeJS()
//      obs.buffer(notifier).toFuture.map{
//        case x => println(x) //assert(x == js.Array(1,2))
//      }
    }
    'catchOrRetry-{
      'catch-{
        var lastN = 0
          Observable.of(1, 2, 3, 4, 5)
            .map( (n, _) => if(n==4) throw js.JavaScriptException("four!") else n )
            .catchOrRetry{
              case _ => false
            }
            .map( (n,_) => lastN = n).toFuture.map(_ => assert( lastN == 3 ))
      }
      'retry- {
        var lastN = 0
        var catched = false
        Observable.of(1, 2, 3, 4, 5)
          .map((n, _) => if (n == 4 && !catched) throw js.JavaScriptException("four!") else n)
          .catchOrRetry {
            case _ =>
              catched = true
              true
          }
          .take(5)
          .map((n, _) => lastN = n)
          .toFuture.map( _ => assert(lastN == 2) )
      }
      'exception-{
        Observable.of(1).map[Int]( (_,_) => throw scalajs.js.JavaScriptException(1) )
          .catchOrRetry{
          case x =>
            false
        }.subscribe(_ => ())
      }
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
      Observable.of(42).map( (i,_) => i+1 ).toFuture.map( v => assert(v==43) )
    }
    'take-{
      Observable.range(1,10).take(5).count.toFuture.map(v => assert(v==5) )
    }
  }
}


object ObservableInstanceTest extends ObservableInstanceBehaviour {
}
