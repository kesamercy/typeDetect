import org.specs2.mutable._

import scala.io.Source._

class CSVTest extends Specification { 

  "The Type Detector" should {


    "Load and detect CSV Files" >> {

      //create object for testCases class
      //val ts = new testCases( )

      val data = fromFile("test_data/zs.csv").getLines

      //val data = Seq("A,B,C","1,3,4","2,,","1,2,6","1,4,6","2,2,6",",2,6") //fromFile("zs.csv").getLines

      val rowData = data.map(row => {
        (if(row.trim.startsWith(","))
          s"***${row}"
        else if(row.endsWith(","))
          s"${row}***"
        else
          row).split(",").toSeq.map(el => if(el.equals("***")) "" else el)
      })

      val columnarData = rowData.foldLeft(Seq[Seq[String]]())((init, cur) => {
        init match {
          case Seq() => cur.map(cell => Seq(cell))
          case nonEmptySeq => cur.zipWithIndex.map(cellidx => nonEmptySeq(cellidx._2) :+ s"${cellidx._1}")
          case _ => init
        }
      })

      columnarData.tail.map(col => dataTypeDetect.findAllTypes(col)) should contain("Integer" -> 5)
    }
  }
}