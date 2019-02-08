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

      //read the data by the coloumn
      val columnarData = skipHeader.foldLeft(Seq[Seq[String]]())((init, currentRow) => {

        init match {
          case Seq() => currentRow.map(cell => Seq(cell))
          case nonEmptySeq => (currentRow.zipWithIndex).map(cellidx => nonEmptySeq(cellidx._2) :+ cellidx._1)
          case _ => init
        }

      })

      val colTypes = columnarData.map(column => dataTypeDetect.findAllTypes(column) )

      println(colTypes.mkString("\n") )

      colTypes(0) must be havePair("Integer" -> 4)
      colTypes(1) must be havePair("Integer" -> 4)

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

/*
* Next plan:
*
* test and confirm commented parts work
* import large data sets... follow the nyc data set link
* get the vm profiler to do optimization - so you are able to see how fast it runs..
*
*
* FROM NOTES!---
* grab a large data set and see how long it takes using the VM profiler
grab the first 100 lines of the file form the nyc data file and test it using
the code you have wrtieent so you can see the run time from the vm profiler
*
* */