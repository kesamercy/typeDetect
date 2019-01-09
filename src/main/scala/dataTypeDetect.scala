
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

    // determine the most frequent data type from the set

    // use find all to return the values for the data types
    val checkTypes = findAllTypes(data) //- this should retunr a collection of data sets

    checkTypes.maxBy(numTpes => numTypes._2)

    // method to check if int is greater than all the other types
    if (int > float){

      def checkInt(dataType: Int): String = data {

          //check if int is greater than date
          if(int > date){

            if (int > boolean){

              if (int > timestamp){

                println("the datatype is an integer")

              }// end if int & timestamp

              else {

                println("the datatype is a timestamp")

              }//end else for int & timestamp

            }// end if int & boolean

            else if (boolean > timestamp) {

              println("the datatype is a boolean")

            } // end else if bool & time

            else {

              println("the datatype is a timestamp")

            } // end else for timestamp

          }// end if date & int

          else if (date > boolean ) {
            //call method for check date
            checkDate();

          }// end else if date & boolean

          else if (boolean > timestamp){

            //call method for check boolean
            checkBoolean();
          }

          else {
            println("the datatype is a time stamp")
          }

      }// end def checkInt

    }// end if int & float

    //check if float is greater than all the other types

    if(float > int){

      def checkFloat(dataType: Int): String = data {

        //check if float is greater than date
        if(float > date){

          if (float > boolean){

            if (float > timestamp){

              println("the datatype is a float")

            }// end if float & timestamp

            else {

              println("the datatype is a timestamp")

            }//end else for int & timestamp

          }// end if float & boolean

          else if (boolean > timestamp) {

            println("the datatype is a boolean")

          } // end else if bool & time

          else {

            println("the datatype is a timestamp")

          } // end else for timestamp

        }// end if date & date

        else if (date > boolean ) {
          //call method for check date

        }// end else if date & boolean

        else if (boolean > timestamp) {

          //call method for check boolean
        }

        else {
          //method for timestamp
          println("the datatype is a timestamp")
        }

      }// end def checkInt

    }// end if float & int

    //check if date is greater than all the other types


    if(date > int){

      def checkDate(data: Int) String = data {

        if (date > float) {

          if (date > boolean) {

            if (date > timestamp) {

            } // end if date & timestamp


          } // end if date & boolean

        } // end if date & float

        else if (float > date) {

          if (float > boolean) {

          } // end if

          else if (boolean > float) {

            if (boolean > timestamp) {

              println("the data type is a boolean")

            } // end if
            else {
              println("the datatype is a timestamp")
            }

          } // end else if

        } // end else if

      }// end def check date

    }// end if date & int

    //check boolean

    if(boolean > int) {

      def checkBoolean(data: Int) String = data {

        if (boolean > float) {
          if (boolean > date) {
            if (boolean > timestamp) {

              println("the data type is a boolean")

            } // end bool & timestamp

          } // end if bool & date
        } // end if bool & float
      }// end def
    }// end if bool & date


    // return the number with the highest count for the data types

    //check dataType with regex expressions
    for ((typeName :String, regex:Regex) <- chekXpression) {

      var foundType =  typeName;

    }// end for

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

}// end dataTypeDetect


/*return one type of data for the most frequent data set


    try this on a much larger data set  - new file that runs the new test case with the larger data

    new class for the larger tests of data set. instead of writing the data, have a file that reads the data for testing

    create a new class that uses my code

    long term challenge - goal is to make it faster, the code should run faster for the data sets given.

*/