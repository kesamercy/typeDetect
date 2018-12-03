
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator
import scala.io.Source._

object dataTypeDetect {
  //create object for testCases class
  //val ts = new testCases( )

  val data = fromFile("/Users/nekesamercy/IdeaProjects/typeDetect/src/main/scala/zs.csv").getLines

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


  columnarData.mkString("<br>")


  //regex to check data types
  var chekXpression: Map[String,Regex] = Map(

    "Integer"    -> "[0-9]".r,
    "Float"      -> "[-+]?([0-9]+(\\.[0-9]+)?|\\.[0-9]+)".r,
    "Date"       -> """(0?[1-9]|1[012])[- \/.](0?[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d""".r,
    "Boolean"    -> "([Vv]+(erdade(iro)?)?|[Ff]+(als[eo])?|[Tt]+(rue)?|0|[\\+\\-]?1)".r,
    "TimeStamp"  -> "\\b([0-1][0-9]|[2][0-3]):([0-5][0-9])\\b".r,

  )

  def guessType(data:Seq[String]): String = {
    ???
  }

  def findAllTypes(data: Seq[String]): Map[String, Int] = {

    for( (typeName:String, regex:Regex) <- chekXpression ) {
      println(typeName)
      val count = findType(regex, data)
      println("Found "+count+" "+typeName+"(s)")
    }

    ???
  }

  //method to determine the dataTypes
  def findType (regularXp: Regex , data: Seq[String]): Int = {

    var numInt: MatchIterator = regularXp.findAllIn(data.mkString("\n"))

    return numInt.size
  }


  def main(args: Array[String]): Unit = {

    // print the results
    columnarData.tail.map(col => findAllTypes(col))



  }


}


