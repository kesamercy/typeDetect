
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

  //method to determine / guess the dataType of a string
  def guessType(data:Seq[String]): String = data {

    // use find all to return the values for the data types
    val checkTypes = findAllTypes(data)

    // determine the max of the dataTypes and return the dataType of the highest probability.
    checkTypes.maxBy(numTypes => numTypes )

  }// end guess

  def findAllTypes(data: Seq[String]): Map[String, Int] = {

    (for( (typeName:String, regex:Regex) <- chekXpression ) yield{
      println(typeName)

      //instead of print, return the values
      val count = findType(regex, data)

      //assigned the return values to variable names
      var dataType = typeName;
      var numType = count;

      println("Found this "+numType+" "+dataType+"(s)")
      (dataType,numType)
     }).toMap

    //save the values in an array

  }// end def

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


/*return one type of data for the most frequent data set

    try this on a much larger data set  - new file that runs the new test case with the larger data

    new class for the larger tests of data set. instead of writing the data, have a file that reads the data for testing

    create a new class that uses my code

    long term challenge - goal is to make it faster, the code should run faster for the data sets given.

*/