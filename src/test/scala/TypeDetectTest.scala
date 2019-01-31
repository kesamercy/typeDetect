import org.specs2.mutable._
import com.github.tototoshi.csv._
import java.io._

class  TypeDetectTest extends Specification {
  /*current goal:
  *
  * translate the format of the csv to match the format that the method expects
  * call the findall types method on one column at a time
  *
  * */
  "The Type Detector" should {

    "Count Integers" >> {

      //open the csv file
      val reader = CSVReader.open(new File("C:\\Users\\nm293\\IdeaProjects\\typeDetect\\src\\test\\scala\\test_data\\int_test.csv"))

      //read all lines
      val allLines = reader.all()

      //skip the first line of the csv which is the header
      val skipHeader = allLines.drop(1)

      //loop through each line of the file
      skipHeader.foreach(

        println

      )

      //read the number of values on the line
      val countInt = skipHeader.iterator

      dataTypeDetect.findAllTypes(
       countInt.next()
      ) must be havePair("Integer" -> 2)
    }


   /*"Recognize Integers" >> {

      val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\int_test.csv"))

      val intReader = reader.iterator

      dataTypeDetect.guessType(
        intReader.next()

      ) must be equalTo("Integer")
    }


       "Recognize Floats" >> {

         val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\bigFloatFile.csv"))

         val floatReader = reader.iterator
         dataTypeDetect.guessType(
         floatReader.next()

         ) must be equalTo("Float")

       }



               "Recognize Dates" >> {

                 val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\zs.csv"))

                 val dateReader = reader.iterator

                 dataTypeDetect.guessType(
                  dateReader.next()
                 ) must be equalTo("Date")
               }


               "Recognize Strings" >> {

                 val reader = CSVReader.open(new File("C:\\Users\\mercy\\Documents\\GitHub\\typeDetect\\src\\test\\scala\\test_data\\cpuspeed.csv"))

                 val stringReader = reader.iterator

                 dataTypeDetect.guessType(

                   stringReader.next()

                 ) must be equalTo("String")

               }
*/
  }
}