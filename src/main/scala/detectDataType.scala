
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator


object dataTypeDetect {
  //create object for testCases class
  val ts = new testCases( )


  //regex to check data types

  var chekXpression: Map[String,Regex] = Map(
    "Integer"    -> "[0-9]".r,
    "Float"      -> "[+-]?([0-9]*[.])?[0-9]+".r,
    "Date"       -> """(0?[1-9]|1[012])[- \/.](0?[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d""".r,
    "Boolean"    -> "([Vv]+(erdade(iro)?)?|[Ff]+(als[eo])?|[Tt]+(rue)?|0|[\\+\\-]?1)".r,
    "TimeStamp"  -> "\\b([0-1][0-9]|[2][0-3]):([0-5][0-9])\\b".r,
  )

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
    findAllTypes(ts.dataSeq)
    // println("this is the number of integers in the string " + numIntegers);
    // println("this is the number of float numbers " + numfloat);
    // println("this is the number of dates in the string " + numDates);
    // println( "this is the number of boolean in the string " + numBoolean);
    // println( "this is the number of time stamps in the string " + numTimeStamps);


  }


}
/*
* look at the phone pictures for how to do new implementation
*
* 2. put the regex in a seq list form
*
* 3. use a for loop method to run the regex to find the data type
*
* 4. display the output in the seq list format for the data types
*
* 5. debug the regex for date or change it to a diff regex. look at phone for easier one
*
*
*
* */


