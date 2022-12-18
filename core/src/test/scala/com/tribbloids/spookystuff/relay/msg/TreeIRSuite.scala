//package com.tribbloids.spookystuff.relay.msg
//
//import com.tribbloids.spookystuff.relay.FunSpecx
//
//class TreeIRSuite extends FunSpecx {
//
//  import TreeIRSuite._
//
//  describe("from/to JSON") {
//
//    it("round-trip") {
//
//      val jv = o3.write.toJSON()
//      jv.shouldBe(
//        """
//          |{
//          |  "e" : {
//          |    "c" : 9223372036854775807,
//          |    "d" : {
//          |      "a" : 1,
//          |      "b" : 2.0
//          |    }
//          |  },
//          |  "f" : "FF"
//          |}
//          |""".stripMargin
//      )
//
//      val reader = TreeIR._Relay[Any]()
//      val back = reader.fromJSON(jv)
//
//      val jv2 = back.toJSON()
//
//      jv2.shouldBe(jv)
//
//      back.toString shouldBe o3.toString
//
//      back.treeView.treeString.shouldBe(
//        """
//          |Struct
//          |:- Struct
//          |:  :- Leaf 9223372036854775807
//          |:  +- Struct
//          |:     :- Leaf 1
//          |:     +- Leaf 2.0
//          |+- Leaf FF
//          |""".stripMargin
//      )
//    }
//  }
//}
//
//object TreeIRSuite {
//
//  val o1 = TreeIR.Builder().struct("a" -> TreeIR.Leaf(1)(), "b" -> TreeIR.Leaf(2.0)())
//
//  val o2 = TreeIR.Builder[Any]().struct("c" -> TreeIR.Leaf(Long.MaxValue)(), "d" -> o1)
//
//  val o3 = TreeIR.Builder[Any]().struct("e" -> o2, "f" -> TreeIR.Leaf("FF")())
//}