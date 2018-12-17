
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator

object dataTypeDetect {

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

      //instead of print, return the values
      val count = findType(regex, data)
      //assigned the return values to variable names
      var dataType = typeName;
      var numType = count;

      println("Found this "+numType+" "+dataType+"(s)")
    }

    ???
  }
  //method to determine the dataTypes
  def findType (regularXp: Regex , data: Seq[String]): Int = {

    var numInt: MatchIterator = regularXp.findAllIn(data.mkString("\n"))

    return numInt.size
  }

//  def main(args: Array[String]): Unit = {
//
//    val td = new TypeDetectTest( )
//
//  }// end main

}// end dataTypeDetect


