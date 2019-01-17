
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
  def guessType(data:Seq[String]): String = data { //return the label

    // use find all to return the values for the data types
    val checkTypes = findAllTypes(data) //- this should retunr a collection of data sets
    
    // determine the max of the dataTypes and return the dataType of the highest probability.
    val finalType:(String, Int) = checkTypes.maxBy(numTypes => numTypes._2)

    return finalType._1

  }// end guess

  def findAllTypes(data: Seq[String]): Map[String, Int] = {

    (for( (typeName:String, regex:Regex) <- chekXpression ) yield{

      //instead of print, return the values
      val count = findType(regex, data)

      //assigned the return values to variable names
      var dataType = typeName;
      var numType = count;

      println("Found "+dataType+ "(s)"+" "+ numType)
      (dataType,numType)
     }).toMap

  }// end def

  //method to determine the dataTypes
  def findType (regularXp: Regex , data: Seq[String]): Int = {

    var numInt: MatchIterator = regularXp.findAllIn(data.mkString("\n"))

    return numInt.size
  }

}// end dataTypeDetect


/*
    return one type of data for the most frequent data set

    create a new class that uses my code

    long term challenge - goal is to make it faster, the code should run faster for the data sets given.

*/