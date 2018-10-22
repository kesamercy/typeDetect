
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator


object dataTypeDetect {

  //declare variables



  //create object for testCases class
  val ts = new testCases( )

  //detect int
  def findInt ( ): MatchIterator = {

    val numberPattern: Regex = "[0-9]".r
    val match1 = numberPattern.findAllIn(ts.address)

    return match1
  }

  //detect float

  def findFloat ( ): MatchIterator = {

    val floatPattern: Regex = "[+-]?([0-9]*[.])?[0-9]+".r
    val match2 = floatPattern.findAllIn(ts.floaty)

    return match2


  }



  // detect date
  def findDate ( ): MatchIterator ={

    val datePattern: Regex = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d".r
    val match3 = datePattern.findAllIn(ts.date)

    return match3


  }


 //detect boolean

  def findBool ( ): MatchIterator ={

    val boolPattern: Regex = "([Vv]+(erdade(iro)?)?|[Ff]+(als[eo])?|[Tt]+(rue)?|0|[\\+\\-]?1)".r
    val match4 = boolPattern.findAllIn(ts.booly)

    return match4

  }


  //detect time stamp

   def findTime ( ): MatchIterator = {

     val time = "the time is 21:00 and i should leave at 22:39"

     val timePattern: Regex = "\\b([0-1][0-9]|[2][0-3]):([0-5][0-9])\\b".r
     val match5 = timePattern.findAllIn(time)

     return match5


   }

  /*def countInt ( ): Int = {

    var count = 0;

    count = findInt().foreach(count);

    return count
  }*/


def main(args: Array[String]): Unit = {


//  println(ts.prompt)

  findInt().length

  /*findFloat().foreach(println)

  findDate().foreach(println)

  findBool().foreach(println)

  findTime().foreach(println)

*/

}


}



