
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator

object newClass {

  // declare  variables
  var prompt = "Please enter  4/1/2001 the string  0.5 0.6 0.9 to which you 555 296574598 would like to find the data type trial"

  val address = "123 Main Street Suite 101"

  val date = "today is 4/1/2001 and tomorrow will be 10/12/2018 and next year will be 5/2/2019"

  val time = "the time is 21:00 and i should leave at 22:39"

  val booly = "this is true"

  val floaty = " 0.4 0.5 0.9"

  //detect int
  def findInt ( ): MatchIterator = {

    val numberPattern: Regex = "[0-9]".r
    val match1 = numberPattern.findAllIn(address)

    return match1
  }



  //detect float

  def findFloat ( ): MatchIterator = {

    val floatPattern: Regex = "[+-]?([0-9]*[.])?[0-9]+".r
    val match2 = floatPattern.findAllIn(floaty)

    return match2


  }



  // detect date
  def findDate ( ): MatchIterator ={

    val datePattern: Regex = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d".r
    val match3 = datePattern.findAllIn(date)

    return match3


  }


 //detect boolean

  def findBool ( ): MatchIterator ={

    val boolPattern: Regex = "([Vv]+(erdade(iro)?)?|[Ff]+(als[eo])?|[Tt]+(rue)?|0|[\\+\\-]?1)".r
    val match4 = boolPattern.findAllIn(booly)

    return match4

  }


  //detect time stamp

   def findTime ( ): MatchIterator = {

     val time = "the time is 21:00 and i should leave at 22:39"

     val timePattern: Regex = "\\b([0-1][0-9]|[2][0-3]):([0-5][0-9])\\b".r
     val match5 = timePattern.findAllIn(time)

     return match5


   }


def main(args: Array[String]): Unit = {


  println(prompt)

  findInt().foreach(println)

  findFloat().foreach(println)

  findDate().foreach(println)

  findBool().foreach(println)

  findTime().foreach(println)



}


}



