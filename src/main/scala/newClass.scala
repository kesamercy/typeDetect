
import scala.util.matching.Regex

object newClass {

  // declare a var to for the user input

  var prompt = "Please enter the string to which you 555 would like to find the data type";

  val numberPattern: Regex = "[0-9]".r





    numberPattern.findFirstMatchIn(prompt) match {

    case Some(_) => println("Password ok")
    case None => println ("Passowrd must contain a number")

  }


  //read string from a file

//  if (args.length > 0) {
//
//    for (line <- Source.fromFile(args(0)).getLines())
//
//      println(line.length + " " + line)
//
//  }
//  else
//    Console.err.println("Please enter a file name")


  //detect data type methods
  // detect a data type of int in the prompt

  def max(x: Int, y: Int): Int = {


    if (x > y) x

    else y
  }


  def main(args: Array[String]): Unit = {




    println(max(3,5))

    println(prompt)




  }

}
