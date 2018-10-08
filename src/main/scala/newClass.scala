
import scala.util.matching.Regex

object newClass {

  // declare a var to for the user input

  var prompt = "Please enter the string to which you 555 would like to find the data type trial"

    val numberPattern: Regex = "[0-9]".r

    val address = "123 Main Street Suite 101"

    val match1 = numberPattern.findFirstIn(address)





  //detect int
  def findInt ( ): Unit = {



  }



  //detect float

  def findFloat ( ): Unit = {


  }



  // detect date


  def findDate ( ): Unit ={


  }



  //detect boolean

  def findBool ( ): Unit ={


  }



  //detect time stamp

   def findTime ( ): Unit = {


   }



def max(x: Int, y: Int): Int = {


  if (x > y) x

  else y
}


def main(args: Array[String]): Unit = {


  println(max(3, 5))

  println(prompt)

}


}



