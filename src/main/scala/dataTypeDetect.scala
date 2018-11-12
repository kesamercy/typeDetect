
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator


object dataTypeDetect {
  //create object for testCases class
  val ts = new testCases( )
  

  var numIntegers= findType("[0-9]".r, ts.address)
  var numfloat = findType("[+-]?([0-9]*[.])?[0-9]+".r, ts.floaty)
  var numDates = findType("""(0?[1-9]|1[012])[- \/.](0?[1-9]|[12][0-9]|3[01])[- \/.](19|20)\d\d""".r, ts.date)
  var numBoolean = findType("([Vv]+(erdade(iro)?)?|[Ff]+(als[eo])?|[Tt]+(rue)?|0|[\\+\\-]?1)".r, ts.booly)
  var numTimeStamps = findType("\\b([0-1][0-9]|[2][0-3]):([0-5][0-9])\\b".r, ts.time)

  //method to determine the dataTypes
  def findType (regularXp: Regex , fileName: String): Int = {

    var numInt: MatchIterator = regularXp.findAllIn(fileName)

    return numInt.size
  }


def main(args: Array[String]): Unit = {

// print the results

  println("this is the number of integers in the string " + numIntegers);
  println("this is the number of float numbers " + numfloat);
  println("this is the number of dates in the string " + numDates);
  println( "this is the number of boolean in the string " + numBoolean);
  println( "this is the number of time stamps in the string " + numTimeStamps);


}


}
/*
* look at the phone pictures for how to do new implementation
*
* 1. get the input to read from a seq. the data is in list form
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


